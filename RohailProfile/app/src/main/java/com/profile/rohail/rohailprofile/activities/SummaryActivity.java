package com.profile.rohail.rohailprofile.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.profile.rohail.rohailprofile.R;

public class SummaryActivity extends AppCompatActivity {

    private TextView tvTitle;
    private TextView tvDescription;
    private String title;
    private String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_summary);

        fetchIntents();
        initView();
    }

    private void fetchIntents() {
        title = (String) getIntent().getExtras().get(getString(R.string.intent_title));
        description = (String) getIntent().getExtras().get(getString(R.string.intent_description));
    }

    private void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvDescription = (TextView) findViewById(R.id.tv_description);
        tvTitle.setText(title);
        tvDescription.setText(description);
    }
}
