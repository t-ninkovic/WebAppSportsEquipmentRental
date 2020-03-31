/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njt.webappiznajmljivanjesportskeopreme.controller;

import java.util.List;
import njt.webappiznajmljivanjesportskeopreme.domain.VrstaOpreme;
import njt.webappiznajmljivanjesportskeopreme.dto.VrstaDTO;
import njt.webappiznajmljivanjesportskeopreme.dto.VrstaMapper;
import njt.webappiznajmljivanjesportskeopreme.service.VrstaOpremeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HP
 */
@Controller
@RequestMapping(value = "/vrsta/*")
public class VrstaController {
    @Autowired
    private VrstaOpremeService vrstaOpremeService;
    private VrstaMapper vrstaMapper;
    
    @GetMapping("/all")
    public ModelAndView all() {
        List<VrstaDTO> vrste = vrstaMapper.INSTANCE.toVrstaDTOs(vrstaOpremeService.findAll());
        for (VrstaDTO vrstaDTO : vrste) {
            System.out.println(vrstaDTO.getNaziv());
        }
        ModelAndView modelAndView = new ModelAndView("/vrsta/all");
        modelAndView.addObject("vrste", vrste);
        return modelAndView;
    }
}
