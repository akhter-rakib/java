package com.rakib.String_pro;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringImmutabilityTest {

    @Test
    public void testConcatenation() {
        String originalString = "Hello";
        String concatedString = originalString + " " + "World!";
        /*Verify original String is unchanged*/
        assertEquals("Hello", originalString);
        /*Verify new String is created*/
        assertEquals("Hello World!", concatedString);
    }

    @Test
    public void subStringTest() {
        String originalString = "Immutable";
        String substring = originalString.substring(0, 4);
        // Verify that original string is unchanged
        assertEquals("Immutable", originalString);
        // Verify that new substring is created
        assertEquals("Immu", substring);
    }

    @Test
    public void testUpperCase() {
        String originalString = "hello";
        String upperCaseString = originalString.toUpperCase();

        // Verify that original string is unchanged
        assertEquals("hello", originalString);
        // Verify that new string in upper case is created
        assertEquals("HELLO", upperCaseString);
    }

    @Test
    public void testReplace() {
        String originalString = "Hello World";
        String replacedString = originalString.replace('o', '0');

        // Verify that original string is unchanged
        assertEquals("Hello World", originalString);
        // Verify that new string with replacement is created
        assertEquals("Hell0 W0rld", replacedString);
    }

    @Test
    public void testTrim() {
        String originalString = "  Trim me  ";
        String trimmedString = originalString.trim();

        // Verify that original string is unchanged
        assertEquals("  Trim me  ", originalString);
        // Verify that new trimmed string is created
        assertEquals("Trim me", trimmedString);
    }
}
