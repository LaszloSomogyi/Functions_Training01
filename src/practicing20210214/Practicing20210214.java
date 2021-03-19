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
    
    public static boolean tenMinuteWalk(char[] walk){
        //https://www.codewars.com/kata/54da539698b8a2ad76000228
        if (walk.length!=10) {
            return false;
        }
        int nCounter = 0;
        int sCounter = 0;
        int wCounter = 0;
        int eCounter = 0;
        for (int i = 0; i < walk.length; i++) {
            switch(walk[i]){
                case 'n': nCounter++;
                break;
                case 's': sCounter++;
                break;
                case 'w': wCounter++;
                break;
                case 'e': eCounter++;
                break;
            }
        }
        System.out.println("nCounter "+nCounter);
        System.out.println("sCounter "+sCounter);
        if(nCounter==sCounter && wCounter==eCounter) {
            return true;
        } else {
            return false;
        }
    }
    
    public static int[] DataReverse(int[] data){
        //https://www.codewars.com/kata/569d488d61b812a0f7000015
        int min = data.length-8;
        int max = data.length-1;
        List<Integer> dataList = new ArrayList<>();
        while(min>=0){
            for(int i = min; i <= max; i++){
                dataList.add(data[i]);
            }
            max = min-1;
            min = min-8;
        }
        Integer[] array = new Integer[dataList.size()];
        array = dataList.toArray(array);
        for (int i = 0; i < array.length; i++) {
            data[i] = array[i];
        }
        return data;
    }
    
    public static int[] DataReverse2(int[] data){
        //https://www.codewars.com/kata/569d488d61b812a0f7000015
        int min = data.length-8;
        int max = data.length-1;
        int counter = 0;
        int[] data2 = new int[data.length];
        while(min>=0){
            for(int i = min; i <= max; i++){
                data2[counter] = data[i];
                counter++;
            }
            max = min-1;
            min = min-8;
        }
        return data2;
    }
    
    public static void miniMaxSum(int[] array){
        //https://www.hackerrank.com/challenges/mini-max-sum/problem
        long min = array[0];
        long max = array[0];
        long total = 0;
        for(int i = 0; i < array.length; i++){
            if (min>array[i]) {
                min = array[i];
            }
            if (max<array[i]) {
                max = array[i];
            }
            total += array[i];
        }
        long minSum = total - max;
        long maxSum = total - min;
        System.out.println(minSum+" "+maxSum);
    }
    
    public static String timeConversion(String s){
        //https://www.hackerrank.com/challenges/time-conversion/problem 
        int hours = Integer.parseInt(s.substring(0, 2));
        if (s.startsWith("12") && s.endsWith("AM")){
            s = "00" + s.substring(2, s.length()-2);
        } else if (s.startsWith("12") && s.endsWith("PM")){
            s = "12" + s.substring(2, s.length()-2);
        } else  if (s.endsWith("PM")) {
            hours = hours + 12;
            s = (hours+"")+s.substring(2, s.length()-2);
        } else if (s.endsWith("AM")){
            s = s.substring(0, s.length()-2);
        }
        return s;
    }
    
    public static List<Integer> gradeRounder(List<Integer> grades){
        //https://www.hackerrank.com/challenges/grading/problem
        int grade = 0;
        for (int i = 0; i < grades.size(); i++) {
            if(grades.get(i)>=38 && grades.get(i)%5>2) {
                grade = grades.get(i);
                grades.set(i, grade + (5 - (grade % 5)));
            } 
        }
        return grades;
    }
    
    public static String pigLatin(String str){
        String[] strArray = str.split(" ");
        str = "";
        for(int i = 0; i < strArray.length; i++){
            char start = strArray[i].charAt(0);
            strArray[i] = strArray[i].substring(1, strArray[i].length())+start+"ay";
            str += strArray[i]+" ";
        }
        str = str.trim();
        return str;
    }
    
    public static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
    int appleCounter = 0;
    int orangeCounter = 0;
    for(int i = 0; i < apples.length; i++){
        if(a+apples[i]>=s && a+apples[i]<=t){
            appleCounter++;
        }        
    }
    System.out.println(appleCounter);
    for(int i = 0; i < oranges.length; i++){
        if(b+oranges[i]<=t && b+oranges[i]>=s){
            orangeCounter++;
        }
    }
    System.out.println(orangeCounter);
    }
    

    public static void main(String[] args) {
        

        
    


        
    }

}
