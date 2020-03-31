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
import njt.webappiznajmljivanjesportskeopreme.domain.StavkaCenovnika;
import njt.webappiznajmljivanjesportskeopreme.repository.StavkaCenovnikaRepository;
import njt.webappiznajmljivanjesportskeopreme.service.StavkaCenovnikaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
@Transactional
public class StavkaCenovnikaServiceImpl implements StavkaCenovnikaService{
    @Autowired
    private StavkaCenovnikaRepository stavkaCenovnikaRepository;
            
    
    @Override
    public List<StavkaCenovnika> findAll() {
        return stavkaCenovnikaRepository.findAll();
    }

    @Override
    public void save(StavkaCenovnika stavkaCenovnika) {
        stavkaCenovnikaRepository.save(stavkaCenovnika);
    }

    @Override
    public void delete(Long id) {
        stavkaCenovnikaRepository.deleteById(id);
    }

    @Override
    public StavkaCenovnika findById(Long id) {
        Optional<StavkaCenovnika> optionalStavka = stavkaCenovnikaRepository.findById(id);
        if (optionalStavka.isPresent()) {
            return optionalStavka.get();
        }
        return null;
    }

    @Override
    public StavkaCenovnika findByOprema(Long oprema_id) {
        List<StavkaCenovnika> stavke = stavkaCenovnikaRepository.findAll();
        for (StavkaCenovnika stavkaCenovnika : stavke) {
            if (stavkaCenovnika.getOprema().getId() == oprema_id) {
                return stavkaCenovnika;
            }
        }
        return null;
    }
    
}
