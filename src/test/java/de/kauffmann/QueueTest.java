package de.kauffmann;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
	Queue q = new Queue(3); 
	@Test
	public void testEnqueueDequeue() {
		
		q.enqueue(1);
		assertEquals(1, q.dequeue());
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		assertEquals(1, q.dequeue());
		
	}
	
	@Test(expected=IllegalStateException.class, timeout=1000)
	public void testDequeueLeer() {
		q.dequeue();
	}
	
	
	
}
