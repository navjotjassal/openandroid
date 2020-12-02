package com.navjotsingh.a20201202_navjotsingh_nycschools.Network;

import com.navjotsingh.a20201202_navjotsingh_nycschools.Models.SatScoreModel;
import com.navjotsingh.a20201202_navjotsingh_nycschools.Models.SchoolModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    // School list Data
    @GET("s3k6-pzi2.json")
    Call<List<SchoolModel>> getAllSchools();

    // Sat Score Data
    @GET("f9bf-2cp4.json")
    Call<List<SatScoreModel>> getAllSAT();
}
