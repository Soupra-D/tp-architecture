package fr.esiea.model;

import java.util.Date;
import java.util.Random;

public class Vol {


    private float prix;
    private int disponibilite;
    private int depart;
    private int arrive;
    private String date;

    public Vol(int depart, int arrive, int disponibilite, String date, float prix){
        this.depart = depart;
        this.arrive = arrive;
        this.disponibilite = disponibilite;
        this.date = date;
        this.prix = prix;
    }

    public float getPrix() {
        return prix;
    }

    public int isDisponibilite() {
        return disponibilite;
    }

    public String getDate() {
        return date;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setDisponibilite(int disponibilite) {
        this.disponibilite = disponibilite;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDepart() {
        return depart;
    }

    public void setDepart(int depart) {
        this.depart = depart;
    }

    public int getDisponibilite() {
        return disponibilite;
    }

    public int getArrive() {
        return arrive;
    }

    public void setArrive(int arrive) {
        this.arrive = arrive;
    }
}
