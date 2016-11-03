package strategy;

/**
 * Created by Liuqi
 * Date: 2016/11/2.
 */

/**
 * 策略模式的实现
 * 对于程序中这个 Discount 接口而言，实现该接口的实现类就可以实现打折，但具体的打折策略与该接口无关，而是由具体的实现类来决定打折策略。
 * 由此可见，这个 Discount 接口的作用和 Spring 框架中 Resource 接口的作用完全相同。
 * 就像 Spring 框架必须为 Resource 接口提供大量实现类一样，我们此处也需要为 DiscountStrategy 接口提供两个实现类，每个实现类代表一种打折策略。
 */
public class DiscountStrategyContext {
    private Discount discount;

    public DiscountStrategyContext(Discount discount) {
        this.discount = discount;
    }

    public double getDiscountPrice(double price) {
        if (discount == null) {
            discount = new OldDiscount();
        }
        return discount.getDiscount(price);
    }

    /**
     * 提供改变打折策略的方法
     *
     * @param discount
     */
    public void changeDiscountMethod(Discount discount) {
        this.discount = discount;
    }
}
