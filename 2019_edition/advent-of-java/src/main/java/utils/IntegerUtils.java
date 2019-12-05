package utils;

import java.util.Arrays;
import java.util.List;

public class IntegerUtils {
    private static final String consecutiveDigitsPattern = "(\\d)\\1+";

    /*
     * Compares two integers and returns: 1 if the first integer is bigger; -1 if
     * the first integer is smaller; 0 if the two integers are equal
     */
    public static int compareInts(int a, int b) {
        if (a > b)
            return 1;
        else if (a < b)
            return -1;
        else
            return 0;
    }
    
    public static List<Integer> reverse(int valueToReverse) {
        String[] valueDigitsString = String.valueOf(valueToReverse).split("");
        int valueLength = valueDigitsString.length;
        Integer[] valueDigitsReverse = new Integer[valueLength];
        for (int i = 0; i < valueLength; i++)
            valueDigitsReverse[valueLength-i-1] = Integer.parseInt(valueDigitsString[i]);   

        return Arrays.asList(valueDigitsReverse);
    }

    public static boolean checkIntegerLength(Integer value, int expectedLength) {
        return String.valueOf(value).length() == expectedLength;
    }

    public static boolean integerIsWithinRange(Integer value, Integer rangeStartInclusive, Integer rangeEndInclusive) {
        return (rangeStartInclusive <= value) && (value <= rangeEndInclusive);
    }

    public static boolean hasSequenceOfSameDigits(Integer password) {
        return StringUtils.hasSequenceOfSameChars(String.valueOf(password), consecutiveDigitsPattern);

    }

    public static boolean hasSequenceOfSameDigits(Integer password, int sequenceLength) {
        return StringUtils.hasSequenceOfSameChars(String.valueOf(password), consecutiveDigitsPattern, sequenceLength);
    }
}