import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        Consumer<Double> eventCheck = number -> {
            if (closeToZero(number))
                System.out.println("Event: number is relatively close to zero! " + number);
        };
        Consumer<Double> pollingCheck = number -> {
            if (closeToZero(number))
                System.out.println("Polling: number is relatively close to zero! " + number);
        };

        ChangingThing changingThing = new ChangingThing(eventCheck);
        PollingThing pollingThing = new PollingThing(changingThing, pollingCheck);

        new Thread(changingThing).start();
        new Thread(pollingThing).start();
    }
    static boolean closeToZero(double number) {
        return Math.abs(number) < 250;
    }
}
