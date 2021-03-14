package com.thisteampl.jackpot.main.floating

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.thisteampl.jackpot.R
import kotlinx.android.synthetic.main.activity_project_creation.*
import kotlinx.android.synthetic.main.activity_signup.*

class ProjectCreation : AppCompatActivity() {
    
    // 해야할 것
    // 2. 2 page로 구성하기
    // 3. Database에 넘기기


    // SignUpActivity 참고함
    // 모집 포지션, 분야를 위한 stack 선언
    private val stackToolposition = mutableListOf<String>()
    private val stackToolfield = mutableListOf<String>()

    // 프로젝트 방식, 프로젝트 예상 기간을 위한 arrayOfNulls 선언
    private var systembtn = arrayOfNulls<Button>(2)
    private var periodbtn = arrayOfNulls<Button>(3)
    private var systemtext = "system"
    private var periodtext = "period"

    private var page: Int = 1

    private var stacklistdeveloper = "개발자" // 개발자 list 저장용
    private var stacklistdesigner = "디자이너" // 디자이너 list 저장용
    private var stacklistregions = "지역" // 지역 list 저장용

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_creation)

        createproject_minusbutton_imageview.setOnClickListener {
            finish()
        }


        setWriteProjectRecruitment()
    }


    private fun setWriteProjectRecruitment() {

        // 1 page
        stackToolposition.clear()
        stackToolfield.clear()

        // 스택, 툴 버튼 설정 메서드 (signupactivity btnOnClick 이용)
        // 모집포지션
        for (i in 0 until projectcreate_position_linearlayout.childCount) {
            val child: View = projectcreate_position_linearlayout.getChildAt(i)

            // 해당 버튼에 효과 주기
            if(child is Button) {
                child.background = ContextCompat.getDrawable(this@ProjectCreation, R.drawable.radius_button_effect)
                child.setOnClickListener {

                    if(!stackToolposition.contains(child.text.toString())) {
                        child.background = ContextCompat.getDrawable(this@ProjectCreation, R.drawable.radius_background_transparent_select)
                        stackToolposition.add(child.text.toString())
                    } else {
                        child.background = ContextCompat.getDrawable(this@ProjectCreation, R.drawable.radius_button_effect)
                        stackToolposition.remove(child.text.toString())
                    }

                }
            }
        }

        // 사용 예정 스택, 개발자
        var stacktobeusingdeveloper = listOf("JAVA","C++","Python","JavaScript","Html/CSS","Swift","Spring","Kotlin",
            "Django","React.js","Flask")
        // 스택 선택을 해 줄 배열과 액티비티의 스피너와 연결해줄 어댑터.
        createproject_developer_spinner.setItems(stacktobeusingdeveloper) // 스피너와 어댑터를 연결
        createproject_developer_spinner.setOnSpinnerItemSelectedListener<String> { oldIndex, oldItem, newIndex, newItem ->
            stacklistdeveloper = newItem
        }

        // 사용 예정 스택, 디자이너
        var stacktobeusingdesigner = listOf("Adobe Photoshop","Adobe Illustrator","Adobe XD","Figma","Sketch","Principle",
            "Adobe Indesign","Adobe After Effects","Adobe Premiere","C4D","Protopie","Zeplin")

        createproject_designer_spinner.setItems(stacktobeusingdesigner)
        createproject_designer_spinner.setOnSpinnerItemSelectedListener<String> { oldIndex, oldItem, newIndex, newItem ->
            stacklistdesigner = newItem
        }


        // 프로젝트 방식

        systembtn[0] = findViewById(R.id.projectcreate_offperiod_button)
        systembtn[1] = findViewById(R.id.projectcreate_openperiod_button)
        systembtn[0]?.setOnClickListener { systembtn[0]?.let { it1 -> this.onClickBtn(it1,0) } }
        systembtn[1]?.setOnClickListener { systembtn[1]?.let { it2 -> this.onClickBtn(it2,1) } }


        // 지역
        var regions = listOf("서울","부산","대구","인천","광주",
            "대전","울산","세종","경기도","강원도","충청북도","충청남도","전라북도","전라남도","경상북도","경상남도","제주도")

        createproject_regions_spinner.setItems(regions)
        createproject_regions_spinner.setOnSpinnerItemSelectedListener<String> { oldIndex, oldItem, newIndex, newItem ->
            stacklistregions = newItem
        }


        // 프로젝트 예상시간
        periodbtn[0] = findViewById(R.id.projectcreate_month_button)
        periodbtn[1] = findViewById(R.id.projectcreate_month2_button)
        periodbtn[2] = findViewById(R.id.projectcreate_month3_button)
        periodbtn[0]?.setOnClickListener { periodbtn[0]?.let{it1 -> this.onClickBtn(it1,0)} }
        periodbtn[1]?.setOnClickListener { periodbtn[1]?.let{it1 -> this.onClickBtn(it1,1)} }
        periodbtn[2]?.setOnClickListener { periodbtn[2]?.let{it1 -> this.onClickBtn(it1,2)} }

        // 분야 IT ~ 요리
        for (i in 0 until projectcreate_field_linearlayout.childCount) {
            val child: View = projectcreate_field_linearlayout.getChildAt(i)

            // 해당 버튼에 효과 주기
            if(child is Button) {
                child.background = ContextCompat.getDrawable(this@ProjectCreation, R.drawable.radius_button_effect)
                child.setOnClickListener {

                    // child
                    if(!stackToolfield.contains(child.text.toString())) {
                        child.background = ContextCompat.getDrawable(this@ProjectCreation, R.drawable.radius_background_transparent_select)
                        stackToolfield.add(child.text.toString())
                    } else {
                        child.background = ContextCompat.getDrawable(this@ProjectCreation, R.drawable.radius_button_effect)
                        stackToolfield.remove(child.text.toString())
                    }

                }
            }
        }

        // 분야 취미 ~ 자기계발
        for (i in 0 until projectcreate_field2_linearlayout.childCount) {
            val child: View = projectcreate_field2_linearlayout.getChildAt(i)

            // 해당 버튼에 효과 주기
            if(child is Button) {
                child.background = ContextCompat.getDrawable(this@ProjectCreation, R.drawable.radius_button_effect)
                child.setOnClickListener {

                    if(!stackToolfield.contains(child.text.toString())) {
                        child.background = ContextCompat.getDrawable(this@ProjectCreation, R.drawable.radius_background_transparent_select)
                        stackToolfield.add(child.text.toString())
                    } else {
                        child.background = ContextCompat.getDrawable(this@ProjectCreation, R.drawable.radius_button_effect)
                        stackToolfield.remove(child.text.toString())
                    }

                }
            }
        }



        // 버튼 눌렸을 때 1 page, 2 page 구분
        createproject_writerecruitment_button.setOnClickListener {
            if(page == 1){
                if(checkPageButton()){
                    page = 2
                    projectcreate_write_recruitment_article_constraintlayout.visibility =View.GONE
                    projectcreate_write_recruitment_article2_constraintlayout.visibility = View.VISIBLE

                    if(stackToolposition[0] is String){
                        Log.d("문자열 : ","String stackToolposition[0]입니다.")
                    }
                    if(stacklistdeveloper is String){
                        Log.d("문자열 : ","String 입니다.")
                    }

                    // String
//                    Log.d("stack: ","${stackToolposition[0].toString()}")
                }
                projectcreate_page_textview.text = "$page  /  2"
            }else if(page == 2){

            }
            
        }

    }

    // 모집 포지션, 사용 예정 스택, 프로젝트 방식 지역, 프로젝트 예상기간, 분야 선택 안되었을 때
    private fun checkPageButton():Boolean{
        if(stackToolposition.size == 0) {ToastmakeTextPrint("모집 포지션 선택해주세요."); return false}
        if(stacklistdeveloper.equals("개발자")){ToastmakeTextPrint("$stacklistdeveloper 사용 예정 스택 입력해주세요!"); return false}
        if(stacklistdesigner.equals("디자이너")){ToastmakeTextPrint("$stacklistdesigner 사용 예정 스택 입력해주세요!"); return false}
        if(systemtext.equals("system")){ToastmakeTextPrint("프로젝트 방식을 선택해주세요."); return false}
        if(stacklistregions.equals("지역")){ToastmakeTextPrint("$stacklistregions 지역을 입력해주세요!"); return false}
        if(periodtext.equals("period")){ToastmakeTextPrint("프로젝트 예상 기간을 선택해주세요."); return false}
        if(stackToolfield.size == 0) {ToastmakeTextPrint("분야를 선택해주세요."); return false}

        return true
    }
    private fun ToastmakeTextPrint(word:String){
        Toast.makeText(this, word, Toast.LENGTH_SHORT).show()
    }

    // 버튼 둘 중 하나만 선택되게 하기 위해 사용
    private fun onClickBtn(v : View, index:Int) {
        var id = v.id

        // 프로젝트 방식
        if(id == R.id.projectcreate_offperiod_button || id == R.id.projectcreate_openperiod_button) {
            for(i in 0..1) {
                if(i == index) {
                    systembtn[i]?.background = ContextCompat.getDrawable(this@ProjectCreation,R.drawable.radius_background_transparent_select)
                    systemtext = systembtn[i]?.text.toString()
                }
                else {
                    systembtn[i]?.background = ContextCompat.getDrawable(this@ProjectCreation, R.drawable.radius_button_effect)
                }
            }
        }


        // 프로젝트 예상 기간
        if(id == R.id.projectcreate_month_button || id == R.id.projectcreate_month2_button
            || id == R.id.projectcreate_month3_button) {
            for(i in 0..2) {
                if(i == index) {
                    periodbtn[i]?.background = ContextCompat.getDrawable(this@ProjectCreation,R.drawable.radius_background_transparent_select)
                    periodtext = periodbtn[i]?.text.toString()
                }
                else {
                    periodbtn[i]?.background = ContextCompat.getDrawable(this@ProjectCreation, R.drawable.radius_button_effect)
                }
            }
        }
    }


}