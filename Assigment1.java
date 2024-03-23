package hospital;

import java.util.Scanner;

public class Assigment1 { // The name of the class.

	public static void main(String[] args) {

		System.out.println(
				"Please enter the number of days that a patient has entered the hospital");/*
																							 * To know how many days
																							 * that the patient spent in
																							 * hospital.
																							 */
		Scanner input = new Scanner(System.in);
		int number_of_days = input.nextInt();// Enter the number of days
		double[][] hospital;/*
							 * Define ragged array with row (number of days) and column (number of
							 * temperatures).
							 */
		hospital = new double[number_of_days][];

		for (int i = 0; i < hospital.length; i++) {
			System.out.println(
					"Please enter the number of times that the nurse read the tempreture of the patient in Celsius in day "
							+ (i + 1));
			int number_of_times = input.nextInt();// Enter number of readings.
			hospital[i] = new double[number_of_times];
		}

		for (int i = 0; i < hospital.length; i++) {
			for (int j = 0; j < hospital[i].length; j++) {
				System.out.print(" Please enter the tempreture in day " + (i + 1) + " in reading " + (j + 1) + " : ");
				double temperatures = input.nextDouble();// Enter the temperatures.
				if (temperatures >= 30 && temperatures <= 45) {// Conditions for temperatures.
					hospital[i][j] = temperatures;
				} else {
					System.out.println(" ERROR !!! ");// If the temperature below 30 or above 45.

					j--;// Decrement j.
					continue;// To start again from for loop.
				}

			}
		}
		input.close();// Close the Scanner.
		System.out.println(" ");// Next line.
		double[] maximum_minimum_avg = Summary(hospital);/*
															 * Call the method Summary to print the maximum
															 * temperature,minimum temperature and average.
															 */
		System.out.println(" -----------------------------------------------------------------------------------");
		System.out.println("The maximum temperature is: " + maximum_minimum_avg[0]);// Print the maximum temperature.
		System.out.println("The minimum temerature is: " + maximum_minimum_avg[1]);// Print the minimum temperature.
		int number = (int) ((maximum_minimum_avg[2] + 0.005) * 100);/*
																	 * Multiply the average by 100 and casting it to
																	 * integer. (0.005 for approximation).
																	 */
		double average = number / 100.0;// To make the average have only two decimal numbers after the comma.
		System.out.println("The Average is: " + average);// Print the average of temperatures.

		int[] below_above = countbelowAboveAverage(hospital,
				maximum_minimum_avg[2]);/*
										 * Call the method countbelowAboveAverage to print the total Number of
										 * temperatures Below and Above average.
										 */
		System.out.println("Total Number of reading Below average or equal is "
				+ below_above[0]);/*
									 * Print total Number of reading Below average or equal.
									 */
		System.out.println("Total Number of reading Above average is "
				+ below_above[1]);/*
									 * Print total Number of reading Above average.
									 */
		System.out.println(" -----------------------------------------------------------------------------------");
		System.out.println("After Sort array");
		double[][] sort = sortArray(hospital);// Call the method sortArray for sorting.
		printArray(sort);// Call the method printArray for printing the sorting array.
		System.out.println(" -----------------------------------------------------------------------------------");
		double value = leaveHospital(sort);/*
											 * Call the mehod leaveHospital for printing average and if patient can
											 * leave or not.
											 */
		int num = (int) ((value + 0.005) * 100);// Multiply the average of 4 readings by 100 and casting it to integer.
		double avg_last_temp = num / 100.0;/*
											 * To make the average of 4 readings have only two decimal numbers after the
											 * comma.
											 */

		if (value >= 35.5 && value <= 36.5)// If the average between 35.5-36.5.
		{
			System.out.println("Your average is Stable and it's :" + avg_last_temp + " C, You can leave.");
		}

		else {
			System.out.println("Your average is not Stable and it's :" + avg_last_temp + " C, You can't leave.");
		}

	}

	public static double[] Summary(
			double[][] temp)/*
							 * This method is to find average,maximum and minimum value of the temperatures.
							 */
	{
		double summary_array[] = new double[3];// Define an array of size 3.
		double sum = 0.0;// Define the sum and set it's initial value to zero.
		double count = 0.0;// Define the count(number of readings) and set it's initial value to zero.
		double avg = 0.0;// Define the average and set it's initial value to zero.
		double maximum = temp[0][0];// Define the maximum and set it's initial value to the first temperature.
		double minimum = temp[0][0];// Define the minimum and set it's initial value to the first temperature.

		for (int i = 0; i < temp.length; i++) {
			count += temp[i].length;// To find a number of temperatures.
			for (int j = 0; j < temp[i].length; j++) {
				sum += temp[i][j];// To find the sum of temperatures.
				if (temp[i][j] > maximum) {

					maximum = temp[i][j];
				}

				if (temp[i][j] < minimum) {

					minimum = temp[i][j];
				}

			}
			avg = sum / count;// Divide the sum by the count to find the average.
			summary_array[0] = maximum;
			summary_array[1] = minimum;
			summary_array[2] = avg;
		}
		return summary_array;// Return maximum, minimum and average.

	}

	public static int[] countbelowAboveAverage(double[][] temp,
			double average)/*
							 * Method to print the number of temperatures below and above the average.
							 */

	{
		int count_Array[] = new int[2];// Define an array of size 2.
		int number_readings_below_avg = 0;// Define the number below the average and set it's initial value to zero.
		int number_readings_above_avg = 0;// Define the number above the average and set it's initial value to zero.
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				if (temp[i][j] <= average) {// If a temperature less than or equal the average.
					number_readings_below_avg++;// Increment the number below the average.

				} else {// If the first condition is not true.
					number_readings_above_avg++;// Decrement the number above the average.
				}
			}
			count_Array[0] = number_readings_below_avg;
			count_Array[1] = number_readings_above_avg;

		}
		return count_Array;// Return the number of above and below the average.

	}

	public static double[][] sortArray(double[][] temp) {// Method to sort array in ascending order.

		double[][] new_array = new double[temp.length][];// Define a new array with the same size of hospital.
		for (int i = 0; i < temp.length; i++) {
			new_array[i] = new double[temp[i].length];
			for (int j = 0; j < temp[i].length; j++) {
				new_array[i][j] = temp[i][j];
			}
		}

		for (int i = 0; i < new_array.length; i++) {// 3 for loops to sort.
			for (int j = 0; j < new_array[i].length; j++) {
				for (int q = 0; q < new_array[i].length; q++) {// Sort a new array in ascending order.
					if (new_array[i][j] < new_array[i][q]) {
						double sorting = new_array[i][j];// Swapping.
						new_array[i][j] = new_array[i][q];
						new_array[i][q] = sorting;
					}
				}
			}
		}

		return new_array;// Return a new array and all it's values ordered ascending.
	}

	public static void printArray(double[][] temp)// Method to print the sorting array.
	{

		for (int i = 0; i < temp.length; i++) {// For loop to print the sorting array.
			System.out.print(temp[i].length + "  ");// Print the number of readings.

			for (int j = 0; j < temp[i].length; j++) {
				System.out.print(temp[i][j] + "  ");// Print the sorting array.

			}
			System.out.println(" ");// Next line to print after it's the new temperatures.

		}
	}

	public static double leaveHospital(double[][] temp)/*
														 * Method to find the average in the last two days and print if
														 * the patient can leave the hospital or not.
														 */

	{
		double sum = 0.0;// Define the sum and set it's initial value to zero.
		for (int i = temp.length - 2; i < temp.length; i++) {// for loop to find the sum of the last 4 temperatures.
			for (int j = temp[i].length - 2; j < temp[i].length; j++) {

				sum += temp[i][j];
			}
		}
		double average = sum / 4;// To find the average.
		return average;// Return the average of temperatures.
	}
}
