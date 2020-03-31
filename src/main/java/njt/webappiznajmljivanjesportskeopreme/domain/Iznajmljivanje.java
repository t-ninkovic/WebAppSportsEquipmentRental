/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author HP
 */
@Entity
public class Iznajmljivanje implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date datumOd;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date datumDo;
    private String status;
    @ManyToOne
    @NotNull
    private Klijent klijent;
    @ManyToOne
    @NotNull
    private Oprema oprema;
    @ManyToOne
    @NotNull
    private Radnik radnik;
    private double cena;

    public Iznajmljivanje() {
    }

    public Iznajmljivanje(Date datumOd, Date datumDo, String status, Klijent klijent, Oprema oprema, Radnik radnik, double cena) {
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.status = status;
        this.klijent = klijent;
        this.oprema = oprema;
        this.radnik = radnik;
        this.cena = cena;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public Oprema getOprema() {
        return oprema;
    }

    public void setOprema(Oprema oprema) {
        this.oprema = oprema;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.datumOd);
        hash = 59 * hash + Objects.hashCode(this.datumDo);
        hash = 59 * hash + Objects.hashCode(this.status);
        hash = 59 * hash + Objects.hashCode(this.klijent);
        hash = 59 * hash + Objects.hashCode(this.oprema);
        hash = 59 * hash + Objects.hashCode(this.radnik);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.cena) ^ (Double.doubleToLongBits(this.cena) >>> 32));
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
        final Iznajmljivanje other = (Iznajmljivanje) obj;
        if (Double.doubleToLongBits(this.cena) != Double.doubleToLongBits(other.cena)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.datumOd, other.datumOd)) {
            return false;
        }
        if (!Objects.equals(this.datumDo, other.datumDo)) {
            return false;
        }
        if (!Objects.equals(this.klijent, other.klijent)) {
            return false;
        }
        if (!Objects.equals(this.oprema, other.oprema)) {
            return false;
        }
        if (!Objects.equals(this.radnik, other.radnik)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Iznajmljivanje{" + "id=" + id + ", datumOd=" + datumOd + ", datumDo=" + datumDo + ", status=" + status + ", klijent=" + klijent + ", oprema=" + oprema + ", radnik=" + radnik + ", cena=" + cena + '}';
    }
    
    
}
