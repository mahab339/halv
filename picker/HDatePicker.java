package com.halv.picker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.widget.DatePicker;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by mohabh on 7/8/15.
 */
public class HDatePicker {

    /**
     * date holder for what the user pick.
     * initially points to the current time in the default time zone with the default locale.
     */
    private Calendar pickedDate = new GregorianCalendar();

    public static HPickerUpdatable senderActivity;

    public HDatePicker(HPickerUpdatable senderActivity){
        this.senderActivity = senderActivity;
    }


    public void showHDatePickerDialog() {
        DialogFragment newFragment = new HDatePickerFragment();
        newFragment.show(senderActivity.getSupportFragmentManager(), "datePicker");
    }

    public Calendar getPickedDate() {
        return pickedDate;
    }

    private void setPickedDate(Calendar pickedDate) {
        this.pickedDate = pickedDate;
    }


    /**
     */
    @SuppressLint("ValidFragment")
    public class HDatePickerFragment extends DialogFragment implements
            DatePickerDialog.OnDateSetListener {

        /**
         * Method onCreateDialog.
         *
         * @param savedInstanceState
         * Bundle
         * @return Dialog
         */

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            setRetainInstance(true);

            // Use the current date as the default date in the picker
            final Calendar c = pickedDate;
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(senderActivity, this, year, month, day);
        }

        /**
         * Method onDateSet.
         *
         * @param view
         * DatePicker
         * @param year
         * int
         * @param month
         * int
         * @param day
         * int
         *
         */
        public void onDateSet(DatePicker view, int year, int month, int day) {
            Calendar c = new GregorianCalendar(year,month,day);
            pickedDate = c;
            senderActivity.updateOnPickerSet();
        }


    }
}
