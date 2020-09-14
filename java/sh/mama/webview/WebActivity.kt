package sh.mama.webview

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        browser.webViewClient = WebViewClient()
        browser.loadUrl("https://duckduckgo.com/app")
        browser.settings.javaScriptEnabled = true
        browser.settings.setSupportZoom(true)

        searchurl.onSearch {
            val str = searchurl.text.toString()
            val https = """https://""".toRegex()
            val http = """http://""".toRegex()
            if (https.containsMatchIn(str)) {
                browser.loadUrl(str)
                Toast.makeText(this, "Søger: $str", Toast.LENGTH_SHORT)
                    .show()
            } else if (http.containsMatchIn(str)) {
                Toast.makeText(this, "Du skal bruge https...", Toast.LENGTH_SHORT)
                    .show()
            } else {
                browser.loadUrl("https://$str")
                Toast.makeText(this, "Søger: $str", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun EditText.onSearch(func: () -> Unit) {
        setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val imm =
                    context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(windowToken, 0)
                func()
            }
            true
        }
    }

    override fun onBackPressed() {
        if (browser.canGoBack())
            browser.goBack()
        else
            super.onBackPressed()
    }
}