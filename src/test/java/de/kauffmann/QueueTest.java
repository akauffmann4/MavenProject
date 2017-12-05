package de.kauffmann;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
	
	@Test
	public void testEnqueueDequeue() {
		Queue q = new Queue(3); 
		q.enqueue(1);
		assertEquals(1, q.dequeue());
	}
	
	
	
}
