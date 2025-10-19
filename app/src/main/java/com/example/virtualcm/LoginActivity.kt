package com.example.virtualcm

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.virtualcm.entity.Cliente
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    var tvRecuperarPass: TextView? = null
    var tvRegistro: TextView? = null
    private lateinit var tilUsuario : TextInputLayout
    private lateinit var tietUsuario : TextInputEditText
    private lateinit var btnIniciarSesion : Button
    private lateinit var tilPass : TextInputLayout
    private lateinit var tietPass : TextInputEditText

    private val listaClientes = mutableListOf(
        Cliente(1, "aran123", "Andree", "Moreno", "aran123@gmail.com", "987654321", "1weq23e2"),
        Cliente(2, "test456", "Nombres", "Apellidos", "test456@gmail.com", "963852741", "1q2w3e")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        tvRecuperarPass = findViewById(R.id.tvRecuperarPass)
        tvRegistro = findViewById(R.id.tvRegistro)
        tilUsuario = findViewById(R.id.tilUsuario)
        tietUsuario = findViewById(R.id.tietUsuario)
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion)
        tilPass = findViewById(R.id.tilPass)
        tietPass = findViewById(R.id.tietPass)

        tvRecuperarPass?.setOnClickListener {
            cambioActivity(RecuperarPassActivity::class.java)
        }

        btnIniciarSesion.setOnClickListener {
            validarCampos()
        }

        tvRegistro?.setOnClickListener {
            cambioActivity(RegistroActivity::class.java)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val imeInsets = insets.getInsets(WindowInsetsCompat.Type.ime())
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                maxOf(systemBars.bottom, imeInsets.bottom)
            )
            insets
        }
    }
    fun cambioActivity(activityDestino : Class<out Activity>) {
        val intent = Intent(this, activityDestino)
        startActivity(intent)
    }

    fun validarCampos() {
        val usuario = tietUsuario.text.toString().trim()
        val pass = tietPass.text.toString().trim()
        var error : Boolean = false
        if (usuario.isEmpty()) {
            tilUsuario.error = "Campo requerido"
            error = true
        } else {
            tilUsuario.error = ""
        }
        if (pass.isEmpty()) {
            tilPass.error = "Campo requerido"
            error = true
        } else {
            tilPass.error = ""
        }
        if (error) {
            return
        } else {
            Toast.makeText(this, "Ingreso satisfactorio. Procesando...", Toast.LENGTH_LONG).show()

            var clienteEncontrado : Cliente?= null
            for (u in listaClientes) {
                if (u.usuario == usuario && u.pass == pass) {
                    clienteEncontrado = u
                    break
                }
            }
            if (clienteEncontrado != null) {
                Toast.makeText(this, "Bienvenido ${clienteEncontrado.nombres}", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show()
            }
        }

    }
}