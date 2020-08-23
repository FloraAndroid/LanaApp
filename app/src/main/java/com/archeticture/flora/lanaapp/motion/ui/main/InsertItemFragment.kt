package com.archeticture.flora.lanaapp.motion.ui.main

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.archeticture.flora.lanaapp.R
import com.archeticture.flora.lanaapp.motion.model.UserInfo
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.fragment_insert_item.*
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InsertItemFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InsertItemFragment : Fragment() {
    // TODO: Rename and change types of parameters
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    lateinit var editDate: TextInputEditText
    lateinit var editHour: TextInputEditText
    var datePickerDialog: DatePickerDialog? = null
    var timerPickerDialog: TimePickerDialog? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_insert_item, container, false)
        var calendar = Calendar.getInstance()
        editDate = view.findViewById<TextInputEditText>(R.id.inputDate)
        editHour = view.findViewById<TextInputEditText>(R.id.inputHour)
        editDate.inputType=InputType.TYPE_NULL
        editHour.inputType=InputType.TYPE_NULL
        val hour: Int = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        val minutes: Int = Calendar.getInstance().get(Calendar.MINUTE)
        context?.let {
            datePickerDialog = DatePickerDialog(
                it,
                OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    //var monthOfYearSt:String=(monthOfYear+1).toString()
                    val monthOfYearSt=when{
                        monthOfYear+1<10->"0${monthOfYear+1}"
                        else->"${monthOfYear+1}"
                    }

                    val dayOfMonthSt=when{
                        dayOfMonth<10->"0${dayOfMonth}"
                        else->"${dayOfMonth}"
                    }

                    editDate.setText("$dayOfMonthSt / ${(monthOfYearSt)} / $year")
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_YEAR)
            )

            timerPickerDialog =
                TimePickerDialog(this.context, OnTimeSetListener { view, hourOfDay, minute ->
                    editHour.setText("$hourOfDay:$minute")
                }, hour, minutes, true)

        }

        editDate.setOnClickListener {
            datePickerDialog?.show()

        }

        editHour.setOnClickListener {
            timerPickerDialog?.show()
        }

        var floatBtn = view.findViewById<FloatingActionButton>(R.id.insertAddButton)
        floatBtn.setOnClickListener {
            var userInfo = UserInfo(inputNameEdit.text.toString(), inputPhone.text.toString(),
            "${editDate.text.toString()} ${editHour.text.toString()}")
            userInfo.createUser()

        }




        return view
    }

    fun openTimePicker() {
//        if (v == btnDatePicker) {
//
//            // Get Current Date
//            final Calendar c = Calendar.getInstance();
//            mYear = c.get(Calendar.YEAR);
//            mMonth = c.get(Calendar.MONTH);
//            mDay = c.get(Calendar.DAY_OF_MONTH);
//
//
//            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
//                new DatePickerDialog.OnDateSetListener() {
//
//                    @Override
//                    public void onDateSet(DatePicker view, int year,
//                        int monthOfYear, int dayOfMonth) {
//
//                        txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
//
//                    }
//                }, mYear, mMonth, mDay);
//            datePickerDialog.show();
//        }
//        if (v == btnTimePicker) {
//
//            // Get Current Time
//            final Calendar c = Calendar.getInstance();
//            mHour = c.get(Calendar.HOUR_OF_DAY);
//            mMinute = c.get(Calendar.MINUTE);
//
//            // Launch Time Picker Dialog
//            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
//                new TimePickerDialog.OnTimeSetListener() {
//
//                    @Override
//                    public void onTimeSet(TimePicker view, int hourOfDay,
//                        int minute) {
//
//                        txtTime.setText(hourOfDay + ":" + minute);
//                    }
//                }, mHour, mMinute, false);
//            timePickerDialog.show();
//        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment InsertItemFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            InsertItemFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
            }
    }
}

