package com.bitsapplication.app.modules.sesiondeestudio.ui

import android.app.AlertDialog
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.bitsapplication.app.R
import com.bitsapplication.app.appcomponents.base.BaseActivity
import com.bitsapplication.app.databinding.ActivitySesionDeEstudioBinding
import kotlin.String
import kotlin.Unit

class SesionDeEstudioActivity : BaseActivity<ActivitySesionDeEstudioBinding>(R.layout.activity_sesion_de_estudio) {

  private lateinit var minutosButtonFocus: AppCompatButton
  private lateinit var segundosButtonFocus: AppCompatButton
  private lateinit var minutosButtonDescanso: AppCompatButton
  private lateinit var segundosButtonDescanso: AppCompatButton

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    minutosButtonFocus = findViewById(R.id.focus_btn_minutos)
    segundosButtonFocus = findViewById(R.id.focus_btn_segundos)
    minutosButtonDescanso = findViewById(R.id.descanso_btn_minutos)
    segundosButtonDescanso = findViewById(R.id.descanso_btn_segundos)

    minutosButtonFocus.setOnClickListener {
      showNumberInputDialog(minutosButtonFocus)
    }

    segundosButtonFocus.setOnClickListener {
      showNumberInputDialog(segundosButtonFocus)
    }

    minutosButtonDescanso.setOnClickListener {
      showNumberInputDialog(minutosButtonDescanso)
    }

    segundosButtonDescanso.setOnClickListener {
      showNumberInputDialog(segundosButtonDescanso)
    }
  }

  private fun showNumberInputDialog(button: AppCompatButton) {
    val builder = AlertDialog.Builder(this)
    builder.setTitle("Ingrese un número entre 0 y 60")

    val input = EditText(this)
    input.inputType = InputType.TYPE_CLASS_NUMBER
    builder.setView(input)

    builder.setPositiveButton("Aceptar") { dialog, _ ->
      val userInput = input.text.toString()
      if (userInput.isNotEmpty() && userInput.matches(Regex("\\d+"))) {
        val number = userInput.toInt()
        if (number in 0..60) {
          button.text = String.format("%02d", number) // Formatea el número como dos dígitos
        } else {
          // Muestra un mensaje de error si el número está fuera del rango
          Toast.makeText(this, "El número debe estar entre 0 y 60", Toast.LENGTH_SHORT).show()
        }
      } else {
        // Muestra un mensaje de error si no se ingresó un número válido
        Toast.makeText(this, "Ingrese un número válido", Toast.LENGTH_SHORT).show()
      }
      dialog.dismiss()
    }

    builder.setNegativeButton("Cancelar") { dialog, _ ->
      dialog.cancel()
    }

    builder.show()
  }

  override fun onInitialized(): Unit {

  }

  override fun setUpClicks(): Unit {
    binding.topAppBarAlarmas.setNavigationOnClickListener( {finish()})
  }


  companion object {
    const val TAG: String = "SESION_DE_ESTUDIO_ACTIVITY"

  }
}
