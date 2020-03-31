/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author HP
 */
@Entity
public class StavkaCenovnika implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @NotNull
    private Cenovnik cenovnik;
    @ManyToOne
    private JedinicaMere jm;
    @ManyToOne
    private Valuta valuta;
    private double cena;
    @ManyToOne
    private Oprema oprema;

    public StavkaCenovnika() {
    }

    public StavkaCenovnika(Cenovnik cenovnik, JedinicaMere jm, Valuta valuta, double cena, Oprema oprema) {
        this.cenovnik = cenovnik;
        this.jm = jm;
        this.valuta = valuta;
        this.cena = cena;
        this.oprema = oprema;
    }

    public Valuta getValuta() {
        return valuta;
    }

    public void setValuta(Valuta valuta) {
        this.valuta = valuta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cenovnik getCenovnik() {
        return cenovnik;
    }

    public void setCenovnik(Cenovnik cenovnik) {
        this.cenovnik = cenovnik;
    }

    public JedinicaMere getJm() {
        return jm;
    }

    public void setJm(JedinicaMere jm) {
        this.jm = jm;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.cenovnik);
        hash = 41 * hash + Objects.hashCode(this.jm);
        hash = 41 * hash + Objects.hashCode(this.valuta);
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
        final StavkaCenovnika other = (StavkaCenovnika) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.cenovnik, other.cenovnik)) {
            return false;
        }
        if (!Objects.equals(this.jm, other.jm)) {
            return false;
        }
        if (!Objects.equals(this.valuta, other.valuta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StavkaCenovnika{" + "id=" + id + ", cenovnik=" + cenovnik + ", jm=" + jm + ", valuta=" + valuta + '}';
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Oprema getOprema() {
        return oprema;
    }

    public void setOprema(Oprema oprema) {
        this.oprema = oprema;
    }
    
    
}
