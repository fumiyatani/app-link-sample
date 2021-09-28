
package com.example.applinksample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handleIntent()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)

        handleIntent()
    }

    private fun handleIntent() {
        val appLinkAction = intent.action
        val appLinkData = intent.data
        if (Intent.ACTION_VIEW == appLinkAction && appLinkData != null) {
            val comment: String = """
                lastPathSegment: ${appLinkData.lastPathSegment}
                id: ${appLinkData.getQueryParameter("id")}
                name: ${appLinkData.getQueryParameter("name")}
            """.trimIndent()
            findViewById<TextView>(R.id.tv_app_links).text = comment
        }
    }
}