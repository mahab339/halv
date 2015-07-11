# halv
A wrapper around most common Android features. Aims to apply ["coding by convention"](https://en.wikipedia.org/wiki/Convention_over_configuration) principle. In a way that "decreases the number of decisions that developers need to make, gaining simplicity, but not necessarily losing flexibility."
<br>

## HNotification
### Setup
In the launcher activity `onCreate()` method
```
HNotification.setupsetupHNotification(getApplicationContext(), this.getClass());
```
### Methods usage in HNotification
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
