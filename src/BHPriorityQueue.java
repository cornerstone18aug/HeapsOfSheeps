import java.util.LinkedList;

public class BHPriorityQueue<K extends Comparable, V>  implements VCPriorityQueue<K, V> {

    private LinkedList<Entry<K, V>> queue;

    public BHPriorityQueue() {
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
