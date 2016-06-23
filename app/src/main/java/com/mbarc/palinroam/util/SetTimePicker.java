package com.mbarc.palinroam.util;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Admin on 6/21/2016.
 */
public class SetTimePicker implements View.OnFocusChangeListener, TimePickerDialog.OnTimeSetListener {
    private EditText editText;
    private Calendar myCalendar;
    Context context;

    public SetTimePicker( Context context,EditText editText) {
        this.editText = editText;
        this.context=context;
        this.editText.setOnFocusChangeListener(this);
        myCalendar = Calendar.getInstance();
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(hasFocus){
            new TimePickerDialog(context, this, myCalendar
                    .get(Calendar.HOUR_OF_DAY), myCalendar.get(Calendar.MINUTE),
                    true).show();
        }
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        myCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        myCalendar.set(Calendar.MINUTE, minute);
        editText.setText(hourOfDay +"  :  "+ minute);

    }
}
