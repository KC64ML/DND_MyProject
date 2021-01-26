package com.example.group_example1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView



class UserAdapter (val context:Context,val UserList:ArrayList<User>):BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.list_item_user,null)

        val profile = view.findViewById<ImageView>(R.id.imageView)
        val company = view.findViewById<TextView>(R.id.tv_company_name)
        val project = view.findViewById<TextView>(R.id.tv_project_name)
        val part = view.findViewById<TextView>(R.id.tv_part)

        val user = UserList[position]

        profile.setImageResource(user.profile)
        company.text = user.company_name
        project.text = user.project_name
        part.text = user.part

        return view
        
    }

    override fun getItem(position: Int): Any {
        return UserList[position]

    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {

        return UserList.size
    }

}