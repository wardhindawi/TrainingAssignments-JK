package com.icsfs.training.fundamentals.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

public class CalculatorService {

	public final int validationValue = 10000;
	private Random randNum = new Random();
	private List<Integer> threeMostFreq;

	public int[] generateRandomNumbers(int arraySize) {
		int[] numbers = new int[arraySize];
		for (int index = 0; index < numbers.length; index++) {
			numbers[index] = randNum.nextInt(1, 1000);
		}
		return numbers;
	}

	public boolean validateInputNumber(int inputNumber) {
		if (inputNumber <= validationValue) {
			return false;
		}
		return true;
	}

	public int arraySum(int[] numbers) {
		int sum = 0;
		for (int index = 0; index < numbers.length; index++) {
			sum += numbers[index];
		}
		return sum;
	}

	public int arrayAvg(int sum, int arraySize) {
		int avg = sum / arraySize;
		return avg;
	}

	public List<Integer> arrayFrequentNum(int[] numbers) {
		HashMap<Integer, Integer> mostFreqMap = new HashMap<>();
		for (int index = 0; index < numbers.length; index++) {
			if (mostFreqMap.containsKey(numbers[index])) {
				mostFreqMap.put(numbers[index], mostFreqMap.get(numbers[index]) + 1);
			} else {
				mostFreqMap.put(numbers[index], 1);
			}
		}

		List<Integer> mostFreqList = new ArrayList<>(mostFreqMap.values());
		Collections.sort(mostFreqList);

		threeMostFreq = new ArrayList<Integer>();
		threeMostFreq.add(getKey(mostFreqMap, mostFreqList.get(mostFreqList.size() - 1)));
		threeMostFreq.add(getKey(mostFreqMap, mostFreqList.get(mostFreqList.size() - 2)));
		threeMostFreq.add(getKey(mostFreqMap, mostFreqList.get(mostFreqList.size() - 3)));
		
		return threeMostFreq;

	}

	public Integer getKey(HashMap<Integer, Integer> mostFreqMap, int value) {
		for (Entry<Integer, Integer> entry : mostFreqMap.entrySet()) {

			if (entry.getValue() == value) {
				if (!threeMostFreq.contains(entry.getKey())) {
					return entry.getKey();
				}
			}
		}
		return null;
	}
}
