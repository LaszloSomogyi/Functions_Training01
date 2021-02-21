/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicing20210214;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Somogyi László <proceed step by step>
 */
public class Practicing20210214 {
    
    public static int[] arrayCreator(int length){
        int[] array = new int[length];
        arrayFiller(array);
        return array;
    }

    
    public static void arrayFiller(int[] array){
        for (int i=0; i<array.length; i++)
            array[i] = i+1;
    }
    
    public static void arrayPrinter(int[] array){
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]);
        if(i<array.length-1) {
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
        if (counter/2 == a.length) {
            return true;
        } else {
            System.out.println(a.length);
            System.out.println(counter);
            return false;       
        }
    }
    
    
        public static double findUniq(double arr[]) {
            //https://www.codewars.com/kata/585d7d5adb20cf33cb000235 
      double outlyer = 0;
      for(int i = 1; i<arr.length-1; i++) {
        if(arr[i-1]!=arr[i] && arr[i-1]==arr[i+1]) {
          outlyer = arr[i];
        } else if (arr[i-1]!=arr[i] && arr[i]==arr[i+1]){
            outlyer = arr[i-1];
        } else if (arr[arr.length-1]!=arr[arr.length-2]) {
            outlyer = arr[arr.length-1];
        }
      }
      return outlyer;
    }
        
    public static int[] longToArray(long a){
        int arrayLength = (a+"").length();
        int[] array = new int[arrayLength];
        String chars = a+"";
        for (int i = 0; i < chars.length(); i++) {
            array[i] = Integer.parseInt(chars.charAt(i)+"");
        }
        return array;
    }
    
    
    public static int[] longToArray2(long a){
        int arrayLength = (a+"").length();
        int[] array = new int[arrayLength];
        for(int i = 0; i < arrayLength; i++) {
            array[arrayLength-i-1] = (int) a%10;
            a=a/10;
        }
        return array;
    }
    
    public static int[] sortDescending(int[] array){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array.length-1-i; j++){
                if(array[j]<array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
        return array;
    }
    
    public static long arrayToLong(int[] array){
        long num = 0;
        String chars = "";
        for(int i = 0; i<array.length; i++){
            chars += array[i]+"";
        }
        return Long.parseLong(chars);
    }

    public static long sortLong(long num){
        //https://www.codewars.com/kata/5467e4d82edf8bbf40000155 
        return arrayToLong(sortDescending(longToArray(num)));        
    }
    
    public static String duplicateEncoder(String word){
        //https://www.codewars.com/kata/54b42f9314d9229fd6000d9c 
        word = word.toLowerCase();
        char[] wordArray = word.toCharArray();
        for(int i = 0; i<wordArray.length; i++){
            for(int j = i+1; j<wordArray.length; j++){
                if(wordArray[i]==wordArray[j] && i!=j){
                    wordArray[i]=')';
                    wordArray[j]=')';
                }
            }
        }
        for(int i=0; i<wordArray.length; i++){
            if(wordArray[i]!=')'){
                wordArray[i]='(';
            }
        }      
        word = String.valueOf(wordArray);
        return word;
    }
    
    public static int[] reverser(int[] a){
        for(int i = 0; i<a.length/2; i++){
            int tmp = a[i];
            a[i] = a[a.length-i-1];
            a[a.length-i-1] = tmp;
        }
        return a;
    }
    
    public static boolean isUnique(String word){
        //Implement an algorithm to determine if a string has all unique characters
        //int identicalCounter = 0;
        for(int i =0; i<word.length(); i++){
            for (int j = i+1; j < word.length(); j++) {
                if(word.charAt(i)==word.charAt(j))
                    return false;
            }
        }
        return true;
    }
    
    public static boolean isPalindrom(String word){
        boolean palindrom = true;
        for(int i = 0; i<word.length(); i++) {
            if(word.charAt(i)==word.charAt(word.length()-i-1)){
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
      for(int i = 0; i<a.length; i++){
          occuranceCounter=0;
        for(int j = 0; j<a.length; j++){
            if (a[i]==a[j]) {
                occuranceCounter++;
            }
        }
        if(occuranceCounter%2!=0){
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
                    //System.out.print(nString.charAt(i)+", ");
                    result *= Integer.parseInt(nString.charAt(i) + "");
                }
                n = result;
                //System.out.println(result);
                mPersistence++;
            } while (result > 9);
        }
        return mPersistence;
    }
    
    
    public static int recursiveFibonacci(int n){
        //megírni!
        return 0;
    }
    
    public static int binarySearcher(int[] array, int num){
        //https://www.javatpoint.com/binary-search-in-java 
        int position = 0;
        int min = array.length-array.length;
        int max = array.length-1;
        int middle = (min+max)/2;
        
        while(min<=max){
            if(num<array[middle]){
                max = middle-1;
            } else if(num>array[middle]){
                min = middle+1;
            } else if(num==array[middle]) {
                position = middle;
                break;
            }
            middle = (min+max)/2;
        }
        return position;
    }
    
    public static void leftRotator(int[] array, int d){
        //not yet ready!!!
        for(int i=array.length-1; i>=0; i--){
            if (i>=d) {
                array[i]=array[i-d];    
            } else {
               array[i]=array[((array.length)+i)-(d)];
            }
        }
    }
    
    //array[1]=array[array.length-i+1]
    //array[0]=array[array.length-i+]
    
    public static void main(String[] args) {
        
        System.out.println("Az eredeti tömb:");
        int[] array = new int[15];
        arrayFiller(array);
        arrayPrinter(array);
        System.out.println("A tömb elemei fordított sorrendben:");
        reverser(array);
        arrayPrinter(array);
        System.out.println("A tömb leftRotator-ral:");
        leftRotator(array, 2);
        arrayPrinter(array);
        
        System.out.println("Más feladatok:");
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        System.out.println(comp(a, b));
        
        System.out.println("CodeWars findUniq feladat:");
        double[] c = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 10.0};
        System.out.println(findUniq(c));

        System.out.println("Nagy számot tömbbé alakítunk:");        
        long num = 1986212343;
        int[] array2 = longToArray(num);
        arrayPrinter(array2);
        
        System.out.println("Tömböt nagy számmá alakítunk:");
        long num2 = arrayToLong(array2);
        System.out.println(num2);
        
        System.out.println("Tömb elemeit csökkenő sorrendbe rendezzük:");
        sortDescending(array2);
        arrayPrinter(array2);
        
        System.out.println("Itt pedig egyben próbáljuk ki a három metódust:");
        long num3 = sortLong(1234567);
        System.out.println(num3);    

        System.out.println("longToArray2 próba:");
        int[] array3 = longToArray2(num);
        arrayPrinter(array3);
        
        System.out.println("DuplicateEncoder próba:");
        System.out.println("Prespecialized");
        System.out.println(duplicateEncoder("Prespecialized"));
        
        System.out.println("CodeWars: Are they the same?");
        int[] f = {121, 144, 19, 161, 19, 144, 19, 11};  
        int[] g = {121, 14641, 20736, 361, 25921, 361, 20736, 361};
        System.out.println(comp(f, g));
        
        System.out.println("isUnique próba:");
        System.out.println(isUnique("asdfghjklé"));
        
        System.out.println("isPalindrom próba:");
        System.out.println(isPalindrom("gi tt ig"));
        
        System.out.println("Listapróba:");
        List<Integer> lista = new ArrayList<>();
        lista.add(123);
        lista.add(34);
        lista.add(111);
        lista.size();
        System.out.println(lista.get(2));
        
        System.out.println("Binary Search:");
        int[] array4 = arrayCreator(11);
        arrayPrinter(array4);
        System.out.println(binarySearcher(array4, 7));
        
        System.out.println("FindIt próba:");
        int[] array5 = new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5,10,10};
        int odd = findIt(array5);
        System.out.println(odd);
        
        System.out.println("FindIt próba2:");
        int[] array6 = new int[]{1,1,2,-2,5,2,4,4,-1,-2,5};
        System.out.println(findIt(array6));
        
        System.out.println("Persistence próba:");
        System.out.println(persistence(7));
        
        
        
        
        
    }
}
