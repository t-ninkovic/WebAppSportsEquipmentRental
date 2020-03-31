/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.service;

import java.util.List;
import njt.webappiznajmljivanjesportskeopreme.domain.Proizvodjac;

/**
 *
 * @author HP
 */
public interface ProizvodjacService {
    List<Proizvodjac> findAll();

    void save(Proizvodjac proizvodjac);

    Proizvodjac findById(Long id);
    
    void delete(Long id);

}
