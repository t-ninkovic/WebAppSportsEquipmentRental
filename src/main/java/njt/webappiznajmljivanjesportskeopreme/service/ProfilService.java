/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.service;

import java.util.List;
import njt.webappiznajmljivanjesportskeopreme.domain.Profil;

/**
 *
 * @author HP
 */
public interface ProfilService {
    List<Profil> findAll();
    Profil findById(Long id);

    public Profil validate(String korisnickoIme, String sifra);
}
