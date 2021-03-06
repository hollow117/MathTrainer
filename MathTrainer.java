///////////////////////////////////////////////////////////////////////////////
//	
// Title:			 Math Trainer
// Files:			 MathTrainer.java, Config.java
// Semester:		 CS302	Spring 2016
//
// Author:			 Jason Choe
// Email:			 choe2@wisc.edu
// CS Login:		 choe
// Lecturer's Name:  Jim Williams
// Lab Section:		 313
//
///////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:  MathTrainer
// File:             MathTrainer.java
// Semester:         CS302 Spring 2016
//
// Author:           Jason Choe, choe2@wisc.edu
// CS Login:         choe
// Lecturer's Name:  Jim Williams
// Lab Section:      313
//
///////////////////////////////////////////////////////////////////////////////

/** Application that helps user with training math. */

import java.util.Scanner;
import java.util.Random;

/**
 * Class MathTrainer help user to practice different types of math
 * questions. It will not only tell the user whether his/her answer is
 * correct/incorrect, it will also show the correct answer and the list
 * of correct answers from the table.
 *
 * no known bugs
 *
 * @author Jason Choe
 */

public class MathTrainer {

	/**
	 * Main method is used to ask user arithmetic questions and depending on 
	 * the type of arithmetic user chooses. This method will show whether 
	 * user's answer is correct or not and show table of solutions with 
	 * operands used for math questions.
	 *
	 * @param none used
	 * @return none used
	 */

	public static void main(String[] args) {
		// Displaying welcome message
		System.out.println("Hello and welcome to the Math Trainer!");
		System.out.println("======================================");

		// Program asking users to choose the type of arithmetic problem
		// they would like to practice from options available
		System.out.println("Which math operation would you like to practice?");
		System.out.println("[A]ddition");
		System.out.println("[S]ubtraction");
		System.out.println("[M]ultiplication");
		System.out.println("[D]ivision");
		System.out.println("[R]emainder");

		// Program asking for user's choice
		System.out.print("Enter your choice: ");
		Scanner input = new Scanner(System.in);
		String choice = input.nextLine();

		Random randGen = new Random(Config.RANDOM_SEED);
		
		// If user chooses A or a for Addition questions, program will go 
		// through this path.
		if (choice.equals("A") || choice.equals("a")) {
			boolean isNumber; // initializing boolean isNumber
			int countQuestion = 0; // initializing countQuestion
			int countCorrect = 0; // initializing countCorrect
			double rowMin = 0; // initializing row_min
			double rowMax = 0; // initializing row_max
			double columnMin = 0; // initializing column_min
			double columnMax = 0; // initializing column_min

			// start of the do while loop
			do {

				// creating correctRange and correctRange1 values
				// using random seed values
				int correctChance = randGen.nextInt(Config.MAX_VALUE - +
						Config.MIN_VALUE + 1);

				int correctRange = correctChance + Config.MIN_VALUE;

				int correctChance1 = randGen.nextInt(Config.MAX_VALUE - +
						Config.MIN_VALUE + 1);
				int correctRange1 = correctChance1 + Config.MIN_VALUE;

				// asking user addition question
				System.out
				.print("What is the solution to the problem: " + correctRange +
						" + " + correctRange1 + " = ");

				// getting the correct solution for the question asked
				double solution = (double) correctRange + correctRange1;

				// start of if statement where if user enter number value
				// it will take user to this path
				if (input.hasNextDouble()) {

					// taking user's input to answer1
					double answer1 = input.nextDouble();

					// another if statement to see if his/her answer is
					// close to 0.1 of the correct answer, it computer will
					// say that the user got the correct answer and count
					// the number of correct answer
					if (Math.abs(solution - answer1) <= 0.1) {
						System.out.println("That is correct!");
						countCorrect++;

						// if user had number input but not the correct answer
						// computer will say answer must be entered as decimal
						// numbers and write out the correct solution
					} else {
						// the next two lines have been commented out
						// for milestone 3
						// System.out.println("All solutions must be "+
						// "entered as " + "decimal" + " numbers.");
						System.out.println("The correct solution is " + 
						(solution) + ".");

						// assigning row value
						double row = correctRange;

						// assigning row max range
						double rowPlusTwo = row + 2;
						if (rowPlusTwo >= Config.MAX_VALUE) {
							rowMax = Config.MAX_VALUE;
						} else {
							rowMax = rowPlusTwo;
						}
						// assigning row min range
						double rowMinusTwo = row - 2;
						if (rowMinusTwo <= Config.MIN_VALUE) {
							rowMin = Config.MIN_VALUE;
						} else {
							rowMin = rowMinusTwo;
						}

						// assigning column value
						double column = correctRange1;

						// assigning row max range
						double columnPlusTwo = column + 2;
						if (columnPlusTwo >= Config.MAX_VALUE) {
							columnMax = Config.MAX_VALUE;
						} else {
							columnMax = columnPlusTwo;
						}
						// assigning row min range
						double columnMinusTwo = column - 2;
						if (columnMinusTwo <= Config.MIN_VALUE) {
							columnMin = Config.MIN_VALUE;
						} else {
							columnMin = columnMinusTwo;
						}

						// Displaying table for wrong answer

						// i is going to control column instead of column_min;
						double i = columnMin;
						String s = " |"; // horizontal divider for table
						String t = "-------"; // vertical divider for table
						String k = "---------"; // vertical divider for table

						// displaying first row of the table
						System.out.printf("%8s", s);
						while (i <= columnMax) {
							System.out.printf(" %6.2f", i);
							i++;
						}
						i = columnMin;

						System.out.println();
						System.out.printf("%9s", k);

						// displaying the rest of the table using while loop
						while (i <= columnMax) {
							System.out.printf("%7s", t);
							i++;
						}
						i = columnMin;

						System.out.println();

						while (rowMin <= rowMax) {
							System.out.printf("%6.2f", rowMin);
							System.out.printf("%2s", s);
							while (i <= columnMax) {
								System.out.printf(" %6.2f", rowMin + i);
								i++;
							}
							i = columnMin;
							rowMin++;
							System.out.println();
						}

					}

					// isNumber is set as false to go around the loop again
					isNumber = false;
					// this will count the number of question
					countQuestion++;
				}

				// if user entered input that is not number it will show that
				// all solutions must be entered as decimal numbers and what
				// the correct answer is
				else {
					System.out.println("All solutions must be entered as " + 
				"decimal" + " numbers.");
					System.out.println("The correct solution is " + 
				(solution) + ".");
					// isNumber is set as false to go around the loop again
					isNumber = false;
					// this will count the number of question
					countQuestion++;
					input.next();
				}
				// this while loop will determine whether or not to go
				// around the loop. In here, it will be determined by
				// number of questions asked eventually.
			} while (!isNumber && countQuestion < Config.NUMBER_OF_QUESTIONS);
			System.out.print("***You answered " + countCorrect + " out of " + 
			Config.NUMBER_OF_QUESTIONS
					+ " questions correctly.\n");
		}

		// If user chooses S or s for Subtraction questions, program will go 
		// through this path.
		else if (choice.equals("S") || choice.equals("s")) {
			boolean isNumber; // initializing boolean isNumber
			int countQuestion = 0; // initializing countQuestion
			int countCorrect = 0; // initializing countCorrect
			double rowMin = 0; // initializing row_min
			double rowMax = 0; // initializing row_max
			double columnMin = 0; // initializing column_min
			double columnMax = 0; // initializing column_max

			// start of the do while loop
			do {

				// creating correctRange and correctRange1 values
				// using random seed values
				int correctChance = randGen.nextInt(Config.MAX_VALUE - +
						Config.MIN_VALUE + 1);

				int correctRange = correctChance + Config.MIN_VALUE;

				int correctChance1 = randGen.nextInt(Config.MAX_VALUE - +
						Config.MIN_VALUE + 1);
				int correctRange1 = correctChance1 + Config.MIN_VALUE;

				// asking user subtraction question
				System.out
				.print("What is the solution to the problem: " + 
				correctRange + " - " + correctRange1 + " = ");

				// getting the correct solution for the question asked
				double solution = (double) correctRange - correctRange1;

				// start of if statement where if user enter number value
				// it will take user to this path
				if (input.hasNextDouble()) {

					// taking user's input to answer1
					double answer1 = input.nextDouble();

					// another if statement to see if user's answer is
					// close to 0.1 of the correct answer, it computer will
					// say that the user got the correct answer and count
					// the number of correct answer
					if (Math.abs(solution - answer1) <= 0.1) {
						System.out.println("That is correct!");
						countCorrect++;

						// if user had number input but not the correct answer
						// computer will say answer must be entered as decimal
						// numbers and write out the correct solution
					} else {
						// the next two lines have been commented out
						// for milestone 3
						// System.out.println("All solutions must be entered as
						// "
						// + "decimal" + " numbers.");
						System.out.println("The correct solution is " +
						(solution) + ".");

						// assigning row value
						double row = correctRange;
						// assigning row max range
						double rowPlusTwo = row + 2;
						if (rowPlusTwo >= Config.MAX_VALUE) {
							rowMax = Config.MAX_VALUE;
						} else {
							rowMax = rowPlusTwo;
						}
						// assigning row min range
						double rowMinusTwo = row - 2;
						if (rowMinusTwo <= Config.MIN_VALUE) {
							rowMin = Config.MIN_VALUE;
						} else {
							rowMin = rowMinusTwo;
						}

						// assigning column value
						double column = correctRange1;
						// assigning column max range
						double columnPlusTwo = column + 2;
						if (columnPlusTwo >= Config.MAX_VALUE) {
							columnMax = Config.MAX_VALUE;
						} else {
							columnMax = columnPlusTwo;
						}
						// assigning column min range
						double columnMinusTwo = column - 2;
						if (columnMinusTwo <= Config.MIN_VALUE) {
							columnMin = Config.MIN_VALUE;
						} else {
							columnMin = columnMinusTwo;
						}

						// Displaying table for wrong answer

						// i is going to control column instead of column_min;
						double i = columnMin;
						String s = "|"; // horizontal divider for table
						String t = "-------"; // vertical divider for table
						String k = "---------"; // vertical divider for table

						// displaying first row of the table
						System.out.printf("%8s", s);
						while (i <= columnMax) {
							System.out.printf(" %6.2f", i);
							i++;
						}
						i = columnMin;

						System.out.println();
						System.out.printf("%9s", k);

						// displaying the rest of the table using while loop
						while (i <= columnMax) {
							System.out.printf("%7s", t);
							i++;
						}
						i = columnMin;

						System.out.println();

						while (rowMin <= rowMax) {
							System.out.printf("%6.2f", rowMin);
							System.out.printf("%2s", s);
							while (i <= columnMax) {
								System.out.printf(" %6.2f", rowMin - i);
								i++;
							}
							i = columnMin;
							rowMin++;
							System.out.println();
						}

					}

					// isNumber is set as false to go around the loop again
					isNumber = false;
					// this will count the number of question
					countQuestion++;
				}

				// if user entered input that is not number it will show that
				// all solutions must be entered as decimal numbers and what
				// the correct answer is
				else {
					System.out.println("All solutions must be entered as " + 
				"decimal" + " numbers.");
					System.out.println("The correct solution is " + 
				(solution) + ".");
					// isNumber is set as false to go around the loop again
					isNumber = false;
					// this will count the number of question
					countQuestion++;
					input.next();
				}
				// this while loop will determine whether or not to go
				// around the loop. In here, it will be determined by
				// number of questions asked eventually.
			} while (!isNumber && countQuestion < Config.NUMBER_OF_QUESTIONS);
			System.out.print("***You answered " + countCorrect + " out of " +
			Config.NUMBER_OF_QUESTIONS
					+ " questions correctly.\n");
		}

		// If user chooses M or m for Multiplication questions, program will go 
		// through this path.
		else if (choice.equals("M") || choice.equals("m")) {

			boolean isNumber; // initializing boolean isNumber
			int countQuestion = 0; // initializing countQuestion
			int countCorrect = 0; // initializing countCorrect
			double rowMin = 0; // initializing row_min
			double rowMax = 0; // initializing row_max
			double columnMin = 0; // initializing column_min
			double columnMax = 0; // initializing column_max

			// start of the do while loop
			do {

				// creating correctRange and correctRange1 values
				// using random seed values
				int correctChance = randGen.nextInt(Config.MAX_VALUE - +
						Config.MIN_VALUE + 1);

				int correctRange = correctChance + Config.MIN_VALUE;

				int correctChance1 = randGen.nextInt(Config.MAX_VALUE - +
						Config.MIN_VALUE + 1);
				int correctRange1 = correctChance1 + Config.MIN_VALUE;

				// asking user multiplication question
				System.out
				.print("What is the solution to the problem: " + correctRange +
						" x " + correctRange1 + " = ");

				// getting the correct solution for the question asked
				double solution = (double) correctRange * correctRange1;

				// start of if statement where if user enter number value
				// it will take user to this path
				if (input.hasNextDouble()) {

					// taking user's input to answer1
					double answer1 = input.nextDouble();

					// another if statement to see if user's answer is
					// close to 0.1 of the correct answer, it computer will
					// say that the user got the correct answer and count
					// the number of correct answer
					if (Math.abs(solution - answer1) <= 0.1) {
						System.out.println("That is correct!");
						countCorrect++;

						// if user had number input but not the correct answer
						// computer will say answer must be entered as decimal
						// numbers and write out the correct solution
					} else {
						// the next two lines have been commented out
						// for milestone 3
						// System.out.println("All solutions must be entered as
						// "
						// + "decimal" + " numbers.");
						System.out.println("The correct solution is " + 
						(solution) + ".");

						// assigning row value
						double row = correctRange;

						// assigning row max range
						double rowPlusTwo = row + 2;
						if (rowPlusTwo >= Config.MAX_VALUE) {
							rowMax = Config.MAX_VALUE;
						} else {
							rowMax = rowPlusTwo;
						}
						// assigning row min range
						double rowMinusTwo = row - 2;
						if (rowMinusTwo <= Config.MIN_VALUE) {
							rowMin = Config.MIN_VALUE;
						} else {
							rowMin = rowMinusTwo;
						}

						// assigning column value
						double column = correctRange1;

						// assigning column max range
						double columnPlusTwo = column + 2;
						if (columnPlusTwo >= Config.MAX_VALUE) {
							columnMax = Config.MAX_VALUE;
						} else {
							columnMax = columnPlusTwo;
						}
						// assigning column min range
						double columnMinusTwo = column - 2;
						if (columnMinusTwo <= Config.MIN_VALUE) {
							columnMin = Config.MIN_VALUE;
						} else {
							columnMin = columnMinusTwo;
						}

						// Displaying table for wrong answer

						// i is going to control column instead of column_min;
						double i = columnMin;
						String s = "|"; // horizontal divider for table
						String t = "-------"; // vertical divider for table
						String k = "---------"; // vertical divider for table

						// displaying first row of the table
						System.out.printf("%8s", s);
						while (i <= columnMax) {
							System.out.printf(" %6.2f", i);
							i++;
						}
						i = columnMin;

						System.out.println();
						System.out.printf("%9s", k);

						// displaying the rest of the table using while loop
						while (i <= columnMax) {
							System.out.printf("%7s", t);
							i++;
						}
						i = columnMin;

						System.out.println();

						while (rowMin <= rowMax) {
							System.out.printf("%6.2f", rowMin);
							System.out.printf("%2s", s);
							while (i <= columnMax) {
								System.out.printf(" %6.2f", rowMin * i);
								i++;
							}
							i = columnMin;
							rowMin++;
							System.out.println();
						}

					}

					// isNumber is set as false to go around the loop again
					isNumber = false;
					// this will count the number of question
					countQuestion++;
				}

				// if user entered input that is not number it will show that
				// all solutions must be entered as decimal numbers and what
				// the correct answer is
				else {
					System.out.println("All solutions must be entered as " +
				"decimal" + " numbers.");
					System.out.println("The correct solution is " + 
				(solution) + ".");
					// isNumber is set as false to go around the loop again
					isNumber = false;
					// this will count the number of question
					countQuestion++;
					input.next();
				}
				// this while loop will determine whether or not to go
				// around the loop. In here, it will be determined by
				// number of questions asked eventually.
			} while (!isNumber && countQuestion < Config.NUMBER_OF_QUESTIONS);
			System.out.print("***You answered " + countCorrect + " out of " + 
			Config.NUMBER_OF_QUESTIONS
					+ " questions correctly.\n");
		}

		// If user chooses D or d for Division questions, program will go 
		// through this path.
		else if (choice.equals("D") || choice.equals("d")) {

			boolean isNumber; // initializing boolean isNumber
			int countQuestion = 0; // initializing countQuestion
			int countCorrect = 0; // initializing countCorrect
			double rowMin = 0; // initializing row_min
			double rowMax = 0; // initializing row_max
			double columnMin = 0; // initializing column_min
			double columnMax = 0; // initializing column_max

			// start of the do while loop
			do {

				// creating correctRange and correctRange1 values
				// using random seed values
				int correctChance = randGen.nextInt(Config.MAX_VALUE - +
						Config.MIN_VALUE + 1);

				int correctRange = correctChance + Config.MIN_VALUE;

				int correctChance1 = randGen.nextInt(Config.MAX_VALUE - +
						Config.MIN_VALUE + 1);
				int correctRange1 = correctChance1 + Config.MIN_VALUE;

				// asking user division question
				System.out
				.print("What is the solution to the problem: " + 
				correctRange + " / " + correctRange1 + " = ");

				// getting the correct solution for the question asked
				double solution = (double) correctRange / correctRange1;

				// start of if statement where if user enter number value
				// it will take user to this path
				if (input.hasNextDouble()) {

					// taking user's input to answer1
					double answer1 = input.nextDouble();

					// another if statement to see if user's answer is
					// close to 0.1 of the correct answer, it computer will
					// say that the user got the correct answer and count
					// the number of correct answer
					if (Math.abs(solution - answer1) <= 0.1) {
						System.out.println("That is correct!");
						countCorrect++;

						// if user had number input but not the correct answer
						// computer will say answer must be entered as decimal
						// numbers and write out the correct solution
					} else {
						// the next two lines have been commented out
						// for milestone 3
						// System.out.println("All solutions must be entered as
						// "
						// + "decimal" + " numbers.");
						System.out.println("The correct solution is " + 
						(solution) + ".");

						// assigning row value
						double row = correctRange;

						// assigning row max range
						double rowPlusTwo = row + 2;
						if (rowPlusTwo >= Config.MAX_VALUE) {
							rowMax = Config.MAX_VALUE;
						} else {
							rowMax = rowPlusTwo;
						}
						// assigning row min range
						double rowMinusTwo = row - 2;
						if (rowMinusTwo <= Config.MIN_VALUE) {
							rowMin = Config.MIN_VALUE;
						} else {
							rowMin = rowMinusTwo;
						}

						// assigning column value
						double column = correctRange1;

						// assigning column max range
						double columnPlusTwo = column + 2;
						if (columnPlusTwo >= Config.MAX_VALUE) {
							columnMax = Config.MAX_VALUE;
						} else {
							columnMax = columnPlusTwo;
						}
						// assigning column min range
						double columnMinusTwo = column - 2;
						if (columnMinusTwo <= Config.MIN_VALUE) {
							columnMin = Config.MIN_VALUE;
						} else {
							columnMin = columnMinusTwo;
						}

						// Displaying table for wrong answer

						// i is going to control column instead of column_min;
						double i = columnMin;
						String s = "|"; // horizontal divider for table
						String t = "-------"; // vertical divider for table
						String k = "---------"; // vertical divider for table

						// displaying first row of the table
						System.out.printf("%8s", s);
						while (i <= columnMax) {
							System.out.printf(" %6.2f", i);
							i++;
						}
						i = columnMin;

						System.out.println();
						System.out.printf("%9s", k);

						// displaying the rest of the table using while loop
						while (i <= columnMax) {
							System.out.printf("%7s", t);
							i++;
						}
						i = columnMin;

						System.out.println();

						while (rowMin <= rowMax) {
							System.out.printf("%6.2f", rowMin);
							System.out.printf("%2s", s);
							while (i <= columnMax) {
								System.out.printf(" %6.2f", rowMin / i);
								i++;
							}
							i = columnMin;
							rowMin++;
							System.out.println();
						}

					}

					// isNumber is set as false to go around the loop again
					isNumber = false;
					// this will count the number of question
					countQuestion++;
				}

				// if user entered input that is not number it will show that
				// all solutions must be entered as decimal numbers and what
				// the correct answer is
				else {
					System.out.println("All solutions must be entered as " +
				"decimal" + " numbers.");
					System.out.println("The correct solution is " + 
				(solution) + ".");
					// isNumber is set as false to go around the loop again
					isNumber = false;
					// this will count the number of question
					countQuestion++;
					input.next();
				}
				// this while loop will determine whether or not to go
				// around the loop. In here, it will be determined by
				// number of questions asked eventually.
			} while (!isNumber && countQuestion < Config.NUMBER_OF_QUESTIONS);
			System.out.print("***You answered " + countCorrect + " out of " + 
			Config.NUMBER_OF_QUESTIONS
					+ " questions correctly.\n");
		}

		// If user chooses R or r for Remainder questions, program will go 
		// through this path.
		else if (choice.equals("R") || choice.equals("r")) {

			boolean isNumber; // initializing boolean isNumber
			int countQuestion = 0; // initializing boolean isNumber
			int countCorrect = 0; // initializing boolean isNumber
			double rowMin = 0; // initializing boolean isNumber
			double rowMax = 0; // initializing boolean isNumber
			double columnMin = 0; // initializing boolean isNumber
			double columnMax = 0; // initializing boolean isNumber

			// start of the do while loop
			do {

				// creating correctRange and correctRange1 values
				// using random seed values
				int correctChance = randGen.nextInt(Config.MAX_VALUE - +
						Config.MIN_VALUE + 1);

				int correctRange = correctChance + Config.MIN_VALUE;

				int correctChance1 = randGen.nextInt(Config.MAX_VALUE - +
						Config.MIN_VALUE + 1);
				int correctRange1 = correctChance1 + Config.MIN_VALUE;

				// asking user remainder question
				System.out
				.print("What is the solution to the problem: " + 
				correctRange + " % " + correctRange1 + " = ");

				// getting the correct solution for the question asked
				double solution = (double) correctRange % correctRange1;

				// start of if statement where if user enter number value
				// it will take user to this path
				if (input.hasNextDouble()) {

					// taking user's input to answer1
					double answer1 = input.nextDouble();

					// another if statement to see if user's answer is
					// close to 0.1 of the correct answer, it computer will
					// say that the user got the correct answer and count
					// the number of correct answer
					if (Math.abs(solution - answer1) <= 0.1) {
						System.out.println("That is correct!");
						countCorrect++;

						// if user had number input but not the correct answer
						// computer will say answer must be entered as decimal
						// numbers and write out the correct solution
					} else {
						// the next two lines has been commented out
						// for milestone 3
						// System.out.println("All solutions must be entered as
						// "
						// + "decimal" + " numbers.");
						System.out.println("The correct solution is " + 
						(solution) + ".");

						// assigning row value
						double row = correctRange;

						// assigning row max range
						double rowPlusTwo = row + 2;
						if (rowPlusTwo >= Config.MAX_VALUE) {
							rowMax = Config.MAX_VALUE;
						} else {
							rowMax = rowPlusTwo;
						}
						// assigning row min range
						double rowMinusTwo = row - 2;
						if (rowMinusTwo <= Config.MIN_VALUE) {
							rowMin = Config.MIN_VALUE;
						} else {
							rowMin = rowMinusTwo;
						}

						// assigning column value
						double column = correctRange1;

						// assigning column max range
						double columnPlusTwo = column + 2;
						if (columnPlusTwo >= Config.MAX_VALUE) {
							columnMax = Config.MAX_VALUE;
						} else {
							columnMax = columnPlusTwo;
						}
						// assigning column min range
						double columnMinusTwo = column - 2;
						if (columnMinusTwo <= Config.MIN_VALUE) {
							columnMin = Config.MIN_VALUE;
						} else {
							columnMin = columnMinusTwo;
						}

						// Displaying table for wrong answer

						// i is going to control column instead of column_min;
						double i = columnMin;
						String s = "|"; // horizontal divider for table
						String t = "-------"; // vertical divider for table
						String k = "---------"; // vertical divider for table

						// displaying first row of the table
						System.out.printf("%8s", s);
						while (i <= columnMax) {
							System.out.printf(" %6.2f", i);
							i++;
						}
						i = columnMin;

						System.out.println();
						System.out.printf("%9s", k);

						// displaying the rest of the table using while loop
						while (i <= columnMax) {
							System.out.printf("%7s", t);
							i++;
						}
						i = columnMin;

						System.out.println();

						while (rowMin <= rowMax) {
							System.out.printf("%6.2f", rowMin);
							System.out.printf("%2s", s);
							while (i <= columnMax) {
								System.out.printf(" %6.2f", rowMin % i);
								i++;
							}
							i = columnMin;
							rowMin++;
							System.out.println();
						}

					}

					// isNumber is set as false to go around the loop again
					isNumber = false;
					// this will count the number of question
					countQuestion++;
				}

				// if user entered input that is not number it will show that
				// all solutions must be entered as decimal numbers and what
				// the correct answer is
				else {
					System.out.println("All solutions must be entered as " +
				"decimal" + " numbers.");
					System.out.println("The correct solution is " + 
				(solution) + ".");
					// isNumber is set as false to go around the loop again
					isNumber = false;
					// this will count the number of question
					countQuestion++;
					input.next();
				}

				// this while loop will determine whether or not to go
				// around the loop. In here, it will be determined by
				// number of questions asked eventually.
			} while (!isNumber && countQuestion < Config.NUMBER_OF_QUESTIONS);
			System.out.print("***You answered " + countCorrect + " out of " + 
			Config.NUMBER_OF_QUESTIONS
					+ " questions correctly.\n");
		}

		// if non-numerical value was placed as input the following message will
		// show and it will end the program
		else {
			System.out.println("I'm sorry, I only understand choices of: A," +
		" S, M, D, or R!");
		}

		// Displaying closing message
		System.out.println("=====================================");
		System.out.println("Thank you for using the Math Trainer!");
		
		// Closing out Scanner
		input.close();
	}

}
