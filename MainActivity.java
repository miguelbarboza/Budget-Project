package edu.lewisu.cs.miguelabarboza.budgetproject;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;


public class MainActivity extends Activity {
    TextView textView;
    private float currentBudget;
    private float personalExpense;
    private float commutingExpense;
    private float foodExpense;
    private float funExpense;
    private float workExpense;
    private float billsExpense;
    private NumberFormat format = NumberFormat.getCurrencyInstance();
    private static final int REQUEST_NUMBER = 2;
    private static final int REQUEST_NUMBER2 = 3;




    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.currentBudget);
        String gainString = format.format(currentBudget);
        textView.setText(gainString);




    }
    public void incomeClick(View v){

        Intent intent = new Intent(this,IncomeActivity.class);
        startActivityForResult(intent, REQUEST_NUMBER);
    }
    public void expenseClick(View v) {

        Intent intent = new Intent(this,ExpensesActivity.class);
        startActivityForResult(intent, REQUEST_NUMBER2);

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_NUMBER) {
                float cashEarned = data.getFloatExtra("income", 0);
                currentBudget += cashEarned;

                if (currentBudget > 0){
                    textView.setTextColor(ColorStateList.valueOf(0xff00ff00));
                }

                if (currentBudget == 0) {
                    textView.setTextColor(ColorStateList.valueOf(0xff000000));
                }

                String gainString = format.format(currentBudget);
                textView.setText(gainString);

            }
            String checkBoxValue = data.getStringExtra("checkBoxText");
            if (requestCode == REQUEST_NUMBER2) {
                if (checkBoxValue.equals("Personal")) {
                    float cashSpent = data.getFloatExtra("expense", 0);
                    currentBudget -= cashSpent;
                    personalExpense += cashSpent;
                }
                if (checkBoxValue.equals("Commute")){
                    float cashSpent = data.getFloatExtra("expense",0);
                    currentBudget -= cashSpent;
                    commutingExpense += cashSpent;
                }
                if (checkBoxValue.equals("Bills")){
                    float cashSpent = data.getFloatExtra("expense",0);
                    currentBudget -= cashSpent;
                    billsExpense += cashSpent;
                }
                if (checkBoxValue.equals("Fun")){
                    float cashSpent = data.getFloatExtra("expense",0);
                    currentBudget -= cashSpent;
                    funExpense += cashSpent;
                }
                if (checkBoxValue.equals("Work")){
                    float cashSpent = data.getFloatExtra("expense",0);
                    currentBudget -= cashSpent;
                    workExpense += cashSpent;
                }
                if (checkBoxValue.equals("Food")){
                    float cashSpent = data.getFloatExtra("expense",0);
                    currentBudget -= cashSpent;
                    foodExpense += cashSpent;
                }

                    if (currentBudget < 0) {
                        textView.setTextColor(ColorStateList.valueOf(0xffff0000));

                    }

                    if (currentBudget == 0) {
                        textView.setTextColor(ColorStateList.valueOf(0xff000000));
                    }

                    String gainString = format.format(currentBudget);
                    textView.setText(gainString);
                }

        }

    }
    public void chartClick(View v){

        Intent intent = new Intent(this,ChartsActivity.class);
        Bundle b = new Bundle();
        b.putFloat("personal",personalExpense);
        b.putFloat("commute",commutingExpense);
        b.putFloat("food",foodExpense);
        b.putFloat("fun",funExpense);
        b.putFloat("bills",billsExpense);
        b.putFloat("work",workExpense);
        intent.putExtra("allExpenses",b);
        startActivity(intent);
    }

    }


