package com.akshay.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UseCalculate {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// provides creates instances of Class Calculator or Class ScientificCalculator,
		// based on the option selected by user

		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Select Calculator (Basic Calculator : b or Scientific Calculator : s) : ");
		System.out.flush();

		String option = bfr.readLine();

		if (option.length() == 1) {
			if (option.equals("b") || option.equals("B")) {
				Calculator cal = new Calculator();
				cal.calc();
			} else if (option.equals("s") || option.equals("S")) {
				ScientificCalculator sc = new ScientificCalculator();
				sc.calc();
			} else {
				System.out.println("Please enter 'b' or 's' ..");
			}

		} else {
			System.out.println("Please enter 'B' or 'S' ..");
		}
	}

}
