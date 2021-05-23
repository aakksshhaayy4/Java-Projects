package com.akshay.calculator;

public class Calculate implements iCalc {

	private int iFirstNumber;
	private int iSecondNumber;
	private char operator;
	private Double dblNumber = new Double(0);
	private Double dblResult = new Double(0);
	private int iResult = 0;
	private boolean typeDouble = false;
	private boolean typeInt = false;

	Calculate() {
		// default constructor
	}

	Calculate(Double dblNum, char cOperator) {
		// constructor containing two arguments.. This constructor is used for
		// scientific calculations.
		dblNumber = dblNum;
		operator = cOperator;
		typeDouble = true;
	}

	Calculate(int iFirstNum, char cOperator, int iSecondNum) {
		// constructor containing three arguments.. This constructor is used for basic
		// calculations..
		iFirstNumber = iFirstNum;
		operator = cOperator;
		iSecondNumber = iSecondNum;
		typeInt = true;
	}

	@Override
	public void doCalculation() {

		iResult = 0;
		dblResult = 0.0;

		switch (operator) {
		case '+':
			checkInt();
			iResult = iFirstNumber + iSecondNumber;
			break;

		case '-':
			checkInt();
			iResult = iFirstNumber - iSecondNumber;
			break;

		case '*':
			checkInt();
			iResult = iFirstNumber * iSecondNumber;
			break;

		case '/':
			checkInt();
			if (!checkSecondNumber()) {
				iResult = iFirstNumber / iSecondNumber;
				break;
			}
		case 'S':
		case 's':
			checkDouble();
			dblResult = Math.sin(dblNumber);
			break;

		case 'C':
		case 'c':
			checkDouble();
			dblResult = Math.cos(dblNumber);
			break;

		case 'T':
		case 't':
			checkDouble();
			dblResult = Math.tan(dblNumber);
			break;

		case 'L':
		case 'l':
			checkDouble();
			dblResult = Math.log(dblNumber);
			break;

		default:
			iResult = 0;
			dblResult = 0.0;
			System.out.println("No operation found..");
			break;

		}

	}

	@Override
	public void getResult() {

		if (typeInt) {
			System.out.println("Result is : " + iResult);
		} else if (typeDouble) {
			System.out.println("Result is : " + dblResult);
		}
	}

	public boolean checkSecondNumber() {
		// In case of division of two numbers, it checks for value 0 in the second
		// number entered.
		if(iSecondNumber==0) {
			System.out.println("Zero not allowed");
			System.exit(0);
			return true;
		}
		else {
			return false;
		}
	}

	public void checkInt() {
		// Checks if basic calculation is performed
		if (!typeInt) {
			iResult = 0;
			System.out.println("Operation not avaialbe.. select avaialable operation");
			System.exit(0);
		}
	}

	public void checkDouble() {
		// Checks if scientific calculation is performed
		if (!typeDouble) {
			dblResult = 0.0;
			System.out.println("Operation not avaialble.. select available option");
			System.exit(0);
		}
	}

}
