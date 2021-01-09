package com.example.fragmentkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFrag(0)

        btn1.setOnClickListener{

            setFrag(0)
        }
        btn2.setOnClickListener{

            setFrag(1)
        }
        btn3.setOnClickListener{

            setFrag(2)
        }


    }


    // setFrag 메소드
    // 변수 0이 넘어왔다면 when에서 0을 실행한다.
    private fun setFrag(fragNum : Int) {
        val ft = supportFragmentManager.beginTransaction()
        // fragment 이용하여, fragment 교체 관리하는 manager를 불러왔다. beginTransaction : 교체
        when(fragNum){
            0 -> {
                ft.replace(R.id.main_frame,Fragment1()).commit()
                // replace : 화면 교체 하는 메소드
                // main_frame 위치 교체, Fragment1와 연동
            }

            1 -> {
                ft.replace(R.id.main_frame,Fragment2()).commit()
                // replace : 화면 교체 하는 메소드
                // main_frame 위치 교체, Fragment1와 연동
            }


            2 -> {
                ft.replace(R.id.main_frame,Fragment3()).commit()
                // replace : 화면 교체 하는 메소드
                // main_frame 위치 교체, Fragment1와 연동
            }



        }
    }
}