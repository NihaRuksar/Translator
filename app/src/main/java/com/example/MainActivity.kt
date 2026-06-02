package com.example

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
  @SuppressLint("SetJavaScriptEnabled")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    
    val webView = WebView(this).apply {
      layoutParams = FrameLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT
      )
      settings.javaScriptEnabled = true
      settings.domStorageEnabled = true
      settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
      settings.allowFileAccess = true
      settings.allowFileAccessFromFileURLs = true
      settings.allowUniversalAccessFromFileURLs = true
      settings.cacheMode = WebSettings.LOAD_NO_CACHE
      
      webViewClient = WebViewClient()
      webChromeClient = WebChromeClient()
    }
    
    setContentView(webView)
    webView.loadUrl("file:///android_asset/editor.html")
  }
}
