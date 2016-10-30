package tools;

/**
 * Created by Liuqi
 * Date: 2016/10/30.
 */

/**
 * 修改class文件，修改常量池常量
 */
public class ClassModifier {
    //class文件中常量池的其实偏移地址
    private static final int CONSTANT_POOL_INDEX = 8;
    //CONSTANT_Utf8_info的标志
    private static final int CONSTANT_Utf8_info = 1;
    //常量池中11种常量所占的长度，CONSTANT_Utf8_info类型常量除外，因为他不是定长的
    private static final int[] CONSTANT_ITEM_LENTH = {-1, -1, -1, 5, 5, 9, 9, 3, 3, 5, 5, 5, 5};
    private static final int u1 = 1;
    private static final int u2 = 2;
    private byte[] classByte;

    public ClassModifier(byte[] classByte) {
        this.classByte = classByte;
    }

    /**
     * 修改常量池中的CONSTANT_Utf8_info常量的内容
     *
     * @param oldStr 修改前的内容
     * @param newStr 修改后的内容
     * @return
     */
    public byte[] modifyUTF8Constant(String oldStr, String newStr) {

        int cpc = getConstantPoolCount();
        int offset = CONSTANT_POOL_INDEX + u2;
        for (int i = 0; i < cpc; i++) {
            int tag = ByteUtils.bytes2Int(classByte, offset, u1);
            if (tag == CONSTANT_Utf8_info) {
                int len = ByteUtils.bytes2Int(classByte, offset + u1, u2);
                offset += (u1 + u2);
                String str = ByteUtils.byte2String(classByte, offset, len);
                if (str.equalsIgnoreCase(oldStr)) {
                    byte[] strBytes = ByteUtils.string2Byte(newStr);
                    byte[] strLen = ByteUtils.int2Bytes(newStr.length(), u2);
                    classByte = ByteUtils.bytesReplace(classByte, offset - u2, u2, strLen);
                    classByte = ByteUtils.bytesReplace(classByte, offset, len, strBytes);
                    return classByte;
                } else {
                    offset += len;
                }
            } else {
                offset += CONSTANT_ITEM_LENTH[tag];
            }
        }
        return classByte;
    }

    public int getConstantPoolCount() {
        return ByteUtils.bytes2Int(classByte, CONSTANT_POOL_INDEX, u2);
    }
}
