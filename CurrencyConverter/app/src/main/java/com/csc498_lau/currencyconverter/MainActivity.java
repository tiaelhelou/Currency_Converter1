package com.csc498_lau.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usd;
    EditText lbp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usd = (EditText) findViewById(R.id.usd);
        lbp = (EditText) findViewById(R.id.lbp);
    }

    public void convert (View v) {

        String input_usd_string = usd.getText().toString();
        String input_lbp_string = lbp.getText().toString();

        if ( (input_lbp_string.equals("") || input_lbp_string.equals("0")) && (!input_usd_string.equals("") && !input_usd_string.equals("0")) ) {

            int input_usd = Integer.parseInt(input_usd_string);

            int usd_to_lbp = input_usd * 22000;

            String result = input_usd + " USD = " + usd_to_lbp + " LBP";

            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
        }

        else if ( (input_usd_string.equals("") || input_usd_string.equals("0")) && (!input_lbp_string.equals("") && !input_lbp_string.equals("0")) ) {

            int input_lbp = Integer.parseInt(input_lbp_string);

            int lbp_to_usd = input_lbp / 22000;

            String result = input_lbp + " LBP = " + lbp_to_usd + " USD";

            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
        }
    }
}