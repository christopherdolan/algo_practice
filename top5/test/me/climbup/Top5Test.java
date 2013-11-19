package me.climbup;

import static me.climbup.Top5.top5;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Top5Test {

	@Test
	public void testTop5() {
		String stanza = "hat the the The The The The The cat cat cat cat in in in";
		List<String> results = top5(stanza);
		assertEquals(Arrays.asList(new String[]{"The", "cat", "in", "the", "hat"}), results);
	}

}
