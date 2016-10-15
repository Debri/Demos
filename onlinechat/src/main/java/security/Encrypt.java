package security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Liuqi
 * Date: 2016/10/15
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class Encrypt {
    public static String getMD5(String str) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes());
        byte b, temp[] = md.digest();
        char[] chars = new char[32];
        int k = 0;
        for (int i = 0; i < 16; i++) {
            b = temp[i];
        }
        return new String(temp);
    }
}
