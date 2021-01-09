package com.example.menu_create_exercise

import android.content.Intent
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
        }

        naviView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.login -> {
                val intent = Intent(this,login::class.java)
                startActivity(intent)
            }
            R.id.project ->{
                val intent2 = Intent(this,Company_Element::class.java)
                startActivity(intent2)
            }
        }
        layout_drawer.closeDrawers()
        // 실행 후 현재 펼쳐져있는 drawer 네비게이션 menu를 닫아라
        // 네비게이션 닫기
        return false

    }



    override fun onBackPressed() {
        if(layout_drawer.isDrawerOpen(GravityCompat.START)){
            layout_drawer.closeDrawers()  // 닫히게
        }else{
            super.onBackPressed()    // 일반 back버튼 기능 실행
        }

        super.onBackPressed()
    }
}