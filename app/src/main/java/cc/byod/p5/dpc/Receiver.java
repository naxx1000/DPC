package cc.byod.p5.dpc;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Receiver extends DeviceAdminReceiver {

    public void onEnabled(Context context, Intent intent){
        Toast.makeText(context,R.string.policiesactive,Toast.LENGTH_LONG).show();
    }

    public void onDisabled(Context context, Intent intent){
        Toast.makeText(context,R.string.policiesinactive,Toast.LENGTH_LONG).show();
    }

}
