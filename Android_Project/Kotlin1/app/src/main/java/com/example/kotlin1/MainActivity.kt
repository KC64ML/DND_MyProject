package com.example.kotlin1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_subactivity3.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv.setText("Hello world..")

        btn3.setOnClickListener{
            val intent = Intent(this, SubActivity::class.java)
            // 다음 화면으로 이동하기 위한 인텐드 객체 생성
            intent.putExtra("Kyoung",tv.text.toString())

            startActivity(intent)
//            finish()
            
        }
    }
}