package com.example.artapp.entidades;

public class Publicacion {
    private int thubmbnail;
    private String autor;
    private String descricpion;

    public Publicacion(int thubmbnail, String autor, String descricpion) {
        this.thubmbnail = thubmbnail;
        this.autor = autor;
        this.descricpion = descricpion;
    }

    public int getThubmbnail() {
        return thubmbnail;
    }

    public void setThubmbnail(int thubmbnail) {
        this.thubmbnail = thubmbnail;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescricpion() {
        return descricpion;
    }

    public void setDescricpion(String descricpion) {
        this.descricpion = descricpion;
    }
}
