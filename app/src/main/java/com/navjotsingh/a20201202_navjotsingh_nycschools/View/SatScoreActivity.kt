package com.navjotsingh.a20201202_navjotsingh_nycschools.View

import android.app.AlertDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.navjotsingh.a20201202_navjotsingh_nycschools.Models.Constants
import com.navjotsingh.a20201202_navjotsingh_nycschools.Presenter.SatScorePresenter
import com.navjotsingh.a20201202_navjotsingh_nycschools.Presenter.SchoolContract
import com.navjotsingh.a20201202_navjotsingh_nycschools.R
import kotlinx.android.synthetic.main.activity_sat_score.*

class SatScoreActivity : AppCompatActivity(), SchoolContract.SatScore {

    internal var dbnId: String? = null
    internal var schoolName: String? = null
    var satScorePresenter: SatScorePresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sat_score)
        // get Intent data after click on school
        dbnId = intent.getStringExtra(Constants.DBN_ID)
        schoolName = intent.getStringExtra(Constants.SCHOOL_NAME)
        setTitle(schoolName)
        init()
    }

    private fun init() {
        satScorePresenter = SatScorePresenter(this, dbnId)
        satScorePresenter!!.getSatScores()
    }

    // setting a data to the view
    override fun onSatScore(math: String?, reading: String?, writing: String?) {
        txt_math.text = "Math: " + math
        txt_reading.text = "Reading: " + reading
        txt_writing.text = "Writing: " + writing
    }

    // Show Dialog if selected school dont have any details
    override fun onEmptyState() {
        setDialog()
    }

    override fun onError() {
        Constants.dismissProgressDialog()
        Toast.makeText(this@SatScoreActivity, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show()
    }

    override fun onProgress() {
        Constants.dismissProgressDialog()
    }


    private fun setDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(Constants.ALERTDIALOG_MESSAGE).setCancelable(false).setPositiveButton("OK") { dialog, id -> finish() }
        val alert = builder.create()
        alert.show()
    }
}
