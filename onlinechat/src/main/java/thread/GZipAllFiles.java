package thread;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Liuqi
 * Date: 2016/9/24
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class GZipAllFiles {

    public static final int Thread_count = 4;

    /**
     * 使用线程池
     *
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(Thread_count);
        for (String str : args) {
            File file = new File(str);
            if (file.exists()) {
                File[] files = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    Runnable task = new GZipRunnable(files[i]);
                    pool.submit(task);
                }
            } else {
                Runnable task = new GZipRunnable(file);
                pool.submit(task);
            }
        }
        pool.shutdown();
    }
}
