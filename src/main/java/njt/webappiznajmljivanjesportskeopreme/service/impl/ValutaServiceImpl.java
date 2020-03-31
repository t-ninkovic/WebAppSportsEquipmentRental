/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.service.impl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import njt.webappiznajmljivanjesportskeopreme.domain.Valuta;
import njt.webappiznajmljivanjesportskeopreme.repository.ValutaRepository;
import njt.webappiznajmljivanjesportskeopreme.service.ValutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
@Transactional
public class ValutaServiceImpl implements ValutaService{

    @Autowired
    private ValutaRepository valutaRepository;
    
    @Override
    public List<Valuta> findAll() {
        return valutaRepository.findAll();
    }

    @Override
    public Valuta findById(Long id) {
        Optional<Valuta> optinalValuta = valutaRepository.findById(id);
        if (optinalValuta.isPresent()) {
            return optinalValuta.get();
        }
        return null;
    }
    
}
