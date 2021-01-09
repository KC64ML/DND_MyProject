package com.example.logkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    var a : Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        a = 2


        // 조건이 있을 때 어디가 실행되었는지 알 수 있다.
        // 복잡한 화면 구성이 있을 때, 어느 쪽이 실행되는 지 직관적으로 알고 싶을 때 Log를 활용한다.
        // msg(변수명)을 사용하여 현재 어떤 것이 실행되었는지 알 수 있다.
        if (a ==2){
            Log.d("if 문", "ENTER")
        }else if(a==1){
            Log.d("else if 문 ", "ENTER")
        }

        Log.d("var a의 변수 값", a.toString())
        // Log.d : debug 줄인말
        // 정상실행되었을 때 : onCreate문에서 정상적으로 Log를 실행하였다.
        // Logcat -> com.example.logkt (25558) | Debug 에서 확인가능
        // Log.d(tag, msg) => tag : log  설명, msg : 입력해야할 값
        // msg : String으로 넣어야한다.
        // 정수.toString => 문자
        // Logcat 펼치기 : alt + 6
        // 긴 코드가 있을 때 중간에 Log.d를 이용하면 실행하면서 어디가 오류가 있는지 알수있다.
        // 1. 현재 변수 값을 출력한다.
        // 2. 어디가 실행되었는지 어디가 실행 안되었는지 알 수 있다.

        Log.e("if 문 ", "ENTER")
        // 간단한 코드 점검을 할 때, Debug 코드 중 빨간색으로 확인하고 싶을 때 사용

    }
}