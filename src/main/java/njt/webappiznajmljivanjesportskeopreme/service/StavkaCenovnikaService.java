/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.service;

import java.util.List;
import njt.webappiznajmljivanjesportskeopreme.domain.StavkaCenovnika;

/**
 *
 * @author HP
 */
public interface StavkaCenovnikaService {
    List<StavkaCenovnika> findAll();
    void save(StavkaCenovnika stavkaCenovnika);
    void delete(Long id);
    StavkaCenovnika findById(Long id);
    StavkaCenovnika findByOprema(Long oprema_id);
}
