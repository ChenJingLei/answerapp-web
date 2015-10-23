package app.controller;

import app.models.AnsRecord;
import app.models.ChoiceQuestion;
import app.repositories.AnsRecordRepository;
import app.repositories.ChoiceQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by cjl20 on 2015/10/20.
 */

@Controller
public class ChoiceQuestionController {

    public static final String QUESTIONNUM = "questionnum";
    public static final String CHOICEQUESTION = "choicequestion";

    private final ChoiceQuestionRepository choiceQuestionRepository;
    private final AnsRecordRepository ansRecordRepository;

    @Autowired
    public ChoiceQuestionController(ChoiceQuestionRepository choiceQuestionRepository, AnsRecordRepository ansRecordRepository) {
        this.choiceQuestionRepository = choiceQuestionRepository;
        this.ansRecordRepository = ansRecordRepository;
    }

    @RequestMapping(value = "/ChoiceQuestion", method = RequestMethod.GET)
    public String ChoiceQuestion(@RequestParam(value = "id", required = true, defaultValue = "1") String id, Model model) {
        model.addAttribute(QUESTIONNUM, choiceQuestionRepository.count());
        model.addAttribute(CHOICEQUESTION, choiceQuestionRepository.findById(Long.valueOf(id)));
        return "views/answerPage";
    }

    @RequestMapping(value = "/RecordAndRead", method = RequestMethod.GET)
    public String RecordAndRead(HttpServletRequest request, Model model) {
        Map<String, String[]> params = request.getParameterMap();
        Set<String> keys = params.keySet();
        HashMap<String, String> map = new HashMap<>();
        for (String key : keys) {
            Long qid = Long.valueOf(key);
            String uanswer = params.get(key)[0];
            String answer = choiceQuestionRepository.findOne(qid).getAnswer();
            int judge = (answer.equals(uanswer)) ? 1 : 0;
            ansRecordRepository.save(new AnsRecord(qid, 1L, uanswer, new Timestamp(new java.util.Date().getTime()), judge));
            map.put("r" + key, (judge == 1) ? "right" : "wrong");
        }
        model.addAllAttributes(map);
        model.addAttribute("QuestionNum", keys.size());
        return "views/result";
    }
}
