import java.util.function.Consumer;

public class ChangingThing implements Runnable {
    final Consumer<Double> consumer;
    boolean add;
    double number = 0;
    public ChangingThing(Consumer<Double> consumer) {
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while (true) {
            double random = Math.random() * 100;
            try {
                Thread.sleep((long) random);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (add) number += random;
            else number -= random;
            add = !add;
            System.out.println("number = " + number);
            consumer.accept(number);
        }
    }

    public double getNumber() {
        return number;
    }
}
