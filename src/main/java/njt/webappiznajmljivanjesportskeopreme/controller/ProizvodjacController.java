/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.controller;

import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import njt.webappiznajmljivanjesportskeopreme.domain.Proizvodjac;
import njt.webappiznajmljivanjesportskeopreme.domain.Radnik;
import njt.webappiznajmljivanjesportskeopreme.service.ProizvodjacService;
import njt.webappiznajmljivanjesportskeopreme.service.RadnikService;
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
@RequestMapping(value = "/proizvodjac/*")
public class ProizvodjacController {
    @Autowired
    private ProizvodjacService proizvodjacService;
    
    @GetMapping("/all")
    public ModelAndView all() {
        List<Proizvodjac> proizvodjaci = proizvodjacService.findAll();
        for (Proizvodjac proizvodjac : proizvodjaci) {
            System.out.println(proizvodjac);
        }
        ModelAndView modelAndView = new ModelAndView("/proizvodjac/all");
        modelAndView.addObject("proizvodjaci", proizvodjaci);
        return modelAndView;
    }
    
    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public ModelAndView get(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("/proizvodjac/view");
        Proizvodjac proizvodjac = proizvodjacService.findById(id);
        modelAndView.addObject("viewProizvodjac", proizvodjac);
        return modelAndView;
    }
    
    @RequestMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        proizvodjacService.delete(id);
        ModelAndView modelAndView = new ModelAndView("/proizvodjac/all");
        List<Proizvodjac> list = proizvodjacService.findAll();
        modelAndView.addObject("proizvodjaci", list);
        return modelAndView;
    }
    
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add() {
        return "/proizvodjac/add";
    }
    
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute(name = "proizvodjac") @Valid Proizvodjac proizvodjac, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/proizvodjac/add";
        }
        proizvodjacService.save(proizvodjac);
        return "redirect:/proizvodjac/all";
    }
    
    @ModelAttribute(name = "proizvodjac")
    public Proizvodjac proizvodjac() {
        return new Proizvodjac("n/a");
    }
}
