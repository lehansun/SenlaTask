package com.test;

/*
Задание 6

Программу, которая удаляет из текста числа.
Текст вводится вручную во время выполнения программы.
 */

import java.util.Scanner;

public class ReplaceNumbers {

    public static void main(String[] argv) throws java.io.IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку с числами: ");
        String s = in.nextLine();
        String r = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                 r += c;
            }
        }
        System.out.println("Итоговая строка: " + r);
    }
}