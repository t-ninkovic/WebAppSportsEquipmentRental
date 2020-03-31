/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.service.impl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import njt.webappiznajmljivanjesportskeopreme.domain.Profil;
import njt.webappiznajmljivanjesportskeopreme.repository.ProfilRepository;
import njt.webappiznajmljivanjesportskeopreme.service.ProfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
@Transactional
public class ProfilServiceImpl implements ProfilService{
    
    @Autowired
    private ProfilRepository profilRepository;

    @Override
    public List<Profil> findAll() {
        return profilRepository.findAll();
    }

    @Override
    public Profil findById(Long id) {
        Optional<Profil> optionalProfil = profilRepository.findById(id);
        if (optionalProfil.isPresent()) {
            return optionalProfil.get();
        }
        return null;
    }

    @Override
    public Profil validate(String korisnickoIme, String sifra) {
        List<Profil> sviProfili = profilRepository.findAll();
        for (Profil profil : sviProfili) {
            if (profil.getKorisnickoIme().equals(korisnickoIme) && profil.getSifra().equals(sifra))
                return profil;
        }
        return null;
    }
    
}
