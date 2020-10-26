package com.example.platecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculateActivity extends AppCompatActivity {
    EditText edtUser1;
    EditText edtUser2;
    EditText edtUser3;
    Button btnSave;
    Button btnAddFive;
    public static final String PLATE_45 = "PLATE_45";
    public static final String PLATE_35 = "PLATE_35";
    public static final String PLATE_25 = "PLATE_25";
    public static final String PLATE_10 = "PLATE_10";
    public static final String PLATE_5 = "PLATE_5";
    public static final String PLATE_2_5 = "PLATE_2_5";
    public static final String PLATE_1_25 = "PLATE_1_25";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        edtUser1 = findViewById(R.id.User1);
        edtUser2 = findViewById(R.id.User2);
        edtUser3 = findViewById(R.id.User3);
        btnSave = findViewById(R.id.btnSave1);
        btnAddFive = findViewById(R.id.btnaddFiveToAll);

    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences prefInfo = getSharedPreferences(MainActivity.SP_NAME, Context.MODE_PRIVATE);
        String plate45 = prefInfo.getString(PLATE_45, null);
        String plate35 = prefInfo.getString(PLATE_35, null);
        String plate25 = prefInfo.getString(PLATE_25, null);
        String plate10 = prefInfo.getString(PLATE_10, null);
        String plate5 = prefInfo.getString(PLATE_5, null);
        String plate2_5 = prefInfo.getString(PLATE_2_5, null);
        String plate1_25 = prefInfo.getString(PLATE_1_25, null);
        Toast.makeText(getApplicationContext(), plate45 + plate35 + plate25 + plate10 + plate5, Toast.LENGTH_SHORT).show();


    }
}
