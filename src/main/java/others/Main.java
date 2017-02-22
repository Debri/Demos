package others;

/**
 * Created by Liuqi
 * Date: 2017/2/22.
 */


import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    static {
        try {
            Field value = String.class.getDeclaredField("value");
            value.setAccessible(true);
            value.set("Hello World!", value.get("神马情况，随机失败！"));
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    private static String randomString(int seed) {
        Random rand = new Random(seed);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; ; i++) {
            int n = rand.nextInt(27);
            if (n == 0)
                break;
            sb.append((char) ('`' + n));
        }
        return sb.toString();
    }

    public static int get()[] {
        return new int[]{1, 2, 3};
    }

    public static void main(String args[]) {
        List<String> list = Arrays.asList("你好\t啊");
        String str = list.get(0);
        String str1 = str.replaceFirst("\\\t", "");
        String str2 = str.replaceFirst("\\t", "");
        String str3 = str.replaceFirst("\t", "");


        System.out.println(str1.equals(str2));
        System.out.println(str2.equals(str3));

        System.out.println("Hello World!");
        Random random = new Random(441287210);
        for (int i = 0; i < 10; i++) {
            System.out.print(random.nextInt(10) + " ");
        }
        System.out.println();
        System.out.println(randomString(-229985452) + ' '
                + randomString(-147909649));

        int value = (byte) +(char) -(int) +(long) -1;
        System.out.println(value);


        System.out.println("编译成功!");

    }
}