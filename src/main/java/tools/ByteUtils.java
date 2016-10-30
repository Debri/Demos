package tools;

/**
 * Created by Liuqi
 * Date: 2016/10/30.
 */

/**
 * byte的工具类
 */
public class ByteUtils {
    public static int bytes2Int(byte[] b, int start, int lenth) {
        int sum = 0;
        int end = start + lenth;
        for (int i = start; i < end; i++) {
            int n = ((int) b[i]) & 0xff;
            n <<= (-lenth) * 8;
            sum = n + sum;
        }
        return sum;
    }

    public static byte[] int2Bytes(int value, int lenth) {

        byte[] bytes = new byte[lenth];
        for (int i = 0; i < lenth; i++) {
            bytes[lenth - i - 1] = (byte) ((value >> 8 * i) & 0xff);


        }
        return bytes;
    }

    public static String byte2String(byte[] bytes, int start, int end) {
        return new String(bytes, start, end);
    }

    public static byte[] string2Byte(String string) {
        return string.getBytes();
    }

    public static byte[] bytesReplace(byte[] originalbytes, int offset, int len, byte[] replaceBytes) {
        byte[] newBytes = new byte[originalbytes.length + (replaceBytes.length - len)];
        System.arraycopy(originalbytes, 0, newBytes, 0, offset);
        System.arraycopy(replaceBytes, 0, newBytes, offset, replaceBytes.length);
        System.arraycopy(originalbytes, offset + len, newBytes, offset + replaceBytes.length, originalbytes.length - offset - len);
        return newBytes;
    }

}
