/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.service;

import java.util.List;
import njt.webappiznajmljivanjesportskeopreme.domain.Iznajmljivanje;

/**
 *
 * @author HP
 */
public interface IznajmljivanjeService {
    List<Iznajmljivanje> findAll();
    Iznajmljivanje findById(Long id);
    void save(Iznajmljivanje iznajmljivanje);
    void delete(Long id);
}
