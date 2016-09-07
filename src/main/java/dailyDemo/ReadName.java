package dailyDemo;

import java.io.*;
import java.util.*;

/**
 * Created by Liuqi
 * Date: 2016/9/2
 * Email:18908356464@163.com
 * Project:test
 */

public class ReadName {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new HashMap<String, Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt"),"GBK"));
        String line,name;
        while ( (line = br.readLine()) !=null){
            name= line.substring(2,4);
            Integer num = map.get(name);
            if (num == null) {
                num = 1;
            } else
                num++;
            map.put(name, num);
        }

        List<Map.Entry<String,Integer>> list = new LinkedList<Map.Entry<String,Integer>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
            //降序
            public int compare(Map.Entry<String, Integer> object1, Map.Entry<String, Integer> object2) {
                return object2.getValue().compareTo(object1.getValue());
            }

        });
        for(Map.Entry<String, Integer> entry:list){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }



    }

}
