package com.bitsapplication.app.modules.alarmasyrutinas.ui

import android.content.Intent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.bitsapplication.app.R
import com.bitsapplication.app.appcomponents.base.BaseActivity
import com.bitsapplication.app.databinding.ActivityAlarmasYRutinasBinding
import com.bitsapplication.app.modules.alarmasyrutinas.data.model.GridtitleRowModel
import com.bitsapplication.app.modules.alarmasyrutinas.data.model.RowRutinasModel
import com.bitsapplication.app.modules.alarmasyrutinas.data.viewmodel.AlarmasYRutinasVM
import com.bitsapplication.app.modules.crearalarma.ui.CrearAlarmaActivity
import com.bitsapplication.app.modules.crearrutina.ui.CrearRutinaActivity
import com.bitsapplication.app.modules.sesiondeestudio.ui.SesionDeEstudioActivity
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton


class AlarmasYRutinasActivity :
    BaseActivity<ActivityAlarmasYRutinasBinding>(R.layout.activity_alarmas_y_rutinas) {

  private val viewModel: AlarmasYRutinasVM by viewModels<AlarmasYRutinasVM>()


  var mAddFab: ExtendedFloatingActionButton? = null
  var mAddAlarmFab: ExtendedFloatingActionButton? = null
  var mAddRutineFab: ExtendedFloatingActionButton? = null
  var mStudySessionFab: ExtendedFloatingActionButton? = null
  var addAlarmActionText: TextView? = null
  var addRutineActionText: TextView? = null
  var studySessionActionText: TextView? = null
  var isAllFabsVisible: Boolean? = null

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val alarmaAdapter = AlarmaAdapter(viewModel.gridtitleList.value?:mutableListOf())
    binding.recyclerAlarmas.adapter = alarmaAdapter
    alarmaAdapter.setOnItemClickListener(
    object : AlarmaAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : GridtitleRowModel) {
        onClickRecyclerGridtitle(view, position, item)
      }
    }
    )
    viewModel.gridtitleList.observe(this) {
      alarmaAdapter.updateData(it)
    }
    binding.alarmasYRutinasVM = viewModel
    val rutinaAdapter = RutinaAdapter(viewModel.rowRutinasList.value?:mutableListOf())
    binding.recyclerRutinas.adapter = rutinaAdapter
    rutinaAdapter.setOnItemClickListener(
      object : RutinaAdapter.OnItemClickListener {
        override fun onItemClick(view:View, position:Int, item : RowRutinasModel) {
          onClickRecyclerRowRutina(view, position, item)
        }
      }
    )
    viewModel.rowRutinasList.observe(this) {
      rutinaAdapter.updateData(it)
    }
    binding.alarmasYRutinasVM = viewModel

    // Register all the FABs with their IDs This FAB button is the Parent
    mAddFab = findViewById<ExtendedFloatingActionButton>(R.id.extended_fab)

    // FAB button
    mAddAlarmFab = findViewById<ExtendedFloatingActionButton>(R.id.add_alarm_fab)
    mAddRutineFab = findViewById<ExtendedFloatingActionButton>(R.id.add_rutine)
    mStudySessionFab = findViewById<ExtendedFloatingActionButton>(R.id.study_session)

    // Also register the action name text, of all the FABs.
    addAlarmActionText = findViewById<TextView>(R.id.add_alarm_action_text)
    addRutineActionText = findViewById<TextView>(R.id.add_rutine_action_text)
    studySessionActionText = findViewById<TextView>(R.id.study_session_text)


    mAddAlarmFab?.visibility = View.GONE
    mAddRutineFab?.visibility = View.GONE
    mStudySessionFab?.visibility = View.GONE

    addAlarmActionText?.visibility = View.GONE
    addRutineActionText?.visibility = View.GONE
    studySessionActionText?.visibility = View.GONE

    isAllFabsVisible = false

    mAddFab?.setOnClickListener(View.OnClickListener { view: View? ->
      isAllFabsVisible = if (!isAllFabsVisible!!) {

        mAddAlarmFab?.show()
        mAddRutineFab?.show()
        mStudySessionFab?.show()
        addAlarmActionText?.setVisibility(View.VISIBLE)
        addRutineActionText?.setVisibility(View.VISIBLE)
        studySessionActionText?.setVisibility(View.VISIBLE)

        true
      } else {

        mAddAlarmFab?.hide()
        mAddRutineFab?.hide()
        mStudySessionFab?.hide()
        addAlarmActionText?.setVisibility(View.GONE)
        addRutineActionText?.setVisibility(View.GONE)
        studySessionActionText?.setVisibility(View.GONE)

        false
      }
    })

    mAddRutineFab?.setOnClickListener(
      View.OnClickListener { view: View? ->
        irCrearRutina(view)
      })

    mAddAlarmFab?.setOnClickListener(
    View.OnClickListener { view: View? ->
      irCrearAlarma(view)
    })

    mStudySessionFab?.setOnClickListener(
      View.OnClickListener { view: View? ->
        irSesionEstudio(view)
      })
  }


  override fun setUpClicks(): Unit {
  }

  fun onClickRecyclerGridtitle(
    view: View,
    position: Int,
    item: GridtitleRowModel
  ): Unit {
    when(view.id) {
    }
  }

  fun onClickRecyclerRowRutina(
    view: View,
    position: Int,
    item: RowRutinasModel
  ): Unit {
    when(view.id) {
    }
  }

  fun irSesionEstudio(view: View?) {
    val intent = Intent(this, SesionDeEstudioActivity::class.java)
    startActivity(intent)
  }
  fun irCrearRutina(view: View?) {
    val intent = Intent(this, CrearRutinaActivity::class.java)
    startActivity(intent)
  }

  fun irCrearAlarma(view: View?) {
    val intent = Intent(this, CrearAlarmaActivity::class.java)
    startActivity(intent)
  }


  companion object {
    const val TAG: String = "ALARMAS_Y_RUTINAS_ACTIVITY"

  }
}
