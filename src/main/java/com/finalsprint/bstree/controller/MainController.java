package com.finalsprint.bstree.controller;
import com.finalsprint.bstree.model.AVLTree;
import com.finalsprint.bstree.model.Submit;
import com.finalsprint.bstree.repository.SubmitRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {

    @Autowired
    private SubmitRepository submitRepository;

    // Get submit page
    @GetMapping(path = "/submit")
    public String getSubmitPage(Model model) {
        Submit submit = new Submit();
        model.addAttribute("submit", submit);
        return "submit";
    }

    // Post search
    @PostMapping(path = "/submit")
    public String submitForm(@ModelAttribute("submit") Submit submit, Model model, AVLTree tree, JSONObject bTree) {
        Submit listSubmit = new Submit();
//        submitRepository.insertWithEntityManager(new Submit(submit.getNumber1(), submit.getNumber2(),
//                submit.getNumber3(), submit.getNumber4(), submit.getNumber5(), submit.getNumber6(),
//                submit.getNumber7(), submit.getNumber8(), submit.getNumber9()));
        model.addAttribute("listSubmit", listSubmit);
        System.out.println("#######" + listSubmit);
        tree.insert(submit.getNumber1());
        tree.insert(submit.getNumber2());
        tree.insert(submit.getNumber3());
        tree.insert(submit.getNumber4());
        tree.insert(submit.getNumber5());
        tree.insert(submit.getNumber6());
        tree.insert(submit.getNumber7());
        tree.insert(submit.getNumber8());
        tree.insert(submit.getNumber9());
        tree.insert(submit.getNumber10());
        System.out.println(tree);
        bTree.put("tree", tree);
        System.out.println(bTree);
        return "results";
    }
}
