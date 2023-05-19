package com.lab3;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String nr_indeksu;
    private String imie;
    private String nazwisko;
    private int rok_st;
    private List<Double> oceny;

    public Student(String nr_indeksu, String imie, String nazwisko, int rok_st) {
        this.nr_indeksu = nr_indeksu;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rok_st = rok_st;
        this.oceny = new ArrayList<>();
    }

    public String getNr_indeksu() {
        return nr_indeksu;
    }

    public void setNr_indeksu(String nr_indeksu) {
        this.nr_indeksu = nr_indeksu;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getRok_st() {
        return rok_st;
    }

    public void setRok_st(int rok_st) {
        this.rok_st = rok_st;
    }

    public List<Double> getOceny() {
        return oceny;
    }

    public void setOceny(List<Double> oceny) {
        this.oceny = oceny;
    }

    public void dodajOcene(double ocena) {
        oceny.add(ocena);
    }

    public void wyswietlStudenta() {
        System.out.println("Nr indeksu: " + nr_indeksu);
        System.out.println("Imię: " + imie);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("Rok studiów: " + rok_st);
        System.out.println("Oceny: " + oceny);
    }
}