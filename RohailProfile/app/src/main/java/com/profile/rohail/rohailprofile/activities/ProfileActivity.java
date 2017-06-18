package com.profile.rohail.rohailprofile.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.Toast;

import com.profile.rohail.rohailprofile.R;
import com.profile.rohail.rohailprofile.adapters.ProfileAdapter;
import com.profile.rohail.rohailprofile.interfaces.IOnItemClickCustomListner;
import com.profile.rohail.rohailprofile.models.ProfileModel;
import com.profile.rohail.rohailprofile.models.WorkEducationModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProfileActivity extends AppCompatActivity implements IOnItemClickCustomListner {

    private RecyclerView recyclerView;
    private ProfileAdapter profileAdapter;
    private ArrayList<ProfileModel> profileList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initProfileData();
        initView();
    }

    /*
    initializing profile data
     */
    private void initProfileData() {
        profileList = new ArrayList<>();
        profileList.add(new ProfileModel("Profile Summary", 1));
        profileList.add(new ProfileModel("Skills Summary", 2));
        profileList.add(new ProfileModel("Employment History", 3));
        profileList.add(new ProfileModel("Education", 4));
        profileList.add(new ProfileModel("Projects", 5));
        profileList.add(new ProfileModel("Interests", 6));
        profileList.add(new ProfileModel("Contact Details", 7));
        profileList.add(new ProfileModel("Location Espeo", 8));
    }

    /*
    initializing views
     */
    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_profile);
        profileAdapter = new ProfileAdapter(this, profileList, this);
        recyclerView.setAdapter(profileAdapter);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        recyclerView.setItemAnimator(itemAnimator);

    }

    @Override
    public void onItemClicked(View view, int position) {

        int id = profileList.get(position).getId();

        Bundle bundle = null;

        switch (id) {
            case 1:
                bundle = new Bundle();
                bundle.putString(getString(R.string.intent_title), getString(R.string.profile_summary_title));
                bundle.putString(getString(R.string.intent_description), getString(R.string.profile_summary_text));
                newActivity(SummaryActivity.class, bundle);
                break;
            case 2:
                bundle = new Bundle();
                bundle.putString(getString(R.string.intent_title), getString(R.string.skills_summary_title));
                bundle.putString(getString(R.string.intent_description), getString(R.string.skills_summary_text));
                newActivity(SummaryActivity.class, bundle);
                break;
            case 3:
                setWorkHistoryData();
                break;
            case 4:
                setEducationData();
                break;
            case 5:
                bundle = new Bundle();
                bundle.putString(getString(R.string.intent_title), getString(R.string.projects_title));
                bundle.putString(getString(R.string.intent_description), getString(R.string.projects_description));
                newActivity(SummaryActivity.class, bundle);
                break;
            case 6:
                bundle = new Bundle();
                bundle.putString(getString(R.string.intent_title), getString(R.string.interest_title));
                bundle.putString(getString(R.string.intent_description), getString(R.string.interest_description));
                newActivity(SummaryActivity.class, bundle);
                break;
            case 7:
                newActivity(ContactActivity.class, null);
                break;
            case 8:
                openGoogleMap();
                break;
            default:
                break;
        }

    }

    private void setEducationData() {

        ArrayList<WorkEducationModel> educationList = new ArrayList<>();

        //Post graduate
        WorkEducationModel workEducationModel = new WorkEducationModel();
        workEducationModel.setTitle(getString(R.string.put));
        workEducationModel.setLocationDate(getString(R.string.poznan_title));
        workEducationModel.setDescription(getString(R.string.degree_title));
        workEducationModel.setIcon(R.drawable.edu_icon);
        educationList.add(workEducationModel);

        //graduate
        workEducationModel = new WorkEducationModel();
        workEducationModel.setTitle(getString(R.string.ucp_title));
        workEducationModel.setLocationDate(getString(R.string.lhr_title));
        workEducationModel.setDescription(getString(R.string.bscs_title));
        workEducationModel.setIcon(R.drawable.edu_icon);
        educationList.add(workEducationModel);

        //college
        workEducationModel = new WorkEducationModel();
        workEducationModel.setTitle(getString(R.string.pgc_title));
        workEducationModel.setLocationDate(getString(R.string.fsd_title));
        workEducationModel.setDescription(getString(R.string.fsc));
        workEducationModel.setIcon(R.drawable.edu_icon);
        educationList.add(workEducationModel);

        //school
        workEducationModel = new WorkEducationModel();
        workEducationModel.setTitle(getString(R.string.sps_title));
        workEducationModel.setLocationDate(getString(R.string.fsd_school_title));
        workEducationModel.setDescription(getString(R.string.matric_title));
        workEducationModel.setIcon(R.drawable.edu_icon);
        educationList.add(workEducationModel);

        Bundle bundle = new Bundle();
        bundle.putSerializable(getString(R.string.intent_serializable), educationList);
        bundle.putBoolean(getString(R.string.intent_boolean), false);
        bundle.putString(getString(R.string.intent_string), getString(R.string.education_title));
        newActivity(WorkHistoryActivity.class, bundle);

    }

    private void setWorkHistoryData() {

        ArrayList<WorkEducationModel> workHistoryList = new ArrayList<>();

        WorkEducationModel workEducationModel = new WorkEducationModel();
        workEducationModel.setTitle(getString(R.string.inov8_title));
        workEducationModel.setLocationDate(getString(R.string.inov8_location_date));
        workEducationModel.setDescription(getString(R.string.software_title));
        workEducationModel.setIcon(R.drawable.inov);

        workHistoryList.add(workEducationModel);
        Bundle bundle = new Bundle();
        bundle.putSerializable(getString(R.string.intent_serializable), workHistoryList);
        bundle.putBoolean(getString(R.string.intent_boolean), true);
        bundle.putString(getString(R.string.intent_string), getString(R.string.work_history));
        newActivity(WorkHistoryActivity.class, bundle);
    }

    private void newActivity(Class newClass, Bundle bundle) {
        Intent intent = new Intent(ProfileActivity.this, newClass);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }


    private void openGoogleMap() {

        // Espeo Software lat and lng location
        String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?daddr=%s,%s (%s)",
                "52.408753", "16.934309", "Espeo Software");
        Intent mapsIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));

        //open google maps
        mapsIntent.setClassName("com.google.android.apps.maps",
                "com.google.android.maps.MapsActivity");

        if (mapsIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapsIntent);
        } else {
            Toast.makeText(ProfileActivity.this,
                    "There is some error opening Google Map. Try again...",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
