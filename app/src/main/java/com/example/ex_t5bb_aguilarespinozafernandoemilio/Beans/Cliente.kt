package com.example.ex_t5bb_aguilarespinozafernandoemilio.Beans

class Cliente {
    var Nombre: String = "";
    var Dni: String = "";
    var Servicio: String = "";
    var CostoS: Double = 0.0;
    var CostoI: Double = 0.0;
    var Dscto: Double = 0.0;
    var Total: Double = 0.0;

    constructor(pNombre: String, pDni: String, pServicio: String){

        this.Nombre = pNombre
        this.Dni = pDni
        this.Servicio = pServicio
        this.CostoS = 0.0
        this.CostoI = 0.0
        this.Dscto = 0.0
        this.Total = 0.0
    }

    public fun CostoServicio(){
        if(this.Servicio.equals("Duo - Telefono e Internet")){
            CostoS = 109.0
        }else if (this.Servicio.equals("Trio - Telefono + TV + Internet")){
            CostoS = 159.0
        }else if (this.Servicio.equals("Solo Internet")){
            CostoS = 89.0
        }else if(this.Servicio.equals("Solo Telefono")) {
            CostoS = 59.0
        }else{
            CostoS = 79.0
        }
    }

    public fun CostoInstalacion(){
        if(this.Servicio.equals("Duo - Telefono e Internet")){
            CostoI = 35.0
        }else if (this.Servicio.equals("Trio - Telefono + TV + Internet")){
            CostoI = 60.0
        }else if (this.Servicio.equals("Solo Internet")){
            CostoI = 15.0
        }else if(this.Servicio.equals("Solo Telefono")) {
            CostoI = 12.0
        }else{
            CostoI = 15.0
        }
    }

    public fun Total(): Double{
        var tot: Double = 0.0
        tot = (this.CostoI) + (this.CostoS)
        return tot
    }

    public fun calcularDscto(){

        if (this.Servicio.equals("Duo - Telefono e Internet")) {
            Dscto = 5.0
        } else if (this.Servicio.equals("Trio - Telefono + TV + Internet")) {
            Dscto = 10.0
        } else if (this.Servicio.equals("Solo Internet")) {
            Dscto = 2.0
        } else if (this.Servicio.equals("Solo Telefono")) {
            Dscto = 1.0
        } else {
            Dscto = 1.0
        }
    }

}