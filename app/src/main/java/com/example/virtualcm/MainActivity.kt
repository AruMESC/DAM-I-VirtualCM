package com.example.virtualcm

import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var dlMain : DrawerLayout
    private lateinit var ivMenu : ImageView
    private lateinit var flContainer : FrameLayout
    private lateinit var nvMenu : NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        dlMain = findViewById(R.id.dlMain)
        ivMenu = findViewById(R.id.ivMenu)
        flContainer = findViewById(R.id.flContainer)
        nvMenu = findViewById(R.id.nvMenu)

        ivMenu.setOnClickListener {
            dlMain.open()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.dlMain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}