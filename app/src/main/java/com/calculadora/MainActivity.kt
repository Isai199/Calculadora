package com.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var  binding:ActivityMainBinding
    var firtValue: Double = 0.0
    var operator: Char = '0'
    override fun onCreate(savedInstanceState: Bundle?) {
        //por defecto
        super.onCreate(savedInstanceState)
        //agregar esto nuevo
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        //esto ya estaba por defecto(remplazar por el nuevo xml "view")
        setContentView(view)

        //formas para llamar un elemento
        //forma 1, por id
        val miBoton: Button = findViewById<Button>(R.id.btn0)

        //forma por binding
        binding.btn0.setOnClickListener{
            //Toast.makeText(this, "ejemplo", Toast.LENGTH_SHORT).show()
            binding.etCalulations.text.clear()
        }

        binding.btnDelete.setOnClickListener{
            binding.etCalulations.setText(binding.etCalulations.text.dropLast(1))
        }

        binding.btnEqual.setOnClickListener{
            when(operator){
                '+' -> { binding.etCalulations.setText("${firtValue + binding.etCalulations.text.toString().toDouble()}") }
                'x' -> { binding.etCalulations.setText("${firtValue * binding.etCalulations.text.toString().toDouble()}") }
                '÷' -> { binding.etCalulations.setText("${firtValue / binding.etCalulations.text.toString().toDouble()}") }
                '-' -> { binding.etCalulations.setText("${firtValue - binding.etCalulations.text.toString().toDouble()}") }
                else -> binding.etCalulations.setText("ERROR")

            }
            operator = '0'
        }

        binding.btnPorsentaje.setOnClickListener{
            //TODO ejemplo propina 200+10% = 220

            binding.etCalulations.setText( porcentage(operator))
        }


    }
    fun porcentage(operatorToUse: Char) : String{
        when(operatorToUse){
            '+' -> {return "${firtValue + (firtValue*binding.etCalulations.text.toString().toDouble()/100)}"}
            '-' -> {return "${firtValue - (firtValue*binding.etCalulations.text.toString().toDouble()/100)}"}
            '0' -> {return "${binding.etCalulations.text.toString().toDouble()}"}
            else -> { return  "Error"}
        }
    }

    fun getOperator(view: View){
        val button = view as Button
        //forma 1
        operator = button.text.get(0)
        //forma 2
        /*
        operator = when(button.id){
            binding.btnDivision.id -> {'÷'}
            binding.btnMultiplicacion.id -> {'x'}
            binding.btnSuma.id -> {'+'}
            binding.btnResta.id -> {'-'}
            else -> { '0' }
        }*/

        firtValue = binding.etCalulations.text.toString().toDouble()
        binding.etCalulations.text.clear()


    }

    fun numberButtonClicked(view: View){
        //castear vista a boton
        val button = view as Button

        if(button.id.equals(binding.btnDecimal.id) ){
            if( !binding.etCalulations.text.contains('.')){
                binding.etCalulations.text.append(button.text)
            }
        }else{
            binding.etCalulations.text.append(button.text)
        }

        /*when(button.id){
            binding.btnDecimal.id -> {
                if(binding.etCalulations.text.contains('.')){
                    binding.etCalulations.text.append('.')
                }
            }
            binding.btn0.id  -> { binding.etCalulations.text.append('0')}
            binding.btn1.id -> { binding.etCalulations.text.append('1')}
            binding.btn2.id -> { binding.etCalulations.text.append('2')}
            binding.btn3.id -> { binding.etCalulations.text.append('3')}
            binding.btn4.id -> { binding.etCalulations.text.append('4')}
            binding.btn5.id -> { binding.etCalulations.text.append('5')}
            binding.btn6.id -> { binding.etCalulations.text.append('6')}
            binding.btn7.id -> { binding.etCalulations.text.append('7')}
            binding.btn8.id -> { binding.etCalulations.text.append('8')}
            binding.btn9.id -> { binding.etCalulations.text.append('9')}

        }*/
    }
}