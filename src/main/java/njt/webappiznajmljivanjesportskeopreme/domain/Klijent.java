/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;

/**
 *
 * @author HP
 */
@Entity
public class Klijent extends Korisnik implements Serializable {
    private String adresa;
    private String telefon;

    public Klijent() {
    }

    public Klijent(String adresa, String telefon) {
        this.adresa = adresa;
        this.telefon = telefon;
    }

    public Klijent(String adresa, String telefon, String ime, String prezime) {
        super(ime, prezime);
        this.adresa = adresa;
        this.telefon = telefon;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.adresa);
        hash = 97 * hash + Objects.hashCode(this.telefon);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Klijent other = (Klijent) obj;
        if (!Objects.equals(this.adresa, other.adresa)) {
            return false;
        }
        if (!Objects.equals(this.telefon, other.telefon)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "Klijent{" + "adresa=" + adresa + ", telefon=" + telefon + '}';
    }

    
    
    
}
