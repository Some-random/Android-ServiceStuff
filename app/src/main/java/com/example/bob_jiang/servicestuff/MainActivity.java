package com.example.bob_jiang.servicestuff;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView LV = new ListView(this);

        LV.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getData()));
        LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //arg1 here is the row number
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                switch (arg2) {
                    case 0:
                        Intent it0 = new Intent(MainActivity.this, IntentService.class);
                        startActivity(it0);
                        break;
                    case 1:
                        Intent it1 = new Intent(MainActivity.this, StartService.class);
                        startActivity(it1);
                        break;
                    case 2:
                        Intent it2 = new Intent(MainActivity.this, BindServiceLocal.class);
                        startActivity(it2);
                        break;
                    case 3:
                        Intent it3 = new Intent(MainActivity.this, BindServiceMessenger.class);
                        startActivity(it3);
                }
            }
        });
        setContentView(LV);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public ArrayList<String> getData() {
        ArrayList<String> ALS = new ArrayList<>();
        ALS.add("IntentService");
        ALS.add("StartSerivce");
        ALS.add("BindServiceLocal");
        ALS.add("MessengerService");
        return ALS;
    }
}
