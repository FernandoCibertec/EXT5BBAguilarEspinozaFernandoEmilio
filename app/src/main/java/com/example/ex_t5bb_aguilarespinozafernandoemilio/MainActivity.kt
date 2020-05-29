package com.example.ex_t5bb_aguilarespinozafernandoemilio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    public fun btnllamarCliente_OnClick(v: View)
    {

        var oActivity: Intent =Intent(this,
            ClienteClase::class.java)
        startActivity(oActivity)

    }
}
