package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4 {


/*请完成下面这个函数，实现题目要求的功能*/
/*当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ */

    /******************************开始写代码******************************/
    static int maxProfit(int[] stockPrices, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < stockPrices.length; i += k) {
            list.add(stockPrices[i]);
        }
        int sum=-list.get(0);
        for (int i=1;i<list.size();i++){
            if (sum+list.get(i)<0){
                sum-=list.get(i);

            }else {
                sum+=list.get(i);
            }
        }
        return sum;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _stockPrices_size = 0;
        _stockPrices_size = Integer.parseInt(in.nextLine().trim());
        int[] _stockPrices = new int[_stockPrices_size];
        int _stockPrices_item;
        for (int _stockPrices_i = 0; _stockPrices_i < _stockPrices_size; _stockPrices_i++) {
            _stockPrices_item = Integer.parseInt(in.nextLine().trim());
            _stockPrices[_stockPrices_i] = _stockPrices_item;
        }

        int _k;
        _k = Integer.parseInt(in.nextLine().trim());

        res = maxProfit(_stockPrices, _k);
        System.out.println(String.valueOf(res));

    }
}
