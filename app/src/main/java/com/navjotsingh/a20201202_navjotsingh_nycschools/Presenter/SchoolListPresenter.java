package com.navjotsingh.a20201202_navjotsingh_nycschools.Presenter;

import com.navjotsingh.a20201202_navjotsingh_nycschools.Models.SchoolModel;
import com.navjotsingh.a20201202_navjotsingh_nycschools.Network.GetDataService;
import com.navjotsingh.a20201202_navjotsingh_nycschools.Network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SchoolListPresenter {
    private SchoolContract.School school;

    public SchoolListPresenter(SchoolContract.School school) {
        this.school = school;
    }

    // service call to get all the School list
    public void getSchoolList() {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<SchoolModel>> call = service.getAllSchools();
        call.enqueue(new Callback<List<SchoolModel>>() {
            @Override
            public void onResponse(Call<List<SchoolModel>> call, Response<List<SchoolModel>> response) {
                school.onProgrss();
                school.onSchoolList(response.body());
            }

            @Override
            public void onFailure(Call<List<SchoolModel>> call, Throwable t) {
                school.onProgrss();
                school.onError();
            }
        });
    }
}