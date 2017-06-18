package com.profile.rohail.rohailprofile.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.profile.rohail.rohailprofile.R;
import com.profile.rohail.rohailprofile.interfaces.IOnItemClickCustomListner;
import com.profile.rohail.rohailprofile.models.ProfileModel;

import java.util.ArrayList;

/**
 * Created by Rohail on 6/16/2017.
 */

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<ProfileModel> profileList;
    private IOnItemClickCustomListner iOnItemClickCustomListner;

    public ProfileAdapter(Context context, ArrayList<ProfileModel> list, IOnItemClickCustomListner listner) {
        this.context = context;
        this.profileList = list;
        iOnItemClickCustomListner = listner;
    }

    @Override
    public int getItemCount() {
        return profileList.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tvTitle.setText(profileList.get(position).getTitle());

        holder.llMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iOnItemClickCustomListner.onItemClicked(view, position);
            }
        });


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_profile, parent, false);
        return new MyViewHolder(itemView);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle;
        public CardView llMain;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_heading);
            llMain = (CardView) itemView.findViewById(R.id.cv_profile);
        }
    }
}
