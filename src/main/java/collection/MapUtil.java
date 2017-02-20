package collection;

/**
 * Created by Liuqi
 * Date: 2017/2/17.
 */

import java.util.*;

/**
 * map根据key或者value 进行排序
 */
public class MapUtil {

    /**
     * 根据key排序 ，使用TreeMap<>()集合类默认进行排序
     * TreeMap默认是升序的，如果我们需要改变排序方式，则需要使用比较器：Comparator
     */
    public static void byKey() {
        Map<String, String> map = new TreeMap<String, String>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        // 降序排序
                        return obj2.compareTo(obj1);
                    }
                });
        map.put("b", "ccccc");
        map.put("d", "aaaaa");
        map.put("c", "bbbbb");
        map.put("a", "ddddd");

        Set<String> keySet =  map.keySet();
        Iterator<String> iter = keySet.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            System.out.println(key + ":" + map.get(key));
        }
    }

    /**
     * 根据value排序，
     * 对value排序我们就需要借助于Collections的sort(List<T> list, Comparator<? super T> c)方法，
     * 该方法根据指定比较器产生的顺序对指定列表进行排序
     */
    public static void byValue() {
        Map<String, String> map = new TreeMap<String, String>();
        map.put("a", "ddddd");
        map.put("c", "bbbbb");
        map.put("d", "aaaaa");
        map.put("b", "ccccc");

        //这里将map.entrySet()转换成list
        List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
            //升序排序
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for(Map.Entry<String,String> mapping:list){
            System.out.println(mapping.getKey()+":"+mapping.getValue());
        }
    }

}
