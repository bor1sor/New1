package org.example;

import java.util.Scanner;

public class calcus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Сколько тебе полных лет? ");
        int age = scanner.nextInt();

        System.out.println("Через 10 лет тебе будет " + (age + 1) + " лет!");

        scanner.close();
    }
}