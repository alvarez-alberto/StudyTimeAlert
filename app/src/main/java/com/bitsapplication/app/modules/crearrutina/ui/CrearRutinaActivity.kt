package com.bitsapplication.app.modules.crearrutina.ui


import android.os.Bundle
import android.widget.TextView
import com.bitsapplication.app.R
import com.bitsapplication.app.appcomponents.base.BaseActivity
import com.bitsapplication.app.databinding.ActivityCrearRutinaBinding
import kotlin.String
import kotlin.Unit

class CrearRutinaActivity : BaseActivity<ActivityCrearRutinaBinding>(R.layout.activity_crear_rutina)
    {

      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val textViews = listOf(
          findViewById<TextView>(R.id.txtFrame325),
          findViewById<TextView>(R.id.txtFrame326),
          findViewById<TextView>(R.id.txtFrame327),
          findViewById<TextView>(R.id.txtFrame328),
          findViewById<TextView>(R.id.txtFrame329),
          findViewById<TextView>(R.id.txtFrame330),
          findViewById<TextView>(R.id.txtFrame331)
        )

        for (textView in textViews) {
          textView.setOnClickListener {
            toggleTextViewStyle(textView)
          }
        }

      }

      private fun toggleTextViewStyle(textView: TextView) {
        val currentStyle = textView.typeface.style
        val newStyle = if (currentStyle == R.style.txtSolidRounded) {
          R.style.txtSolidRounded_1 // Cambia al estilo txtSolidRounded_1
        } else {
          R.style.txtSolidRounded // Cambia al estilo txtSolidRounded
        }
        textView.setTextAppearance(newStyle)
        textView.invalidate()
      }

  override fun onInitialized(): Unit {

  }

  override fun setUpClicks(): Unit {
    binding.tobBarCrearRutina.setNavigationOnClickListener( {finish()})
  }

  companion object {
    const val TAG: String = "CREAR_RUTINA_ACTIVITY"

  }
}
