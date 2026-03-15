package org.example;

import java.util.Scanner;

public class calcus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Сколько тебе полных лет? ");
        int age = scanner.nextInt();

        System.out.println("Через 5 лет тебе будет " + (age + 5) + " лет!");

        scanner.close();
    }
}