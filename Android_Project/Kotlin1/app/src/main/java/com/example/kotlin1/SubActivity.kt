package com.example.kotlin1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sub.*
import kotlinx.android.synthetic.main.activity_sub.view.*

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        if(intent.hasExtra("Kyoung")){
            tv_get.text = intent.getStringExtra("Kyoung")
            // 서브 액티티비에 존재하는 텍스트뷰에다가 HelloWorld가 넘겨져 옴

        }
    }
}