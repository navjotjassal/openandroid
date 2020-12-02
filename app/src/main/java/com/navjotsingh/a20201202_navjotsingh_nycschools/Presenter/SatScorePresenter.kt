package com.navjotsingh.a20201202_navjotsingh_nycschools.Presenter

import com.navjotsingh.a20201202_navjotsingh_nycschools.Models.SatScoreModel
import com.navjotsingh.a20201202_navjotsingh_nycschools.Network.GetDataService
import com.navjotsingh.a20201202_navjotsingh_nycschools.Network.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SatScorePresenter(private var satScore: SchoolContract.SatScore, private var dbn : String?) {
    internal lateinit var getmath: String
    internal lateinit var getreading:String
    internal lateinit var getwriting:String
    internal var value: Boolean = false

    // Service call to get all the Sat Score
    fun getSatScores() {
        val service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService::class.java)
        val call = service.getAllSAT()
        call.enqueue(object : Callback<List<SatScoreModel>> {
            override fun onResponse(call: Call<List<SatScoreModel>>, response: Response<List<SatScoreModel>>) {
                setdata(response.body()!!)
            }

            override fun onFailure(call: Call<List<SatScoreModel>>, t: Throwable) {
                satScore.onProgress()
                satScore.onError()
            }
        })
    }

    // Filter the list based on DBN id
    private fun setdata(body: List<SatScoreModel>) {
        for (i in body.indices) {
            if (body[i].getDbn().equals(dbn)) {
                value = true
                getmath = body[i].getSatMathAvgScore()
                getreading = body[i].getSatCriticalReadingAvgScore()
                getwriting = body[i].getSatWritingAvgScore()
                break
            } else {
                value = false
            }
        }
        if (value) {
            satScore.onProgress()
            satScore.onSatScore(getmath, getreading, getwriting)
        } else {
            satScore.onProgress()
            satScore.onEmptyState()
        }
    }
}