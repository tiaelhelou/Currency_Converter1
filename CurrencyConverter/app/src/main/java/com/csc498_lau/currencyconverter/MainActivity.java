/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                                                                 *
 * Name: Tia El Helou                                                              *
 * Id: 202002154                                                                   *
 * course: CSC498                                                                  *
 * Date Last Modified: 4/2/2022                                                    *
 * Program Description: An android app that convert USD to LBP and vice versa.     *
 *                      Note that 1$ = 22,000 LBP rate                             *
 *                                                                                 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

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
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usd = (EditText) findViewById(R.id.usd);
        lbp = (EditText) findViewById(R.id.lbp);
        output = (TextView) findViewById(R.id.output);
    }

    public void convert (View v) {

        // Reading input from the user
        String input_usd_string = usd.getText().toString();
        String input_lbp_string = lbp.getText().toString();

        try {

            // If the user want to convert from USD to LBP
            if ( (input_lbp_string.equals("") || input_lbp_string.equals("0")) && (!input_usd_string.equals("") && !input_usd_string.equals("0")) ) {

                int input_usd = Integer.parseInt(input_usd_string);

                int usd_to_lbp = input_usd * 22000;

                String result = input_usd + " USD = " + usd_to_lbp + " LBP";

                output.setText(result); // Changing the TextView to the result of the conversion
            }

            // If the user want to convert from LBP to USD
            else if ( (input_usd_string.equals("") || input_usd_string.equals("0")) && (!input_lbp_string.equals("") && !input_lbp_string.equals("0")) ) {

                int input_lbp = Integer.parseInt(input_lbp_string);

                int lbp_to_usd = input_lbp / 22000;

                String result = input_lbp + " LBP = " + lbp_to_usd + " USD";

                output.setText(result); // Changing the TextView to the result of the conversion
            }

            // If the user did not input any number
            else if ( (input_lbp_string.equals("") || input_lbp_string.equals("0")) && (input_usd_string.equals("0") || input_usd_string.equals("")) ) {

                // Printing an message on the screen
                Toast.makeText(getApplicationContext(), "You need to enter a number in one of the fields above!", Toast.LENGTH_LONG).show();
            }

            // If the user input numbers in the two EditText (USD and LBP)
            else {

                // Printing an message on the screen
                Toast.makeText(getApplicationContext(), "Please enter a number in only one of the fields above!", Toast.LENGTH_LONG).show();
            }

        } catch (NumberFormatException e) { //Catching the error if the user input a character instead of a number

            // Printing an message on the screen
            Toast.makeText(getApplicationContext(), "Please enter a valid number!", Toast.LENGTH_LONG).show();
        }
    }
}