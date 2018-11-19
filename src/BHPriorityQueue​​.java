import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BHPriorityQueue​​ <K extends Comparable, V>  implements VCPriorityQueue<K, V> {

    private List<Entry<K, V>> queue;

    public BHPriorityQueue​​() { queue = new ArrayList<>(); }

    @Override
    public int size() { return queue.size(); }

    @Override
    public boolean isEmpty() { return queue.isEmpty(); }

    @Override
    public Entry<K, V> enqueue(K key, V value) throws IllegalArgumentException {
        Entry<K, V> newEntry = new Entry<>(key, value);
        queue.add(newEntry);
        int insertIndex = queue.size() - 1;
        while (insertIndex > 0) {
            int parentIndex = (insertIndex - 1) / 2;
            Entry<K, V> insertEntry = queue.get(insertIndex);
            Entry<K, V> parentEntry = queue.get(parentIndex);
            if (insertEntry.getKey().compareTo(parentEntry.getKey()) > 0) {
                Entry<K, V> temp = queue.get(parentIndex);
                //swap
                queue.set(parentIndex, queue.get(insertIndex));
                queue.set(insertIndex, temp);

                insertIndex = parentIndex;
            } else {
                break;
            }
        }
        return newEntry;
    }

    @Override
    public Entry<K, V> peek() { return queue.get(0); }

    @Override
    public Entry<K, V> dequeueMin() {
        if (queue.size() == 1) {
            return queue.remove(0);
        }


        int parentIndex = 0;
        int rightChildIndex = 2 * parentIndex + 1;

        Entry<K, V> tempDequeue = queue.get(0);
        queue.set(0, queue.remove( queue.size() - 1));

        while (rightChildIndex < queue.size()) {
            int leftChildIndex = rightChildIndex + 1;
            int bigger = leftChildIndex;
            if (rightChildIndex < queue.size()) {
                if (queue.get(rightChildIndex).getKey().compareTo(queue.get(leftChildIndex).getKey()) > 0) {
                    bigger = rightChildIndex;
                }
            }
            if (queue.get(parentIndex).getKey().compareTo(queue.get(bigger).getKey()) < 0) {
                Entry<K, V> temp = queue.get(parentIndex);
                queue.set(parentIndex, queue.get(bigger));
                queue.set(bigger, temp);
                parentIndex = bigger;
                rightChildIndex = 2 * parentIndex + 1;
            } else {
                break;
            }
        }
        return tempDequeue;
    }

    @Override
    public VCPriorityQueue<K, V> merge(VCPriorityQueue<K, V> other) {
        return null;
    }
}
