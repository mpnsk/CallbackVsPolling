import java.util.function.Consumer;

public class PollingThing implements Runnable {

    final ChangingThing changingThing;
    private final Consumer<Double> consumer;

    public PollingThing(ChangingThing changingThing, Consumer<Double> consumer) {
        this.changingThing = changingThing;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            double number = changingThing.getNumber();
            consumer.accept(number);
        }
    }
}
