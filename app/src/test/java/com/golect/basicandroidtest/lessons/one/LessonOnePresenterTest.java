package com.golect.basicandroidtest.lessons.one;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LessonOnePresenterTest {

    private LessonOneView lessonOneView;
    private LessonOnePresenter presenter;

    @Before
    public void setUp() throws Exception {
        lessonOneView = mock(LessonOneView.class);
        presenter = new LessonOnePresenter(lessonOneView);
    }

    @Test
    public void testInputShouldBeEvenNumber() throws Exception {
        final int number = 4;
        final boolean isEvenNumber = presenter.isEvenNumber(number);
        assertTrue(isEvenNumber);
    }

    @Test
    public void testInputShouldBeOddNumber() throws Exception {
        final int number = 3;
        final boolean isOddNumber = presenter.isOddNumber(number);
        assertTrue(isOddNumber);
    }

    @Test
    public void testProcessNumberShouldTriggerEvenMessage() throws Exception {
        presenter.processNumber("4");
        verify(lessonOneView).showEvenNumberMessage();
    }

    @Test
    public void testProcessNumberShouldTriggerOddMessage() throws Exception {
        presenter.processNumber("3");
        verify(lessonOneView).showOddNumberMessage();
    }

    @Test
    public void testProcessNumberShouldTriggerErrorMessage() throws Exception {
        presenter.processNumber("qwerty");
        verify(lessonOneView).showConvertNumberError();
    }
}