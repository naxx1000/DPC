package cc.byod.p5.dpc;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PolicyManager extends AppCompatActivity {

    ComponentName DeviceAdmin;
    ComponentName DeviceProfile;
    DevicePolicyManager DPM;
    TextView isAdminActive;
    Button enableAdminButton;
    Button enablePoliciesButton;
    Button disableAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy_manager);
        isAdminActive = (TextView)findViewById(R.id.textViewActive);
        enableAdminButton = (Button)findViewById(R.id.button7);
        enablePoliciesButton = (Button)findViewById(R.id.button);
        disableAdmin = (Button)findViewById(R.id.button3);

        DPM = (DevicePolicyManager)getSystemService(Context.DEVICE_POLICY_SERVICE);
        DeviceAdmin = new ComponentName(this,Receiver.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (AdminActive()) {
            isAdminActive.setText(R.string.policiesactive);
            disableAdmin.setVisibility(View.VISIBLE);
            enableAdminButton.setVisibility(View.INVISIBLE);
            enablePoliciesButton.setVisibility(View.VISIBLE);
        } else {
            isAdminActive.setText(R.string.policiesinactive);
            disableAdmin.setVisibility(View.INVISIBLE);
            enableAdminButton.setVisibility(View.VISIBLE);
            enablePoliciesButton.setVisibility(View.INVISIBLE);
        }
    }

    private boolean AdminActive(){
        return DPM.isAdminActive(DeviceAdmin);
    }

    public void AdminEnable(View view){
        Intent intentDeviceAdmin = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        intentDeviceAdmin.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, DeviceAdmin);
        intentDeviceAdmin.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, getString(R.string.explanation));
        startActivity(intentDeviceAdmin);
    }

    public void PolicyEnable(View view){

        DPM.setCameraDisabled(DeviceAdmin,true);
        DPM.setPasswordQuality(DeviceAdmin,DevicePolicyManager.PASSWORD_QUALITY_SOMETHING);

        // Requests a password change if there is none
        if(!DPM.isActivePasswordSufficient()){
            Intent intent = new Intent(DevicePolicyManager.ACTION_SET_NEW_PASSWORD);
            startActivity(intent);
        }

        Toast.makeText(this, "Policies are active", Toast.LENGTH_LONG).show();
    }

    public void PolicyDisable(View view){
        DPM.removeActiveAdmin(DeviceAdmin);
        finish();
    }
}
