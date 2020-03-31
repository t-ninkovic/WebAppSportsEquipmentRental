/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.service.impl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import njt.webappiznajmljivanjesportskeopreme.domain.Proizvodjac;
import njt.webappiznajmljivanjesportskeopreme.repository.ProizvodjacRepository;
import njt.webappiznajmljivanjesportskeopreme.service.ProizvodjacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
@Transactional
public class ProizvodjacServiceImpl implements ProizvodjacService{
    
    @Autowired
    private ProizvodjacRepository proizvodjacRepository;

    @Override
    public List<Proizvodjac> findAll() {
        return proizvodjacRepository.findAll();
    }

    @Override
    public void save(Proizvodjac proizvodjac) {
        proizvodjacRepository.save(proizvodjac);
    }

    @Override
    public Proizvodjac findById(Long id) {
        Optional<Proizvodjac> optionalProizvodjac = proizvodjacRepository.findById(id);
        if (optionalProizvodjac.isPresent()) {
            return optionalProizvodjac.get();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        proizvodjacRepository.deleteById(id);
    }
    
}
