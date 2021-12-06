package com.webalk.futas.Service.ServiceDTO;

import com.webalk.futas.Enums.Erzes;

import java.util.Optional;

public class Futas {

    private Long id;

    private int futasTipus;

    private float tav;

    private int ido;

    private Erzes erzes;

    public Futas() {
    }

    public Futas(com.webalk.futas.Entity.Futas futas){
        this.id = futas.getId();
        this.futasTipus = futas.getFutasTipus();
        this.ido = futas.getIdo();
        this.tav = futas.getTav();
        this.erzes = futas.getErzes();
    }

    public Futas(Optional<com.webalk.futas.Entity.Futas> futas) {
        this.id = futas.get().getId();
        this.futasTipus = futas.get().getFutasTipus();
        this.ido = futas.get().getIdo();
        this.tav = futas.get().getTav();
        this.erzes = futas.get().getErzes();
    }

    public com.webalk.futas.Entity.Futas toEntity(){
        return new com.webalk.futas.Entity.Futas(id, futasTipus, tav, ido, erzes);
    }

    public Futas(Long id, int futasTipus, float tav, int ido, Erzes erzes) {
        this.id = id;
        this.futasTipus = futasTipus;
        this.tav = tav;
        this.ido = ido;
        this.erzes = erzes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFutasTipus() {
        return futasTipus;
    }

    public void setFutasTipus(int futasTipus) {
        this.futasTipus = futasTipus;
    }

    public float getTav() {
        return tav;
    }

    public void setTav(float tav) {
        this.tav = tav;
    }

    public int getIdo() {
        return ido;
    }

    public void setIdo(int ido) {
        this.ido = ido;
    }

    public Erzes getErzes() {
        return erzes;
    }

    public void setErzes(Erzes erzes) {
        this.erzes = erzes;
    }
}
