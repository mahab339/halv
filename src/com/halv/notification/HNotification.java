package com.halv.HNotification;

/**
 * Created by mohabh on 7/1/15.
 */
        import android.app.Activity;
        import android.app.AlertDialog;
        import android.app.NotificationManager;
        import android.app.PendingIntent;
        import android.app.TaskStackBuilder;
        import android.content.Context;
        import android.content.DialogInterface;
        import android.content.DialogInterface.OnClickListener;
        import android.content.Intent;
        import android.support.v4.app.NotificationCompat;
        import android.widget.Toast;


public class HNotification {

    private static Context  context;
    private static Class mainActivity;

    public static void setupHNotification(Context c, Class m){
        context = c;
        mainActivity = m;
    }

    public static void displayToastNotification(String message) {
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();

    }

    public static void displayNotification(String title, String message) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                context).setContentTitle(title).setContentText(message);
        // Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(context, mainActivity);

        // The stack builder object will contain an artificial back stack for
        // the
        // started Activity.
        // This ensures that navigating backward from the Activity leads out of
        // your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder
                .create(context);
        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(mainActivity);
        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,
                PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        // mId allows you to update the notification later on.
        mNotificationManager.notify(0, mBuilder.build());
    }

    public static void simpleAlert(Activity callingActivityObject,
                                   String title, String message) {
        new AlertDialog.Builder(callingActivityObject)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.yes,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                // Here for further actions on click
                            }
                        }).setIcon(android.R.drawable.ic_dialog_alert).show();
    }

    static boolean confirmationReply;

    public static boolean confirmationAlert(Activity callingActivityObject,
                                            String title, String message, OnClickListener actionOnConfirm,
                                            OnClickListener actionOnDecline) {
        confirmationReply = false;
        new AlertDialog.Builder(callingActivityObject).setTitle(title)
                .setMessage(message)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, actionOnConfirm)
                .setNegativeButton(android.R.string.no, actionOnDecline).show();
        return confirmationReply;
    }
}
