import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    private void produce() {
        try {

            Object element = ThreadLocalRandom.current().nextInt(100);
            buffer.produce(element);

            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                produce();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}