package com.halv.spinner;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

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

    private static int spinnerItemView = android.R.layout.simple_spinner_item;
    private static int spinnerView = android.R.layout.simple_spinner_dropdown_item;

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
        ArrayAdapter<String> adapterData = new ArrayAdapter<>(senderActivity, spinnerItemView, spinnerData);
        adapterData.setDropDownViewResource(spinnerView);
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
        ArrayAdapter<String> adapterData = new ArrayAdapter<>(senderActivity, HSpinner.spinnerItemView, spinnerData);
        adapterData.setDropDownViewResource(HSpinner.spinnerView);
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


    /**
     * set a custom layout to the spinner items
     * @param spinnerItemView i.e. R.layout.my_custom_spinner_item
     */
    public static void setSpinnerItemView(int spinnerItemView) {
        HSpinner.spinnerItemView = spinnerItemView;
    }

    /**
     * set a custom layout to the spinner view
     * @param spinnerView i.e. R.layout.my_custom_spinner
     */
    public static void setSpinnerView(int spinnerView) {
        HSpinner.spinnerView = spinnerView;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
