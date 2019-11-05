package com.test;

/*
Задание 4

Рекурсивный алгоритм для нахождения НОД и НОК двух чисел.
Два числа вводятся вручную во время выполнения программы.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NokAndNod {
    static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите два положительных числа: ");
        try {
            a = Integer.parseInt(reader.readLine());
            b = Integer.parseInt(reader.readLine());
        }
        catch (NumberFormatException e) {
            System.out.println("Вы ввели не число! Попробуйте еще раз: ");
            a = Integer.parseInt(reader.readLine());
            b = Integer.parseInt(reader.readLine());
        }

        if (a<=0 || b<=0) {
            System.out.println("Введенные числа должны быть больше нуля!");
        } else {
            rung(a, b);
            System.out.println("Наименьшее общее кратное = " + rekursiveNok(a, b));
            System.out.println("Наибольший общий делитель = " + rekursiveNod(a, b));
        }
    }

    // Наименьшее общее кратное

    private static int rekursiveNok(int max, int min) {
        if (max%a==0 && max%b==0) return max;
        else return rekursiveNok(max+a, min);
    }

    // Наибольший общий делитель

    public static int rekursiveNod(int max, int min) {
        if (max%min==0 && b%min==0) return min;
        else return rekursiveNod(max, min - 1);
    }

    // Метод rung я написал для удобства, чтобы точно знать, что число a больше числа b

    public static void rung(int x, int y) {
        if (y>x) {
            a = y;
            b = x;
        }
    }
}
