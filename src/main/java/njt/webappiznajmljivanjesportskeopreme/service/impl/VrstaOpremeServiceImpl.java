/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.service.impl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import njt.webappiznajmljivanjesportskeopreme.domain.VrstaOpreme;
import njt.webappiznajmljivanjesportskeopreme.repository.VrstaOpremeRepository;
import njt.webappiznajmljivanjesportskeopreme.service.VrstaOpremeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
@Transactional
public class VrstaOpremeServiceImpl implements VrstaOpremeService{
    @Autowired
    private VrstaOpremeRepository vrstaOpremeRepository;

    @Override
    public List<VrstaOpreme> findAll() {
        return vrstaOpremeRepository.findAll();
    }

    @Override
    public VrstaOpreme findById(Long id) {
        Optional<VrstaOpreme> optinalVrsta = vrstaOpremeRepository.findById(id);
        if (optinalVrsta.isPresent()) {
            return optinalVrsta.get();
        }
        return null;
    }
    
}
