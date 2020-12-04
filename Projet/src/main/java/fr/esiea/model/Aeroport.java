package fr.esiea.model;


public class Aeroport {

    private String codeAeroport;
    private String nomAeroport;

    public Aeroport(String codeA, String nomA){
        this.nomAeroport = nomA;
        this.codeAeroport = codeA;
    }

    public String getAeroportNom(){
        return this.nomAeroport;
    }

    public String getAeroportCode(){
        return this.codeAeroport;
    }

}
