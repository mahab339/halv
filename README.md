# halv
Android Helpers

##Setup
In the launcher activity `onCreate()` method
```
Helper.setupsetupHNotification(getApplicationContext(), this.getClass());
```
## HNotification
 *`displayToastNotification(message)` to display a toast notification with the provided message.
 *`displayNotification(title, message)` to display a normal notification, if the user clicks it, the application will launch from the launcher activity.
 *`simpleAlert(this, title, message)` to display a simple alert with an OK button.
 *`confirmationAlert(this, title, message, actionOnConfirm, actionOnDecline)` to display a confirmation message. `actionOnConfirm` will be executed if the user clicks OK. `actionOnDecline` will be executed if the user clicks Cancel.<br>
 Example of OnClickListener
 ```
 OnClickListener onDeleteConfirm = new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int whichButton) {
try {
Session.currentUserRoomActivityFacade
.deleteEventRoom(roomIndex);
startActivityForResult(new Intent(ViewRoom.this,
Rooms.class), 0);
} catch (Exception e) {
Helper.simpleAlert(ViewRoom.this, "error",
e.getMessage());
}
}
};

Helper.confirmationAlert(this, "Confirm Deletion",
"Are you sure you want to delete this room?",
onDeleteConfirm, null); //null means on decline don't do anything.
```

This code will delete the object and move to another activity `Rooms.class`, but since the deletion may raise an exception, there is a try-catch clause, and in the catch; a simple alert will be displayed to the user with the exception message.
