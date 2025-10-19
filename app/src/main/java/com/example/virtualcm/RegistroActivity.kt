package com.example.virtualcm

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegistroActivity : AppCompatActivity() {

    var tvTitle: TextView?= null
    var tvRegresoLogin: TextView?= null
    private lateinit var tilUsuario : TextInputLayout
    private lateinit var tietUsuario : TextInputEditText
    private lateinit var llNomCompletoUser : LinearLayout
    private lateinit var tilNombres : TextInputLayout
    private lateinit var tietNombres : TextInputEditText
    private lateinit var tilApellidos : TextInputLayout
    private lateinit var tietApellidos : TextInputEditText
    private lateinit var tilEmail : TextInputLayout
    private lateinit var tietEmail : TextInputEditText
    private lateinit var tilFono : TextInputLayout
    private lateinit var tietFono : TextInputEditText
    private lateinit var tilPass : TextInputLayout
    private lateinit var tietPass : TextInputEditText
    private lateinit var btnRegister : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro)

        tvTitle = findViewById(R.id.tvTitle)
        tvRegresoLogin = findViewById(R.id.tvRegresoLogin)
        tilUsuario = findViewById(R.id.tilUsuario)
        tietUsuario = findViewById(R.id.tietUsuario)
        llNomCompletoUser = findViewById(R.id.llNomCompletoUser)
        tilNombres = findViewById(R.id.tilNombres)
        tietNombres = findViewById(R.id.tietNombres)
        tilApellidos = findViewById(R.id.tilApellidos)
        tietApellidos = findViewById(R.id.tietApellidos)
        tilEmail = findViewById(R.id.tilEmail)
        tietEmail = findViewById(R.id.tietEmail)
        tilFono = findViewById(R.id.tilFono)
        tietFono = findViewById(R.id.tietFono)
        tilPass = findViewById(R.id.tilPass)
        tietPass = findViewById(R.id.tietPass)
        btnRegister = findViewById(R.id.btnRegister)

        tvRegresoLogin?.setOnClickListener {
            cambioActivity(LoginActivity::class.java)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun cambioActivity(activityDestino : Class<out Activity>) {
        val intent = Intent(this, activityDestino)
        startActivity(intent)
    }
}