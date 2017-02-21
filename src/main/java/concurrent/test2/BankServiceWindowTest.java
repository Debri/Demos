package concurrent.test2;

/**
 * Created by Liuqi
 * Date: 2017/2/21.
 */
public class BankServiceWindowTest {
    public static void main(String[] args){
        final BankServiceWindow bankServiceWindows=new BankServiceWindow(2);
        Thread tom=new Thread(){
            public void run(){
                bankServiceWindows.handle();
                System.out.println("tom开始办理业务");
                try {
                    this.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("tom结束办理业务");
                bankServiceWindows.unhandle();
            }
        };
        Thread jim=new Thread(){
            public void run(){
                bankServiceWindows.handle();
                System.out.println("jim开始办理业务");
                try {
                    this.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("jim结束办理业务");
                bankServiceWindows.unhandle();
            }
        };
        Thread jay=new Thread(){
            public void run(){
                bankServiceWindows.handle();
                System.out.println("jay开始办理业务");
                try {
                    this.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("jay结束办理业务");
                bankServiceWindows.unhandle();
            }
        };
        tom.start();
        jim.start();
        jay.start();
    }
}
