/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.SpringTesting.qestionRider;

import org.springframework.stereotype.Service;
import ru.yakimov.SpringTesting.prop.QuestionProp;
import ru.yakimov.SpringTesting.question.Question;
import ru.yakimov.SpringTesting.question.Questioner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionReaderImpl implements QuestionReader {
    private String url;

    public QuestionReaderImpl(QuestionProp questionProp) {
        this.url = questionProp.getFileUrl();
    }

    //    ---question---,---trueAns---,---falseAns1---,---falseAns2---,---falseAns3---
    @Override
    public List<Questioner> readCsvQuestions() throws IOException {
        return Files.readAllLines(Paths.get(url))
                .stream()
                .filter(v -> !v.startsWith("---,"))
                .map(Question::new)
                .collect(Collectors.toList());
    }
}
