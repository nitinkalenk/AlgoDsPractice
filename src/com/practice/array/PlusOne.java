package com.practice.array;

public class PlusOne {

  private int[] merge(int carry, int[] digits) {
    int[] arr = new int[digits.length + 1];
    arr[0] = carry;
    for(int i = 1; i < arr.length; i++) {
      arr[i] = digits[i - 1];
    }
    return arr;
  }

  public int[] plusOne(int[] digits) {
    int currentPos = digits.length - 1;
    int addition = digits[currentPos] + 1;
    digits[currentPos] = addition % 10;
    int carry = addition / 10;
    while(carry != 0 & --currentPos >= 0) {
      addition = digits[currentPos] + carry;
      digits[currentPos] = addition % 10;
      carry = addition / 10;
    }
    return carry == 0 ? digits : merge(carry, digits);
  }


}
