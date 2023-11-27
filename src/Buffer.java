import java.util.ArrayList;
import java.util.List;

public class Buffer {
    private final int capacity;
    private List<Object> elements;

    public Buffer(int capacity) {
        this.capacity = capacity;
        this.elements = new ArrayList<>();
    }

    public synchronized void produce(Object element) throws InterruptedException {
        while (elements.size() == capacity) {
            wait();
        }

        elements.add(element);
        notifyAll();
    }

    public synchronized Object consume() throws InterruptedException {
        while (elements.isEmpty()) {
            // Buffer is empty, wait for elements
            wait();
        }

        Object element = elements.remove(0);

        notifyAll();

        return element;
    }
}
