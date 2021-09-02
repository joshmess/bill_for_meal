/*
 * Author: Josh Messitte (811976008)
 * CSCI 4060: Mobile Software Development
 * Project 1: Bill For Meal
 * Java file for tip calculation activity.
 */

package edu.uga.cs.billformeal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import  android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // Widget Instance Variables
    private TextView per_person;
    private TextView tip_amount;
    private TextView tip_pp;
    private EditText bill_amt_view;
    private EditText num_people_view;

    // For formatting doubles
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Widgets
        per_person = findViewById(R.id.bill_totals);
        tip_amount = findViewById(R.id.tip_amount);
        bill_amt_view = findViewById(R.id.amountEditText);
        num_people_view = findViewById(R.id.peopleEditText);
        tip_pp = findViewById(R.id.tip_totals);
    }

    /*
    This method calculates the 10% option.
     */
    public void calculate(View v){

        double tip_percent = 0;
        // Figure out what button was pushed
        switch (v.getId()){
            case R.id.tip1:
                tip_percent = 0.10;
                break;
            case R.id.tip2:
                tip_percent = 0.15;
                break;
            case R.id.tip3:
                tip_percent = 0.18;
                break;
        }

        double pretip_cost = 0;
        if(!bill_amt_view.getText().toString().equals("")) {
            pretip_cost = Double.parseDouble(bill_amt_view.getText().toString());
        }
        double num_people = 0;
        if(num_people_view.getText().toString().equals("")) {
            num_people = 1.0;
        }else{
            num_people = Double.parseDouble(num_people_view.getText().toString());
        }
        // Split the bill
        double tip = tip_percent*pretip_cost;
        double total_cost = pretip_cost + tip;

        double individual_tip_total = tip/num_people;
        double individual_bill_cost = total_cost/num_people;

        // Set Text of Needed Widgets
        per_person.setText("Per Person: $" + df2.format(individual_bill_cost));
        tip_amount.setText("Tip Total: $" + df2.format(tip));
        tip_pp.setText("Tip Per Person: $" + df2.format(individual_tip_total));

    }
}