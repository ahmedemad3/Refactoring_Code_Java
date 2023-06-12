package com.eg.lb.algorithms;

import java.util.*;

public class RoundRobin {

	public static void main(String[] args) {
		List<String> resources = Arrays.asList("Server 1", "Server 2", "Server 3");
		int currentIndex = 0;

		// simulate 10 incoming requests
		for (int i = 1; i <= 10; i++) {
			String currentResource = resources.get(currentIndex);
			System.out.println("Request " + i + " handled by " + currentResource);

			// move to the next resource in the list
			currentIndex = (currentIndex + 1) % resources.size();
//			currentIndex ++;
//			if(currentIndex == resources.size())
//				currentIndex = 0;
		}
	}

}
