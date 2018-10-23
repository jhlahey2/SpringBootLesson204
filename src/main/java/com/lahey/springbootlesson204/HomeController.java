package com.lahey.springbootlesson204;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @GetMapping("/tvform")
    public String loadTvForm(Model model){

        model.addAttribute("tvshow", new TvShow());
        return "tvform";
    }

    //Correct implementation of this method does not match the book which says:
    //public String processTvForm(@Valid TvShow tvshow, BindingResult result);

    @PostMapping("/tvform")
    public String processTvForm(@Valid @ModelAttribute("tvshow") TvShow tvshow, BindingResult result){

        if(result.hasErrors()){

            return "tvform";
        }

        return "tvshowconfirm";
    }
}
