package exam;

/**
 * Created by Liuqi
 * Date: 2017/3/9.
 */


import java.io.*;
import java.util.*;

/**
 * Notice:
 * <BR> 1. 仅限使用以下package:
 * java.lang.*, java.io.*, java.math.*, java.text.*, java.util.*
 * <BR> 2. 请勿变更 package名，类名，test()定义。
 */
public class ProgramTest {

    /**
     * 请在此方法内完成代码，但可以增加自己的私有方法。
     * 数据文件inputFile的内容格式为一行一条数据，每条数据有2个字段用逗号分隔，第1个字段为排序用的Key，第二个字段为value。
     * 换行符为'\n'。
     * 数据内容举例如下:
     * abe,xmflsflmfmlsmfs
     * abc,xmlmxlkmffhf
     * 8fj3l,xxjfluu313ooo11
     * <p>
     * 注意点: 1.本次的测试数据内容都是ASCII字符，无中文汉字.所以不必考虑encoding。
     * 2.本次的测试数据中,key的最大长度8，value的最大长度32。
     * <p>
     * 排序以key的升序，使用String.compareTo()来比较key的大小。最后排序完成的数据写入outputFile。
     *
     * @param inputFile  输入文件
     * @param outputFile 输出文件
     * @param tempFile   临时文件。处理的数据量大的时候，可能会需要用到临时文件。
     * @throws Exception
     */
    public static void test(File inputFile, File outputFile, File tempFile) throws Exception {

        //Hashtable<String, String> hashtable = new Hashtable<String, String>();
        Map<String, String> map = new TreeMap<String, String>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        // 降序排序
                        return obj1.compareTo(obj2);
                    }
                });


        //HashMap<String, String> map = new HashMap<String, String>(500000);
        InputStreamReader read = new InputStreamReader(new FileInputStream(inputFile));
        BufferedReader bufferedReader = new BufferedReader(read);
        OutputStream out = new FileOutputStream(outputFile);
        OutputStreamWriter write = new OutputStreamWriter(out);
        BufferedWriter bufferedWriter = new BufferedWriter(write);
        String lineTxt = null;
        String[] str = new String[2];
        long count = 0;
        while ((lineTxt = bufferedReader.readLine()) != null) {
            str = lineTxt.split(",");
            map.put(str[0], str[1]);
        }
        bufferedReader.close();
        read.close();
        Set<String> keySet = map.keySet();
        Iterator<String> iter = keySet.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            bufferedWriter.write(key + "," + map.get(key) + "\n");
            count++;
        }
        System.out.println(count);
    }
}
