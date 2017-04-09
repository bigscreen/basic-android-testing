package com.golect.basicandroidtest.lessons.one;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.golect.basicandroidtest.BaseActivity;
import com.golect.basicandroidtest.R;

public class LessonOneActivity extends BaseActivity implements LessonOneView {

    private EditText inputNumber;
    private TextView textMessage;

    private LessonOnePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_one);
        showBackButton();

        inputNumber = (EditText) findViewById(R.id.input_number);
        textMessage = (TextView) findViewById(R.id.text_message);

        presenter = new LessonOnePresenter(this);
    }

    public void buttonCheckClick(View view) {
        String numberFromInput = inputNumber.getText().toString();
        presenter.processNumber(numberFromInput);
    }

    @Override
    public void showEvenNumberMessage() {
        textMessage.setVisibility(View.VISIBLE);
        textMessage.setTextColor(ContextCompat.getColor(this, R.color.textEvenColor));
        textMessage.setText("You enter an even number.");
    }

    @Override
    public void showOddNumberMessage() {
        textMessage.setVisibility(View.VISIBLE);
        textMessage.setTextColor(ContextCompat.getColor(this, R.color.textOddColor));
        textMessage.setText("You enter an odd number.");
    }

    @Override
    public void showConvertNumberError() {
        textMessage.setVisibility(View.VISIBLE);
        textMessage.setTextColor(ContextCompat.getColor(this, R.color.textRed));
        textMessage.setText("Please input decimal number.");
    }
}
