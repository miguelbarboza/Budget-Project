package edu.lewisu.cs.miguelabarboza.budgetproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IncomeActivity extends AppCompatActivity {

    EditText editTextIncome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        editTextIncome = (EditText)findViewById(R.id.moneyEarned);


        Button incomeButton = (Button)findViewById(R.id.addIncomeScreen3);

        incomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    float income = Float.parseFloat(editTextIncome.getText().toString());
                    Intent intent = getIntent();
                    intent.putExtra("income", income);
                    setResult(RESULT_OK, intent);

                    finish();
                }catch(Exception e){
                    Toast toast = Toast.makeText(IncomeActivity.this,"Please enter a number", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
}