/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.service;

import java.util.List;
import njt.webappiznajmljivanjesportskeopreme.domain.Radnik;

/**
 *
 * @author HP
 */
public interface RadnikService {
    List<Radnik> findAll();
    Radnik findById(Long id);
    void save(Radnik radnik);
    void delete(Long id);
}
