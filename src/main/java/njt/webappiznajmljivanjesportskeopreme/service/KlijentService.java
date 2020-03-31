/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.service;

import java.util.List;
import njt.webappiznajmljivanjesportskeopreme.domain.Klijent;

/**
 *
 * @author HP
 */
public interface KlijentService {
    List<Klijent> findAll();
    Klijent findById(Long id);
    void save(Klijent klijent);
    void delete(Long id);
}
