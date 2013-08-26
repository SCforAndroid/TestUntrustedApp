package org.scforandroid.testuntrustedapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnLaunchremoteContactsManager = (Button) findViewById(R.id.btnLaunchremoteContactsManager);
        btnLaunchremoteContactsManager.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                launchRemoteContactsManager();
            }
        });

        final Button btnLaunchOwnContactsManager = (Button) findViewById(R.id.btnOwnContactsManager);
        btnLaunchOwnContactsManager.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                launchOwnContactsManager();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void launchRemoteContactsManager() {
        try {
            Intent intent = new Intent("org.scforandroid.TestContainerApp.TestAction1");
            startService(intent);
        }
        catch (SecurityException exception) {
            Toast.makeText(getApplicationContext(),
                    "Failed to launch remote contacts manager because of a security exception: " + exception.getMessage(),
                    Toast.LENGTH_LONG);
        }
    }

    private void launchOwnContactsManager() {
        try {
            Intent intent = new Intent(this, ContactManagerActivity.class);
            startActivity(intent);
        }
        catch (SecurityException exception) {
            Toast.makeText(getApplicationContext(),
             "Failed to launch own contacts manager because of a security exception: " + exception.getMessage(),
             Toast.LENGTH_LONG);
        }
    }
}
