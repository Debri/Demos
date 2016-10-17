package concurrent.simple1;

/**
 * Created by Liuqi
 * Date: 2016/10/17
 * Email: 18908356464@163.com
 * Project: Demos
 */
public abstract class Pet {
    protected final String name;

    public Pet(String name) {
        this.name = name;
    }

    public abstract void examine();

    public class Cat extends Pet {
        public Cat(String name) {
            super(name);
        }

        @Override
        public void examine() {
            System.out.println("mao");
        }
    }

    public class Dog extends Pet {
        public Dog(String name) {
            super(name);
        }

        @Override
        public void examine() {
            System.out.println("gou");
        }
    }

    public class Appointment<T> {
        private final T toBeSeen;

        public T getPatient() {
            return toBeSeen;
        }

        public Appointment(T toBeSeen) {
            this.toBeSeen = toBeSeen;
        }
    }
}
