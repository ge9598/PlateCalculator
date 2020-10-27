package com.example.platecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class CalculateActivity extends AppCompatActivity {
    private static final String TAG = "debug";
    EditText edtUser1;
    EditText edtUser2;
    EditText edtUser3;
    EditText edtOutput1;
    EditText edtOutput2;
    EditText edtOutput3;
    EditText edtBar1;
    EditText edtBar2;
    EditText edtBar3;
    Button btnSave;
    Button btnAddFive;

    String plate45;
    String plate35;
    String plate25;
    String plate10;
    String plate5;
    String plate2_5;
    String plate1_25;

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

        edtBar1 = findViewById(R.id.Bar1);
        edtBar2 = findViewById(R.id.Bar2);
        edtBar3 = findViewById(R.id.Bar3);

        edtOutput1 = findViewById(R.id.Output1);
        edtOutput2 = findViewById(R.id.Output2);
        edtOutput3 = findViewById(R.id.Output3);

        btnSave = findViewById(R.id.btnSave1);
        btnAddFive = findViewById(R.id.btnaddFiveToAll);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takeInput();
            }
        });
    }
    private void takeInput(){
        try {
            double target1 = Double.parseDouble(edtUser1.getText().toString());
            double target2 = Double.parseDouble(edtUser2.getText().toString());
            double target3 = Double.parseDouble(edtUser3.getText().toString());
            String ans1 = calculatePlates(target1 - Double.parseDouble(edtBar1.getText().toString()));
            String ans2 = calculatePlates(target2 - Double.parseDouble(edtBar2.getText().toString()));
            String ans3 = calculatePlates(target3 - Double.parseDouble(edtBar3.getText().toString()));
            edtOutput1.setText(ans1);
            edtOutput2.setText(ans2);
            edtOutput3.setText(ans3);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "One of the field is invalid, please check again!", Toast.LENGTH_SHORT).show();
        }

    }
    private String calculatePlates(double target){
        StringBuilder sb = new StringBuilder();
        HashMap<String, Double> map = new HashMap<>();
        map.put(PLATE_45, Double.parseDouble(plate45));
        map.put(PLATE_35, Double.parseDouble(plate35));
        map.put(PLATE_25, Double.parseDouble(plate25));
        map.put(PLATE_10, Double.parseDouble(plate10));
        map.put(PLATE_5, Double.parseDouble(plate5));
        map.put(PLATE_2_5, Double.parseDouble(plate2_5));
        map.put(PLATE_1_25, Double.parseDouble(plate1_25));
        HashMap<String, Double> weight = new HashMap<>();
        weight.put(PLATE_45, 45.0);
        weight.put(PLATE_35, 35.0);
        weight.put(PLATE_25, 25.0);
        weight.put(PLATE_10, 10.0);
        weight.put(PLATE_5, 5.0);
        weight.put(PLATE_2_5, 2.5);
        weight.put(PLATE_1_25, 1.25);
        String[] plateValue = new String[]{
                PLATE_45, PLATE_35, PLATE_25, PLATE_10, PLATE_5, PLATE_2_5, PLATE_1_25
        };

        int index = 0;

        while(index < plateValue.length){
                if(target == weight.get(plateValue[index]) * 2 ){
                    sb.append(" 2 * " + plateValue[index]);
                    return sb.toString();
                }
                else if(target - weight.get(plateValue[index]) * 2 < 0){
                    // this plate is too much for the weight
                    index++;
                }else{
                    if(map.get(plateValue[index]) <= 0){
                        index++;
                        continue;
                    }
                    target -= weight.get(plateValue[index]) * 2;
                    map.put(plateValue[index], map.get(plateValue[index]) - 2);
                    sb.append(" 2 * " + plateValue[index] + " + ");

                }
            }

        return new String("not happening");
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences prefInfo = getSharedPreferences(MainActivity.SP_NAME, Context.MODE_PRIVATE);
         plate45 = prefInfo.getString(PLATE_45, null);
         plate35 = prefInfo.getString(PLATE_35, null);
         plate25 = prefInfo.getString(PLATE_25, null);
         plate10 = prefInfo.getString(PLATE_10, null);
         plate5 = prefInfo.getString(PLATE_5, null);
         plate2_5 = prefInfo.getString(PLATE_2_5, null);
         plate1_25 = prefInfo.getString(PLATE_1_25, null);
        Toast.makeText(getApplicationContext(), plate45 + plate35 + plate25 + plate10 + plate5, Toast.LENGTH_SHORT).show();


    }
}
