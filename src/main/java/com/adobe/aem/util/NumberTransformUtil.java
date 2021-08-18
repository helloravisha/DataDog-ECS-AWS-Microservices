package com.adobe.aem.util;

import com.adobe.aem.exception.NumberException;

/**
 * class responsible for converting the given number to roman numeral.
 *
 * @author ravi shanker katta
 * @since 2021 Aug
 * @version 1.0
 */
public class NumberTransformUtil {
  private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
  private static final String[] ROMAN_LITERALS = {
    "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
  };

  public static String convertToToRomanNumber(int input) throws NumberException {
    StringBuilder romanNumber = new StringBuilder();
    try {
      for (int index = 0; index < VALUES.length; index++) {
        while (input >= VALUES[index]) {
          input = input - VALUES[index];
          romanNumber.append(ROMAN_LITERALS[index]);
        }
      }
    } catch (Exception exception) {
      throw new NumberException(
          " error converting given number to roman number , exception=" + exception.getMessage());
    }
    return romanNumber.toString();
  }
}
