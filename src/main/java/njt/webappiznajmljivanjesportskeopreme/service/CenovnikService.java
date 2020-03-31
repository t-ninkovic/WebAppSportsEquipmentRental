/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.service;

import java.util.List;
import njt.webappiznajmljivanjesportskeopreme.domain.Cenovnik;

/**
 *
 * @author HP
 */
public interface CenovnikService {
    List<Cenovnik> findAll();
    Cenovnik findById(Long id);
    void save(Cenovnik cenovnik);
    void delete(Long id);
}
