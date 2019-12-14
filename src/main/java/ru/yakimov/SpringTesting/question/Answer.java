/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.SpringTesting.question;

public class Answer{
    private int number;
    private String answer;
    private boolean isTrue;

    public Answer(int number, String answerName, boolean isTrue) {
        this.number = number;
        this.answer = answerName;
        this.isTrue = isTrue;
    }

    public int getNumber() {
        return number;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }

    public void printAnswer(){
        System.out.printf("%d) %s\n", number, answer);
    }
}
