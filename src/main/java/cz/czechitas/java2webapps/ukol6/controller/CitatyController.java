package cz.czechitas.java2webapps.ukol6.controller;

import cz.czechitas.java2webapps.ukol6.service.CitatyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Random;

/**
 *
 */
@Controller
public class CitatyController {

  private final CitatyService citatyService;

  @Autowired
  public CitatyController(CitatyService citatyService) {
    this.citatyService = citatyService;
  }

  @GetMapping("/")
  public ModelAndView nahodnyCitat() {
    ModelAndView modelAndView = new ModelAndView("citat");
    modelAndView.addObject("citat", this.citatyService.nahodnyCitat());
    return modelAndView;
  }

  @GetMapping("/{id}")
  public ModelAndView konkretniCitat(@PathVariable int id) {
    ModelAndView modelAndView = new ModelAndView("citat");
    modelAndView.addObject("citat", this.citatyService.konkretniCitat(id));
    return modelAndView;
  }
}
