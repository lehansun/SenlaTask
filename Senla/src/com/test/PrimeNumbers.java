package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Задание 1

Программа, которая вычисляет простые числа в пределах от 1 до N.
N – вводится вручную во время выполнения программы.

Понимаю, что данный метод не самый рациональный, т.к. на поиск простых чисел
в промежутке от 1 до 1000000 мой ПК потратил 7 долгих минут.
*/

public class PrimeNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите любое число больше 1:");
        int  n = Integer.parseInt(reader.readLine());
        isPrime(n);
    }

    public static void isPrime(int n) {

        if (n < 2) System.out.println("В указанном промежутке нет простых чисел!");
        else {
            if (n == 2) System.out.println("В указанном промежутке 1 простое число");
            if (n == 3) System.out.println("В указанном промежутке 2 простых числа");
            if (n >  3) {
                ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
                primeNumbers.add(2);
                primeNumbers.add(3);

                for (int i = 4; i <= n ; i++) {
                    boolean isPrime = true;

                    for (int j = 2; j < i; j++) {
                        if (i%j == 0) {
                            isPrime = false;
                            j = i;
                        }
                    }

                    if (isPrime) primeNumbers.add(i);
                }

                System.out.println("В промежутке от 1 до " + n + " находится " + primeNumbers.size() + " простых чисел.");
                System.out.println();
                System.out.println("Вот они: ");

                for (int i : primeNumbers) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
