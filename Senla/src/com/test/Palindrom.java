package com.test;
/*
Задание 5

Программу, которая проверяет слово на "палиндромность".
Слово для проверки вводится вручную во время выполнения программы.
 */
import java.util.Scanner;

public class Palindrom {
    public static void main(String[] argv) throws java.io.IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите слово: ");
        String s = in.nextLine();

        if (isPalindrom(s)) System.out.println("Введенное слово является палиндромом");
        else System.out.println("Введенное слово не является палиндромом");
    }

    private static boolean isPalindrom(String s) {
        boolean r = true;

        for (int i = 0; i < s.length()/2; ) {
            char first = s.charAt(i);
            char last = s.charAt(s.length()-i-1);

            if (first==last) i++;
            else return false;
        }
    return r;
    }
}
