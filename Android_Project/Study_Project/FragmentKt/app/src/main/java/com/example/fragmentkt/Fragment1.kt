package com.example.fragmentkt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Fragment1 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.frag1, container, false)
        // view : setContentView와 같다. Fragment에서 사용된 setContentView

        // 이쪽 화면에 다른 설계를 해도 된다.

        return view
    }
}
