package com.navjotsingh.a20201202_navjotsingh_nycschools.Models;

import android.app.ProgressDialog;
import android.content.Context;

public class Constants {
    public static final String DBN_ID = "dbn";
    public static final String SCHOOL_NAME = "schoolname";
    private static final String PROGRESS_DIALOG_LOADING_MESSAGE = "Loading....";
    public static final String ALERTDIALOG_MESSAGE = "No Data Found Related to this School or University";
    public static final String SCHOOL_TITLE = "Schools List";
    public static final String NA = "N/A";
    public static final String SAT_SCORE_JSON = "{\"dbn\":\"01M292\",\"school_name\":\"HENRY STREET SCHOOL FOR INTERNATIONAL STUDIES\",\"num_of_sat_test_takers\":\"29\",\"sat_critical_reading_avg_score\":\"355\",\"sat_math_avg_score\":\"404\",\"sat_writing_avg_score\":\"363\"}";
   public static final String SCHOOL_LIST_JSON = "{\"dbn\":\"02M260\",\"school_name\":\"Clinton School Writers & Artists, M.S. 260\",\"city\":\"Manhattan\",\"zip\":\"10003\",\"state_code\":\"NY\"}";
    private static ProgressDialog progressDoalog;

    public static void loadProgressDialog(Context context){
        progressDoalog = new ProgressDialog(context);
        progressDoalog.setMessage(Constants.PROGRESS_DIALOG_LOADING_MESSAGE);
        progressDoalog.show();
    }

    public static void dismissProgressDialog(){
        progressDoalog.dismiss();
    }
}
