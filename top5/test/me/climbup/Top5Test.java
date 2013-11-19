package me.climbup;

import static me.climbup.Top5.top5;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Top5Test {

	@Test
	public void testUnambiguousCounts() {
		String stanza = "hat the the The The The The The cat cat cat cat in in in";
		List<String> results = top5(stanza);
		assertEquals(Arrays.asList(new String[]{"The", "cat", "in", "the", "hat"}), results);
	}
	
	@Test
	public void testEmptyString() {
		String stanza = "";
		List<String> results = top5(stanza);
		assertEquals(Arrays.asList(new String[]{""}), results);
	}
	
	@Test
	public void testThreeWayTie() {
		String stanza = "the the big dog dog big";
		List<String> results = top5(stanza);
		assertEquals(Arrays.asList(new String[]{"big", "dog", "the"}), results);
	}
	
	@Test
	public void testIgnorePunctuation() {
		String stanza = "the the. big dog dog big.";
		List<String> results = top5(stanza);
		assertEquals(Arrays.asList(new String[]{"big", "dog", "the"}), results);
	}

}
