package com.example.ex_t5bb_aguilarespinozafernandoemilio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_imprimir.*

class Imprimir : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imprimir)

        edtNombres.setText(intent.extras!!["EDTNombres"]!!.toString())
        edtDni.setText(intent.extras!!["EDTDni"]!!.toString())
        edtServicio.setText(intent.extras!!["EDTServicio"]!!.toString())
        edtCostoServicio.setText(intent.extras!!["EDTCostoS"]!!.toString())
        edtCostoInstalacion.setText(intent.extras!!["EDTCostoI"]!!.toString())
        edtDescuento.setText(intent.extras!!["EDTDscto"]!!.toString())
        edtTotal.setText(intent.extras!!["EDTTotal"]!!.toString())
    }
}
