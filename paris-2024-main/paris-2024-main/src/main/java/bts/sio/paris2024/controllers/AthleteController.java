package bts.sio.paris2024.controllers;

import bts.sio.paris2024.models.Athlete;
import bts.sio.paris2024.models.Pays;
import bts.sio.paris2024.services.AthleteService;
import bts.sio.paris2024.services.PaysService;
import bts.sio.paris2024.ui.UIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AthleteController {


    @Autowired
    private AthleteService athleteservice;

    @Autowired
    private PaysService paysService;

    @Autowired
    private UIService uiService;

    private ModelAndView initForm(Athlete athlete,String title){
        ModelAndView mav = new ModelAndView("/athletes/form");
        mav.addObject("title", title);
        mav.addObject("athlete", athlete);
        mav.addObject("listPays", uiService.toOptions(paysService.getLesPays(),athlete.getPays()));
        return mav;
    }

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Athlete> listAthletes = athleteservice.getAthletes();
        model.addAttribute("athletes", listAthletes);
        return "/home";
    }

    @GetMapping("/createAthlete")
    public ModelAndView createAthlete() {
        return initForm(new Athlete(),"Création d'un athlète");
    }

    @GetMapping("/updateAthlete/{id}")
    public ModelAndView updateAthlete(@PathVariable final long id) {
        return initForm(athleteservice.getAthlete(id).get(),"Modification d'un athlète");
    }

    @PostMapping("/saveAthlete")
    public ModelAndView saveAthlete(@ModelAttribute Athlete athlete, @RequestParam Long paysId) {
        Pays pays = paysService.getPays(paysId).get();
        athlete.setPays(pays);
        athlete.setNom(athlete.getNom());
        athleteservice.saveAthlete(athlete);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/deleteAthlete/{id}")
    public ModelAndView deleteAthlete(@PathVariable final Long id) {
        athleteservice.deleteAthlete(id);
        return new ModelAndView("redirect:/");
    }
}
