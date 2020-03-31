/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.domain;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author HP
 */
@Entity
public class Radnik extends Korisnik {
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date datumZaposlenja;
    private String brojRadneKnjizice;

    public Radnik() {
    }

    public Radnik(Date datumZaposlenja, String brojRadneKnjizice) {
        this.datumZaposlenja = datumZaposlenja;
        this.brojRadneKnjizice = brojRadneKnjizice;
    }

    public Radnik(Date datumZaposlenja, String brojRadneKnjizice, String ime, String prezime) {
        super(ime, prezime);
        this.datumZaposlenja = datumZaposlenja;
        this.brojRadneKnjizice = brojRadneKnjizice;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.datumZaposlenja);
        hash = 13 * hash + Objects.hashCode(this.brojRadneKnjizice);
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
        final Radnik other = (Radnik) obj;
        if (!Objects.equals(this.brojRadneKnjizice, other.brojRadneKnjizice)) {
            return false;
        }
        if (!Objects.equals(this.datumZaposlenja, other.datumZaposlenja)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() { 
        return super.toString() + "Radnik{" + "datumZaposlenja=" + datumZaposlenja + ", brojRadneKnjizice=" + brojRadneKnjizice + '}';
    }

    public Date getDatumZaposlenja() {
        return datumZaposlenja;
    }

    public void setDatumZaposlenja(Date datumZaposlenja) {
        this.datumZaposlenja = datumZaposlenja;
    }

    public String getBrojRadneKnjizice() {
        return brojRadneKnjizice;
    }

    public void setBrojRadneKnjizice(String brojRadneKnjizice) {
        this.brojRadneKnjizice = brojRadneKnjizice;
    }
    
}
