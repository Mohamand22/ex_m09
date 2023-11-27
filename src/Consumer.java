import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Consumer implements Runnable {
    private Buffer buffer;
    private String name;

    public Consumer(String name, Buffer buffer) {
        this.name = name;
        this.buffer = buffer;
    }

    private void consume() {
        try {

            Object element = buffer.consume();

            System.out.println(name + " consumed: " + element);

            // Simulate consumption time
            Thread.sleep(1000); // Adjust as needed
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                consume();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
