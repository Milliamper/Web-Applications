package com.webalk.futas.Entity;

import com.webalk.futas.Enums.Erzes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Futas {

    @Id
    @GeneratedValue
    private Long id;

    private int futasTipus;

    private float tav;

    private int ido;

    private Erzes erzes;

    public Futas() {
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
