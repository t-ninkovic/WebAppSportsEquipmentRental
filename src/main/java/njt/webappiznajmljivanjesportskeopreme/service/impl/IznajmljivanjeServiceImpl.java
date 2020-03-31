/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.service.impl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import njt.webappiznajmljivanjesportskeopreme.domain.Iznajmljivanje;
import njt.webappiznajmljivanjesportskeopreme.repository.IznajmljivanjeRepository;
import njt.webappiznajmljivanjesportskeopreme.service.IznajmljivanjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
@Transactional
public class IznajmljivanjeServiceImpl implements IznajmljivanjeService{

    @Autowired
    private IznajmljivanjeRepository iznajmljivanjeRepository;
    
    @Override
    public List<Iznajmljivanje> findAll() {
        return iznajmljivanjeRepository.findAll();
    }

    @Override
    public Iznajmljivanje findById(Long id) {
        Optional<Iznajmljivanje> optIzn = iznajmljivanjeRepository.findById(id);
        if (optIzn.isPresent()) {
            return optIzn.get();
        }
        return null;
    }

    @Override
    public void save(Iznajmljivanje iznajmljivanje) {
        iznajmljivanjeRepository.save(iznajmljivanje);
    }

    @Override
    public void delete(Long id) {
        iznajmljivanjeRepository.deleteById(id);
    }
    
}
