/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.service;

import java.util.List;
import njt.webappiznajmljivanjesportskeopreme.domain.Oprema;

/**
 *
 * @author HP
 */
public interface OpremaService {
    List<Oprema> findAll();
    Oprema findById(Long id);
    void save(Oprema oprema);
    void delete(Long id);
}
