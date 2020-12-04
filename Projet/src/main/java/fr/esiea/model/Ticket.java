package fr.esiea.model;

import java.util.Date;

public class Ticket {
    private int id;
    private float prix;
    private boolean disponibilite;
    private int idVol;
    private Date dateAchat;

    public Ticket(int id, float prix, boolean disponibilite, int idVol, Date dateAchat) {
        this.id = id;
        this.prix = prix;
        this.disponibilite = disponibilite;
        this.idVol = idVol;
        this.dateAchat = dateAchat;
    }

    public int getId() {
        return id;
    }

    public float getPrix() {
        return prix;
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

    public boolean isDisponibilite() {
        return disponibilite;
    }

    public int getIdVol() {
        return idVol;
    }

    public Date getDateAchat() {
        return dateAchat;
    }
}
