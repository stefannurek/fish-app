package fishapp.controllers;

import fishapp.models.TripModel;
import fishapp.models.forms.TripForm;
import fishapp.repositories.TripRepository;
import javassist.runtime.Desc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.text.Normalizer;
import java.time.LocalDate;


@Controller
public class TripController {

    TripRepository tripRepository;

    public TripController(TripRepository tripRepository){
        this.tripRepository=tripRepository;
    }


    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("tripForm", new TripForm());
        return "addadventure";

    }

    @PostMapping("/")
    public String index(@ModelAttribute("tripForm") @Valid TripForm form, BindingResult result, Model model){

        if(result.hasErrors()){
            return "addadventure";
        }
        tripRepository.save(new TripModel(form));
        model.addAttribute("showAddedRecord", tripRepository.findAll());
        model.addAttribute("info", "Udało się poprawnie dodać wyprawę !!!");
        return  "addadventure";
    }


}
