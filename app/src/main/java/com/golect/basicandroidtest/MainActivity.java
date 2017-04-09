package com.golect.basicandroidtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.golect.basicandroidtest.lessons.one.LessonOneActivity;
import com.golect.basicandroidtest.lessons.two.LessonTwoActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lessonMenuClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.text_lesson_one:
                intent = new Intent(MainActivity.this, LessonOneActivity.class);
                break;
            case R.id.text_lesson_two:
                intent = new Intent(MainActivity.this, LessonTwoActivity.class);
                break;
        }
        goToActivity(intent);
    }

    private void goToActivity(Intent intent) {
        if (intent == null) return;
        startActivity(intent);
    }
}
