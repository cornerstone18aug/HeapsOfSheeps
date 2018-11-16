import java.util.ArrayList;
import java.util.List;

public class D​​LPriorityQueue<K extends Comparable, V>  implements VCPriorityQueue<K, V> {

    private List<Entry<K, V>> queue;

    public D​​LPriorityQueue() {
       queue = new ArrayList<>();
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
        return null;
    }

    @Override
    public Entry<K, V> peek() {
        return null;
    }

    @Override
    public Entry<K, V> dequeueMin() {
        return null;
    }

    @Override
    public VCPriorityQueue<K, V> merge(VCPriorityQueue<K, V> other) {
        return null;
    }
}
