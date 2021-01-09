package com.example.listviewkt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_company__element.*
import kotlinx.android.synthetic.main.activity_main.*

class Company_Element : AppCompatActivity() {


    var UserList = arrayListOf<User>(

        // Upload된 회사 이름
        User(R.drawable.project,"Naver","Project1","which part1"),
        User(R.drawable.project,"KakaoTalk","Project2","which part2"),
        User(R.drawable.project,"Google","Project3","which part3"),
        User(R.drawable.project,"Korea","Project4","which part4"),
        User(R.drawable.project,"Republic","Project5","which part5"),
        User(R.drawable.project,"AWS","Project6","which part6"),
        User(R.drawable.project,"IOS","Project7","which part7"),
        User(R.drawable.project,"CentOS","Project8","which part8")

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        // 액티비티 실행 시작지점

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company__element)

//        val item = arrayOf("사과", "배","딸기","키위","경창")
//        // arrayOf : 배열 생성
//        // context : 한 액티비티의 모든 정보를 담고 있다.
//        // Android에서 제공하는 ArrayAdapter
//        listView.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,item)
//        // 2 번째, android.R.layout.simple_list_item_1 : layout 형태
//        // 3 번째에 장착 (배열)

        val Adapter = UserAdapter(this,UserList)
        listView.adapter = Adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position) as User
            // 현재 클릭한 position 변수가 selectItem에 저장된다. (User모델로부터)
            selectItem.profile
//           Toast.makeText(this, selectItem.company_name, Toast.LENGTH_SHORT).show()
            // Toast 메시지를 띄울것이다.
            // 현재 activity로부터 띄울 것이다.
            val intent = Intent(this,Introduce_Company::class.java)
            startActivity(intent)
        }

    }

}