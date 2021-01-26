package com.example.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView.settings.javaScriptEnabled = true
        // 자바 스크립트 허용
        /* 웹 뷰에서 새 창이 뜨지 않도록 방지하는 구문*/
        // 웹 뷰를 실행했을 때 새 창이 뜨지 않도록 방지하는 구문
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()
        // 위 2줄은 거의 필수록 작성한다.

        webView.loadUrl("https://www.naver.com") // 링크 주소를 load 한다.
    }

    // 웹에서 뒤로가기 버튼이 실행되기 위해 사용하는 메소드
    // 백버튼 누를 시 수행할 로직 구현
    override fun onBackPressed() {
        if(webView.canGoBack()){
            // 웹사이트에서 뒤로 갈 페이지가 존재 한다면
            webView.goBack() // 웹 사이트 뒤로가기 명령어
        }
        else{
            super.onBackPressed()
            // 더 이상 웹 사이트 뒤로 돌아가기 했을 때
            // 페이지가 없다면 웹 페이지 종료
        }

    }
}