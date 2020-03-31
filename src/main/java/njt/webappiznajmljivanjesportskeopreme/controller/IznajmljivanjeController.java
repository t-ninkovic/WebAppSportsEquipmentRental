/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import njt.webappiznajmljivanjesportskeopreme.domain.Iznajmljivanje;
import njt.webappiznajmljivanjesportskeopreme.domain.Klijent;
import njt.webappiznajmljivanjesportskeopreme.domain.Korisnik;
import njt.webappiznajmljivanjesportskeopreme.domain.Oprema;
import njt.webappiznajmljivanjesportskeopreme.domain.Profil;
import njt.webappiznajmljivanjesportskeopreme.domain.Radnik;
import njt.webappiznajmljivanjesportskeopreme.domain.StavkaCenovnika;
import njt.webappiznajmljivanjesportskeopreme.service.IznajmljivanjeService;
import njt.webappiznajmljivanjesportskeopreme.service.KlijentService;
import njt.webappiznajmljivanjesportskeopreme.service.OpremaService;
import njt.webappiznajmljivanjesportskeopreme.service.RadnikService;
import njt.webappiznajmljivanjesportskeopreme.service.StavkaCenovnikaService;
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
@RequestMapping(value = "/iznajmljivanje/*")
public class IznajmljivanjeController {

    @Autowired
    private IznajmljivanjeService iznajmljivanjeService;
    @Autowired
    private OpremaService opremaService;
    @Autowired
    private KlijentService klijentService;
    @Autowired
    private RadnikService radnikService;
    @Autowired
    private StavkaCenovnikaService stavkaCenovnikaService;

    @RequestMapping(value = "add/{id}", method = RequestMethod.GET)
    public ModelAndView add(HttpServletRequest request, @PathVariable("id") Long id) {
        ModelAndView mav;
        Profil p = (Profil) request.getSession().getAttribute("profil");
        if (p == null) {
            mav = new ModelAndView("/nematePristup");
            mav.addObject("tip", "pogresan");
        } else {
            Korisnik k = p.getKorisnik();
            Oprema o = opremaService.findById(id);
            if (k instanceof Klijent) {
                k = (Klijent) k;
                mav = new ModelAndView("/iznajmljivanje/add");
                mav.addObject("tip", "klijent");
                Iznajmljivanje izn = new Iznajmljivanje(null, null, "rezervisano", (Klijent) k, o, null, 0);
                mav.addObject("izn", izn);
            } else {
                k = (Radnik) k;
                Iznajmljivanje izn = new Iznajmljivanje(null, null, "zaduzeno", null, o, (Radnik) k, 0);
                mav = new ModelAndView("/iznajmljivanje/add");
                mav.addObject("tip", "radnik");
                mav.addObject("izn", izn);
            }
        }
        return mav;
    }

    @RequestMapping(value = "razduzi/{id}", method = RequestMethod.GET)
    public ModelAndView razduzi(HttpServletRequest request, @PathVariable("id") Long id) {
        ModelAndView mav;
        Profil p = (Profil) request.getSession().getAttribute("profil");
        if (p == null) {
            mav = new ModelAndView("/nematePristup");
            mav.addObject("tip", "pogresan");
        } else {
            Korisnik k = p.getKorisnik();
            if (k instanceof Klijent) {
                k = (Klijent) k;
                mav = new ModelAndView("/nematePristup");
                mav.addObject("tip", "klijent");
            } else {
                k = (Radnik) k;
                Iznajmljivanje izn = iznajmljivanjeService.findById(id);
                izn.setStatus("razduzeno");
                mav = new ModelAndView("/iznajmljivanje/edit");
                mav.addObject("tip", "radnik");
                mav.addObject("editIzn", izn);
            }
        }
        return mav;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute(name = "izn") Iznajmljivanje iznajmljivanje, BindingResult bindingResult) {
        System.out.println(iznajmljivanje);
        if (bindingResult.hasErrors()) {
            return "redirect:/iznajmljivanje/add";
        }
        Date datOd = iznajmljivanje.getDatumOd();
        Date datDo = iznajmljivanje.getDatumDo();
        long razlika = datDo.getTime() - datOd.getTime();
        if (razlika < 0) {
            return "redirect:/iznajmljivanje/add";
        }
        long dani = TimeUnit.DAYS.convert(razlika, TimeUnit.MILLISECONDS);
        System.out.println(dani);
        StavkaCenovnika sc = stavkaCenovnikaService.findByOprema(iznajmljivanje.getOprema().getId());
        System.out.println(sc);
        iznajmljivanje.setCena(dani * sc.getCena());
        if (iznajmljivanje.getStatus().equals("zaduzeno")) {
            Long idOpreme = iznajmljivanje.getOprema().getId();
            Oprema o = opremaService.findById(idOpreme);
            if (o.getNaStanju() == 0) {
                //vrati error
                return "redirect:/oprema/all";
            }
            o.setNaStanju(o.getNaStanju() - 1);
            opremaService.save(o);
        }
        iznajmljivanjeService.save(iznajmljivanje);
        return "redirect:/oprema/all";
        
    }

    @RequestMapping(value = "saveEdit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute(name = "editIzn") Iznajmljivanje iznajmljivanje, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/oprema/all";
        }
        Date datOd = iznajmljivanje.getDatumOd();
        Date datDo = iznajmljivanje.getDatumDo();
        long razlika = datDo.getTime() - datOd.getTime();
        if (razlika < 0) {
            System.out.println("tu sam uso");
            return "redirect:/oprema/all";
        }
        long dani = TimeUnit.DAYS.convert(razlika, TimeUnit.MILLISECONDS);
        StavkaCenovnika sc = stavkaCenovnikaService.findByOprema(iznajmljivanje.getOprema().getId());
        iznajmljivanje.setCena(dani * sc.getCena());
        if (iznajmljivanje.getStatus().equals("razduzeno")) {
            Long idOpreme = iznajmljivanje.getOprema().getId();
            Oprema o = opremaService.findById(idOpreme);

            o.setNaStanju(o.getNaStanju() + 1);
            opremaService.save(o);
        }
        iznajmljivanjeService.save(iznajmljivanje);
        return "redirect:/oprema/all";
    }

    @GetMapping("/all")
    public ModelAndView all(HttpServletRequest request) {
        List<Iznajmljivanje> iznajmljivanja = iznajmljivanjeService.findAll();
        List<Iznajmljivanje> aktivna = new ArrayList<>();
        List<Iznajmljivanje> istorija = new ArrayList<>();
        for (Iznajmljivanje iznajmljivanje : iznajmljivanja) {
            if (iznajmljivanje.getStatus().equals("razduzeno")) {
                istorija.add(iznajmljivanje);
            } else {
                aktivna.add(iznajmljivanje);
            }
        }
        ModelAndView modelAndView = new ModelAndView("/iznajmljivanje/all");
        Profil p = (Profil) request.getSession().getAttribute("profil");
        if (p == null) {
            modelAndView = new ModelAndView("/nematePristup");
        } else {
            Korisnik k = p.getKorisnik();
            if (k instanceof Klijent) {
                k = (Klijent) k;

                List<Iznajmljivanje> klijentAkt = new ArrayList<>();
                List<Iznajmljivanje> klijentIst = new ArrayList<>();
                for (Iznajmljivanje iznajmljivanje : aktivna) {
                    if (iznajmljivanje.getKlijent().equals(k)) {
                        klijentAkt.add(iznajmljivanje);
                    }
                }
                for (Iznajmljivanje iznajmljivanje : istorija) {
                    if (iznajmljivanje.getKlijent().equals(k)) {
                        klijentIst.add(iznajmljivanje);
                    }
                }

                modelAndView.addObject("tip", "klijent");
                modelAndView.addObject("klijent", k);
                modelAndView.addObject("aktivna", klijentAkt);
                if (klijentIst.size() == 0) {
                    modelAndView.addObject("istorija", "nema");
                } else {
                modelAndView.addObject("istorija", klijentIst);
                }
            } else {
                k = (Radnik) k;
                modelAndView.addObject("tip", "radnik");
                modelAndView.addObject("radnik", k);
                modelAndView.addObject("aktivna", aktivna);
                modelAndView.addObject("istorija", istorija);
            }
        }

        return modelAndView;
    }

    @ModelAttribute(name = "iznajmljivanje")
    public Iznajmljivanje iznajmljivanje() {
        return new Iznajmljivanje(null, null, null, null, null, null, 0);
    }

    @ModelAttribute(name = "klijenti")
    public List<Klijent> klijenti() {
        return klijentService.findAll();
    }

    @ModelAttribute(name = "radnici")
    public List<Radnik> radnici() {
        return radnikService.findAll();
    }
}
