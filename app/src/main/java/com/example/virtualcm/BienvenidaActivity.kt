package com.example.virtualcm

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BienvenidaActivity : AppCompatActivity() {

    private lateinit var btnIrRegistro : Button
    private lateinit var btnIrLogin : Button
    private lateinit var ibX : ImageButton
    private lateinit var ibFb : ImageButton
    private lateinit var ibInstagram : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bienvenida)

        btnIrRegistro = findViewById(R.id.btnIrRegistro)
        btnIrLogin = findViewById(R.id.btnIrLogin)
        ibX = findViewById(R.id.ibX)
        ibFb = findViewById(R.id.ibFb)
        ibInstagram = findViewById(R.id.ibInstagram)

        btnIrRegistro.setOnClickListener {
            cambioActivity(RegistroActivity::class.java)
        }

        btnIrLogin.setOnClickListener {
            cambioActivity(LoginActivity::class.java)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun cambioActivity(activityDestino: Class<out Activity>) {
        val intent = Intent(this, activityDestino)
        startActivity(intent)
    }

    fun irX() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData("https://x.com/home".toUri())
        startActivity(intent)
    }

    fun irFb() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData("https://www.facebook.com/".toUri())
        startActivity(intent)
    }

    fun irInstagram() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData("https://www.instagram.com/".toUri())
        startActivity(intent)
    }
}