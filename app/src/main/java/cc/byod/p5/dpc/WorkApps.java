package cc.byod.p5.dpc;

import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;

public class WorkApps extends AppCompatActivity {

    PackageInstaller packageInstaller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_apps);

    }

    public void InstallKoala(View view){
        String fileName = Environment.getExternalStorageDirectory() + "/WrappedApps/Koala_app-release-wrapped.apk";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(new File(fileName)), "application/vnd.android.package-archive");
        startActivity(intent);
    }

    public void InstallChat(View view){
        String fileName = Environment.getExternalStorageDirectory() + "/WrappedApps/CHAT_app-release-wrapped.apk";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(new File(fileName)), "application/vnd.android.package-archive");
        startActivity(intent);
    }
}
