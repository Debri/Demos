package MyData.hash;

/**
 * Created by Liuqi
 * Date: 2016/9/20
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class MyHash {
    /**
     * 将一个字符串转化为hash函数
     * @param key
     * @param tableSize
     * @return
     */
    public int toHash(String key, int tableSize) {
        int hashValue = 0;
        for (int i = 0; i < key.length(); i++) {
            hashValue = 37 * hashValue + key.charAt(i);
        }
        hashValue %= tableSize;
        if (hashValue < 0) {
            hashValue += tableSize;
        }
        return hashValue;
    }
}
