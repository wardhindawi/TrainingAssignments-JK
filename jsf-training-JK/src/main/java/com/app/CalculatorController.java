package com.app;

import java.io.Serializable;

import io.micrometer.common.util.StringUtils;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.val;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Named("calculator")
@ViewScoped
public class CalculatorController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int value1;
	private int value2;
	private String value = "";
	private int choice = 0;

	public void setNumber(int Number) {
		if (choice == -1)
			value = "";
		value = value + "" + Number;
		if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
			choice = 0;
		}
	}

	public void deleteAllC() {
		if (value != "") {
			value1 = Integer.parseInt(value);
		}
		value = "";
	}

	// TODO
	public void deleteAllCE() {
		value1 = 0;
		value2 = 0;
		choice = 0;
		value = "";
	}

	public void deleteDigit() {
		if (value != "") {
			char c[] = value.toCharArray();
			System.out.println("array size => " + c.length);
			value = StringUtils.truncate(value, c.length - 1);
		} else {
			System.out.println("value is empty");
		}
	}

	public int getValue1() {
		return value1;
	}

	public void setValue1(int value) {
		value1 = value;
	}

	public int getValue2() {
		return value2;
	}

	public void setValue2(int value2) {
		this.value2 = value2;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int add(int v1, int v2) {
		return v1 + v2;
	}

	public int substract(int v1, int v2) {
		return v1 - v2;
	}

	public int multiply(int v1, int v2) {
		return v1 * v2;
	}

	public int divide(int v1, int v2) {
		return v1 / v2;
	}

	public void sqrootCal() {
		if (value != "") {
			value1 = Integer.parseInt(value);
			value1 = (int) Math.sqrt(value1);
			value = value1 + "";
		}
	}

	public void power() {
		if (value != "") {
			value1 = Integer.parseInt(value);
			value1 = (int) Math.pow(value1, 2);
			value = value1 + "";
		}
	}

	public void negateNumber() {
		value1 = Integer.parseInt(value);
		value = Math.negateExact(value1) + "";
	}

	public int mod(int x, int y) {
		return x % y;
	}

	public void showResult() {
		if (value != "") {
			this.value2 = Integer.parseInt(value);
			switch (this.choice) {
			case 1:
				value = Integer.toString(add(value1, value2));
				this.choice = -1;
				return;
			case 2:
				value = Integer.toString(substract(value1, value2));
				this.choice = -1;
				return;
			case 3:
				value = Integer.toString(multiply(value1, value2));
				this.choice = -1;
				return;
			case 4:
				value = Integer.toString(divide(value1, value2));
				this.choice = -1;
				return;
			case 5:
				value = Integer.toString(mod(value1, value2));
				System.out.println("value = " + value);
				this.choice = -1;
				return;
			default:
				System.out.println("default");
				return;
			}
		}
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		System.out.println("1- value 1 = " + value1);
		if (value != "")
			value1 = Integer.parseInt(value);
		System.out.println("2- value 1 = " + value1);
		value = "";
		this.choice = choice;
	}

	public static void main(String[] args) {
		int x = 4 % 2;
		System.out.println("x: " + x);
	}

}
