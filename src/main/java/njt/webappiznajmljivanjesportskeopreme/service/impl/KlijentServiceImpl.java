/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.service.impl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import njt.webappiznajmljivanjesportskeopreme.domain.Klijent;
import njt.webappiznajmljivanjesportskeopreme.repository.KlijentRepository;
import njt.webappiznajmljivanjesportskeopreme.service.KlijentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
@Transactional
public class KlijentServiceImpl implements KlijentService{
    @Autowired
    private KlijentRepository klijentRepository;

    @Override
    public List<Klijent> findAll() {
        return klijentRepository.findAll();
    }

    @Override
    public Klijent findById(Long id) {
        Optional<Klijent> optinalKlijent = klijentRepository.findById(id);
        if (optinalKlijent.isPresent()) {
            return optinalKlijent.get();
        }
        return null;
    }

    @Override
    public void save(Klijent klijent) {
        klijentRepository.save(klijent);
    }

    @Override
    public void delete(Long id) {
        klijentRepository.deleteById(id);
    }
    
}
