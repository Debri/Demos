package tools;

/**
 * Created by Liuqi
 * Date: 2016/10/30.
 */

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * 为javaClass劫持java.lang.System提供支持
 * 除了out和err以外，其余的都直接转发给System处理
 */
public class HackSystem {
    public static final InputStream in = System.in;
    private static ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    public static final PrintStream out = new PrintStream(buffer);
    public static final PrintStream err = out;

    public static String getBufferString() {
        return buffer.toString();
    }

    public static void clearBuffer() {
        buffer.reset();
    }

    public static void setSecurityManager(final SecurityManager securityManager) {

        System.setSecurityManager(securityManager);
    }

    public static SecurityManager getSecuritymanager() {
        return System.getSecurityManager();
    }

    public static long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int lenth) {
        System.arraycopy(src,srcPos,dest,destPos,lenth);

    }
    public static int identifyHashCode(Object obj){
        return System.identityHashCode(obj);
    }

}
