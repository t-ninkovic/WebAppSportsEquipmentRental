/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import njt.webappiznajmljivanjesportskeopreme.domain.Klijent;
import njt.webappiznajmljivanjesportskeopreme.domain.Korisnik;
import njt.webappiznajmljivanjesportskeopreme.domain.Oprema;
import njt.webappiznajmljivanjesportskeopreme.domain.Profil;
import njt.webappiznajmljivanjesportskeopreme.domain.Proizvodjac;
import njt.webappiznajmljivanjesportskeopreme.domain.Radnik;
import njt.webappiznajmljivanjesportskeopreme.domain.VrstaOpreme;
import njt.webappiznajmljivanjesportskeopreme.service.OpremaService;
import njt.webappiznajmljivanjesportskeopreme.service.ProizvodjacService;
import njt.webappiznajmljivanjesportskeopreme.service.VrstaOpremeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HP
 */
@Controller
@RequestMapping(value = "/oprema/*")
public class OpremaController {

    @Autowired
    private OpremaService opremaService;

    @Autowired
    private VrstaOpremeService vrstaOpremeService;

    @Autowired
    private ProizvodjacService proizvodjacService;

    @ModelAttribute(name = "oprema")
    public Oprema oprema() {
        return new Oprema(0, "n/a", null, null, "n/a");
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView add(HttpServletRequest request) {
        ModelAndView mav;
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
                mav = new ModelAndView("/oprema/add");
                mav.addObject("tip", "radnik");
                mav.addObject("radnik", k);
            }
        }
        return mav;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute(name = "oprema") @Valid Oprema oprema, BindingResult bindingResult, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/oprema/all");
        if (bindingResult.hasErrors()) {
            mav.addObject("msg", "error");
        }
        opremaService.save(oprema);
        List<Oprema> opreme = opremaService.findAll();
        Profil p = (Profil) request.getSession().getAttribute("profil");
        mav.addObject("msg", "success");
        if (p == null) {
            mav.addObject("tip", "pogresan");
        } else {
            Korisnik k = p.getKorisnik();
            if (k instanceof Klijent) {
                k = (Klijent) k;
                mav.addObject("tip", "klijent");
                mav.addObject("klijent", k);
            } else {
                k = (Radnik) k;
                mav.addObject("tip", "radnik");
                mav.addObject("radnik", k);
            }
        }
        mav.addObject("opreme", opreme);
        return mav;
    }

    @RequestMapping(value = "saveEdit", method = RequestMethod.POST)
    public ModelAndView saveEdit(@ModelAttribute(name = "editOprema") @Valid Oprema oprema, BindingResult bindingResult, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/oprema/all");
        if (bindingResult.hasErrors()) {
            mav.addObject("msg", "error");
        }
        opremaService.save(oprema);
        List<Oprema> opreme = opremaService.findAll();
        Profil p = (Profil) request.getSession().getAttribute("profil");
        mav.addObject("msg", "success");
        if (p == null) {
            mav.addObject("tip", "pogresan");
        } else {
            Korisnik k = p.getKorisnik();
            if (k instanceof Klijent) {
                k = (Klijent) k;
                mav.addObject("tip", "klijent");
                mav.addObject("klijent", k);
            } else {
                k = (Radnik) k;
                mav.addObject("tip", "radnik");
                mav.addObject("radnik", k);
            }
        }
        mav.addObject("opreme", opreme);
        return mav;
    }

    @RequestMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        opremaService.delete(id);
        ModelAndView modelAndView = new ModelAndView("/oprema/all");
        List<Oprema> list = opremaService.findAll();
        modelAndView.addObject("opreme", list);
        return modelAndView;
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public ModelAndView get(@PathVariable("id") Long id, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("/oprema/view");
        Oprema oprema = opremaService.findById(id);
        modelAndView.addObject("viewOprema", oprema);
        Profil p = (Profil) request.getSession().getAttribute("profil");
        if (p == null) {
            modelAndView.addObject("tip", "pogresan");
        } else {
            Korisnik k = p.getKorisnik();
            if (k instanceof Klijent) {
                k = (Klijent) k;
                modelAndView.addObject("tip", "klijent");
            } else {
                k = (Radnik) k;
                modelAndView.addObject("tip", "radnik");
                modelAndView.addObject("radnik", k);
            }
        }
        return modelAndView;
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Long id, HttpServletRequest request) {
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
                Oprema oprema = opremaService.findById(id);
                modelAndView = new ModelAndView("/oprema/edit");
                modelAndView.addObject("editOprema", oprema);
                modelAndView.addObject("tip", "radnik");
                modelAndView.addObject("radnik", k);
            }
        }
        return modelAndView;
    }

    @GetMapping("/all")
    public ModelAndView all(HttpServletRequest request) {
        List<Oprema> opreme = opremaService.findAll();
        ModelAndView modelAndView = new ModelAndView("/oprema/all");
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
        modelAndView.addObject("opreme", opreme);
        return modelAndView;
    }

    @ModelAttribute(name = "vrste")
    public List<VrstaOpreme> vrste() {
        return vrstaOpremeService.findAll();
    }

    @ModelAttribute(name = "proizvodjaci")
    public List<Proizvodjac> proizvodjaci() {
        return proizvodjacService.findAll();
    }
}
