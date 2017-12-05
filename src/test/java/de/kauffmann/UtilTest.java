package de.kauffmann;
import org.junit.Test;
import static org.junit.Assert.*;


public class UtilTest {

	@Test
	public void testistErstesHalbjahr() {
		for (int i = 1; i<6; ++i) {
			assertEquals(true, Util.istErstesHalbjahr(i));
		}
		
		for (int j = 7; j<13; ++j) {
			assertEquals(false, Util.istErstesHalbjahr(j));
		}
	 
	
	}
	@Test(expected=IllegalArgumentException.class, timeout=1000)
	public void testistErstesHalbjahrNull() {
		Util.istErstesHalbjahr(0);
	}
	
	@Test(expected=IllegalArgumentException.class, timeout=1000)
	public void testistErstesHalbjahrMehr() {
		Util.istErstesHalbjahr(13);
	}
	
}
