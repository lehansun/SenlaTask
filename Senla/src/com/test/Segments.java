package com.test;

/*
Задание 3

Программа, которая определяет пересекаются ли два отрезка.
Координаты отрезков вводятся вручную во время выполнения программы.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Segments {
    String name;                        // Имя отрезка
    private double x1, x2, y1, y2;      // Координаты отрезка
    private double k ;                  // Угловой коэффициент прямой отрезка
    private double b;                   // Свободные члены прямой отрезка
    boolean vertical;                   // Поле принимает значение TRUE, если отрезок вертикальный

    public Segments(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws IOException {

        Segments segmentA = new Segments("A");
        segmentA.segmentFilling();
        Segments segmentB = new Segments("B");
        segmentB.segmentFilling();

        if (segmentA.isIntersecting(segmentB)) {
            System.out.println("Отрезки пересекаются.");
        } else System.out.println("Отрезки не пересекаются.");

    }

    // Метод для наполнения полей отрезка значениями
    public void segmentFilling() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите координаты отрезка " + name + ":");
        System.out.print("x1 = ");
        x1 = Double.parseDouble(reader.readLine());
        System.out.print("y1 = ");
        y1 = Double.parseDouble(reader.readLine());
        System.out.print("x2 = ");
        x2 = Double.parseDouble(reader.readLine());
        System.out.print("y2 = ");
        y2 = Double.parseDouble(reader.readLine());
        reader = null;

        double temp;
        if (x1 > x2) {
            temp = x2;
            x2 = x1;
            x1 = temp;
            temp = y2;
            y2 = y1;
            y1 = temp;
        }
        if (x1 == x2) {
            if (y1>y2) {
                temp = y2;
                y2 = y1;
                y1 = temp;
            }
        }
    // Определяем угловой коэффициент прямой отрезка:
        if (y1==y2) k = 0;
        else {
            k=(y2-y1)/(x2-x1);
            if (x1 == x2) vertical = true;
        }
    // Определяем свободные члены в уравнении прямой отрезка
        b = y1-k*x1;
    }

    // Метод для проверки пересекаются отрезки или нет
    public boolean isIntersecting(Segments b) {
        double y;
        double x;

        // Проверка на пересечение вертикальных отрезков
        if (this.vertical || b.vertical) {

            // Если оба отрезка вертикальны
            if (this.vertical && b.vertical) {
                if (this.x1 != b.x1) return false;
                else {
                    // Если два отрезка лежат на одной вертикальной прямой,
                    // проверяем, есть ли у них общие точки
                    if (this.y1 <= b.y1 && b.y1 <= this.y2 || this.y1 <= b.y2 && b.y2 <= this.y2) return true;
                    else return false;
                }

            // Есле вертикален только один из двух отрезков
            } else {

                if (this.vertical) {
                    y = b.k*this.x1+b.b;
                    // Проверяем, что точка пересечения прямых лежит в пределах заданных отрезков
                    if (this.y1 <= y && y <= this.y2 && b.x1 <= this.x1 && this.x1 <= b.x2) return true;
                }
                if (b.vertical) {
                    y = this.k*b.x1+this.b;
                    // Проверяем, что точка пересечения прямых лежит в пределах заданных отрезков
                    if (this.x1 <= b.x1 && b.x1 <= this.x2 && b.y1 <= y && y <= b.y2) return true;
                }
            }

        // Если ни один из отрезков не вертикален
        } else {
            //Проверяем параллельны прямые или нет:
            if (this.k==b.k) {
                // Если два отрезка лежат на одной прямой, то они могут пересекаться
                if (this.b==b.b ) {
                    if (this.x1<=b.x1 && b.x1<=this.x2 || this.x1<=b.x2 && b.x2<=this.x2) return true;
                }
            }
            //Если прямые не параллельны, то ищем их точку пересечения
            else {
                x = ( b.b - this.b ) / ( this.k -  b.k );
                //Проверяем, что точка пересечения не лежит вне заданных отрезков
                if (this.x1<=x && x<=this.x2 && b.x1<=x && x<=b.x2) return true;
            }
        }
        return false;
    }
}
