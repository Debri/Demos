package com.geek.Test;

/**
 * Created by Liuqi
 * Date: 2016/11/29.
 */

/**
 * 一颗爱心
 */
public class Heart {
    public static void main(String[] args) {
        for (float y = 1.5f; y > -1.5f; y -= 0.1f) {
            for (float x = -1.5f; x < 1.5f; x += 0.05) {
                float a = x * x + y * y - 1;
                if (a * a * a - x * x * y * y * y <= 0.0f) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}
