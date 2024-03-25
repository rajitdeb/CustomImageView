package com.rajit.customimageview

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.rajit.customimageview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nameInitialEdt.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(textChar: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (textChar != null) {
                    binding.profileImgView.setNameInitialAsImage(textChar.toString())
                }
            }

            override fun afterTextChanged(p0: Editable?) {}

        })

    }
}