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
        throw new ExecutionControl.NotImplementedException("Not implemented");
//        testPriorityQueue(new BHPriorityQueue<Integer, String>());
    }

    public void testPriorityQueue(VCPriorityQueue queueInstance) {
        queueInstance.enqueue(3, "Man sneezing");
        queueInstance.enqueue(1,"Man Dying");
        queueInstance.enqueue(2, "Man cut his finger");

        assertEquals("Man Dying", queueInstance.dequeueMin().getValue());
        assertEquals("Man cut his finger", queueInstance.dequeueMin().getValue());
        assertEquals("Man sneezing", queueInstance.dequeueMin().getValue());
    }
}
