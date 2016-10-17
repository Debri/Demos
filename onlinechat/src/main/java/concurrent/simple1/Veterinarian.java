package concurrent.simple1;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Liuqi
 * Date: 2016/10/17
 * Email: 18908356464@163.com
 * Project: Demos
 */
public class Veterinarian implements Runnable {
    protected final BlockingQueue<Pet.Appointment<Pet>> appts;
    protected String text = "";
    protected final int restTime;
    private boolean shutdown = false;

    public Veterinarian(BlockingQueue<Pet.Appointment<Pet>> appts, int restTime) {
        this.appts = appts;
        this.restTime = restTime;
    }

    public synchronized void shutdown() {
        shutdown = true;
    }

    public void seePatient() {
        try {
            Pet.Appointment<Pet> appointment = appts.take();
            Pet patient = appointment.getPatient();
            patient.examine();
        } catch (InterruptedException e) {
            e.printStackTrace();
            shutdown = true;
        }
    }

    @Override
    public void run() {
        while (!shutdown) {
            seePatient();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                shutdown = true;
            }
        }
    }
}
