package com.profile.rohail.rohailprofile.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.profile.rohail.rohailprofile.R;
import com.profile.rohail.rohailprofile.interfaces.IOnItemClickCustomListner;
import com.profile.rohail.rohailprofile.models.ProfileModel;
import com.profile.rohail.rohailprofile.models.WorkHistoryModel;

import java.util.ArrayList;

/**
 * Created by Rohail on 6/17/2017.
 */

public class WorkHistoryAdapter extends RecyclerView.Adapter<WorkHistoryAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<WorkHistoryModel> workHistoryList;
    private IOnItemClickCustomListner iOnItemClickCustomListner;

    public WorkHistoryAdapter(Context context, ArrayList<WorkHistoryModel> list, IOnItemClickCustomListner listner) {
        this.context = context;
        this.workHistoryList = list;
        iOnItemClickCustomListner = listner;
    }

    @Override
    public int getItemCount() {
        return workHistoryList.size();
    }

    @Override
    public void onBindViewHolder(WorkHistoryAdapter.MyViewHolder holder, final int position) {

        holder.tvTitle.setText(workHistoryList.get(position).getTitle());
        holder.tvDescription.setText(workHistoryList.get(position).getDescription());
        holder.tvDescription.setSelected(true);
        holder.tvLocationDate.setText(workHistoryList.get(position).getLocationDate());
        holder.tvLocationDate.setSelected(true);
        holder.ivIcon.setImageResource(workHistoryList.get(position).getIcon());

        holder.llMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iOnItemClickCustomListner.onItemClicked(view, position);
            }
        });


    }


    @Override
    public WorkHistoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_image, parent, false);
        return new WorkHistoryAdapter.MyViewHolder(itemView);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle;
        public TextView tvDescription;
        public TextView tvLocationDate;
        public ImageView ivIcon;
        public CardView llMain;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvDescription = (TextView) itemView.findViewById(R.id.tv_description);
            tvLocationDate = (TextView) itemView.findViewById(R.id.tv_location_date);
            ivIcon = (ImageView) itemView.findViewById(R.id.iv_icon);
            llMain = (CardView) itemView.findViewById(R.id.cv_profile);
        }
    }

}
