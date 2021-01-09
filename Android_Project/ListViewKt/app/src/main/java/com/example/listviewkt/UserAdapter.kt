package com.example.listviewkt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

/*
* : BaseAadapter()를 상속한다.
*
* */

// context : 한 액티비티의 모든 정보를 담고 있다.
class UserAdapter (val context:Context,val UserList:ArrayList<User>):BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // ListView View get했을 때 어떻게 뿌려줄 것인지 나타낸다.
        // LayoutInflater.from : View를 붙일 때 사용한다.
        // list_item_user.xml을 붙인다. listView 한 컬럼당 item은 LayoutInflater 형태를 따른다.
        val view: View = LayoutInflater.from(context).inflate(R.layout.list_item_user,null)

        val profile = view.findViewById<ImageView>(R.id.imageView)
        // id로부터 view를 찾아라
        val company = view.findViewById<TextView>(R.id.tv_company_name)
        val project = view.findViewById<TextView>(R.id.tv_project_name)
        val part = view.findViewById<TextView>(R.id.tv_part)

        // position을 가져온다.
        // position 위치, 0번부터
        val user = UserList[position]

        // User 클래스 객체의 profile과 연결이 되었다.
        // 실행되면 R.drawable.android_image가 삽입된다.
        // imageView에 resource로 User 클래스의 profile이 연결된다.
        profile.setImageResource(user.profile)
        company.text = user.company_name
        project.text = user.project_name
        part.text = user.part

        return view
        
    }

    override fun getItem(position: Int): Any {
        // 어떤 item들을 끌고 올 것인가
        return UserList[position]
        // UserList로 위치에 있는 것을 반환

    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        // listView에서 열 개수
        return UserList.size
    }

}