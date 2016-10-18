package Jvm;

/**
 * Created by Liuqi
 * Date: 2016/10/18
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class JavaVMStackOOM {
    private  void dontStop(){
        while (true){

        }
    }
    public void stackLeakByThread(){
        while (true){
            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom=new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
