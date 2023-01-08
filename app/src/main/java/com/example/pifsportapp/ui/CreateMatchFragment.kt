package com.example.pifsportapp.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.*
import androidx.navigation.fragment.findNavController
import com.example.pifsportapp.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*






class CreateMatchFragment : BottomSheetDialogFragment() {
    private lateinit var ivCalendar: ImageView
    private lateinit var ivClock: ImageView
    private lateinit var tvClock: TextView
    private lateinit var btnCreat: Button
    private lateinit var etLocation: EditText
    private lateinit var date: String
    private lateinit var matchDate: TextView
    private lateinit var matchTime: TextView
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

        ivCalendar = view.findViewById(R.id.iv_calender)
        matchDate = view.findViewById(R.id.tv_date)
        matchTime = view.findViewById(R.id.tv_time)
        tvClock = view.findViewById(R.id.tv_time)

        val calendar = Calendar.getInstance()
        // add day of month
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)


        ivCalendar.setOnClickListener() {

            /*  GlobalScope.launch {
                 ivCalendar.startAnimation(scaleUp)
                 delay(300)
             }*/
            val datePickerDialog = DatePickerDialog(view.context, { _, y, m, d ->
                date = "$y-${m + 1}-$d"

                matchDate.setText(date)

            }, year, month, day)
            datePickerDialog.datePicker.minDate = calendar.timeInMillis

            datePickerDialog.show()

        }

        ivClock = view.findViewById(R.id.iv_clock)

        val mTimePicker: TimePickerDialog
        val mcurrentTime = Calendar.getInstance()
        val hour = mcurrentTime.get(Calendar.HOUR_OF_DAY)
        val minute = mcurrentTime.get(Calendar.MINUTE)

        mTimePicker = TimePickerDialog(context, object : TimePickerDialog.OnTimeSetListener {
            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                tvClock.setText(String.format("%d : %d", hourOfDay, minute))
            }
        }, hour, minute, false)

        ivClock.setOnClickListener {
            mTimePicker.show()
        }


        /*    ivClock.setOnClickListener() {
         mTimePicker = TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener {
                 override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                 }
             selectedTime.setText(String.format("%d : %d", hourOfDay, minute))
              }
            }, hour, minute, false)

   }
   */


        etLocation = view.findViewById(R.id.et_location)
        btnCreat = view.findViewById(R.id.btn_create)

        btnCreat.setOnClickListener {
            //TODO


        }
    }
}
