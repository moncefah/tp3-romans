package com.example.romannumerals;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RomanNumberTest {

    @Test
    public void testToRomanKnownValues() {
        assertEquals("I", RomanNumber.toRoman(1));
        assertEquals("III", RomanNumber.toRoman(3));
        assertEquals("IV", RomanNumber.toRoman(4));
        assertEquals("IX", RomanNumber.toRoman(9));
        assertEquals("LVIII", RomanNumber.toRoman(58));
        assertEquals("MCMXCIV", RomanNumber.toRoman(1994));
        assertEquals("MMMCMXCIX", RomanNumber.toRoman(3999));
    }

    @Test
    public void testFromRomanKnownValues() {
        assertEquals(1, RomanNumber.fromRoman("I"));
        assertEquals(3, RomanNumber.fromRoman("III"));
        assertEquals(4, RomanNumber.fromRoman("IV"));
        assertEquals(9, RomanNumber.fromRoman("IX"));
        assertEquals(58, RomanNumber.fromRoman("LVIII"));
        assertEquals(1994, RomanNumber.fromRoman("MCMXCIV"));
        assertEquals(3999, RomanNumber.fromRoman("MMMCMXCIX"));
    }

    @Test
    public void testRangeFailures() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumber.toRoman(0));
        assertThrows(IllegalArgumentException.class, () -> RomanNumber.toRoman(4000));
    }

    @Test
    public void testInvalidRomanFailures() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumber.fromRoman(""));
        assertThrows(IllegalArgumentException.class, () -> RomanNumber.fromRoman("IIII"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumber.fromRoman("VV"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumber.fromRoman("IC"));
    }

    @Test
    public void testToRomanFromRomanConsistency() {
        for (int i = 1; i <= 3999; i++) {
            assertEquals(i, RomanNumber.fromRoman(RomanNumber.toRoman(i)));
        }
    }

    @Test
    public void testNumberMethodsAndComparable() {
        RomanNumber rn = new RomanNumber(10);
        assertEquals("X", rn.toString());
        assertEquals(10.0, rn.doubleValue());
        assertTrue(rn.compareTo(new RomanNumber(10)) == 0);
        assertTrue(rn.compareTo(new RomanNumber(5)) > 0);
        assertTrue(rn.compareTo(new RomanNumber(20)) < 0);
    }
}
