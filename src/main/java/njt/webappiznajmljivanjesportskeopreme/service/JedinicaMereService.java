/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.service;

import java.util.List;
import njt.webappiznajmljivanjesportskeopreme.domain.JedinicaMere;

/**
 *
 * @author HP
 */
public interface JedinicaMereService {
    List<JedinicaMere> findAll();
    JedinicaMere findById(Long id);
}
