package com.navjotsingh.a20201202_navjotsingh_nycschools.Models;

import com.google.gson.annotations.SerializedName;

public class SchoolModel {
    @SerializedName("dbn")
    private String dbn;
    @SerializedName("school_name")
    private String schoolName;
    @SerializedName("city")
    private String city_;
    @SerializedName("zip")
    private String zip_;

    public String getCity() {
        if (city_ != null) {
            return city_;
        } else {
            return Constants.NA;
        }
    }

    public String getZip() {
        if (zip_ != null) {
            return zip_;
        } else {
            return Constants.NA;
        }
    }

    public String getDbn() {
        if (dbn != null) {
            return dbn;
        } else {
            return Constants.NA;
        }
    }

    public String getSchoolName() {
        if (schoolName != null) {
            return schoolName;
        } else {
            return Constants.NA;
        }
    }
}
