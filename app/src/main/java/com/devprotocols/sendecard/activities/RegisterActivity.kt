package com.devprotocols.sendecard.activities

import android.os.Bundle
import android.view.WindowManager
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.devprotocols.sendecard.R
import com.devprotocols.sendecard.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        initViews()
        initClickListener()
    }

    private fun initViews() {
        val countryAdapter = ArrayAdapter.createFromResource(
            this@RegisterActivity,
            R.array.country_list,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerCountry.adapter = adapter
        }
        val industryAdapter = ArrayAdapter.createFromResource(
            this@RegisterActivity,
            R.array.industry_list,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerCategory.adapter = adapter
        }
    }

    private fun initClickListener() {
        binding.txtBack.setOnClickListener{
            onBackPressed()
        }

    }
}