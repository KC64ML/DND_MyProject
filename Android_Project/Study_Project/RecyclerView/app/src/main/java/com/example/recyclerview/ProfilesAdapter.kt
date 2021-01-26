package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

// ArrayList<Profiles> : 형태를 뛰는 Profiles 클래스
// class name () : => :은 클래스 선언
// RecyclerView.Adapter (속성 다운받은 후) 상속
class ProfilesAdapter (val profilesList: ArrayList<Profiles>) : RecyclerView.Adapter<ProfilesAdapter.CustomViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfilesAdapter.CustomViewHolder {
        // setContentView 처럼 list_item을 붙이는 작업을 한다.
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        // context : activity가 담고있는 모든 정보, parent.context : ViewGroup이 가지고 있는 모든 정보
        // list_item에 있는 내용을 adapter에 붙여주는 작업을 하였다.
        //return CustomViewHolder(view)
        // 밑에 있는 클래스 끌어와서 생성한 view를 전달해준다.
        // itemView == View 이다.

        return CustomViewHolder(view).apply{ 
            // 클릭 처리
            itemView.setOnClickListener{
                val curPos = adapterPosition
                // adapterPosition : 클릭한 adapter 위치, 현재 클릭한 위치
                val profile: Profiles = profilesList.get(curPos)
                // Profiles 객체 형태로 클릭한 텍스트 가져온다.

                Toast.makeText(parent.context, "이름 : ${profile.name}\n나이 : ${profile.age}\n직업 : ${profile.job}",Toast.LENGTH_SHORT).show()
                // parent.context : adapter와 연결되어 있는 context (여기서는 MainActivity)

            }
            // itemView : 작성되어있는 View들을 의미한다.

        }
    }

    override fun getItemCount(): Int {
        // 총 개수, 길이
        return profilesList.size
    }

    override fun onBindViewHolder(holder: ProfilesAdapter.CustomViewHolder, position: Int) {
        // onCreateViewHolder에서 만들었던 View를 실제 연결해준다.
        // listView 사용할 때 onBindViewHolder가 지속적으로 호출되면서 모든 데이터를 매칭해준다.
        holder.gender.setImageResource(profilesList.get(position).gender)
        // profileList.get(position).gender : 현재 클릭한 위치에 대하여 연동
        holder.name.text = profilesList.get(position).name
        // setText와 같은 개념 name 영역에 텍스트 입력
        // get(position) : 현재 바운딩 되고 있는 위치
        holder.age.text = profilesList.get(position).age.toString()  // 숫자를 문자열로 변경
        holder.job.text = profilesList.get(position).job

    }

    class CustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        // RecyclerView.ViewHolder에서 itemView
        val gender = itemView.findViewById<ImageView>(R.id.iv_profile) // 성별
        val name = itemView.findViewById<TextView>(R.id.tv_name) // 성별
        val age = itemView.findViewById<TextView>(R.id.tv_age) // 이름
        val job = itemView.findViewById<TextView>(R.id.tv_job) // 직업


    }

}

