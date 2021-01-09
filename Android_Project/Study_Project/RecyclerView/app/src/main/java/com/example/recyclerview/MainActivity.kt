package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val profileList = arrayListOf(
            Profiles(R.drawable.man,"이경창",26,"안드로이드 앱 개발자"),
            Profiles(R.drawable.woman,"박은지",25,"프론트엔드 개발자"),
            Profiles(R.drawable.man,"이경창2",21,"안드로이드 앱 개발자"),
            Profiles(R.drawable.woman,"박은지2",22,"프론트엔드 개발자"),
            Profiles(R.drawable.man,"이경창3",23,"안드로이드 앱 개발자"),
            Profiles(R.drawable.woman,"박은지3",26,"프론트엔드 개발자"),
            Profiles(R.drawable.man,"이경창4",16,"안드로이드 앱 개발자"),
            Profiles(R.drawable.woman,"박은지4",15,"프론트엔드 개발자"),
            Profiles(R.drawable.man,"이경창5",36,"안드로이드 앱 개발자"),
            Profiles(R.drawable.woman,"박은지5",55,"프론트엔드 개발자"),
            Profiles(R.drawable.man,"이경창6",34,"안드로이드 앱 개발자"),
            Profiles(R.drawable.woman,"박은지6",45,"프론트엔드 개발자"),
            Profiles(R.drawable.man,"이경창7",26,"안드로이드 앱 개발자"),
            Profiles(R.drawable.woman,"박은지7",24,"프론트엔드 개발자")

            )
        // arrayListOf : list형태 객체들을 넣을 때 사용

        rv_profile.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        // LayoutManager : RecycleView의 아이템의 배치와 재사용에 대한 정책을 결정하면 LayoutManager의 종류에
        // 따라 아이템의 배치가 변경된다.
        // this : 현재 자기자신의 context를 가져온다. context : MainActivity의 모든 정보 (컴포넌트가 가지고있는 모든정보)

        // LayoutManager의 종류 3가지
        //  1) LinearLayoutManager : 수평, 수직의 스크롤 리스트
        //      - ListView를 구현할 수 있도록 만드는 LayoutManager
        //      - setOrientation을 이용하여 스크롤의 방향을 설정할 수 있으며
        //      - scroll의 위치나 추가, 삭제에 대한 애니메이션 처리를 지원한다.
        //  2) GridLayoutManager : 행에 표시되는 아이템 갯수가 여러개인 리스트
        //      - 열에 2개 이상의 아이템을 넣고 싶을 때 사용
        //  3) StaggeredGridLayoutManage : 높이가 불구칙적인 형태의 그리드 리스트
        //      - 아이템의 높이를 가변적으로 설정
        //로 이루어져 있다.

        rv_profile.setHasFixedSize(true)
        // ReCycler에 대한 성능 방안

        rv_profile.adapter = ProfilesAdapter(profileList)

    }
}