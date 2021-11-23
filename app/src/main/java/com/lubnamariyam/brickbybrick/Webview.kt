package com.lubnamariyam.brickbybrick

import android.annotation.SuppressLint
import android.os.Build
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

@SuppressLint("SetJavaScriptEnabled")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun webPage(url:String){
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            loadUrl(url)
        }
    }, update = {
        it.loadUrl(url)
        it.isFocusableInTouchMode = true
        it.settings.javaScriptEnabled = true
    })
}

