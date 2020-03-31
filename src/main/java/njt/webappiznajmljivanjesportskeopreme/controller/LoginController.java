/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.controller;

import javax.servlet.http.HttpServletRequest;
import njt.webappiznajmljivanjesportskeopreme.domain.Klijent;
import njt.webappiznajmljivanjesportskeopreme.domain.Korisnik;
import njt.webappiznajmljivanjesportskeopreme.domain.Profil;
import njt.webappiznajmljivanjesportskeopreme.domain.Radnik;
import njt.webappiznajmljivanjesportskeopreme.service.ProfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HP
 */
@Controller
public class LoginController {

    @Autowired
    private ProfilService profilService;

    @ModelAttribute(name = "profil")
    public Profil profil() {
        return new Profil("", "", null);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin() {
        return "/login";
    }
    
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView welcomePage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("/welcome");
        Profil p = (Profil) request.getSession().getAttribute("profil");
        if (p == null) {
            modelAndView.addObject("tip", "pogresan");
        } else {
            Korisnik k = p.getKorisnik();
            if (k instanceof Klijent) {
                k = (Klijent) k;
                modelAndView.addObject("tip", "klijent");
                modelAndView.addObject("klijent", k);
            } else {
                k = (Radnik) k;
                modelAndView.addObject("tip", "radnik");
                modelAndView.addObject("radnik", k);
            }
        }
        return modelAndView;
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.POST)
    public ModelAndView loginProcess(@ModelAttribute(name = "profil") Profil profil, HttpServletRequest request) {
        Profil p = profilService.validate(profil.getKorisnickoIme(), profil.getSifra());
        ModelAndView modelAndView = new ModelAndView("/index");
        if (p == null) {
            modelAndView.addObject("tip", "pogresan");
        } else {
            request.getSession().setAttribute("profil", p);
            Korisnik k = p.getKorisnik();
            if (k instanceof Klijent) {
                k = (Klijent) k;
                modelAndView.addObject("tip", "klijent");
                modelAndView.addObject("klijent", k);
            } else {
                k = (Radnik) k;
                modelAndView.addObject("tip", "radnik");
                modelAndView.addObject("radnik", k);
            }

        }
        return modelAndView;
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("profil");
        request.getSession().invalidate();
        return "redirect:login";
    }
}
