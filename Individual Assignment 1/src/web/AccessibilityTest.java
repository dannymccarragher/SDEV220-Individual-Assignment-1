package web;

/**
 * @Author Daniel McCarragher
 * @Version 1.0
 *  *
 *  *SDEV 220 SPRING 2024
 *
 * This class represents an Accessibility Test, which includes various test results
 * obtained from different accessibility checkers.
 */

//simple class with fields, getters, toString()

//write JUnit tests



public class AccessibilityTest {

    //create instance fields
    private String category;
    private String googleResult;
    private String waveResult;
    private String sortSiteResult;
    private String ASLintResult;
    private String description;
    String checkerName = "";

    /**
     * Constructs an AccessibilityTest object with the specified parameters.
     *
     * @param category      The category of the accessibility test.
     * @param googleResult  The result obtained from Google accessibility checker.
     * @param waveResult    The result obtained from WAVE accessibility checker.
     * @param sortSiteResult The result obtained from SortSite accessibility checker.
     * @param ASLintResult  The result obtained from ASLint accessibility checker.
     * @param description   A description of the accessibility test.
     */

    public AccessibilityTest(String category, String googleResult, String waveResult,
                             String sortSiteResult, String ASLintResult, String description) {
        this.category = category;
        this.googleResult = googleResult;
        this.waveResult = waveResult;
        this.sortSiteResult = sortSiteResult;
        this.ASLintResult = ASLintResult;
        this.description = description;

    }
    /**
     * Returns the category of the accessibility test.
     *
     * @return The category of the accessibility test.
     */

    public String getCategory() {
        return category;
    }
    /**
     * Returns the result obtained from Google accessibility checker.
     *
     * @return The result obtained from Google accessibility checker.
     */

    public String getGoogleResult() {
        return googleResult;
    }

    /**
     * Returns the result obtained from WAVE accessibility checker.
     *
     * @return The result obtained from WAVE accessibility checker.
     */
    public String getWaveResult() {
        return waveResult;
    }

    /**
     * Returns the result obtained from SortSite accessibility checker.
     *
     * @return The result obtained from SortSite accessibility checker.
     */

    public String getSortSiteResult() {
        return sortSiteResult;
    }

    /**
     * Returns the result obtained from ASLint accessibility checker.
     *
     * @return The result obtained from ASLint accessibility checker.
     */
    public String getASLintResult() {
        return ASLintResult;
    }

    /**
     * Returns a description of the accessibility test.
     *
     * @return A description of the accessibility test.
     */

    public String getDescription() {
        return description;
    }

    /**
     * Determines the name of the accessibility checker that reported an error or error_paid,
     * or "Other" if no errors were found by any checker.
     *
     * @return The name of the accessibility checker reporting an error
     */


    public String checkerName() {
        if (googleResult.toLowerCase().contains("error") || googleResult.toLowerCase().contains("error_paid")) {
            this.checkerName = "Google";
        } else if (waveResult.toLowerCase().contains("error") || waveResult.toLowerCase().contains("error_paid")) {
            this.checkerName = "WAVE";
        } else if (sortSiteResult.toLowerCase().contains("error") || sortSiteResult.toLowerCase().contains("error_paid")) {
            this.checkerName = "SortSite";
        } else if (ASLintResult.toLowerCase().contains("error") || ASLintResult.toLowerCase().contains("error_paid")) {
            this.checkerName = "ASLint";
        } else {
            this.checkerName = "Other";
        }

        return this.checkerName.toLowerCase();
    }


    /**
     *Generates a string representation of the object, including category, description,
     * and results from Google, WAVE, SortSite, and ASLint.
     *
     * @return String representation of test results, description, and category
     */
    @Override
    public String toString() {
        return category + ": "+ description + " - Google: " + googleResult + ", WAVE: " + waveResult + ", SortSite: " + sortSiteResult + ", ASLint: " + ASLintResult;
    }
}