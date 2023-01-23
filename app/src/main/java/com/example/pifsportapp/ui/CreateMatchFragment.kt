package com.example.pifsportapp.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pifsportapp.R
import com.example.pifsportapp.ViewModel.MatchViewModel
import com.example.pifsportapp.adapter.MatchCreatedAdapter
import com.example.pifsportapp.adapter.MatchDetailsAdapter
import com.example.pifsportapp.data.MatchCreatedData
import com.example.pifsportapp.data.UserData
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*






class CreateMatchFragment : BottomSheetDialogFragment() {
    private lateinit var ivCalendar: ImageView
    private lateinit var matchList: MutableList<MatchCreatedData>
    //lateinit var matchCreatedAdapter: MatchCreatedAdapter
   // lateinit var matchRV: RecyclerView

    private lateinit var ivClock: ImageView
    private lateinit var clockTV: TextView
    private lateinit var btnCreate: Button
    private lateinit var LocationET: EditText
    private lateinit var date: String
    private lateinit var time: String
    private lateinit var location: String
    private lateinit var matchDateTV: TextView
    private lateinit var matchTimeTV: TextView
  //  private lateinit var scaleUp: Animation

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val VM = ViewModelProvider(this).get(MatchViewModel::class.java)

        ivCalendar = view.findViewById(R.id.iv_calender)
        matchDateTV = view.findViewById(R.id.tv_date)
        matchTimeTV = view.findViewById(R.id.tv_time)
        clockTV = view.findViewById(R.id.tv_time)
        btnCreate = view.findViewById(R.id.btn_create)
        LocationET = view.findViewById(R.id.et_location)
        ivClock = view.findViewById(R.id.iv_clock)



        //TODO  matchList= MutableList()

        val calendar = Calendar.getInstance()
        // add day of month
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)

        val current = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val createdDate = current.format(formatter)

        val TimePicker: TimePickerDialog
        val mcurrentTime = Calendar.getInstance()
        val hour = mcurrentTime.get(Calendar.HOUR_OF_DAY)
        val minute = mcurrentTime.get(Calendar.MINUTE)



        ivCalendar.setOnClickListener() {

            /*  GlobalScope.launch {
                 ivCalendar.startAnimation(scaleUp)
                 delay(300)
             }*/
            val datePickerDialog = DatePickerDialog(view.context, { _, y, m, d ->
                date = "$y-${m + 1}-$d"

                matchDateTV.setText(date)

            }, year, month, day)
            datePickerDialog.datePicker.minDate = calendar.timeInMillis

            datePickerDialog.show()
        }


        TimePicker = TimePickerDialog(context, object : TimePickerDialog.OnTimeSetListener {
            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                time = String.format("%d : %d", hourOfDay, minute)
                clockTV.setText(time)
            }
        }, hour, minute, false)

        clockTV.setOnClickListener {
            TimePicker.show()
        }


        btnCreate.setOnClickListener {
            if (matchDateTV.text.isNotEmpty() || clockTV.text.isNotEmpty() || LocationET.text.isNotEmpty()) {
                val match = MatchCreatedData(
                    date = matchDateTV.text.toString(),
                    time= clockTV.text.toString(),
                    location = LocationET.text.toString(),
                    created_date = createdDate.toString(),
                )
                Toast.makeText(context, "Task is added successfully", Toast.LENGTH_SHORT)
                    .show()
                VM.insertMatch(match)
                findNavController().popBackStack()
                // findNavController().navigate(R.id.action_addFragment_to_taskFragment)
            } else {
                Toast.makeText(context, "Please Enter Match details", android.widget.Toast.LENGTH_SHORT)
                    .show()
            }
            // on below line we are adding data to our list
            matchList.add(MatchCreatedData(id, date, time, location, createdDate))

             findNavController().popBackStack()


        }
    }
}
