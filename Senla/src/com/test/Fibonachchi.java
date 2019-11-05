package com.test;

/*
Задание 2

Рекурсивный алгоритм, который находит числа Фибоначчи в пределах от 1 до N.
N – вводится вручную во время выполнения программы.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Fibonachchi {
    static long a = 0;
    static long b = 1;
    static long c = 1;
    static ArrayList<Long> fibo = new ArrayList<Long>();
    static long n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fibo.add((long) a);
        fibo.add((long) b);
        System.out.print("Введиде число больше 1: ");
        try {
            n = Long.parseLong(reader.readLine());
        }
        catch (NumberFormatException e) {
            System.out.println("Вы ввелт не число!");
            System.out.print("Попробуйте ввести число больше 1 еще раз: ");
            n = Long.parseLong(reader.readLine());
        }
        if (n<0) System.out.println("Ошика: Вы ввели отрицательное число!");
        else {
            fiboLessThanN(n);
            System.out.println("Вот числа Фибоначчи, которые удалось найти в промежутке от 0 до " + n + ":");
            for (Long i : fibo) {
                System.out.print(i + " ");
            }
        }
    }

    public static void fiboLessThanN(long n) {
            c = a + b;
            a = b;
            b = c;

            if (c <= n) {
                fibo.add(c);
                fiboLessThanN(n);
            }
    }
}
