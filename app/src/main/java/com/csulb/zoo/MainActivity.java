package com.csulb.zoo;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.app.FragmentTransaction;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    //ExampleFragment fragment = (ExampleFragment) getFragmentManager().findFragmentById(R.id.example_fragment); access fragment stuff

    String[] values = new String[]{"Tetsuya 2", "Happy", "Chopper", "Monokuma", "Kyubey"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
        ListView listview = (ListView) findViewById(R.id.list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                final Intent intent = new Intent(MainActivity.this, AnimalDetails.class);

                if (position == 4) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                    alertDialog.setTitle("Scary Animal Ahead");
                    alertDialog.setMessage("This is a very scary animal. Proceed?");
                    alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            intent.putExtra("name", "Kyubey");
                            intent.putExtra("descr", "Kyubey");
                            intent.putExtra("img", "Kyubey");
                            startActivity(intent);
                        }
                    })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            });
                    alertDialog.show();
                } else {
                    intent.putExtra("name",values[position]);
                    intent.putExtra("descr",values[position]);
                    intent.putExtra("img",values[position]);

                    startActivity(intent);
                }
            }
        });
    }



    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.info:
                Intent intent = new Intent(MainActivity.this, ZooCall.class);
                startActivity(intent);
                break;
            case R.id.uninstall:
                Uri packageURI = Uri.parse("package:com.csulb.zoo");
                Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
                startActivity(uninstallIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
