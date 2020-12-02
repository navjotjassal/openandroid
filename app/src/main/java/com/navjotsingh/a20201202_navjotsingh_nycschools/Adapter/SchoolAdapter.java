package com.navjotsingh.a20201202_navjotsingh_nycschools.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.navjotsingh.a20201202_navjotsingh_nycschools.Models.SchoolModel;
import com.navjotsingh.a20201202_navjotsingh_nycschools.Presenter.SchoolContract;
import com.navjotsingh.a20201202_navjotsingh_nycschools.R;

import java.util.List;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.CustomViewHolder> {

    private List<SchoolModel> dataList;
    private Context context;

    public SchoolAdapter(Context context, List<SchoolModel> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle, txtCity, txtZipcode;

        CustomViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_schoolnames);
            txtCity = itemView.findViewById(R.id.txt_cityname);
            txtZipcode = itemView.findViewById(R.id.txt_zipcode);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.school_inflate_layout, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.txtTitle.setText(dataList.get(position).getSchoolName());
        holder.txtCity.setText(dataList.get(position).getCity());
        holder.txtZipcode.setText(dataList.get(position).getZip());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (context instanceof SchoolContract.AddItemListener){
                    ((SchoolContract.AddItemListener) context).onClickListienr(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }
}