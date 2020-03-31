/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import njt.webappiznajmljivanjesportskeopreme.domain.Klijent;
import njt.webappiznajmljivanjesportskeopreme.domain.Korisnik;
import njt.webappiznajmljivanjesportskeopreme.domain.Oprema;
import njt.webappiznajmljivanjesportskeopreme.domain.Profil;
import njt.webappiznajmljivanjesportskeopreme.domain.Radnik;
import njt.webappiznajmljivanjesportskeopreme.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HP
 */
@Controller
@RequestMapping(value = "/korisnik/*")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    @ModelAttribute(name = "korisnik")
    public Korisnik korisnik() {
        return new Korisnik("n/a", "n/a");
    }

    @GetMapping("/all")
    public ModelAndView all(HttpServletRequest request) {
        ModelAndView modelAndView;
        Profil p = (Profil) request.getSession().getAttribute("profil");
        if (p == null) {
            modelAndView = new ModelAndView("/nematePristup");
            modelAndView.addObject("tip", "pogresan");
        } else {
            Korisnik k = p.getKorisnik();
            if (k instanceof Klijent) {
                modelAndView = new ModelAndView("/nematePristup");
                modelAndView.addObject("tip", "klijent");
            } else {
                k = (Radnik) k;
                List<Korisnik> korisnici = korisnikService.findAll();
                List<Klijent> klijenti = new ArrayList<>();
                List<Radnik> radnici = new ArrayList<>();
                for (Korisnik korisnik : korisnici) {
                    if (korisnik instanceof Klijent) {
                        klijenti.add((Klijent) korisnik);
                    } else {
                        radnici.add((Radnik) korisnik);
                    }
                }
                modelAndView = new ModelAndView("/korisnik/all");
                modelAndView.addObject("tip", "radnik");
                modelAndView.addObject("radnik", k);
                modelAndView.addObject("klijenti", klijenti);
                modelAndView.addObject("radnici", radnici);
            }
        }
        return modelAndView;
    }

}
