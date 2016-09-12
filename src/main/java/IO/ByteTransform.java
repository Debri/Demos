package IO;

import java.io.*;

/**
 * Created by Liuqi
 * Date: 2016/9/12
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class ByteTransform {
    public  byte [] FileToByte(String path) throws Exception {

            File file=new File(path);
            InputStream inputStream= new FileInputStream(file);  //向上转型
            ByteArrayOutputStream baos =new ByteArrayOutputStream();
            byte  data [] = new byte[1024];
            int len=0;
            if ((len=inputStream.read(data)) !=-1 ) {
                baos.write(data,0,len);
            }
            inputStream.close();
            baos.close();
            byte [] bytes=baos.toByteArray();
            for (int i=0;i<bytes.length;i++){
                System.out.print(bytes[i]);
                System.out.println();

            }

        return bytes;
    }

}



