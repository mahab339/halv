package com.halv.picker;

import android.support.v7.app.AppCompatActivity;

/**
 * Extends FragmentActivity because we need .getSupportFragmentManager() method
 * in order to show picker.
 *
 * Created by mohabh on 7/9/15.
 */
public abstract class HPickerUpdatable extends AppCompatActivity {

    /**
     * Call back method called when user set the picker to a certain date or time
     *  i.e. senderActivity.updateOnPickerSet();
     * should contain code to update the view.
     */
    public abstract void updateOnPickerSet(HPicker updatedPicker);

}
