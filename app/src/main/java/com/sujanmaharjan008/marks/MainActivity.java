package com.sujanmaharjan008.marks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sujanmaharjan008.marks.Methods.CalculatePercentage;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtName, edtAPI, edtAndroid, edtIPC;
    private Button btnInsert;
    private TextView txtData;
    private String name;
    private int marksAPI, marksAndroid, marksIPC, percentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtAPI = findViewById(R.id.edtAPI);
        edtAndroid = findViewById(R.id.edtAndroid);
        edtIPC = findViewById(R.id.edtIPC);
        btnInsert = findViewById(R.id.btnInsert);
        txtData = findViewById(R.id.txtData);

        btnInsert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnInsert) {
            name = edtName.getText().toString();
            marksAPI = Integer.parseInt(edtAPI.getText().toString());
            marksAndroid = Integer.parseInt(edtAndroid.getText().toString());
            marksIPC = Integer.parseInt(edtIPC.getText().toString());

            CalculatePercentage calper = new CalculatePercentage(marksAPI, marksAndroid, marksIPC);
            percentage = calper.Percentage();

            appendStuffs();

            edtName.getText().clear();
            edtAPI.getText().clear();
            edtAndroid.getText().clear();
            edtIPC.getText().clear();
            //Toast.makeText(this, name + " " + percentage, Toast.LENGTH_SHORT).show();
        }
    }
    private void appendStuffs(){
        txtData.append("Name: "+name +", Percentage: "+ Integer.toString(percentage)+ "\n");
    }
}
