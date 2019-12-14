/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.SpringTesting.tester;

import org.springframework.stereotype.Service;
import ru.yakimov.SpringTesting.qestionRider.QuestionReader;
import ru.yakimov.SpringTesting.question.Questioner;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Service
public class Test {
    private int trueAnswers = 0;
    private List<Questioner> questions;



    private String name;
    private String surname;

    public Test(QuestionReader questionReader) throws IOException {
        questions = questionReader.readCsvQuestions();
    }

    public void testing(){
        Scanner in = new Scanner(System.in);
        System.out.print("Name: " );
        name = in.nextLine();
        System.out.print("\nSurname: ");
        surname = in.nextLine();

        for (Questioner question : questions) {
            if(ask(question, in))
                trueAnswers++;
        }
        System.out.printf("Results %s %s is %d\n",name,surname,trueAnswers);
        in.close();
    }

    public boolean ask(Questioner question, Scanner in){
        question.askQuestion();
        int atv = in.nextInt();
        return question.isTrue(atv);
    }
}
