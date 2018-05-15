package com.example.xiaozhenglang.eventreport;



import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class MainActivity extends AppCompatActivity implements CommentFragment.OnItemSelected{
    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    private Button mSubmitButton;
    private Button mRegisterButton;
    private DatabaseReference mDatabase;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Show different fragments based on screen size.
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mUsernameEditText = findViewById(R.id.editTextLogin);
        mPasswordEditText = findViewById(R.id.editTextPassword);
        mSubmitButton = findViewById(R.id.submit);
        mRegisterButton = findViewById(R.id.register);

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String userName = mUsernameEditText.getText().toString();
                final String passWord = Utils.md5Encryption(mPasswordEditText.getText().toString());
                final User user = new User(userName, passWord, System.currentTimeMillis());
                mDatabase.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild(userName)) {
                            Toast.makeText(getBaseContext(), "username is already registered, please change one",
                            Toast.LENGTH_SHORT).show();
                        } else if (!userName.equals("") && !passWord.equals("")) {
                            mDatabase.child("users").child(user.getUsername()).setValue(user);
                            Toast.makeText(getBaseContext(), "Successfully registered", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });


        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String userName = mUsernameEditText.getText().toString();
                final String passWord = Utils.md5Encryption(mPasswordEditText.getText().toString());
                mDatabase.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild(userName) &&
                                passWord.equals(dataSnapshot.child(userName).child("password").getValue())) {
                            Log.i( " Your log", "You successfully login");
                        } else {
                            Toast.makeText(getBaseContext(),"Please login again", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });




    }


    @Override
    public void onItemSelected(int position) {
    }

    private boolean isTablet() {
        return (getApplicationContext().getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_LARGE;
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
