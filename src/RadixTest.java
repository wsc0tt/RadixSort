/**
 * @author William Scott
 * Project 2 - CSC 130
 * Test/Driver File to demonstrate and test Radix sort
 * !!! Requires test folder with txt files to read !!!
 */

import java.io.*;
import java.util.*;

public class RadixTest {
    public static void main(String [] args) throws FileNotFoundException {
        FieldQueue q = new FieldQueue();    // Create the main queue

        pl("*** RADIX SORT TESTING");
        pl("Please enter the file you would like to sort:");
        Scanner console = new Scanner(System.in);
        String file = console.nextLine();
        Scanner inputFile = new Scanner(new File("test/" + file)); // read user input test file from test folder
        final int DIGITS = Integer.parseInt(inputFile.nextLine()); // save # of digits as constant

        // While the file has another line and the line is not a zero
        while (inputFile.hasNextLine()) {
            String key = inputFile.nextLine().trim();  // save the key
            String value = inputFile.nextLine().trim();  // save the value
            if(!key.equals("0") && !value.equals("END")) {  // if 0 or END do not add to queue
                q.enqueue(new Field(key, value));
            }
        }

        pl("");
        pl("*** " + file.toUpperCase() + " BEFORE RADIX SORT: ");
        pl("");
        printQueue(q);  // display the queue before sort
        pl("");
        pl("sorting...");
        pl("");
        RadixSort.sort(q, DIGITS);
        pl("*** " + file.toUpperCase() + " AFTER RADIX SORT:");
        pl("");

        printQueue(q);  // display the queue after sort
    }
// helper method for printing a line
    public static void pl (String line) {
        System.out.println(line);
    }
// helper method to print out the queue
    public static void printQueue (FieldQueue q) {
        System.out.print(q.toString());
    }

}

