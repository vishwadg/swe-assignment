package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model;

public class CodingPractice {

    /**
     * 3.5.1.	Write a function (or method) named, printHelloWorld, that takes as input, an array of integers and iterates through them,
     * and it prints the text, "Hello", if the integer is a multiple of 5.
     * It prints the text, "World", if the integer is a multiple of 7. And when it encounters an integer that is a multiple of both 5 and 7,
     * it prints the text, "HelloWorld".
     *
     * @param numList
     */
    public static void printHelloWorld(int[] numList) {
        for (Integer num : numList) {
            if (num % 5 == 0 && num % 7 == 0) {
                System.out.println("Hello World");
            } else if (num % 5 == 0) {
                System.out.println("Hello");
            } else if (num % 7 == 0) {
                System.out.println("World");
            }
        }
    }

    /**
     * 3.5.2.	Write code for a method named, findSecondBiggest, which takes as input, an array of integers and finds and returns the second biggest of the integers.
     * For example, findSecondBiggest([1,2,3,4,5]) should return 4. And findSecondBiggest([19,9,11,0,12]) should return 12. (Note: Do not use sorting).
     *
     * @param numList
     * @return
     */
    public static int findSecondBiggest(int[] numList) {
        if (numList.length < 2) {
            return 0;
        }

        int biggestNum = Integer.MIN_VALUE;
        int secondBiggestNum = Integer.MIN_VALUE;

        for (int num : numList) {
            if (num > biggestNum) {
                secondBiggestNum = biggestNum;
                biggestNum = num;
            } else if (num > secondBiggestNum && num != biggestNum) {
                secondBiggestNum = num;
            }
        }
        return secondBiggestNum;
    }
}
