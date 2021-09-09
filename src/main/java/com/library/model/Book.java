package com.library.model;

public class Book {
    private int isbnLibri;
    private String titulli;
    private String autori;
    private String shtepiB;
    private int cmimi;
    private int idStudenti;

    public Book() {
    }

    public Book(int isbnLibri, String titulli, String autori, String shtepiB, int cmimi, int idStudenti) {
        this.isbnLibri = isbnLibri;
        this.titulli = titulli;
        this.autori = autori;
        this.shtepiB = shtepiB;
        this.cmimi = cmimi;
        this.idStudenti = idStudenti;
    }

    public int getIsbnLibri() {
        return isbnLibri;
    }

    public void setIsbnLibri(int isbnLibri) {
        this.isbnLibri = isbnLibri;
    }

    public String getTitulli() {
        return titulli;
    }

    public void setTitulli(String titulli) {
        this.titulli = titulli;
    }

    public String getAutori() {
        return autori;
    }

    public void setAutori(String autori) {
        this.autori = autori;
    }

    public String getShtepiB() {
        return shtepiB;
    }

    public void setShtepiB(String shtepiB) {
        this.shtepiB = shtepiB;
    }

    public int getCmimi() {
        return cmimi;
    }

    public void setCmimi(int cmimi) {
        this.cmimi = cmimi;
    }

    public int getIdStudenti() {
        return idStudenti;
    }

    public void setIdStudenti(int idStudenti) {
        this.idStudenti = idStudenti;
    }
}