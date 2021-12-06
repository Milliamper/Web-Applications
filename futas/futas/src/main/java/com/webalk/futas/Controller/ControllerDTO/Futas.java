package com.webalk.futas.Controller.ControllerDTO;

import com.webalk.futas.Enums.Erzes;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Futas {

    private Long id;

    @Range(max = 3, min = 1)
    private int futasTipus;

    @Min(5)
    private float tav;

    private int ido;

    private Erzes erzes;

    public Futas() {
    }

    public com.webalk.futas.Service.ServiceDTO.Futas toServiceDTO(){
        return new com.webalk.futas.Service.ServiceDTO.Futas(id, futasTipus, tav, ido, erzes);
    }

    public Futas(com.webalk.futas.Service.ServiceDTO.Futas futas){
        this.id = futas.getId();
        this.futasTipus = futas.getFutasTipus();
        this.ido = futas.getIdo();
        this.tav = futas.getTav();
        this.erzes = futas.getErzes();
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

    public Erzes getErzes() {
        return erzes;
    }

    public void setErzes(Erzes erzes) {
        this.erzes = erzes;
    }

    public int getIdo() {
        return ido;
    }

    public void setIdo(int ido) {
        this.ido = ido;
    }
}
