package com.example.group_example1
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_company__element.*
import kotlinx.android.synthetic.main.activity_main.*

class Company_Element : AppCompatActivity() {


    var UserList = arrayListOf<User>(

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
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company__element)


        val Adapter = UserAdapter(this,UserList)
        listView.adapter = Adapter


    }

}