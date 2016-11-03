package strategy;

/**
 * Created by Liuqi
 * Date: 2016/11/2.
 */
public class StrategyTest {
    public static void main(String[] args) {
        //参数值为空，使用默认打折策略
        DiscountStrategyContext context = new DiscountStrategyContext(null);
        double price = 80;
        System.out.println(context.getDiscountPrice(price));
        //改变打折策略
        context.changeDiscountMethod(new VipDiscount());
        context.getDiscountPrice(price);
    }
}
