package com.demo_expandable_list.pulkit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.demo_expandable_list.pulkit.activities.AnimatedExpandableListViewActivity;
import com.demo_expandable_list.pulkit.activities.ExpandableListViewActivity;
import com.demo_expandable_list.pulkit.activities.ExpandableTextViewActivity;
import com.ms.square.android.expandabletextview.ExpandableTextView;

public class MainActivity extends AppCompatActivity {

    private Button btn_expandable_text_view, btn_expandable_list_view, btn_animated_expandable_list_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findIds();
        init();

    }

    private void findIds() {

        btn_expandable_text_view = (Button) findViewById(R.id.btn_expandable_text_view);
        btn_expandable_list_view = (Button) findViewById(R.id.btn_expandable_list_view);
        btn_animated_expandable_list_view = findViewById(R.id.btn_animated_expandable_list_view);

    }

    private void init() {

        btn_expandable_text_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ExpandableTextViewActivity.class);
                startActivity(intent);
            }
        });

        btn_expandable_list_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ExpandableListViewActivity.class);
                startActivity(intent);
            }
        });

        btn_animated_expandable_list_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AnimatedExpandableListViewActivity.class);
                startActivity(intent);
            }
        });
    }


}
