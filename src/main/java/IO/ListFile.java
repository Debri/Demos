package IO;

import java.io.*;

/**
 * Created by Liuqi
 * Date: 2016/9/15
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class ListFile {
    /**
     * 从文件中以行为单位读取内容
     * @param path
     * @throws Exception
     */
    public void readFile(String path) throws Exception {
        File f;
        FileReader file;
        BufferedReader bufferedReader;
        String oneLine;
        System.out.println("FILE:  " + path);
        f = new File(path);
        file = new FileReader(f);
        //通过InputStreamReader转换输入流转换编码
        InputStreamReader isr = new InputStreamReader(new FileInputStream(f),"gbk" );

        bufferedReader = new BufferedReader(isr);
        while ((oneLine = bufferedReader.readLine()) != null) {
            //字符串的编码转换
          /*  byte [] b =oneLine.getBytes("gbk");
            String str=new String(b,"utf-8");*/
            System.out.println(oneLine);
        }
        file.close();
        bufferedReader.close();

    }


}
