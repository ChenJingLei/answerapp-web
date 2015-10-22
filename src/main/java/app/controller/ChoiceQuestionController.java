package app.controller;

import app.models.ChoiceQuestion;
import app.repositories.ChoiceQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by cjl20 on 2015/10/20.
 */

@Controller
public class ChoiceQuestionController {

    public static final String CHOICEQUESTION = "choicequestion";
    private final ChoiceQuestionRepository repository;

    @Autowired
    public ChoiceQuestionController(ChoiceQuestionRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/ChoiceQuestion", method = RequestMethod.GET)
    public String ChoiceQuestion(@RequestParam(value = "id", required = false, defaultValue = "0") String id, Model model) {
        ChoiceQuestion choiceQuestion = repository.findById(1L);
        System.out.println(choiceQuestion.getQuestion());
        model.addAttribute(CHOICEQUESTION, choiceQuestion);
        return "views/answerPage";
    }

}
