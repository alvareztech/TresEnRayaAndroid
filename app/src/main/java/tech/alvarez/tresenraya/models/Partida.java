package tech.alvarez.tresenraya.models;

import java.util.Date;

/**
 * Created by Daniel Alvarez on 27/6/16.
 * Copyright © 2016 Alvarez.tech. All rights reserved.
 */
public class Partida {

    private String nombreJugador1;
    private String nombreJugador2;
    private int quienGano;
    private Date fecha;

    public Partida(String nombreJugador1, String nombreJugador2, int quienGano, Date fecha) {
        this.nombreJugador1 = nombreJugador1;
        this.nombreJugador2 = nombreJugador2;
        this.quienGano = quienGano;
        this.fecha = fecha;
    }


    public String getNombreJugador1() {
        return nombreJugador1;
    }

    public void setNombreJugador1(String nombreJugador1) {
        this.nombreJugador1 = nombreJugador1;
    }

    public String getNombreJugador2() {
        return nombreJugador2;
    }

    public void setNombreJugador2(String nombreJugador2) {
        this.nombreJugador2 = nombreJugador2;
    }

    public int getQuienGano() {
        return quienGano;
    }

    public void setQuienGano(int quienGano) {
        this.quienGano = quienGano;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
