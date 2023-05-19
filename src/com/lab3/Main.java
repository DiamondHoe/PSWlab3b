package com.lab3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Uni uni = new Uni();
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("""
                    Wybierz opcję:
                    1. Dodaj studenta
                    2. Usuń studenta
                    3. Oblicz średnią ocenę dla studenta
                    4. Oblicz średnią ocenę wszystkich studentów
                    5. Wyjście""");

            input = scanner.nextLine();

            switch (input) {
                case "1" -> uni.dodajStudenta();
                case "2" -> {
                    System.out.println("Podaj nr indeksu studenta do usunięcia:");
                    String nr_indeksu = scanner.nextLine();
                    uni.usunStudenta(nr_indeksu);
                }
                case "3" -> {
                    System.out.println("Podaj nr indeksu studenta:");
                    String nr_indeksu = scanner.nextLine();
                    double srednia = uni.obliczSrednia(nr_indeksu);
                    System.out.println("Średnia ocena studenta o nr indeksu " + nr_indeksu + ": " + srednia);
                }
                case "4" -> {
                    double sredniaAll = uni.obliczSredniaAll();
                    System.out.println("Średnia ocena wszystkich studentów: " + sredniaAll);
                }
                case "5" -> System.out.println("Koniec programu.");
                default -> System.out.println("Nieprawidłowy wybór. Wprowadź ponownie.");
            }
        } while (!input.equals("5"));
    }
}