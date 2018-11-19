import java.util.LinkedList;
import java.util.List;

public class D​​LPriorityQueue<K extends Comparable, V>  implements VCPriorityQueue<K, V> {

    private List<Entry<K, V>> queue;

    public D​​LPriorityQueue() {
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
        Entry<K, V> minEntry = queue.get(0);
        int minIndex = 0;
        for (int i = 0; i < queue.size(); i++){
             if (queue.get(i).getKey().compareTo(minEntry.getKey()) < 0){
                 minEntry = queue.get(i);
                 minIndex = i;
             }
        }
        queue.add(minIndex, newEntry);
        return newEntry;
    }

    @Override
    public Entry<K, V> peek() {
        return queue.get(0);
    }

    @Override
    public Entry<K, V> dequeueMin() {
        return queue.remove(0);
    }

    public List<Entry<K, V>> getQueue() { return queue;}

    @Override
    public VCPriorityQueue<K, V> merge(VCPriorityQueue<K, V> other) {
        D​​LPriorityQueue<K, V> otherQ = ((D​​LPriorityQueue) other);
        for (int i = 0; i < queue.size(); i++) {
            for (int j = 0; j < otherQ.size(); j++){
                if (otherQ.getQueue().get(i).getKey().compareTo(queue.get(j).getKey()) < 0) {
                    this.queue.add(j, otherQ.getQueue().get(i));
                } else {
                    this.queue.add(0, otherQ.getQueue().get(i));
                }
            }
        }
        return this;
    }
}
