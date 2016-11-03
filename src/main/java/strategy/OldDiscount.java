package strategy;

/**
 * Created by Liuqi
 * Date: 2016/11/2.
 */
public class OldDiscount implements Discount {
    public double getDiscount(double price) {
        System.out.println("使用原先方法打折");
        return price*0.8;
    }
}
