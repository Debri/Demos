package tools;

/**
 * Created by Liuqi
 * Date: 2016/10/29.
 */
public class HotSwapClassLoader extends ClassLoader {
    public HotSwapClassLoader() {
        super(HotSwapClassLoader.class.getClassLoader());
    }

    public Class loadByte(byte[] classByte) {
        return defineClass("name", classByte, 0, classByte.length);
    }
}
