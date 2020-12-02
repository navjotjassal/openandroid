package com.navjotsingh.a20201202_navjotsingh_nycschools.Presenter;

import com.navjotsingh.a20201202_navjotsingh_nycschools.Models.SchoolModel;

import java.util.List;

public class SchoolContract {

    public interface School {
        void onSchoolList(List<SchoolModel> schoolModelList);

        void onError();

        void onProgrss();
    }

    public interface AddItemListener {
        void onClickListienr(int position);
    }

    public interface SatScore {

        void onSatScore(String math, String reading, String writing);

        void onError();

        void onProgress();

        void onEmptyState();
    }
}
