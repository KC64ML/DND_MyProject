package com.thisteampl.jackpot.main.projectdetail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thisteampl.jackpot.R
import com.thisteampl.jackpot.main.MainActivity
import com.thisteampl.jackpot.main.mainhome.SearchViewPage
import com.thisteampl.jackpot.main.mypage.MyPage
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.main_appname_textview
import kotlinx.android.synthetic.main.activity_main.main_mypage_imagebutton
import kotlinx.android.synthetic.main.activity_main.main_search_imagebutton
import kotlinx.android.synthetic.main.activity_project_view_detail.*

class ProjectViewDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_view_detail)

        // 상세 page text, intent로 정보 전달한다.
        var project = intent.getStringExtra("project")
        var position = intent.getStringExtra("position")
        var update = intent.getStringExtra("update")
        var stack1 = intent.getStringExtra("stack1")
        var stack2 = intent.getStringExtra("stack2")
        var stack3 = intent.getStringExtra("stack3")

        projectview_position1_textview.text = project
        projectview_position2_textview.text = position


        val intent = Intent(this, MyPage::class.java)
        val mainintent = Intent(this, MainActivity::class.java)
        val searchintent = Intent(this, SearchViewPage::class.java)

        // 검색
        main_search_imagebutton.setOnClickListener {
            startActivity(searchintent)
        }

        // 나의 페이지
        main_mypage_imagebutton.setOnClickListener{
            startActivity(intent)
        }

        // MainActivity 실행
        main_appname_textview.setOnClickListener{
            startActivity(mainintent)
        }


    }
}