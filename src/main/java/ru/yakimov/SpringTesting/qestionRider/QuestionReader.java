/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.SpringTesting.qestionRider;

import ru.yakimov.SpringTesting.question.Questioner;

import java.io.IOException;
import java.util.List;

public interface QuestionReader {
    List<Questioner> readCsvQuestions() throws IOException;
}
