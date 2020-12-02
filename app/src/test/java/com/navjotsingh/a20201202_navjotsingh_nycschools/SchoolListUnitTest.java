package com.navjotsingh.a20201202_navjotsingh_nycschools;

import com.google.gson.Gson;
import com.navjotsingh.a20201202_navjotsingh_nycschools.Models.Constants;
import com.navjotsingh.a20201202_navjotsingh_nycschools.Models.SatScoreModel;
import com.navjotsingh.a20201202_navjotsingh_nycschools.Models.SchoolModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SchoolListUnitTest {
   private SatScoreModel satScoreModel;
   private SchoolModel schoolModel;

    @Before
    public void setUp() throws Exception{
        satScoreModel = new Gson().fromJson(Constants.SAT_SCORE_JSON, SatScoreModel.class);
        schoolModel = new Gson().fromJson(Constants.SCHOOL_LIST_JSON, SchoolModel.class);
    }

    @Test
    public void satScoreTest() {
        Assert.assertEquals(satScoreModel.getDbn(),"01M292");
        Assert.assertEquals(satScoreModel.getSatCriticalReadingAvgScore(),"355");
        Assert.assertEquals(satScoreModel.getSatMathAvgScore(),"404");
        Assert.assertEquals(satScoreModel.getSatWritingAvgScore(),"363");
    }


    @Test
    public void schoolListTest() {
        Assert.assertEquals(schoolModel.getDbn(),"02M260");
        Assert.assertEquals(schoolModel.getCity(),"Manhattan");
        Assert.assertEquals(schoolModel.getSchoolName(),"Clinton School Writers & Artists, M.S. 260");
        Assert.assertEquals(schoolModel.getZip(),"10003");
    }

    @Test
    public void schoolListNullTest() {
        schoolModel = new SchoolModel();
        Assert.assertEquals(schoolModel.getDbn(),Constants.NA);
        Assert.assertEquals(schoolModel.getCity(),Constants.NA);
        Assert.assertEquals(schoolModel.getSchoolName(),Constants.NA);
        Assert.assertEquals(schoolModel.getZip(),Constants.NA);
    }

}
