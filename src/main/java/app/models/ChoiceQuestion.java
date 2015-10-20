package app.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by cjl20 on 2015/10/20.
 */

@Table(name = "choicequestion")
@Entity
public class ChoiceQuestion implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    private String question;
    private String choicea;
    private String choiceb;
    private String choicec;
    private String choiced;
    private String answer;
    private int point;
    private int type;

    protected ChoiceQuestion(){

    }

    public ChoiceQuestion(String question, String choicea, String choiceb, String choicec, String choiced, String answer, int point, int type) {
        this.question = question;
        this.choicea = choicea;
        this.choiceb = choiceb;
        this.choicec = choicec;
        this.choiced = choiced;
        this.answer = answer;
        this.point = point;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoicea() {
        return choicea;
    }

    public void setChoicea(String choicea) {
        this.choicea = choicea;
    }

    public String getChoiceb() {
        return choiceb;
    }

    public void setChoiceb(String choiceb) {
        this.choiceb = choiceb;
    }

    public String getChoicec() {
        return choicec;
    }

    public void setChoicec(String choicec) {
        this.choicec = choicec;
    }

    public String getChoiced() {
        return choiced;
    }

    public void setChoiced(String choiced) {
        this.choiced = choiced;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ChoiceQuestion{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", choicea='" + choicea + '\'' +
                ", choiceb='" + choiceb + '\'' +
                ", choicec='" + choicec + '\'' +
                ", choiced='" + choiced + '\'' +
                ", answer='" + answer + '\'' +
                ", point=" + point +
                ", type=" + type +
                '}';
    }
}
