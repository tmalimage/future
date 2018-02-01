package com.itch.future;

import java.util.concurrent.Callable;

import com.itch.future.util.Helper;

public class CallableAdder implements Callable<Long> {
	
	private int startNumber;
	private int endNumber;

	public CallableAdder(int startNumber, int endNumber) {
		this.startNumber = startNumber;
		this.endNumber = endNumber;
	}
	
	@Override
	public Long call() throws Exception {
		return Helper.getSum(startNumber, endNumber);
	}

}
