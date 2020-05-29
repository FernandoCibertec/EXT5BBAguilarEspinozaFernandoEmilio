package com.example.ex_t5bb_aguilarespinozafernandoemilio

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ex_t5bb_aguilarespinozafernandoemilio.Beans.Cliente
import kotlinx.android.synthetic.main.activity_cliente_clase.*
import kotlinx.android.synthetic.main.activity_cliente_clase.edtCostoInstalacion
import kotlinx.android.synthetic.main.activity_cliente_clase.edtCostoServicio
import kotlinx.android.synthetic.main.activity_cliente_clase.edtTotal
import kotlinx.android.synthetic.main.activity_imprimir.*


class ClienteClase : AppCompatActivity() {

    lateinit var oCliente: Cliente

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente_clase)
    }

    fun Calcular() :Boolean{
        val dnival: String = txtDni.text.toString()
        if(txtNombres.text.isEmpty()){
            Toast.makeText(baseContext, "Por favor introducir nombre completo", Toast.LENGTH_LONG).show()
            return false
        }
        if(dnival.trim().length!=7){
            Toast.makeText(baseContext, "Por favor introducir un dni válido", Toast.LENGTH_LONG).show()
            return false
        }

        oCliente = Cliente(this.txtNombres.text.toString(), this.txtDni.text.toString(), radioServicio())
        oCliente.CostoServicio()
        oCliente.CostoInstalacion()
        oCliente.Total()
        oCliente.calcularDscto()

        return true

    }
    public fun CalcularonClick(v: View){
        if(Calcular()){
            this.edtCostoServicio.setText(oCliente.CostoS.toString())
            this.edtCostoInstalacion.setText(oCliente.CostoI.toString())
            this.edtDscto.setText(oCliente.Dscto.toString()+"%")
            this.edtTotal.setText(oCliente.Total().toString())

        }
    }

    public fun radioServicio() :String{
        if(rdDuo.isChecked){
            return "Duo - Telefono e Internet"
        }else if(rdTrio.isChecked){
            return "Trio - Telefono + TV + Internet"
        }else if(rdInternet.isChecked){
            return "Solo Internet"
        }else if(rdTelefono.isChecked){
            return "Solo Telefono"
        }else {
            return "Solo Cable"
        }
    }

    public fun btnImprimir_OnClick(v: View)
    {
        if (Calcular())
        {
            //Mostrar los datos calculados
            val costoservicio :String = edtCostoServicio.text.toString()
            val costoim :String = edtCostoInstalacion.text.toString()
            val dscto :String = edtDscto.text.toString()
            val total :String = edtTotal.text.toString()

            var oVentanaImprimir: Intent =Intent(this,Imprimir::class.java)
            oVentanaImprimir.putExtra("EDTNombres", txtNombres.text)
            oVentanaImprimir.putExtra("EDTDni", txtDni.text)
            oVentanaImprimir.putExtra("EDTServicio", radioServicio())
            oVentanaImprimir.putExtra("EDTCostoS", costoservicio)
            oVentanaImprimir.putExtra("EDTCostoI", costoim)
            oVentanaImprimir.putExtra("EDTDscto", dscto)
            oVentanaImprimir.putExtra("EDTTotal", total)
            startActivity(oVentanaImprimir)
        }

    }

}
