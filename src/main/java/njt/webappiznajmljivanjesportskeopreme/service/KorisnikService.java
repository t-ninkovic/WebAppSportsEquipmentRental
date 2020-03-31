/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.service;

import java.util.List;
import njt.webappiznajmljivanjesportskeopreme.domain.Korisnik;

/**
 *
 * @author HP
 */
public interface KorisnikService {
    List<Korisnik> findAll();
    Korisnik findById(Long id);
    void save(Korisnik korisnik);
    void delete(Long id);
}
