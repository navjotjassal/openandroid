package com.navjotsingh.a20201202_navjotsingh_nycschools.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.navjotsingh.a20201202_navjotsingh_nycschools.Adapter.SchoolAdapter;
import com.navjotsingh.a20201202_navjotsingh_nycschools.Models.Constants;
import com.navjotsingh.a20201202_navjotsingh_nycschools.Models.SchoolModel;
import com.navjotsingh.a20201202_navjotsingh_nycschools.Presenter.SchoolContract;
import com.navjotsingh.a20201202_navjotsingh_nycschools.Presenter.SchoolListPresenter;
import com.navjotsingh.a20201202_navjotsingh_nycschools.R;

import java.util.ArrayList;
import java.util.List;

public class SchoolsListActivity extends AppCompatActivity implements SchoolContract.School, SchoolContract.AddItemListener {
    private RecyclerView recyclerView;
    SchoolListPresenter schoolListPresenter;
    List<SchoolModel> getschoolModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schools_list);
        setTitle(Constants.SCHOOL_TITLE);
        init();
    }

    private void init() {
        recyclerView = findViewById(R.id.recyclerview_school_list);
        Constants.loadProgressDialog(this);
        schoolListPresenter = new SchoolListPresenter(this);
        schoolListPresenter.getSchoolList();
        getschoolModelList = new ArrayList<>();
    }

    @Override
    public void onSchoolList(List<SchoolModel> schoolModelList) {
        getschoolModelList = schoolModelList;
        SchoolAdapter adapter = new SchoolAdapter(this, schoolModelList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SchoolsListActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onError() {
        Constants.dismissProgressDialog();
        Toast.makeText(SchoolsListActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProgrss() {
        Constants.dismissProgressDialog();
    }

    @Override
    public void onClickListienr(int position) {
        Intent intent = new Intent(this, SatScoreActivity.class);
        intent.putExtra(Constants.DBN_ID, getschoolModelList.get(position).getDbn());
        intent.putExtra(Constants.SCHOOL_NAME, getschoolModelList.get(position).getSchoolName());
        startActivity(intent);
    }
}
