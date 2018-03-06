package com.demo_expandable_list.pulkit.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.demo_expandable_list.pulkit.R;
import com.ms.square.android.expandabletextview.ExpandableTextView;

public class ExpandableTextViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_text_view);

        ExpandableTextView expTv1 = (ExpandableTextView) findViewById(R.id.expand_text_view);

        expTv1.setText(getString(R.string.dummy_text1));

    }
}
