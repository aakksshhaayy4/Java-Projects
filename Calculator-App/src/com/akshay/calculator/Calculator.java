package com.akshay.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;

public class Calculator {

	public void calc() throws IOException {

		boolean next;

		do {
			Integer iFirstNumber = new Integer(0);
			Integer iSecondNumber = new Integer(0);

			BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Enter the First Number : ");
			System.out.flush();

			try {
				iFirstNumber = Integer.parseInt(bfr.readLine());
			} catch (NumberFormatException nfe) {
				System.out.println("Enter only numeric value..");
				System.exit(0);
			}

			System.out.println(
					"Enter the Operation(Addition : +, Substraction : -, Multiplication : *, Division : /) :: ");
			System.out.flush();

			String option = bfr.readLine();

			System.out.println("Enter Second Number");

			try {
				iSecondNumber = Integer.parseInt(bfr.readLine());
			} catch (NumberFormatException nfe) {
				System.out.println("Enter only numeric value..");
				System.exit(0);
			}

			if ((option.length()) == 1) {
				// creates calculate class object here
				Calculate cal = new Calculate(iFirstNumber, option.charAt(0), iSecondNumber);

				// calling the methods to furthure process
				cal.doCalculation();
				cal.getResult();
			} else {
				System.out.println("Operation not available..");
			}

			// to check whether user want to calculate once again
			System.out.println("Do you want to calculate for one more time ? (y/n) : ");
			System.out.flush();

			char responce = (char) bfr.read();

			if ((responce == 'y') || (responce == 'Y')) {
				next = false;
			}
			else {
				next=true;
			}
		} while (!next);

	}

}
