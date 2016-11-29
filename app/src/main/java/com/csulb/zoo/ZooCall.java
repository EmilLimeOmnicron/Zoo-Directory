package com.csulb.zoo;

/**
 * Created by Emil on 9/29/2016.
 */
import android.Manifest;
import android.app.Fragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import static android.content.Intent.ACTION_CALL;

public class ZooCall extends MainActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zooinfo);
    Button button = (Button) findViewById(R.id.button);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:888-8888"));
               try {
                   startActivity(phoneIntent);
               }
               catch(final SecurityException ex) {

                   }
        }
    }
    });
}

}