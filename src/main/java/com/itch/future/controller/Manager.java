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

		long sum = Helper.getSum(0, 1000000000) + Helper.getSum(1000000001, 2000000000)
				+ Helper.getSum(2000000001, 2099999999);
		System.out.printf("Sum : %d\n", sum);

		long endTime = System.currentTimeMillis();

		System.out.printf("Time taken : %d\n\n", (endTime - startTime));
	}

	public static void parallelCalculate() {

		long startTime = System.currentTimeMillis();

		ExecutorService executorService = Executors.newFixedThreadPool(3);
		Future<Long> future1 = executorService.submit(new CallableAdder(0, 1000000000));
		Future<Long> future2 = executorService.submit(new CallableAdder(1000000001, 2000000000));
		Future<Long> future3 = executorService.submit(new CallableAdder(2000000001, 2099999999));

		try {

			Long sum = future1.get() + future2.get() + future3.get();

			System.out.printf("Sum : %d\n", sum.longValue());

		} catch (InterruptedException | ExecutionException e) {
			System.err.printf("Error : %s \n\n", e.getMessage());
		}

		long endTime = System.currentTimeMillis();

		System.out.printf("Time taken : %d\n\n", (endTime - startTime));
	}

}
