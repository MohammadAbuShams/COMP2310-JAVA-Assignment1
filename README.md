# Comp2310-Java: Assignment 1

## Overview
This assignment focuses on processing arrays of objects using core Java concepts covered from Chapters 1 to 8. The primary task is to develop a Java program that manages and analyzes temperature readings for a hospital patient over multiple days.

## Objectives
- **Data Input**: Read and validate temperature readings over a specified number of days.
- **Data Processing**:
  - Calculate and display the average, maximum, and minimum temperatures.
  - Determine the number of temperature readings below, at, and above the average.
  - Sort temperature data for each day and store in a 2D array.
- **Decision Making**:
  - Evaluate whether a patient can be discharged based on the last two days' highest temperature readings.

## Requirements
### Main Method
- Prompt user to enter:
  1. The number of days a patient has been in the hospital.
  2. The number of temperature readings per day.
  3. Individual temperature readings for each day.
- Validate that each temperature is within the acceptable range (30°C to 45°C).

### Methods to Implement
- `Summary()`: Returns the average, max, and min temperatures.
- `countBelowAboveAverage()`: Returns the count of temperatures below, at, and above the average.
- `sortArray()`: Sorts the temperatures per day in ascending order without using built-in sort methods.
- `printArray()`: Prints the sorted 2D array of temperatures.
- `leaveHospital()`: Determines if the patient can be discharged based on specified criteria.

## Sample Input/Output
- **Days**: 5
- **Readings Per Day**: Variable (e.g., Day 1: 4 readings, Day 2: 5 readings, etc.)
- **Temperature Input Requirements**:
  - Enter temperatures one at a time, ensuring each is within the range of 30°C to 45°C.
  - If a temperature outside this range is entered, display an error and prompt for re-entry.

- **Actual Readings Example**:
  - For each day, enter the number of temperature readings followed by the temperatures themselves:
    ```
    Day 1: Enter 4 readings
    Reading 1: 40.5
    Reading 2: 41
    Reading 3: 39.8
    Reading 4: 38.7

    Day 2: Enter 5 readings
    Reading 1: 41.2
    Reading 2: 41.3
    Reading 3: 40.7
    Reading 4: 40.8
    Reading 5: 41.3

    Day 3: Enter 5 readings
    Reading 1: 40.9
    Reading 2: 38.5
    Reading 3: 38.9
    Reading 4: 40.1
    Reading 5: 39.8

    Day 4: Enter 3 readings
    Reading 1: 38.2
    Reading 2: 38.2
    Reading 3: 37.9

    Day 5: Enter 2 readings
    Reading 1: 37.5
    Reading 2: 37.2
    ```

- **Output**:
  - The program will process these inputs to calculate and display the average, maximum, and minimum temperatures, and then sort and print the temperatures in ascending order per day.


