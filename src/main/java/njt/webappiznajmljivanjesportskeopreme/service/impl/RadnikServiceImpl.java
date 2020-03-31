/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.service.impl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import njt.webappiznajmljivanjesportskeopreme.domain.Radnik;
import njt.webappiznajmljivanjesportskeopreme.repository.RadnikRepository;
import njt.webappiznajmljivanjesportskeopreme.service.RadnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
@Transactional
public class RadnikServiceImpl implements RadnikService{
    @Autowired
    private RadnikRepository radnikRepository;

    @Override
    public List<Radnik> findAll() {
        return radnikRepository.findAll();
    }

    @Override
    public Radnik findById(Long id) {
        Optional<Radnik> optinalRadnik = radnikRepository.findById(id);
        if (optinalRadnik.isPresent()) {
            return optinalRadnik.get();
        }
        return null;
    }

    @Override
    public void save(Radnik radnik) {
        radnikRepository.save(radnik);
    }

    @Override
    public void delete(Long id) {
        radnikRepository.deleteById(id);
    }
    
}
