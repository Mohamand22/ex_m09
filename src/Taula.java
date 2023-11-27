import javax.swing.JFrame;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Taula extends JFrame {
    public static void main(String[] args) {
        Taula taula = new Taula();
        taula.iniciarSopar();
    }

    private void iniciarSopar() {

        int bufferCapacity = 10;
        Buffer buffer = new Buffer(bufferCapacity);

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();


        Consumer consumer1 = new Consumer("Consumer1", buffer);
        Consumer consumer2 = new Consumer("Consumer2", buffer);

        Producer producer1 = new Producer(buffer);
        Producer producer2 = new Producer(buffer);

        executor.execute(consumer1);
        executor.execute(consumer2);

        executor.execute(producer1);
        executor.execute(producer2);

    }
}
