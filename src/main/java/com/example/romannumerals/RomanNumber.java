package com.example.romannumerals;

import java.util.*;

public class RomanNumber extends Number implements Comparable<RomanNumber> {
    private final int value;
    private static final NavigableMap<Integer, String> intToRomanMap = new TreeMap<>(Collections.reverseOrder());
    private static final LinkedHashMap<String, Integer> romanToIntMap = new LinkedHashMap<>();
    static {
        intToRomanMap.put(1000, "M");
        intToRomanMap.put(900, "CM");
        intToRomanMap.put(500, "D");
        intToRomanMap.put(400, "CD");
        intToRomanMap.put(100, "C");
        intToRomanMap.put(90, "XC");
        intToRomanMap.put(50, "L");
        intToRomanMap.put(40, "XL");
        intToRomanMap.put(10, "X");
        intToRomanMap.put(9, "IX");
        intToRomanMap.put(5, "V");
        intToRomanMap.put(4, "IV");
        intToRomanMap.put(1, "I");
        for (Map.Entry<Integer, String> e : intToRomanMap.entrySet()) {
            romanToIntMap.put(e.getValue(), e.getKey());
        }
    }
    private static final String ROMAN_REGEX = "^(?=.)M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";

    public RomanNumber(int value) {
        if (value < 1 || value > 3999) {
            throw new IllegalArgumentException("Value must be between 1 and 3999");
        }
        this.value = value;
    }

    public static String toRoman(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Value must be between 1 and 3999");
        }
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> entry : intToRomanMap.entrySet()) {
            while (number >= entry.getKey()) {
                result.append(entry.getValue());
                number -= entry.getKey();
            }
        }
        return result.toString();
    }

    public static int fromRoman(String roman) {
        if (roman == null || !roman.matches(ROMAN_REGEX)) {
            throw new IllegalArgumentException("Invalid Roman numeral: " + roman);
        }
        int index = 0;
        int result = 0;
        for (Map.Entry<String, Integer> entry : romanToIntMap.entrySet()) {
            String symbol = entry.getKey();
            while (roman.startsWith(symbol, index)) {
                result += entry.getValue();
                index += symbol.length();
            }
        }
        return result;
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return value;
    }

    @Override
    public float floatValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

    @Override
    public String toString() {
        return toRoman(value);
    }

    @Override
    public int compareTo(RomanNumber o) {
        return Integer.compare(this.value, o.value);
    }
}
