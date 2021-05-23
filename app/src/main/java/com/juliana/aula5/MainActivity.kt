package com.juliana.aula5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var posicao: EditText? = null
    lateinit var resultado: TextView
    lateinit var mostrar: Button
    var sequenciauser = LongArray(100)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        posicao = findViewById(R.id.edtFibo)
        resultado = findViewById(R.id.txtResultado)
        mostrar = findViewById(R.id.btnFibo)

        mostrar.setOnClickListener {

            val Posicao = posicao?.text.toString()
            if (Posicao.isEmpty()) {
                posicao?.error = "Digite uma posição válida"
            }
            val NumSeq = Posicao.toInt()

            var pos1 : Long = 1
            var pos2 : Long = 1
            var soma : Long= 0

            if (NumSeq == 0)
                resultado.text = "Essa posição não existe."
            else {
                if (NumSeq == 1) {
                    sequenciauser[1] = 1

                } else if (NumSeq == 2) {
                    sequenciauser[1] = 1
                    sequenciauser[2] = 1

                } else {

                    sequenciauser[1] = 1
                    sequenciauser[2] = 1

                    val Seq = NumSeq - 2
                    for (x in 1..Seq) {

                        soma = pos1 + pos2
                        pos1 = pos2
                        pos2 = soma
                        sequenciauser[x+2] = soma

                    }

                }

                resultado.visibility = View.VISIBLE

                var exibir = ""
                var y : Long = 0

                for (x in 1..NumSeq) {
                    y = sequenciauser[x]
                    exibir += " $y "
                }
                resultado.text  = exibir

            }

        }
    }

}