package driver;

import web.AccessibilityResults;
import web.AccessibilityTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        AccessibilityResults accessibilityResults = new AccessibilityResults("Individual Assignment 1/data/a11yCheckersResults.txt");

        //print out number of tests in set called results
        accessibilityResults.numTests(); // returns 142

        //print out category that contains "Key"
        System.out.println(accessibilityResults.showByCategory("Key")); // returns 16 matches
        //print out category that contains "HT"
        System.out.println(accessibilityResults.showByCategory("HT")); // returns 11 matches

        //print out test Results that contain "Colour"
        System.out.println(accessibilityResults.showTestResults("Colour")); // returns 5 matches

        //Show tests that failed all their tests
        System.out.println(accessibilityResults.showAllFailed()); // returns 51 failed tests

        System.out.println(accessibilityResults.numPass("Goog", "")); // returns 23
        System.out.println(accessibilityResults.numPass("SORT", "link")); // returns 4




        }

        }

