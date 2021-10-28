package com.example.otraappconvista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var et_Valor1:EditText
    private lateinit var et_Valor2:EditText
    private lateinit var rb_Sumar:RadioButton
    private lateinit var rb_Restar:RadioButton
    private lateinit var rb_Multiplicar:RadioButton
    private lateinit var rb_Dividir:RadioButton
    private lateinit var tv_Resultado:TextView
    private lateinit var cb_Sumar:CheckBox
    private lateinit var cb_Restar:CheckBox
    private lateinit var cb_Multiplicar:CheckBox
    private lateinit var cb_Dividir:CheckBox
    private lateinit var spinner1:Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_Valor1 = findViewById(R.id.et_Valor1)
        et_Valor2 = findViewById(R.id.et_Valor2)
        rb_Sumar = findViewById(R.id.rb_Sumar)
        rb_Restar = findViewById(R.id.rb_Restar)
        rb_Multiplicar = findViewById(R.id.rb_Multiplicar)
        rb_Dividir = findViewById(R.id.rb_Dividir)
        tv_Resultado = findViewById(R.id.tv_Resultado)
        cb_Sumar = findViewById(R.id.cb_Sumar)
        cb_Restar = findViewById(R.id.cb_Restar)
        cb_Multiplicar = findViewById(R.id.cb_Multiplicar)
        cb_Dividir = findViewById(R.id.cb_Dividir)
        spinner1 = findViewById(R.id.spinner)

        val opciones = arrayOf("Seleccionar...","Sumar","Restar","Multiplicar","Dividir")
        val adaptador = ArrayAdapter(this,android.R.layout.simple_spinner_item,opciones)
        spinner1.adapter = adaptador
    }

    //metodo para el boton
    fun Calcular(Vista:View){
        val valor1_String = et_Valor1.text.toString()
        val valor2_String = et_Valor2.text.toString()

        val valor1_Int = Integer.parseInt(valor1_String)
        val valor2_Int = Integer.parseInt(valor2_String)

        val seleccion = spinner1.selectedItem.toString()

        var resultado = ""

        fun sumar(){
            val suma = valor1_Int + valor2_Int
            resultado = suma.toString()
            tv_Resultado.setText(resultado)
        }
        fun restar(){
            val restar = valor1_Int - valor2_Int
            resultado = restar.toString()
            tv_Resultado.setText(resultado)
        }
        fun multiplicar(){
            val multiplicar = valor1_Int * valor2_Int
            resultado = multiplicar.toString()
            tv_Resultado.setText(resultado)
        }
        fun dividir(){
            try {
                val dividir = valor1_Int / valor2_Int
                resultado = dividir.toString()
                tv_Resultado.setText(resultado)
            }catch (e:Exception){
                Toast.makeText(this,"No puedes dividir entre 0 $e",Toast.LENGTH_LONG).show()
            }finally {
                Toast.makeText(this,"Se ejecuto la operacion",Toast.LENGTH_LONG).show()
            }
        }

        //radio botons
        if(rb_Sumar.isChecked == true){
            sumar()
        }else if (rb_Restar.isChecked == true){
            restar()
        }else if (rb_Multiplicar.isChecked == true){
            multiplicar()
        }else if (rb_Dividir.isChecked == true){
            dividir()
        }

        //Check box
        if(cb_Sumar.isChecked == true){
            val suma = valor1_Int + valor2_Int
            resultado = "La suma es: "+suma+" / "
        }
        if(cb_Restar.isChecked == true){
            val resta = valor1_Int - valor2_Int
            resultado = resultado + "La resta es: "+resta+" / "
        }
        if(cb_Multiplicar.isChecked == true){
            val multiplicar = valor1_Int * valor2_Int
            resultado = resultado + "La multiplicacion es: "+multiplicar+" / "
        }
        if(cb_Dividir.isChecked == true){
            try {
                val dividir = valor1_Int / valor2_Int
                resultado = resultado + "La divicion es: " + dividir + " / "
            }catch (e:Exception){
                Toast.makeText(this,"El Error "+e,Toast.LENGTH_LONG).show()
            }
        }

        tv_Resultado.setText(resultado)

        //Spinner
        if(seleccion.equals("Sumar")){
            sumar()
        }else if(seleccion.equals("Restar")){
            restar()
        }else if(seleccion.equals("Multiplicar")){
            multiplicar()
        }else if(seleccion.equals("Dividir")){
            dividir()
        }


    }


}