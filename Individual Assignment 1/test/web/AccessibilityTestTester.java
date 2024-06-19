package web;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccessibilityTestTester {

    @Test
    void getCategory() {
        AccessibilityTest test = new AccessibilityTest("Category", "Pass", "Pass", "Pass", "Pass", "Test Description");
        assertEquals("Category", test.getCategory());
    }

    @Test
    void getGoogleResult() {
        AccessibilityTest test = new AccessibilityTest("Category", "Pass", "Pass", "Pass", "Pass", "Test Description");
        assertEquals("Pass", test.getGoogleResult());
    }

    @Test
    void getWaveResult() {
        AccessibilityTest test = new AccessibilityTest("Category", "Pass", "Pass", "Pass", "Pass", "Test Description");
        assertEquals("Pass", test.getWaveResult());
    }

    @Test
    void getSortSiteResult() {
        AccessibilityTest test = new AccessibilityTest("Category", "Pass", "Pass", "Pass", "Pass", "Test Description");
        assertEquals("Pass", test.getSortSiteResult());
    }

    @Test
    void getASLintResult() {
        AccessibilityTest test = new AccessibilityTest("Category", "Pass", "Pass", "Pass", "Pass", "Test Description");
        assertEquals("Pass", test.getASLintResult());
    }

    @Test
    void getDescription() {
        AccessibilityTest test = new AccessibilityTest("Category", "Pass", "Pass", "Pass", "Pass", "Test Description");
        assertEquals("Test Description", test.getDescription());
    }
}
