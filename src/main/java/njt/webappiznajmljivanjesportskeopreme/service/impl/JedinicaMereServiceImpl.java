/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.service.impl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import njt.webappiznajmljivanjesportskeopreme.domain.JedinicaMere;
import njt.webappiznajmljivanjesportskeopreme.repository.JedinicaMereRepository;
import njt.webappiznajmljivanjesportskeopreme.service.JedinicaMereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
@Transactional
public class JedinicaMereServiceImpl implements JedinicaMereService
{
    @Autowired
    private JedinicaMereRepository jedinicaMereRepository;

    @Override
    public List<JedinicaMere> findAll() {
        return jedinicaMereRepository.findAll();
    }

    @Override
    public JedinicaMere findById(Long id) {
        Optional<JedinicaMere> optionalJM = jedinicaMereRepository.findById(id);
        if (optionalJM.isPresent()) {
            return optionalJM.get();
        }
        return null;
    }
    
}
