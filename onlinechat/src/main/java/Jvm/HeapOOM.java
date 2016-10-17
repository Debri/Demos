package Jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liuqi
 * Date: 2016/10/17
 * Email: 18908356464@163.com
 * Project: Demos
 */

/**
 * java内存堆的溢出情况
 */
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
