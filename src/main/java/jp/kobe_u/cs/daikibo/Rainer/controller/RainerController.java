package jp.kobe_u.cs.daikibo.Rainer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.kobe_u.cs.daikibo.Rainer.entity.Rainer;
import jp.kobe_u.cs.daikibo.Rainer.service.RainerService;

@Controller
public class RainerController {

    @Autowired
    RainerService rs;

    // Show title screen
    @GetMapping("/")
    String showIndex() {
        return "index";
    }

    // Show main screen
    @GetMapping("/read")
    String showRainerList(Model model) {
        List<Rainer> list = rs.getAllRainer(); // Get all Rainers
        model.addAttribute("rainerList", list); // Set list to model attribute
        model.addAttribute("rainerForm", new RainerForm()); // Set empty form
        return "rainer_list"; // Return list screen
    }

    // Post Rainer
    @PostMapping("/read")
    String postRainer(@ModelAttribute("rainerForm") Rainer form, Model model) {
        // Transfer from form to entity
        Rainer r = new Rainer();
        r.setName(form.getName());
        r.setComment(form.getComment());
        // Request post process to service
        rs.postRainer(r);
        return "redirect:/read"; // Transfer to main screen
    }
}