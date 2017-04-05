package com.example.onafe.bmt;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by onafe on 21/03/2017.
 */

public class Configurazione implements Parcelable {

    String denominazione;
    int colore;
    String numeroOre;
    String tempoOre;

    public Configurazione(String denominazione,int colore, String numeroOre, String tempoOre){
        this.denominazione=denominazione;
        this.colore=colore;
        this.numeroOre=numeroOre;
        this.tempoOre=tempoOre;
    }

    protected Configurazione(Parcel in) {
        readFromParcel(in);
    }

    public void readFromParcel(Parcel in) {
        denominazione = in.readString();
        colore = in.readInt();
        numeroOre = in.readString();
        tempoOre = in.readString();
    }

    public static final Creator<Configurazione> CREATOR = new Creator<Configurazione>() {
        @Override
        public Configurazione createFromParcel(Parcel in) {
            return new Configurazione(in);
        }

        @Override
        public Configurazione[] newArray(int size) {
            return new Configurazione[size];
        }
    };

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public int getColore() {
        return colore;
    }

    public void setColore(int colore) {
        this.colore = colore;
    }

    public String getNumeroOre() {
        return numeroOre;
    }

    public void setNumeroOre(String numeroOre) {
        this.numeroOre = numeroOre;
    }

    public String getTempoOre() {
        return tempoOre;
    }

    public void setTempoOre(String tempoOre) {
        this.tempoOre = tempoOre;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(denominazione);
        dest.writeInt(colore);
        dest.writeString(numeroOre);
        dest.writeString(tempoOre);
    }
}
