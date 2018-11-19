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

    public void setQueue(LinkedList<Entry<K, V>> queue) {
        this.queue = queue;
    }

    @Override
    public VCPriorityQueue<K, V> merge(VCPriorityQueue<K, V> other) {
        int i = 0;
        int j = 0;

        LinkedList<Entry<K, V>> mergedQueue = new LinkedList<>();
        DLPriorityQueue<K, V> otherQ = (DLPriorityQueue<K, V>) other;
        while (i < this.queue.size() && j < other.size()) {
            if (this.queue.get(i).getKey().compareTo(otherQ.queue.get(j).getKey()) < 0) {
                mergedQueue.add(this.queue.get(i));
                i++;
            } else {
                mergedQueue.add(otherQ.queue.get(j));
                j++;
            }
        }
        if (i != this.queue.size()) {
            while (i < this.queue.size()) {
                mergedQueue.add(this.queue.get(i));
                i++;
            }
        }
        if (j != otherQ.queue.size()) {
            while (j < otherQ.queue.size()) {
                mergedQueue.add(otherQ.queue.get(j));
                j++;
            }
        }
        this.setQueue(mergedQueue);
//
//        ALPriorityQueue<K, V> otherQ = ((ALPriorityQueue) other);
//        for (Entry<K, V> entry : otherQ.getQueue()) {
//            this.enqueue(entry.getKey(), entry.getValue());
//        }
        return this;
    }
}
