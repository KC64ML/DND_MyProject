package com.example.camerakt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gun0912.tedpermission.PermissionListener

class MainActivity : AppCompatActivity() {


    val REQUEST_IMAGE_CAPTURE = 1 // 카메라 사진 요청 코드
    lateinit var curPhotoPath: String // 문자열 형태의 사진 경로 값
    // 초기값을 null로 시작하고 싶을 때 사용



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setPermission()
    }
    
    
    /*
    * 
    * 테트 퍼미션 설정
    * 
    * */
    
    private fun setPermission() {
        val permission = object : PermissionListener{
            
        }
    }
}