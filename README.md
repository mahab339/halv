# halv
Android, with many design patterns applied and used, provides a great flexiblity for developer, you can litraly control *almost* every thing in your application. But this flexbility comes in the way when you want kickstart developing.<br> Halv **(L is not silent)**  provides one place for the most common features and building blocks, so you can start developing using default values and then change or add these defaults on a later stage of the developing process. 
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
 OnClickListener onDeleteConfirm = new DialogInterface.OnClickListener() {
 	public void onClick(DialogInterface dialog, int whichButton) {
 		try {
 			Session.currentUserRoomActivityFacade.deleteEventRoom(roomIndex);
 			startActivityForResult(new Intent(ViewRoom.this,
 			Rooms.class), 0);
 		} catch (Exception e) {
 			Helper.simpleAlert(ViewRoom.this, "error",
 			e.getMessage());
 		}
 	}
 };

 HNotification.confirmationAlert(this, "Confirm Deletion",
 	"Are you sure you want to delete this room?",
    onDeleteConfirm, null); //null means on decline don't do anything.
```

This code will delete the object and move to another activity `Rooms.class`, but since the deletion may raise an exception, there is a try-catch clause, and in the catch; a simple alert will be displayed to the user with the exception message.
