package codeWars;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CamelCaseDestroyerTest {
    
    private static final String TEST_STRING = "camelCaseStrinG";
    private static final String RESULT_STRING = "camel Case Strin G";
    private final CamelCaseDestroyer destroyer = new CamelCaseDestroyer();
    
    @Test
    public void testSplit() {
        String result = destroyer.split(TEST_STRING);
        
        assertEquals(RESULT_STRING, result);
    }
    
}