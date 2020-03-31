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
public class Oprema implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int naStanju;
    private String opis;
    @NotNull
    @ManyToOne
    private VrstaOpreme vrsta;
    @ManyToOne
    private Proizvodjac proizvodjac;
    private String slika;

    public Oprema() {
    }

    public Oprema(int naStanju, String opis, VrstaOpreme vrsta, Proizvodjac proizvodjac, String slika) {
        this.naStanju = naStanju;
        this.opis = opis;
        this.vrsta = vrsta;
        this.proizvodjac = proizvodjac;
        this.slika = slika;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNaStanju() {
        return naStanju;
    }

    public void setNaStanju(int naStanju) {
        this.naStanju = naStanju;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public VrstaOpreme getVrsta() {
        return vrsta;
    }

    public void setVrsta(VrstaOpreme vrsta) {
        this.vrsta = vrsta;
    }

    public Proizvodjac getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(Proizvodjac proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    @Override
    public String toString() {
        return "Oprema{" + "id=" + id + ", naStanju=" + naStanju + ", opis=" + opis + ", vrsta=" + vrsta + ", proizvodjac=" + proizvodjac + ", slika=" + slika + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + this.naStanju;
        hash = 43 * hash + Objects.hashCode(this.opis);
        hash = 43 * hash + Objects.hashCode(this.vrsta);
        hash = 43 * hash + Objects.hashCode(this.proizvodjac);
        hash = 43 * hash + Objects.hashCode(this.slika);
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
        final Oprema other = (Oprema) obj;
        if (this.naStanju != other.naStanju) {
            return false;
        }
        if (!Objects.equals(this.opis, other.opis)) {
            return false;
        }
        if (!Objects.equals(this.slika, other.slika)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.vrsta, other.vrsta)) {
            return false;
        }
        if (!Objects.equals(this.proizvodjac, other.proizvodjac)) {
            return false;
        }
        return true;
    }

    
    
}
