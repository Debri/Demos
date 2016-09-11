package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liuqi
 * Date: 2016/9/11
 * Email: 18908356464@163.com
 * Project: Demos
 */
class Demo{
    public  String name ;

}

public class Hello {
    public static void main(String[] args) {
        Demo demo=new Demo();
        String cname = demo.getClass().getName() ;
        Field [] fields = demo.getClass().getFields() ;
        Method [] methods = demo.getClass().getDeclaredMethods();
        System.out.println(cname);
        for (int i =0 ; i < fields.length ; i++){
            System.out.print(fields[i]+" ");
            System.out.println();
        }
//        for (int i =0 ; i < methods.length ; i++){
//            System.out.print(methods[i]+" ");
//            System.out.println();
//        }


    }





}
