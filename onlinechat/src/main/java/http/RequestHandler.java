package http;

import java.io.*;
import java.net.Socket;
import java.net.URLConnection;
import java.nio.file.Files;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Liuqi
 * Date: 2016/10/2
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class RequestHandler implements Runnable {
    private static final Logger logger = Logger.getLogger("RequestHandler");
    private File rootDirectory = null;
    private String indexFileName = "index.html";
    private Socket connection;

    public RequestHandler(File rootDirectory, String indexFileName, Socket connection) {
        if (rootDirectory.isFile()) {
            throw new IllegalArgumentException(rootDirectory + "rootDirectory不是一个目录");
        }
        try {
            rootDirectory = rootDirectory.getCanonicalFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.rootDirectory = rootDirectory;
        if (indexFileName != null) {
            this.indexFileName = indexFileName;
        }
    }

    @Override
    public void run() {
        String root = rootDirectory.getPath();
        try {
            OutputStream os = new BufferedOutputStream(connection.getOutputStream());
            Writer writer = new OutputStreamWriter(os);
            Reader reader = new InputStreamReader(new BufferedInputStream(connection.getInputStream()));
            StringBuilder requestLine = new StringBuilder();
            while (true) {
                int c = reader.read();
                if (c == '\r' || c == '\n') {
                    break;
                } else {
                    requestLine.append((char) c);
                }
            }
            String get = requestLine.toString();
            logger.info(connection.getRemoteSocketAddress() + ":" + get);
            String[] takens = get.split("\\s+");
            String method = takens[0];
            String version = "";
            if (method.equalsIgnoreCase("GET")) {
                String fileName = takens[1];
                if (fileName.endsWith("/")) {
                    fileName += indexFileName;
                }
                String contentType = URLConnection.getFileNameMap().getContentTypeFor(fileName);
                if (takens.length > 2) {
                    version = takens[2];
                }
                File theFile = new File(rootDirectory + fileName.substring(1, fileName.length()));
                if (theFile.canRead() && theFile.getCanonicalPath().startsWith(root)) {
                    byte[] data = Files.readAllBytes(theFile.toPath());
                    if (version.startsWith("HTTP/")) {
                        sendHeader(writer, "HTTP/1.0 200 OK", contentType, data.length);
                    }
                    /**
                     * 发送文件，这可能是一个图像或者其他二进制数据，所以使用底层输出流，而不是writer
                     */
                    os.write(data);
                    os.flush();
                } else {//无法找到文件
                    String body = new StringBuilder("<html>\r\n")
                            .append("<head><title>file not found</title></head>\r\n")
                            .append("<body>\r\n")
                            .append("<H1>http error 404 :file not found</H1>\r\n")
                            .append("</body></html>\r\n").toString();
                    if (version.startsWith("HTTP/")) {
                        sendHeader(writer, "HTTP/1.0 404 not found", "text/html;charset=utf-8", body.length());
                    }
                    writer.write(body);
                    writer.flush();
                }
            } else {
                String body = new StringBuilder("<html>\r\n")
                        .append("<head><title>not implemented</title></head>\r\n")
                        .append("<body>\r\n")
                        .append("<H1>http error 501 : not implemented</H1>\r\n")
                        .append("</body></html>\r\n").toString();
                if (version.startsWith("HTTP/")) {
                    sendHeader(writer, "HTTP/1.0 501 not implemented", "text/html;charset=utf-8", body.length());
                }
                writer.write(body);
                writer.flush();
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error talking to " + connection.getRemoteSocketAddress(), e);
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void sendHeader(Writer writer, String responseCode, String contentType, int lenth) throws IOException {
        writer.write(responseCode + "\r\n");
        Date now = new Date();
        writer.write("Date: " + now);
        writer.write("Server: HTTP 2.0\r\n");
        writer.write("contentLenth: " + lenth + "\r\n");
        writer.write("contentType: " + contentType + "\r\n");
        writer.flush();
    }
}
