package com.example.navigationkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_navi.setOnClickListener {
            layout_drawer.openDrawer(GravityCompat.START)
            // START : LEFT와 같은 말 (왼쪽으로 밀기, 왼쪽에서 오른쪽으로)
            // END : RIGHT와 같은 말 (오른쪽으로 밀기, 오른쪽에서 왼쪽으로)
        }

        naviView.setNavigationItemSelectedListener(this)
        // 네비게이션 메뉴 아이템에 클릭 속성 부여
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean { // 네비게이션 메뉴 클릭시 수행
        // navigation 클릭할 때마다 item에 값이 형성된다.
        when(item.itemId){
            R.id.access -> Toast.makeText(applicationContext,"접근성", Toast.LENGTH_SHORT).show()
            R.id.email -> Toast.makeText(applicationContext,"이메일", Toast.LENGTH_SHORT).show()
            R.id.message -> Toast.makeText(applicationContext,"메시지", Toast.LENGTH_SHORT).show()
        }
        layout_drawer.closeDrawers()
        // 네비게이션 view가 틀어져있을 때 버튼들을 클릭했을 때, Toast 메세지와
        // 현재 펼쳐있는 drawer 네비게이션 menu를 닫아라
        // 네비게이션 닫기
        return false
    }


    override fun onBackPressed() {
        if(layout_drawer.isDrawerOpen(GravityCompat.START)){
            layout_drawer.closeDrawers() // 닫히게
        }else{
            super.onBackPressed()  // 일반 back버튼 기능 실행
        }
    }
}