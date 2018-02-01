package com.itch.future.util;

public class Helper {

	private Helper() {

	}

	public static long getSum(int startNumber, int endNumber) {
		
		long sum = 0;
		
		for (int current = startNumber; current <= endNumber; current++) {
			sum += current;
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.err.printf("Interrupted error %s \n\n", e.getMessage());
		}
		System.out.printf("Current thread is %s \n\n", Thread.currentThread().getName());
		return sum;
	}
	
}
