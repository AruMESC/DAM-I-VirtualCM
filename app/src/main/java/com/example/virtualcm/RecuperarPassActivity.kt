package com.example.virtualcm

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.virtualcm.entity.Cliente
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RecuperarPassActivity : AppCompatActivity() {

    private lateinit var tilCorreo : TextInputLayout
    private lateinit var tietCorreo : TextInputEditText
    private lateinit var btnEnviarEnlace : Button

    private val listaClientes = mutableListOf(
        Cliente(1, "aran123", "Andree", "Moreno", "aran123@gmail.com", "987654321", "1weq23e2"),
        Cliente(2, "test456", "Nombres", "Apellidos", "test456@gmail.com", "963852741", "1q2w3e")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recuperar_pass)

        tilCorreo = findViewById(R.id.tilCorreo)
        tietCorreo = findViewById(R.id.tietCorreo)
        btnEnviarEnlace = findViewById(R.id.btnEnviarEnlace)

        btnEnviarEnlace.setOnClickListener {
            validarEmail()
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
    fun validarEmail() {
        val email = tietCorreo.text.toString().trim()
        var error : Boolean = false
        if (email.isEmpty()) {
            tietCorreo.error = "El correo no puede estar vacío"
            error = true
        } else {
            tietCorreo.error = ""
        }
        if (error) {
            return
        } else {
            Toast.makeText(this, "Correo válido. Enviando enlace...", Toast.LENGTH_LONG).show()

            var clienteEncontrado : Cliente?= null
            for (u in listaClientes) {
                if (u.email == email) {
                    clienteEncontrado = u
                    break
                }
            }
            if (clienteEncontrado != null) {
                startActivity(Intent(this, LoginActivity::class.java))
            } else {
                Toast.makeText(this, "Email no registrado", Toast.LENGTH_LONG).show()
            }
        }
    }
}