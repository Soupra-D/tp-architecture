package fr.esiea.model;


public class Aeroport {

    private String code;
    private String nom;

    public Aeroport(String code, String nom){
        this.nom = nom;
        this.code = code;
    }

    public String getNom(){
        return this.nom;
    }

    public String getCode(){
        return this.code;
    }

}
