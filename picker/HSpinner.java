package com.halv.picker;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.ahalha.androidapp.R;

import java.util.ArrayList;

/**
 * Created by mohabh on 7/9/15.
 * <p/>
 * An object HSpinner contains selectedPosition and selectedItem at any point of time.
 */

public class HSpinner implements AdapterView.OnItemSelectedListener {

    private ArrayList<String> spinnerData;

    private String selectedItem;
    private int selectedPosition = 0;

    /**
     * Constructor
     *
     * @param senderActivity, the activity that instantiate this object, usually (this)
     * @param spinner,        the spinner to be filled
     * @param spinnerData,    data to be filled in spinner
     */
    public HSpinner(Activity senderActivity, Spinner spinner,
                    ArrayList<String> spinnerData) {
        this.spinnerData = spinnerData;
        // Creating adapter for spinner
        ArrayAdapter<String> adapterData = new ArrayAdapter<>(senderActivity, android.R.layout.simple_spinner_item, spinnerData);
        adapterData.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(adapterData);
        spinner.setSelection(0);
        this.selectedItem = spinnerData.get(0);
        spinner.setOnItemSelectedListener(this);
    }


    /**
     * Constructor with listener provided
     *
     * @param senderActivity, the activity that instantiate this object, usually (this)
     * @param spinner,        the spinner to be filled
     * @param spinnerData,    data to be filled in spinner
     * @param l,              spinner listener
     */
    public HSpinner(Activity senderActivity, Spinner spinner,
                    ArrayList<String> spinnerData, AdapterView.OnItemSelectedListener l) {
        this.spinnerData = spinnerData;
        // Creating adapter for spinner
        ArrayAdapter<String> adapterData = new ArrayAdapter<>(senderActivity, android.R.layout.simple_spinner_item, spinnerData);
        adapterData.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(adapterData);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(l);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.selectedItem = spinnerData.get(position);
        this.selectedPosition = position;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public int getSelectedPosition() {
        return selectedPosition;
    }

    public ArrayList<String> getSpinnerData() {
        return spinnerData;
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
