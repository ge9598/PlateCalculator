package com.example.platecalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.function.Consumer;

public class MainActivity extends AppCompatActivity {
    private EditText edtPlate45;
    private EditText edtPlate35;
    private EditText edtPlate25;
    private EditText edtPlate10;
    private EditText edtPlate5;
    private EditText edtplate2_5;
    private EditText edtplate1_25;
    private Button btnSave;
    private Button btnNext;

    public static final String SP_NAME = "PlateInfo";
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
        setContentView(R.layout.activity_main);
        edtPlate45 = findViewById(R.id.plates45);
        edtPlate35 = findViewById(R.id.plates35);
        edtPlate25 = findViewById(R.id.plates25);
        edtPlate10 = findViewById(R.id.plates10);
        edtPlate5 = findViewById(R.id.plates5);
        edtplate2_5 = findViewById(R.id.plates2_5);
        edtplate1_25 = findViewById(R.id.plates1_25);

        edtPlate45.setInputType(InputType.TYPE_CLASS_NUMBER);
        edtPlate35.setInputType(InputType.TYPE_CLASS_NUMBER);
        edtPlate25.setInputType(InputType.TYPE_CLASS_NUMBER);
        edtPlate10.setInputType(InputType.TYPE_CLASS_NUMBER);
        edtPlate5.setInputType(InputType.TYPE_CLASS_NUMBER);
        edtplate2_5.setInputType(InputType.TYPE_CLASS_NUMBER);
        edtplate1_25.setInputType(InputType.TYPE_CLASS_NUMBER);

        btnSave = findViewById(R.id.btnSave);
        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveInfo();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveInfo();
                Intent intent = new Intent(getApplicationContext(), CalculateActivity.class);
                startActivity(intent);
            }
        });






    }
    private void saveInfo(){
        int plate45 = Integer.parseInt(edtPlate45.getText().toString());
        int plate35 = Integer.parseInt(edtPlate35.getText().toString());
        int plate25 = Integer.parseInt(edtPlate25.getText().toString());
        int plate10 = Integer.parseInt(edtPlate10.getText().toString());
        int plate5 = Integer.parseInt(edtPlate5.getText().toString());
        int plate2_5 = Integer.parseInt(edtplate2_5.getText().toString());
        int plate1_25 = Integer.parseInt(edtplate1_25.getText().toString());


        SharedPreferences prefInfo = getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefInfo.edit();
        editor.putInt(PLATE_45, plate45);
        editor.putInt(PLATE_35, plate35);
        editor.putInt(PLATE_25, plate25);
        editor.putInt(PLATE_10, plate10);
        editor.putInt(PLATE_5, plate5);
        editor.putInt(PLATE_2_5, plate2_5);
        editor.putInt(PLATE_1_25, plate1_25);
        editor.apply();
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences prefInfo = getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        int plate45 = Integer.parseInt(prefInfo.getString(PLATE_45, getResources().getString(R.string.Plate45)));
        int plate35 = Integer.parseInt(prefInfo.getString(PLATE_35, getResources().getString(R.string.Plate35)));
        int plate25 = Integer.parseInt(prefInfo.getString(PLATE_25, getResources().getString(R.string.Plate25)));
        int plate10 = Integer.parseInt(prefInfo.getString(PLATE_10, getResources().getString(R.string.Plate10)));
        int plate5 = Integer.parseInt(prefInfo.getString(PLATE_5, getResources().getString(R.string.Plate5)));
        int plate2_5 = Integer.parseInt(prefInfo.getString(PLATE_2_5, getResources().getString(R.string.Plate2_5)));
        int plate1_25 = Integer.parseInt(prefInfo.getString(PLATE_1_25, getResources().getString(R.string.Plate1_25)));
        edtPlate45.setText(plate45);
        edtPlate35.setText(plate35);
        edtPlate25.setText(plate25);
        edtPlate10.setText(plate10);
        edtPlate5.setText(plate5);
        edtplate2_5.setText(plate2_5);
        edtplate1_25.setText(plate1_25);
    }
}
