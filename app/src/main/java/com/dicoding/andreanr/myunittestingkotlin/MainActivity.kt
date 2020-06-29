package com.dicoding.andreanr.myunittestingkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dicoding.andreanr.myunittestingkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    companion object {
        val FIELD_NOT_NULL = "Field ini tidak boleh kosong!"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mainViewModel = MainViewModel(CuboidModel())

        binding.btnSave.setOnClickListener(this)
        binding.btnCalculateVolume.setOnClickListener(this)
        binding.btnCalculateCircumference.setOnClickListener(this)
        binding.btnCalculateSurfaceArea.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val length = binding.edtLength.text?.trim().toString()
        val width = binding.edtWidth.text?.trim().toString()
        val height = binding.edtHeight.text?.trim().toString()

        when {
            length.isEmpty() -> FIELD_NOT_NULL
            width.isEmpty() -> FIELD_NOT_NULL
            height.isEmpty() -> FIELD_NOT_NULL
            else -> {
                val l = length.toDouble()
                val w = width.toDouble()
                val h = height.toDouble()

                when(v?.id) {
                    R.id.btn_save -> {
                        mainViewModel.save(l, w, h)
                        visible()
                    }
                    R.id.btn_calculate_volume -> {
                        binding.tvResult.text = mainViewModel.getVolume().toString()
                        gone()
                    }
                    R.id.btn_calculate_circumference -> {
                        binding.tvResult.text = mainViewModel.getCircumference().toString()
                        gone()
                    }
                    R.id.btn_calculate_surface_area -> {
                        binding.tvResult.text = mainViewModel.getSurfaceArea().toString()
                        gone()
                    }
                }
            }
        }
    }

    private fun visible() {
        binding.btnSave.visibility = View.GONE
        binding.btnCalculateVolume.visibility = View.VISIBLE
        binding.btnCalculateCircumference.visibility = View.VISIBLE
        binding.btnCalculateSurfaceArea.visibility = View.VISIBLE
    }

    private fun gone() {
        binding.btnSave.visibility = View.VISIBLE
        binding.btnCalculateVolume.visibility = View.GONE
        binding.btnCalculateCircumference.visibility = View.GONE
        binding.btnCalculateSurfaceArea.visibility = View.GONE
    }
}