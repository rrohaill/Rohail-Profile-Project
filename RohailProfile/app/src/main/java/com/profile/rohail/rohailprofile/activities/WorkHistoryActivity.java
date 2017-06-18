package com.profile.rohail.rohailprofile.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.profile.rohail.rohailprofile.R;
import com.profile.rohail.rohailprofile.adapters.ProfileAdapter;
import com.profile.rohail.rohailprofile.adapters.WorkHistoryAdapter;
import com.profile.rohail.rohailprofile.interfaces.IOnItemClickCustomListner;
import com.profile.rohail.rohailprofile.models.ProfileModel;
import com.profile.rohail.rohailprofile.models.WorkHistoryModel;

import java.util.ArrayList;

public class WorkHistoryActivity extends AppCompatActivity implements IOnItemClickCustomListner {

    private RecyclerView recyclerView;
    private WorkHistoryAdapter workHistoryAdapter;
    private ArrayList<WorkHistoryModel> workHistoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_history);

        initData();
        initView();
    }

    private void initData() {
        workHistoryList = new ArrayList<>();

        WorkHistoryModel workHistoryModel = new WorkHistoryModel();
        workHistoryModel.setTitle(getString(R.string.inov8_title));
        workHistoryModel.setLocationDate(getString(R.string.inov8_location_date));
        workHistoryModel.setDescription(getString(R.string.software_title));
        workHistoryModel.setIcon(R.drawable.inov);

        workHistoryList.add(workHistoryModel);
    }

    /*
    initializing views
     */
    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_work_history);
        workHistoryAdapter = new WorkHistoryAdapter(this, workHistoryList, this);
        recyclerView.setAdapter(workHistoryAdapter);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        recyclerView.setItemAnimator(itemAnimator);

    }

    @Override
    public void onItemClicked(View view, int position) {
        Intent intent = new Intent(WorkHistoryActivity.this, SummaryActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString(getString(R.string.intent_title), getString(R.string.inov8_title));
        bundle.putString(getString(R.string.intent_description), getString(R.string.inov8_description));

        intent.putExtras(bundle);
        startActivity(intent);
    }
}
