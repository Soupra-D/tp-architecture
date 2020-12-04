package fr.esiea.model;

import sun.jvm.hotspot.ui.EditableAtEndDocument;

import java.util.Date;
import java.util.Random;

public class Vol {
    private int id;
    private float prix;
    private boolean disponibilite;
    private int idVol;
    private Date dateAchat;

    public Vol(float p, boolean d){
        Random rand = new Random();
        this.id = Integer.parseInt(String.format("%04d%n", rand.nextInt(10000)));
    }

    public int getId(){
        return this.id;
    }
    public float getPrix() {
        return prix;
    }

    public boolean isDisponibilite() {
        return disponibilite;
    }

    public int getIdVol() {
        return idVol;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public void setIdVol(int idVol) {
        this.idVol = idVol;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }


}
