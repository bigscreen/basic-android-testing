package com.golect.basicandroidtest.lessons.one;


public class LessonOnePresenter {

    private final LessonOneView view;

    public LessonOnePresenter(LessonOneView view) {
        this.view = view;
    }

    public void processNumber(String numberFromInput) {
        try {
            int number = Integer.parseInt(numberFromInput);
            if (isEvenNumber(number)) {
                view.showEvenNumberMessage();
            } else if (isOddNumber(number)) {
                view.showOddNumberMessage();
            }
        } catch (NumberFormatException e) {
            view.showConvertNumberError();
        }
    }

    public boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }

    public boolean isOddNumber(int number) {
        return number % 2 == 1;
    }
}
