package me.climbup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;

public class Top5 {

	public static List<String> top5(String stanza) {
		List<String> results = new ArrayList<String>();
		List<String> words = Arrays.asList(stanza.replaceAll("[\\.;,:]+","").split(" "));
		Map<String, Integer> frequencyMap = new HashMap<String, Integer>();
		for (String word : words) {
			frequencyMap.put(word, frequencyMap.containsKey(word) ? frequencyMap.get(word) + 1 : 1);
		}
		SortedSet<Entry<String,Integer>> resultSet = 
			new TreeSet<Entry<String,Integer>>(
					new Comparator<Entry<String,Integer>>() {
						public int compare(	Entry<String, Integer> first,
											Entry<String, Integer> second) {
							if (second.getValue().compareTo(first.getValue()) == 0) {
								return first.getKey().compareTo(second.getKey());
							} else {
								return second.getValue().compareTo(first.getValue());
							}
						}
					}
			);
		resultSet.addAll(frequencyMap.entrySet());
		Iterator<Entry<String,Integer>> resultSetIter = resultSet.iterator();
		
		for (int i = 0; i < 5; i++) {
			while (resultSetIter.hasNext()) {
				results.add(resultSetIter.next().getKey());
			}
		}
		return results;
	}
}
