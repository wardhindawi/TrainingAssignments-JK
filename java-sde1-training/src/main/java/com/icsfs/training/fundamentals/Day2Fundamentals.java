package com.icsfs.training.fundamentals;

import java.util.List;
import java.util.Scanner;

import com.icsfs.training.fundamentals.service.CalculatorService;

//Day 2 Practice: Fundamentals
public class Day2Fundamentals {

	private static CalculatorService calculatorService = new CalculatorService();
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		int arraysize = scanInput();
		int[] numbers;

		while (true) {

			if (calculatorService.validateInputNumber(arraysize)) {
				numbers = calculatorService.generateRandomNumbers(arraysize);
				input.close();
				break;
			}

			arraysize = scanInput();
		}

		/**** Calculate and Print ****/
		int sum = calculatorService.arraySum(numbers);
		System.out.println("Sum of all the array items: " + sum);

		int avg = calculatorService.arrayAvg(sum, arraysize);
		System.out.println("Average of all the array items: " + avg);

		List<Integer> threeMostFreq = calculatorService.arrayFrequentNum(numbers);
		System.out.println("Most frequent three numbers: " + threeMostFreq);
	}

	private static int scanInput() {
		System.out.println("Please enter array size  more than " + calculatorService.validationValue + ": ");
		return input.nextInt();
	}

}
