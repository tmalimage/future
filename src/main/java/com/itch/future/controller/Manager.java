package com.itch.future.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.itch.future.CallableAdder;
import com.itch.future.util.Helper;

public class Manager {

	public static void sequentialCalculate() {
		
		long startTime = System.currentTimeMillis();

		System.out.printf("Round 1 : %d\n", Helper.getSum(0, 1000000000));
		System.out.printf("Round 2 : %d\n", Helper.getSum(1000000001, 2000000000));
		System.out.printf("Round 3 : %d\n", Helper.getSum(2000000001, 2099999999));

		long endTime = System.currentTimeMillis();

		System.out.printf("Time taken : %d\n\n", (endTime - startTime));
	}

	public static void parallelCalculate() {
		
		long startTime = System.currentTimeMillis();

		ExecutorService executorService = Executors.newFixedThreadPool(3);
		Future<Long> future1 = executorService.submit(new CallableAdder(0, 1000000000));
		Future<Long> future2 = executorService.submit(new CallableAdder(1000000001, 2000000000));
		Future<Long> future3 = executorService.submit(new CallableAdder(2000000001, 2099999999));

		while (!future1.isDone() || !future2.isDone() || !future3.isDone()) {
			continue;
		}

		try {
			System.out.printf("Round 1 : %d\n", future1.get());
			System.out.printf("Round 2 : %d\n", future2.get());
			System.out.printf("Round 3 : %d\n", future3.get());			
		} catch (InterruptedException | ExecutionException e) {
			System.err.printf("Error : %s \n\n", e.getMessage());
		}

		long endTime = System.currentTimeMillis();

		System.out.printf("Time taken : %d\n\n", (endTime - startTime));
	}

}
