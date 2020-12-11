package fr.esiea.model;

import java.util.Date;

public class Ticket {
    private int customer;
    private int vol;

    public Ticket(){

    }

    public Ticket(int customer, int vol) {
        this.customer = customer;
        this.vol = vol;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        this.vol = vol;
    }
}
