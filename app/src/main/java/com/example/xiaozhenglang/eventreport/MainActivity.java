package com.example.xiaozhenglang.eventreport;



import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity implements EventFragment.OnItemSelected {
    private EventFragment mListFragment;
    private CommentFragment mGridFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Show different fragments based on screen size.
        Log.e("Life Cycle","onCreate();");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hello world");


    }


    private boolean isTablet() {
        return (getApplicationContext().getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_LARGE;
    }


    @Override
    public void onItemSeleted(int position) {
        mGridFragment.onItemSelected(position);
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
