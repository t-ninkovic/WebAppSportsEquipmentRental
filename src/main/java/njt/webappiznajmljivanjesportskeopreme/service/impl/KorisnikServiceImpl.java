/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.service.impl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import njt.webappiznajmljivanjesportskeopreme.domain.Korisnik;
import njt.webappiznajmljivanjesportskeopreme.repository.KorisnikRepository;
import njt.webappiznajmljivanjesportskeopreme.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
@Transactional
public class KorisnikServiceImpl implements KorisnikService{
    @Autowired
    private KorisnikRepository korisnikRepository;

    @Override
    public List<Korisnik> findAll() {
        return korisnikRepository.findAll();
    }

    @Override
    public Korisnik findById(Long id) {
        Optional<Korisnik> optinalKorisnik = korisnikRepository.findById(id);
        if (optinalKorisnik.isPresent()) {
            return optinalKorisnik.get();
        }
        return null;
    }

    @Override
    public void save(Korisnik korisnik) {
        korisnikRepository.save(korisnik);
    }

    @Override
    public void delete(Long id) {
        korisnikRepository.deleteById(id);
    }
    
}
