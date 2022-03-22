package com.devprotocols.sendecard.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import com.devprotocols.sendecard.R
import com.devprotocols.sendecard.adapters.SpinnerAdapter
import com.devprotocols.sendecard.databinding.ActivityWelcomeBinding
import com.devprotocols.sendecard.models.SpinnerModel

class WelcomeActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var spinnerAdapter: SpinnerAdapter
    private lateinit var binding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        initViews()
        initClickListeners()
        binding.spinner.onItemSelectedListener = this

    }

    private fun initClickListeners() {
        binding.txtSignIn.setOnClickListener{
            startActivity(Intent(this@WelcomeActivity, LoginActivity::class.java))
        }
    }

    private fun initViews() {
        val arrayList = ArrayList<SpinnerModel>()
        arrayList.add(SpinnerModel("Pakistan", R.drawable.ic_pakistan))
        arrayList.add(SpinnerModel("Philippines", R.drawable.ic_philippines))
        spinnerAdapter = SpinnerAdapter(this, arrayList)
        binding.spinner.adapter = spinnerAdapter
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }
}