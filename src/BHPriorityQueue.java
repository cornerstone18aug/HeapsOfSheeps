import java.util.LinkedList;

public class BHPriorityQueue<K extends Comparable, V> implements VCPriorityQueue<K, V> {

    private LinkedList<Entry<K, V>> queue;

    public BHPriorityQueue() {
        queue = new LinkedList<Entry<K, V>>();
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
        Entry<K, V> entry = new Entry<>(key, value);
        queue.add(entry);
        int newIndex = this.sortHeap();
        return this.queue.get(newIndex);
    }

    @Override
    public Entry<K, V> peek() {
        return this.queue.get(0);
    }

    @Override
    public Entry<K, V> dequeueMin() {
        Entry r = this.queue.pop();
        this.sortHeap();
        return r;
    }

    @Override
    public VCPriorityQueue<K, V> merge(VCPriorityQueue<K, V> other) {
        ALPriorityQueue<K, V> otherQ = ((ALPriorityQueue) other);
        for (Entry<K, V> entry : otherQ.getQueue()) {
            this.enqueue(entry.getKey(), entry.getValue());
        }

        return this;
    }

    private int sortHeap() {
        Integer index = this.queue.size() - 1;
        Integer parentIndex = (int) Math.floor(index / 2.0);
        while (this.queue.get(index) != null && this.queue.get(index).getKey().compareTo(this.queue.get(parentIndex).getKey()) < 0) {
            Entry temp = this.queue.get(parentIndex);
            this.queue.set(parentIndex, this.queue.get(index)); // do the swap
            this.queue.set(index, temp);
            index = parentIndex;
            parentIndex = (int) Math.floor(index / 2.0);
        }
        return index;
    }
}
