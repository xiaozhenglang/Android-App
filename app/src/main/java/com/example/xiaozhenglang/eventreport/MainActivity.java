package com.example.xiaozhenglang.eventreport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        ListView eventListView = (ListView) findViewById(R.id.event_list);
//        EventAdapter adapter = new EventAdapter(this);
//
//        eventListView.setAdapter(adapter);

    }


    private String[] getEventNames() {
        String[] names = {
                "Event1", "Event2", "Event3",
                "Event4", "Event5", "Event6",
                "Event7", "Event8", "Event9",
                "Event10", "Event11", "Event12"};
        return names;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Life cycle","We are onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Life cycle","We are onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Life cycle", "We are onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Life cycle","We are onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Life cycle", "We are onDestory");
    }




}
