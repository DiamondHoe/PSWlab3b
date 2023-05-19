package com.lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Uni {
    private static final List<Double> ListaDopuszczalnychOcen = Arrays.asList(2.0, 3.0, 3.5, 4.0, 4.5, 5.0);
    private List<Student> ListaStudentow;

    public Uni() {
        this.ListaStudentow = new ArrayList<>();
    }

    public void dodajStudenta() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nr indeksu:");
        String nr_indeksu = scanner.nextLine();
        System.out.println("Podaj imię:");
        String imie = scanner.nextLine();
        System.out.println("Podaj nazwisko:");
        String nazwisko = scanner.nextLine();
        System.out.println("Podaj rok studiów:");
        int rok_st = scanner.nextInt();

        Student student = new Student(nr_indeksu, imie, nazwisko, rok_st);

        System.out.println("Podaj oceny studenta (wpisz 'q' aby zakończyć):");
        while (true) {
            String input = scanner.next();
            if (input.equals("q")) {
                break;
            }

            try {
                double ocena = Double.parseDouble(input);
                if (ListaDopuszczalnychOcen.contains(ocena)) {
                    student.dodajOcene(ocena);
                } else {
                    System.out.println("Nieprawidłowa ocena. Wprowadź ponownie.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Nieprawidłowy format oceny. Wprowadź ponownie.");
            }
        }

        ListaStudentow.add(student);
    }

    public void usunStudenta(String nr_indeksu) {
        for (int i = 0; i < ListaStudentow.size(); i++) {
            Student student = ListaStudentow.get(i);
            if (student.getNr_indeksu().equals(nr_indeksu)) {
                ListaStudentow.remove(i);
                System.out.println("Usunięto studenta o nr indeksu: " + nr_indeksu);
                return;
            }
        }
        System.out.println("Nie znaleziono studenta o nr indeksu: " + nr_indeksu);
    }

    public double obliczSrednia(String nr_indeksu) {
        for (Student student : ListaStudentow) {
            if (student.getNr_indeksu().equals(nr_indeksu)) {
                List<Double> oceny = student.getOceny();
                if (oceny.isEmpty()) {
                    System.out.println("Student o nr indeksu " + nr_indeksu + " nie ma żadnych ocen.");
                    return 0.0;
                }

                double suma = 0.0;
                for (double ocena : oceny) {
                    suma += ocena;
                }

                return suma / oceny.size();
            }
        }

        System.out.println("Nie znaleziono studenta o nr indeksu: " + nr_indeksu);
        return 0.0;
    }

    public double obliczSredniaAll() {
        if (ListaStudentow.isEmpty()) {
            System.out.println("Brak studentów w systemie.");
            return 0.0;
        }

        double suma = 0.0;
        int iloscOcen = 0;

        for (Student student : ListaStudentow) {
            List<Double> oceny = student.getOceny();
            if (!oceny.isEmpty()) {
                for (double ocena : oceny) {
                    suma += ocena;
                    iloscOcen++;
                }
            }
        }

        if (iloscOcen == 0) {
            System.out.println("Brak ocen studentów w systemie.");
            return 0.0;
        }

        return suma / iloscOcen;
    }
}
