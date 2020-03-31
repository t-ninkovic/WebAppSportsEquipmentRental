/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.service;

import java.util.List;
import njt.webappiznajmljivanjesportskeopreme.domain.Valuta;

/**
 *
 * @author HP
 */
public interface ValutaService {
    List<Valuta> findAll();
    Valuta findById(Long id);
}
