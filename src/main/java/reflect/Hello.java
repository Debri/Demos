package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Liuqi
 * Date: 2016/9/11
 * Email: 18908356464@163.com
 * Project: Demos
 */
class Demo{
    private  String name ;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Hello {
    public static void main(String[] args) throws Exception{
       // Demo demo=new Demo();

        Class<?> cls = Class.forName("reflect.Demo");
        Object obj=cls.newInstance();
        String cname = obj.getClass().getName() ;
        Field [] fields = obj.getClass().getFields() ;
        Method [] methods = obj.getClass().getDeclaredMethods();
        Method setMed=cls.getClass().getDeclaredMethod("setName",String.class);
        Method getMed=cls.getClass().getDeclaredMethod("getName");
        //Method setMed=cls.getDeclaredMethod("setName",String.class);//这两行代码和上面两行代码功能一致
       // Method getMed=cls.getDeclaredMethod("getName");
        setMed.invoke(obj,"zhizhang");
        System.out.println(getMed.invoke(obj));
   //虽然可以这样设置值，但最好不要这样做，一定要通过gettter和setter方法来获取和改变值
/*      Field field = obj.getClass().getField("name") ;
        field.set(obj,"mingzi");
        System.out.println(field.get(obj));*/

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
