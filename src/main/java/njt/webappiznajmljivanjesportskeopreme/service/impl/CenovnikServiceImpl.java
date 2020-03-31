/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.service.impl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import njt.webappiznajmljivanjesportskeopreme.domain.Cenovnik;
import njt.webappiznajmljivanjesportskeopreme.repository.CenovnikRepository;
import njt.webappiznajmljivanjesportskeopreme.service.CenovnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
@Transactional
public class CenovnikServiceImpl implements CenovnikService{
    
    @Autowired
    private CenovnikRepository cenovnikRepository;

    @Override
    public List<Cenovnik> findAll() {
        return cenovnikRepository.findAll();
    }

    @Override
    public Cenovnik findById(Long id) {
        Optional<Cenovnik> optinalCenovnik = cenovnikRepository.findById(id);
        if (optinalCenovnik.isPresent()) {
            return optinalCenovnik.get();
        }
        return null;
    }

    @Override
    public void save(Cenovnik cenovnik) {
        cenovnikRepository.save(cenovnik);
    }

    @Override
    public void delete(Long id) {
        cenovnikRepository.deleteById(id);
    }
    
}
