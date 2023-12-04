package model;

import java.util.Date;

public class Alimento {
    private String nombre;
    private double calorias;
    private double gramos;
    private double proteinas;
    private double hidratosDeCarbono;
    private double azucares;
    private double sodio;
    private double fibra;
    private boolean vegetariano;
    private Date fecha;
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCalorias() {
        return this.calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public double getGramos() {
        return this.gramos;
    }

    public void setGramos(double gramos) {
        this.gramos = gramos;
    }

    public double getProteinas() {
        return this.proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public double getHidratosDeCarbono() {
        return this.hidratosDeCarbono;
    }

    public void setHidratosDeCarbono(double hidratosDeCarbono) {
        this.hidratosDeCarbono = hidratosDeCarbono;
    }

    public double getAzucares() {
        return this.azucares;
    }

    public void setAzucares(double azucares) {
        this.azucares = azucares;
    }

    public double getSodio() {
        return this.sodio;
    }

    public void setSodio(double sodio) {
        this.sodio = sodio;
    }

    public double getFibra() {
        return this.fibra;
    }

    public void setFibra(double fibra) {
        this.fibra = fibra;
    }
    public Alimento(String nombre, double calorias, double gramos, double proteinas, double hidratosDeCarbono,
                    double azucares, double sodio, double fibra, boolean vegetariano, Date fecha) {
        this.nombre = nombre;
        this.calorias = calorias;
        this.gramos = gramos;
        this.proteinas = proteinas;
        this.hidratosDeCarbono = hidratosDeCarbono;
        this.azucares = azucares;
        this.sodio = sodio;
        this.fibra = fibra;
        this.vegetariano = vegetariano;
        this.fecha = fecha;

    }

    public boolean isVegetariano() {
        return vegetariano;
    }
    public void setVegetariano(boolean vegetariano) {
        this.vegetariano = vegetariano;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
