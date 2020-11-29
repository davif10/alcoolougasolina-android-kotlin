package com.daviprojetos.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcularPreco(view: View){

        //Recuperar valores digitados
        //val precoAlcool = findViewById<EditText>(R.id.editPrecoAlcool)
        val precoAlcool = editPrecoAlcool.text.toString()
        val precoGasolina = editPrecoGasolina.text.toString()

        val validaCampos = validarCampos(precoAlcool,precoGasolina)
        if(validaCampos){
            calcularMelhorPreco(precoAlcool,precoGasolina)

        }else{
            textResultado.text = "Preencha os preços primeiro!"
        }

    }

    fun calcularMelhorPreco(precoAlcool:String , precoGasolina:String){

        //Converter valores String para numeros
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        /*
            Faz o cálculo(precoAlcool / precoGasolina)
            Se resultado >= 0.7 melhor utilizar gasolina
            senão melhor utilizar Álcool
         */
        val resultadoPreco = valorAlcool/valorGasolina

        if(resultadoPreco >= 0.7){
            //textResultado.setText("Melhor usar Gasolina.")
            textResultado.text = "Melhor utilizar Gasolina!"

        }else{
            //textResultado.setText("Melhor usar Álcool.")
            textResultado.text = "Melhor utilizar Álcool!"
        }

    }

    fun validarCampos(precoAlcool:String , precoGasolina:String):Boolean{

        var camposValidados : Boolean = true
        if(precoAlcool == null || precoAlcool.equals("")){
            camposValidados = false
        }else if(precoGasolina == null || precoGasolina.equals("")){
            camposValidados = false
        }

        return camposValidados

    }
}