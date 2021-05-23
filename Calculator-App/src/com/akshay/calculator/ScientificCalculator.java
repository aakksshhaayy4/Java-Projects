package com.akshay.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScientificCalculator extends Calculate {

	char operator;
	Double dblNumber = new Double(0);

	public ScientificCalculator() {
		// TODO Auto-generated constructor stub
	}

	ScientificCalculator(double dblNumber, char operator) {
		super(dblNumber, operator);

		this.operator = operator;
		this.dblNumber = dblNumber;
	}

	public void calc() throws IOException {

		boolean next;

		do {
			Double d = new Double(0);

			BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Enter the operation (Sin : s, Cos : c, tan : t, log : l :) : ");

			System.out.flush();

			String option = bfr.readLine();

			System.out.println("Enter the value : ");
			System.out.flush();

			try {
				d = Double.valueOf(bfr.readLine());
			} catch (NumberFormatException nfe) {
				System.out.println("Enter numberic value only");
				System.exit(0);
			}

			if (option.length() == 1) {
				// creates object of teh class
				ScientificCalculator sc = new ScientificCalculator(d, option.charAt(0));

				sc.doCalculation();
				sc.getResult();
			} else {
				System.out.println("Operation not found..");
			}
			System.out.println("Do you want to perform operation once again ? (y/n) :");
			System.out.flush();

			char again = (char) bfr.read();
			if ((again == 'y') || (again == 'Y')) {
				next = false;
			} else {
				next = true;
			}
		} while (!next);
	}

}
