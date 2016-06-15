package edu.lewisu.cs.miguelabarboza.budgetproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ExpensesActivity extends AppCompatActivity {

    EditText editTextExpense;
    Expenses expenses;
    CheckBox personalCheckBox;
    CheckBox commuteCheckBox;
    CheckBox billsCheckBox;
    CheckBox funCheckBox;
    CheckBox workCheckBox;
    CheckBox foodCheckBox;
    List<Expenses> items = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        editTextExpense = (EditText)findViewById(R.id.moneySpent);

        personalCheckBox = (CheckBox)findViewById(R.id.personalCheckBox);
        commuteCheckBox = (CheckBox)findViewById(R.id.commuteCheckBox);
        billsCheckBox = (CheckBox)findViewById(R.id.billsCheckBox);
        funCheckBox = (CheckBox)findViewById(R.id.funCheckBox);
        workCheckBox = (CheckBox)findViewById(R.id.workCheckBox);
        foodCheckBox = (CheckBox)findViewById(R.id.foodCheckBox);


        backToMainMenu();
    }

    public void backToMainMenu() {


        final Button expenseButton = (Button)findViewById(R.id.addExpenseSecondScreen);
        expenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedCheckBox = "";


                if (personalCheckBox.isChecked()) {
                    selectedCheckBox = personalCheckBox.getText().toString();
                }
                if (commuteCheckBox.isChecked()) {
                    selectedCheckBox = commuteCheckBox.getText().toString();
                }
                if (billsCheckBox.isChecked()) {
                    selectedCheckBox = billsCheckBox.getText().toString();
                }
                if (funCheckBox.isChecked()) {
                    selectedCheckBox = funCheckBox.getText().toString();
                }
                if (workCheckBox.isChecked()) {
                    selectedCheckBox = workCheckBox.getText().toString();
                }
                if (foodCheckBox.isChecked()) {
                    selectedCheckBox = foodCheckBox.getText().toString();
                }


                try {
                    float expense = Float.parseFloat(editTextExpense.getText().toString());
                    expenses = new Expenses(expense, selectedCheckBox);
                    Intent intent = getIntent();
                    intent.putExtra("expense", expense);
                    intent.putExtra("checkBoxText", selectedCheckBox);
                    setResult(RESULT_OK, intent);
                    items.add(expenses);

                    finish();
                }catch (Exception e){
                    Toast toast = Toast.makeText(ExpensesActivity.this,"Please enter a valid entry",
                            Toast.LENGTH_LONG);

                    toast.show();
                }


            }
        });
    }


}
