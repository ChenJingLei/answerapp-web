package app.repositories;

import app.models.ChoiceQuestion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by cjl20 on 2015/10/20.
 */
public interface ChoiceQuestionRepository extends CrudRepository<ChoiceQuestion, Long> {

    ChoiceQuestion findById(@Param("id") Long id);

}
