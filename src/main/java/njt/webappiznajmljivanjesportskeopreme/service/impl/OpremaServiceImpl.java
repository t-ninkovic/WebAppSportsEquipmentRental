/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.service.impl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import njt.webappiznajmljivanjesportskeopreme.domain.Oprema;
import njt.webappiznajmljivanjesportskeopreme.repository.OpremaRepository;
import njt.webappiznajmljivanjesportskeopreme.service.OpremaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
@Transactional
public class OpremaServiceImpl implements OpremaService{
    
    @Autowired
    private OpremaRepository opremaRepository;

    @Override
    public List<Oprema> findAll() {
        return opremaRepository.findAll();
    }

    @Override
    public Oprema findById(Long id) {
        Optional<Oprema> optinalOprema = opremaRepository.findById(id);
        if (optinalOprema.isPresent()) {
            return optinalOprema.get();
        }
        return null;
    }

    @Override
    public void save(Oprema oprema) {
        opremaRepository.save(oprema);
    }

    @Override
    public void delete(Long id) {
        opremaRepository.deleteById(id);
    }
    
}
