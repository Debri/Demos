package thread;

import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 * Created by Liuqi
 * Date: 2016/9/24
 * Email: 18908356464@163.com
 * Project: Demos
 */

/**
 * 压缩文件，使用多线程的方式
 */
public class GZipRunnable implements Runnable {
    private final File file;

    public GZipRunnable(File file) {
        this.file = file;
    }

    public void run() {
        if (!file.getName().endsWith(".gz")) {
            File output = new File(file.getParent(), file.getName() + "gz");
            if (!output.exists()) {
                try {
                    InputStream in = new BufferedInputStream(new FileInputStream(file));
                    OutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(output)));
                    int b;
                    while ((b = in.read()) != -1) {
                        out.write(b);
                        out.flush();
                    }
                    in.close();
                    out.close();
                } catch (FileNotFoundException e) {
                    System.out.println("文件不存在");
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
