package com.example.webapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.Toast
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.webapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // BINDING
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        settingsKiosk()
        settingsWebView("https://cv.chalichen.cat")
        startLockTask()

        binding.btnSalir.setOnClickListener() {
            showPinDialog()
        }


    }

    fun settingsWebView(url: String) {
        // Configuracion
        binding.webView.webViewClient = WebViewClient()
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.settings.domStorageEnabled = true

        // URL
        binding.webView.loadUrl(url)
    }

    fun settingsKiosk() {
        val controller = WindowInsetsControllerCompat(window, window.decorView)

        controller.hide(WindowInsetsCompat.Type.systemBars())
        controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_DEFAULT

        onBackPressedDispatcher.addCallback(this) {} // No farà res
    }

    private val PIN_SECRETO = "1234" // Aquest es el pin per poder sortir

    private fun showPinDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder
            .setMessage("Iadadad")
            .setTitle("SUUUUUUUUUUUUU")
            .setPositiveButton("Provar") { dialog, which ->

            }
            .setNegativeButton("Cancelar") {dialog, which ->
                dialog.dismiss()
            }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}
