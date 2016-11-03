package strategy;

/**
 * Created by Liuqi
 * Date: 2016/11/2.
 */
public class VipDiscount implements Discount {
    public VipDiscount() {
    }

    public double getDiscount(double price) {
        System.out.println("使用Vip打折方法");
        return price * 0.5;

    }
}
