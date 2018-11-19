import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest {
    @Test
    public void testALPriorityQueue() {
        testPriorityQueue(new ALPriorityQueue<Integer, String>());
    }

    @Test
    public void testDLPriorityQueue() {
        testPriorityQueue(new DLPriorityQueue<Integer, String>());
    }
    @Test
    public void testBHPriorityQueue() throws ExecutionControl.ExecutionControlException {
        testPriorityQueue(new BHPriorityQueue<Integer, String>());
    }

    public void testPriorityQueue(VCPriorityQueue queueInstance) {
        queueInstance.enqueue(3, "Man sneezing");
        queueInstance.enqueue(1,"Man Dying");
        queueInstance.enqueue(2, "Man cut his finger");
        queueInstance.enqueue(4, "Mr Nobody 1");
        queueInstance.enqueue(5, "Mr Nobody 2");
        queueInstance.enqueue(6, "Mr Nobody 6");
        queueInstance.enqueue(7, "Mr Nobody 7");
        queueInstance.enqueue(8, "Mr Nobody 8");
        queueInstance.enqueue(9, "Mr Nobody 9");
        queueInstance.enqueue(10, "Mr Nobody 10");

        assertEquals("Man Dying", queueInstance.dequeueMin().getValue());
        assertEquals("Man cut his finger", queueInstance.dequeueMin().getValue());
        assertEquals("Man sneezing", queueInstance.dequeueMin().getValue());
    }
}
