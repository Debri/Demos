package tools;

/**
 * Created by Liuqi
 * Date: 2016/10/30.
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 执行工具
 */
public class JavaClassExecuter {
    /**
     * 执行外部传来的一个Java类的byte数组
     * 将类的byte数组中代表java.lang.System的CONSTANT_Utf8_info常量修改为劫持后的hackSystem类
     * 执行方法为该类的static main（String【】 args）方法，输出结果为该类项system.out/err输出的信息
     *
     * @param classByte java类的byte数组
     * @return 结果
     */
    public static String execute(byte[] classByte) {

        HackSystem.clearBuffer();
        ClassModifier classModifier = new ClassModifier(classByte);
        byte[] modiBytes = classModifier.modifyUTF8Constant("java/lang/System", "tools/HackSystem");
        HotSwapClassLoader loader = new HotSwapClassLoader();
        Class clazz = loader.loadByte(modiBytes);
        try {
            Method method = clazz.getMethod("main", new Class[]{String[].class});
            method.invoke(null, new String[]{null});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return HackSystem.getBufferString();
    }
}
