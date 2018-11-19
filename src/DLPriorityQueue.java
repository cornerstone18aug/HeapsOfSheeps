import java.util.Collections;
import java.util.LinkedList;

public class DLPriorityQueue<K extends Comparable, V> implements VCPriorityQueue<K, V> {

    private LinkedList<Entry<K, V>> queue;

    public DLPriorityQueue() {
        queue = new LinkedList<>();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public Entry<K, V> enqueue(K key, V value) throws IllegalArgumentException {
        Entry<K, V> newEntry = new Entry<>(key, value);
        this.queue.add(new Entry<K, V>(key, value));
        Collections.sort(queue, (item1, item2) -> item1.getKey().compareTo(item2.getKey()));
        return newEntry;
    }

    @Override
    public Entry<K, V> peek() {
        return this.queue.getFirst();
    }

    @Override
    public Entry<K, V> dequeueMin() {
        return this.queue.pop();
    }

    @Override
    public VCPriorityQueue<K, V> merge(VCPriorityQueue<K, V> other) {
        ALPriorityQueue<K, V> otherQ = ((ALPriorityQueue) other);
        for (Entry<K, V> entry : otherQ.getQueue()) {
            this.queue.add(entry);
        }
        return this;
    }
}
