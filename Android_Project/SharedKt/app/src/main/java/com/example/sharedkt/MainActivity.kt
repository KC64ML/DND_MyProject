package com.example.sharedkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // 앱이 처음 실행될 때 한번 수행하는 곳 (초기화)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        //TODO : 저장된 데이터를 로드
        loadData()
        // 저장되어 있는 edit text 값을 load(적재) 해온다. (setText)
        // 빨간색으로, 처음 메소드를 만들 때
        // ctrl + enter -> create function 'loadData' 클릭
    }

    private fun loadData() {
        val pref = getSharedPreferences("pref",0)
        edt_hello.setText(pref.getString("name",""))
        // 1번째 인자에서는 저장할 당시의 키 값을 적어준다.
        // 2번째 키 값에 데이터가 존재하지 않은 경우 대체 값을 적는다.
    }

    private fun saveDate() {
        val pref = getSharedPreferences("pref",0)
        // 현재 app에 내부 폴더 경로에 pref 이름으로 저장하겠다.
        val edit = pref.edit() // 수정모드
        edit.putString("name",edt_hello.text.toString())
        // 1번째 인자에는 key 값, 2번째 인자에는 실제 담을 값
        
        edit.apply()  // 값을 저장 완료
    }

    override fun onDestroy() {
        // onDestroy : 해당 액티비티가 종료되는 시점이 다가올 때 호출
        // 해당 액티비티 종료될 때 실행하고 싶은 부분 넣는 곳
        super.onDestroy()

        saveDate()
        // saveDate 실행되면 해당 액티비티가 종료될 때 edit text 값이 저장된다.
    }


}