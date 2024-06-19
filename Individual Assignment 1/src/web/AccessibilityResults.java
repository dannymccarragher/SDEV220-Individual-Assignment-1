package web;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


/**
 * @Author Daniel McCarragher
 * @Version 1.0
 *
 *SDEV 220 SPRING 2024
 *
 * The AccessibilityResults class represents a collection of accessibility test results.
 * It provides methods to read test results from a file, display test results, and perform
 * operations such as counting number of tests and showing test results based on test description.
 */

public class AccessibilityResults {

    /**
     * Set to store AccessibilityTest objects representing individual test results.
     */
    private Set<AccessibilityTest> results;

    /**
     * Constructs an AccessibilityResults object by reading test results from CheckersResults.txt.
     *
     * @param filePath The path to the file containing accessibility test results.
     */

    public AccessibilityResults(String filePath) {
        this.results = new HashSet<>();
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine()) {
                String category = fileScanner.next();
                String googleResult = fileScanner.next();
                String waveResult = fileScanner.next();
                String sortSiteResult = fileScanner.next();
                String ASLintResult = fileScanner.next();
                String description = fileScanner.nextLine();

                //create AccessibilityTest object with the populated fields read in from checkers.txt
                AccessibilityTest test = new AccessibilityTest(category, googleResult, waveResult, sortSiteResult, ASLintResult, description);

                //add test objects to hashset "results"
                results.add(test);
            }
            //if file is not found, throw exception
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }


    /**
     * Display total number of accessibility tests in the set.
     */
    public void numTests() {
        System.out.println("Total Number of Tests: " + results.size() + "\n");
    }

/**
 * Displays test results matching the specified test description.
 *
 * @param testDescription The description to search for in test results.
 * @return A string representation of test results matching the specified description.
 * */
    public String showTestResults(String testDescription) {
        String result = "";
        int numMatches = 0;
        for (AccessibilityTest test : results) {
            //check to see if getDescription contains parameter input testDescription
            if (test.getDescription().contains(testDescription) ||
                    //this checks if it is lowercase
                    test.getDescription().contains(testDescription.toLowerCase())) {
                //sets result equal to test.toString()
                result += test.toString() + "\n";
                //increments number of numMatches
                numMatches++;
            }
        }
        //check to see if numMatches is greater than 0
        if (numMatches > 0) {
            result += "\nTotal tests matching: " + numMatches + "\n";
        } else {
            result = "Not found";
        }
        return result;
    }

/**
 * Displays test results belonging to the specified category.
 *
 * @param categorySearch The category to search for in test results.
 * @return A string representation of test results belonging to the specified category.
**/
    public String showByCategory(String categorySearch) {
        String result = "";
        int numMatches = 0;
        for (AccessibilityTest test : results) {
            //checks to see if getCategory contains categorySearch input
            if (test.getCategory().contains(categorySearch)) {
                result += test + "\n";
                numMatches++;
            }
        }
        if (numMatches > 0) {
            result += "\nTotal Categories matching: " + numMatches + "\n";
        } else {
            result = "Not found";
        }
        return result;
    }

    /**
     * Displays tests that resulted in total failure
     * @return String representation of tests that failed
     */

    public String showAllFailed() {
        int testsFailed = 0;
        for (AccessibilityTest test : results) {
            if (test.getGoogleResult().contains("notfound") && test.getWaveResult().contains("notfound") &&
                    test.getSortSiteResult().contains("notfound") &&
                    test.getASLintResult().contains("notfound")) {
                testsFailed++;
                System.out.println(test);
            }
        }
        return "\n" + "Total Tests failed: " + testsFailed;
    }

/**
 * Counts the number of tests that passed for a specified checker name and category.
 *
 * @param checkerName The name of the accessibility checker.
 * @param category    The category to filter the tests.
 * @return The number of tests that passed for the specified checker name and category.
 **/

    public int numPass(String checkerName, String category) {
        int numPass = 0;
        checkerName = checkerName.toLowerCase();
        category = category.toLowerCase();

        for (AccessibilityTest test : results) {
            // check if the test belongs to the specified category
            if (test.getCategory().toLowerCase().contains(category)) {
                // set the checkerName for the current test
                test.checkerName();

                // check if the test's checker name matches the specified checkerName
                if (test.checkerName.toLowerCase().contains(checkerName) ) {
                    // increment the count of passed tests
                    numPass++;
                }
            }
        }
        return numPass;
    }


}
