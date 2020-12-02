package com.navjotsingh.a20201202_navjotsingh_nycschools.Models;

import com.google.gson.annotations.SerializedName;

public class SatScoreModel {

    @SerializedName("dbn")
    private String dbn;

    @SerializedName("school_name")
    private String schoolName;

    @SerializedName("num_of_sat_test_takers")
    private String numOfSatTestTakers;

    @SerializedName("sat_critical_reading_avg_score")
    private String satCriticalReadingAvgScore;

    @SerializedName("sat_math_avg_score")
    private String satMathAvgScore;

    @SerializedName("sat_writing_avg_score")
    private String satWritingAvgScore;

    public String getDbn() {
        return dbn;
    }

    public String getSatCriticalReadingAvgScore() {
        return satCriticalReadingAvgScore;
    }

    public String getSatMathAvgScore() {
        return satMathAvgScore;
    }

    public String getSatWritingAvgScore() {
        return satWritingAvgScore;
    }
}
