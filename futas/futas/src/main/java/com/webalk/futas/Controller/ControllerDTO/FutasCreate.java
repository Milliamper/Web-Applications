package com.webalk.futas.Controller.ControllerDTO;

import com.webalk.futas.Enums.Erzes;
import com.webalk.futas.Service.ServiceDTO.Futas;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class FutasCreate {

    @Range(max = 3, min = 1)
    private int futasTipus;

    @Min(5)
    private float tav;

    @NotNull
    private int ido;

    private Erzes erzes;

    public FutasCreate(int futasTipus, float tav, int ido, Erzes erzes) {
        this.futasTipus = futasTipus;
        this.tav = tav;
        this.ido = ido;
        this.erzes = erzes;
    }

    public FutasCreate() {
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

    public Futas toServiceDTO(){
        return new Futas(null, futasTipus, tav, ido, erzes);
    }
}
