/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicing20210214;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Somogyi László <proceed step by step>
 */
public class Practicing20210214 {

    public static int[] arrayCreator(int length) {
        int[] array = new int[length];
        arrayFiller(array);
        return array;
    }

    public static void arrayFiller(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }
    
    public static int[] ranArrayCreator(int length){
        int[] array = new int[length];
        Random ran = new Random();
        for(int i = 0; i<array.length; i++){
            array[i] = ran.nextInt(200);
        }
        return array;
    }

    public static void arrayPrinter(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(",\t");
            }
        }
        System.out.println();
    }

    public static boolean comp(int[] a, int[] b) {
        //https://www.codewars.com/kata/550498447451fbbd7600041c 
        int counter = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] * a[i] == b[j]) {
                    counter++;
                }
            }
        }
        if (counter / 2 == a.length) {
            return true;
        } else {
            return false;
        }
    }

    public static double findUniq(double arr[]) {
        //https://www.codewars.com/kata/585d7d5adb20cf33cb000235 
        double outlyer = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] != arr[i] && arr[i - 1] == arr[i + 1]) {
                outlyer = arr[i];
            } else if (arr[i - 1] != arr[i] && arr[i] == arr[i + 1]) {
                outlyer = arr[i - 1];
            } else if (arr[arr.length - 1] != arr[arr.length - 2]) {
                outlyer = arr[arr.length - 1];
            }
        }
        return outlyer;
    }

    public static int[] longToArray(long a) {
        int arrayLength = (a + "").length();
        int[] array = new int[arrayLength];
        String chars = a + "";
        for (int i = 0; i < chars.length(); i++) {
            array[i] = Integer.parseInt(chars.charAt(i) + "");
        }
        return array;
    }

    public static int[] longToArray2(long a) {
        int arrayLength = (a + "").length();
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[arrayLength - i - 1] = (int) a % 10;
            a = a / 10;
        }
        return array;
    }

    public static int[] sortDescending(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] < array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }

    public static long arrayToLong(int[] array) {
        long num = 0;
        String chars = "";
        for (int i = 0; i < array.length; i++) {
            chars += array[i] + "";
        }
        return Long.parseLong(chars);
    }

    public static long sortLong(long num) {
        //https://www.codewars.com/kata/5467e4d82edf8bbf40000155 
        return arrayToLong(sortDescending(longToArray(num)));
    }

    public static String duplicateEncoder(String word) {
        //https://www.codewars.com/kata/54b42f9314d9229fd6000d9c 
        word = word.toLowerCase();
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            for (int j = i + 1; j < wordArray.length; j++) {
                if (wordArray[i] == wordArray[j] && i != j) {
                    wordArray[i] = ')';
                    wordArray[j] = ')';
                }
            }
        }
        for (int i = 0; i < wordArray.length; i++) {
            if (wordArray[i] != ')') {
                wordArray[i] = '(';
            }
        }
        word = String.valueOf(wordArray);
        return word;
    }

    public static int[] reverser(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            int tmp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = tmp;
        }
        return a;
    }

    public static boolean isUnique(String word) {
        //Implement an algorithm to determine if a string has all unique characters
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j < word.length(); j++) {
                if (word.charAt(i) == word.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isPalindrom(String word) {
        boolean palindrom = true;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(word.length() - i - 1)) {
                palindrom = true;
            } else {
                palindrom = false;
            }
        }
        return palindrom;
    }

    public static int findIt(int[] a) {
        //https://www.codewars.com/kata/54da5a58ea159efa38000836/train/java
        //Given an array of integers, find the one that appears an odd number of times.
        //There will always be only one integer that appears an odd number of times.
        int occuranceCounter = 0;
        int odd = 0;
        for (int i = 0; i < a.length; i++) {
            occuranceCounter = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j]) {
                    occuranceCounter++;
                }
            }
            if (occuranceCounter % 2 != 0) {
                odd = a[i];
            }
        }
        return odd;
    }

    public static int persistence(long n) {
        //https://www.codewars.com/kata/55bf01e5a717a0d57e0000ec/train/java
        //Write a function, persistence, that takes in a positive parameter num 
        //and returns its multiplicative persistence, which is the number of times
        //you must multiply the digits in num until you reach a single digit.
        int result = 1;
        int mPersistence = 0;
        if (n < 10 && n > 0) {
            mPersistence = 0;
        } else {
            do {
                result = 1;
                String nString = n + "";
                for (int i = 0; i < nString.length(); i++) {
                    result *= Integer.parseInt(nString.charAt(i) + "");
                }
                n = result;
                mPersistence++;
            } while (result > 9);
        }
        return mPersistence;
    }

    public static int Persistence2(long n) {
        int result = 1;
        int mPersistence = 0;
        if (n < 10 && n > 0) {
            mPersistence = 0;
        } else {
            do {
                result = 1;
                while (n > 0) {
                    result *= n % 10;
                    n = n / 10;
                }
                n = result;
                mPersistence++;
            } while (result > 9);
        }
        return mPersistence;
    }

    public static int binarySearcher(int[] array, int num) {
        //https://www.javatpoint.com/binary-search-in-java 
        int position = 0;
        int min = array.length - array.length;
        int max = array.length - 1;
        int middle = (min + max) / 2;

        while (min <= max) {
            if (num < array[middle]) {
                max = middle - 1;
            } else if (num > array[middle]) {
                min = middle + 1;
            } else if (num == array[middle]) {
                position = middle;
                break;
            }
            middle = (min + max) / 2;
        }
        return position;
    }

    public static int findMissingNumber(int[] array) {
        int missingNo = 0;
        int total = 0;
        int maxNum = array[array.length - 1];
        int arraySum = 0;

        for (int i = 0; i <= maxNum; i++) {
            total += i;
        }

        for (int i : array) {
            arraySum += i;
        }

        missingNo = total - arraySum;
        return missingNo;
    }

    public static int findMissingNumber2(int[] array) {
        int missingNo = 0;
        int maxNum = array[array.length - 1];
        int total = 0;
        int arraySum = 0;
        total = (maxNum * (maxNum + 1)) / 2;
        System.out.println("ennyi az összes szám összege: " + total);

        for (int element : array) {
            arraySum += element;
        }
        System.out.println("Ennyi a tömb elemeinek összege: " + arraySum);
        missingNo = total - arraySum;
        return missingNo;
    }

    public static void plusMinus(int[] array) {
        double nullCounter = 0;
        double nullRatio = 0;
        double posCounter = 0;
        double posRatio = 0;
        double negCounter = 0;
        double negRatio = 0;

        DecimalFormat df = new DecimalFormat("0.000000");

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                nullCounter++;
            } else if (array[i] < 0) {
                negCounter++;
            } else {
                posCounter++;
            }
        }
        posRatio = posCounter / array.length;
        System.out.println(df.format(posRatio));
        negRatio = negCounter / array.length;
        System.out.println(df.format(negRatio));
        nullRatio = nullCounter / array.length;
        System.out.println(df.format(nullRatio));
    }

    public static String camelCase(String input) {
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            if (Character.isUpperCase(input.charAt(i))) {
                output = output + " ";
            }
            output = output + input.charAt(i);
        }
        return output;
    }

    public static int digitalRoot(int n) {
        //https://www.codewars.com/kata/541c8630095125aba6000c00
        while (n > 9) {
            String nString = n + "";
            n = 0;
            for (int i = 0; i < nString.length(); i++) {
                n += Integer.parseInt(nString.charAt(i) + "");
            }
        }
        return n;
    }

    public static int digitalRoot2(int n) {
        //https://www.codewars.com/kata/541c8630095125aba6000c00
        int root = 0;
        if (n < 10) {
            return n;
        } else {
            while (n > 9) {
                root = 0;
                while (n > 0) {
                    root += n % 10;
                    n /= 10;
                }
                n = root;
            }
        }
        return root;
    }

    public static List<Integer> SquaresInRect(int lng, int wdth) {
        //https://www.codewars.com/kata/55466989aeecab5aac00003e/train/java 
        List<Integer> squares = new ArrayList<>();
        while (wdth > 0) {
            squares.add(wdth);
            int wdth2 = lng - wdth;
            lng = wdth;
            wdth = wdth2;
        }
        return squares;
    }

    public static int[] deadFishparser(String data) {
        //https://www.codewars.com/kata/51e0007c1f9378fa810002a9 
        int arrayLength = 0;
        int arrayIndex = 0;
        int value = 0;
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == 'o') {
                arrayLength++;
            }
        }
        int[] array = new int[arrayLength];
        for (int i = 0; i < data.length(); i++) {
            switch (data.charAt(i)) {
                case 'i':
                    value++;
                    break;
                case 'd':
                    value--;
                    break;
                case 's':
                    value *= value;
                    break;
                case 'o':
                    array[arrayIndex] = value;
                    arrayIndex++;
                    break;
            }
        }
        return array;
    }

    public static void leftRotator(int[] array, int d) {
        //not yet ready!!!
        for (int i = array.length - 1; i >= 0; i--) {
            if (i >= d) {
                array[i] = array[i - d];
            } else {
                array[i] = array[((array.length) + i) - (d)];
            }
        }
    }
    
    public static boolean LuhnAlgorithm(String n) {
        //https://www.codewars.com/kata/5418a1dd6d8216e18a0012b2/train/java
        int[] array = new int[n.length()];
        int sum = 0;
        for (int i = 0; i < n.length(); i++) {
            array[i] = Integer.parseInt(n.charAt(i) + "");
        }
        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                array[array.length - 1 - i] *= 2;
                if (array[array.length - 1 - i] > 9) {
                    array[array.length - 1 - i] -= 9;
                }
            }
            sum += array[array.length - 1 - i];
        }
        if (sum % 10 == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public static String CamelCaseConverter(String s){
       String[] words = s.split("[-_]");
       s = words[0];
        for (int i = 0; i < words.length; i++) {
            s+=words[i].substring(0, 1).toUpperCase()+words[i].substring(1).toLowerCase();
        }
       return s;
    }

    public static void main(String[] args) {

        String k = CamelCaseConverter("wewe_wewe_wewe");
        System.out.println(k);

        
    }

}
