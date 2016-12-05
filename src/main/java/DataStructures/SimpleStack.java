package DataStructures;

/**
 * Created by Liuqi
 * Date: 2016/12/4.
 */

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 栈
 * 如果一个栈先是增长然后收缩，那么从栈中弹出来的对象不会被当做垃圾回收，即使使用栈的程序不再引用这些对象
 */
public class SimpleStack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITAL_CAPACITY = 16;

    public SimpleStack() {
        elements = new Object[DEFAULT_INITAL_CAPACITY];
    }

    public void push(Object obj) {
        ensureCapacity();
        elements[size++] = obj;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null;//显示的设为空，让GC去回收.清空过期引用
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
