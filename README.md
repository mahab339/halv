# halv
A wrapper around most common Android features. Aims to make using these features by applying ["coding by convention"](https://en.wikipedia.org/wiki/Convention_over_configuration) principle, with a little of design patterns.
<br>

## Package `com.halv.picker`
###HDatePicker
Utility for managing and showing date pickers<br>
Example:
```

//the Activity CreateEvent must extends HPickerUpdatable
public class CreateEvent extends HPickerUpdatable {

  //holders for start and end dates of the event
  private HDatePicker startDate = new HDatePicker(this);
  private HDatePicker endDate = new HDatePicker(this);

  //the callback method responsible for showing the date picker fragment to the user
  public void showStartDatePicker(View view) {
        startDate.showHDatePickerDialog();
    }

  //updating the view when a date gets updated
  @Override
   public void updateOnPickerSet(HPicker updatedPicker) {
     String date = updatedPicker.getFormattedPickedDate("yyyy-MM-dd");
     //checking which date is updated, and update its layout element (EditTex in this case)
       if(updatedPicker == startDate)
          ((EditText) findViewById(R.id.startDate)).setText(date);
       else if(updatedPicker == endDate)
          ((EditText) findViewById(R.id.endDate)).setText(date);
   }

   //sending the picked date to the controller
   public void createEvent(View view){
     Calendar startDate = startDate.getPickedDate();
     Calendar endDate = endDate.getPickedDate();
     //the rest of the method
   }
}
```
## Package `com.halv.spinner`
###HSpinner
Utility for managing drop-down menus AKA spinners<br>
* Spinner without listener<br>
Example:
```
ArrayList<String> spinnerData = new ArrayList<>(Arrays.asList("item1", "item2", "item3"));
Spinner spinner = (Spinner) findViewById(R.id.exampleSpinner);
exampleSpinner = new HSpinner(this, spinner, spinnerData);
```

* Spinner with a listener<br>
Another constructor that accepts [AdapterView.OnItemSelectedListener](http://developer.android.com/reference/android/widget/AdapterView.OnItemSelectedListener.html) listener as a forth argument. This listener will be a callback for `OnItemSelected`.
<br><br>
* Accessing Spinner selected position/item<br>
`int selectedPos = exampleSpinner.getSelectedPosition();`<br>
`String selectedItem = exampleSpinner.getSelectedItem();`



## Package `com.halv.notification`
###HNotification
Utility for showing notifications
#### Setup
In the launcher activity `onCreate()` method
```
HNotification.setupsetupHNotification(getApplicationContext(), this.getClass());
```
#### Methods usage in HNotification
 * `HNotification.displayToastNotification(message)` to display a toast notification with the provided message.
 * `HNotification.displayNotification(title, message)` to display a normal notification. If the user clicks it, the application will launch from the launcher activity.
 * `HNotification.simpleAlert(this, title, message)` to display a simple alert with an OK button.
 * `HNotification.confirmationAlert(this, title, message, actionOnConfirm, actionOnDecline)` to display a confirmation message.<br> `actionOnConfirm` will be executed if the user clicks OK. `actionOnDecline` will be executed if the user clicks Cancel.<br>
 *Example of OnClickListener*

 ```
 //preparing the action listener to be passed to confirmationAlert
 OnClickListener onDeleteConfirm = new DialogInterface.OnClickListener() {
 	public void onClick(DialogInterface dialog, int whichButton) {
 			Session.currentUserRoomActivityFacade.deleteEventRoom(roomIndex);
 			startActivityForResult(new Intent(ViewRoom.this,
 			Rooms.class), 0);
 	}
 };


 HNotification.confirmationAlert(this, "Confirm Deletion",
 	"Are you sure you want to delete this room?",
    onDeleteConfirm, null); //null means on decline don't do anything.
```

This code will delete the object and move to another activity `Rooms.class`.


##TODO
* com.halv.picker.HTimePicker
* ListView
