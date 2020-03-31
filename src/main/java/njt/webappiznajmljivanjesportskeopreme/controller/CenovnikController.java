/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import njt.webappiznajmljivanjesportskeopreme.domain.Cenovnik;
import njt.webappiznajmljivanjesportskeopreme.domain.Klijent;
import njt.webappiznajmljivanjesportskeopreme.domain.Korisnik;
import njt.webappiznajmljivanjesportskeopreme.domain.Profil;
import njt.webappiznajmljivanjesportskeopreme.domain.Radnik;
import njt.webappiznajmljivanjesportskeopreme.domain.StavkaCenovnika;
import njt.webappiznajmljivanjesportskeopreme.service.CenovnikService;
import njt.webappiznajmljivanjesportskeopreme.service.StavkaCenovnikaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HP
 */
@Controller
@RequestMapping(value = "/cenovnik/*")
public class CenovnikController {

    @Autowired
    private CenovnikService cenovnikService;
    @Autowired
    private StavkaCenovnikaService stavkaCenovnikaService;

    @RequestMapping(value = "view", method = RequestMethod.GET)
    public ModelAndView view(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/cenovnik/view");
        List<Cenovnik> cenovnici = cenovnikService.findAll();
        for (Cenovnik cenovnik : cenovnici) {
            if (cenovnik.getStatus().equals("aktivan")) {
                mav.addObject("cenovnik", cenovnik);
                List<StavkaCenovnika> stavke = stavkaCenovnikaService.findAll();
                mav.addObject("stavke", stavke);
            }
        }
        Profil p = (Profil) request.getSession().getAttribute("profil");
        if (p == null) {
            mav.addObject("tip", "pogresan");
        } else {
            Korisnik k = p.getKorisnik();
            if (k instanceof Klijent) {
                mav.addObject("tip", "klijent");
            } else {
                k = (Radnik) k;
                mav.addObject("tip", "radnik");
            }
        }
        return mav;
    }
    
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Long id, HttpServletRequest request) {
        ModelAndView mav;
//        List<Cenovnik> cenovnici = cenovnikService.findAll();
//        for (Cenovnik cenovnik : cenovnici) {
//            if (cenovnik.getStatus().equals("aktivan")) {
//                mav.addObject("cenovnik", cenovnik);
//                List<StavkaCenovnika> stavke = stavkaCenovnikaService.findAll();
//                mav.addObject("stavke", stavke);
//            }
//        }
        Profil p = (Profil) request.getSession().getAttribute("profil");
        if (p == null) {
            mav = new ModelAndView("/nematePristup");
            mav.addObject("tip", "pogresan");
        } else {
            Korisnik k = p.getKorisnik();
            if (k instanceof Klijent) {
                mav = new ModelAndView("/nematePristup");
                mav.addObject("tip", "klijent");
            } else {
                k = (Radnik) k;
                Cenovnik c = cenovnikService.findById(id);
                mav = new ModelAndView("/cenovnik/edit");
                mav.addObject("editCenovnik", c);
                List<StavkaCenovnika> stavke = stavkaCenovnikaService.findAll();
                mav.addObject("stavke", stavke);
                mav.addObject("tip", "radnik");
            }
        }
        return mav;
    }

}
