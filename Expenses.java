package edu.lewisu.cs.miguelabarboza.budgetproject;

import java.util.UUID;

/**
 * Created by miguelbarboza on 3/31/16.
 */
public class Expenses {

    private UUID id;
    private float amountSpent;
    protected String expenseCategory;

    public Expenses(){
        id = UUID.randomUUID();
        amountSpent = 0;
        expenseCategory = "";
    }

    public Expenses(float amountSpent,String expenseCategory){
        id = UUID.randomUUID();
        this.amountSpent = amountSpent;
        this.expenseCategory = expenseCategory;
    }

    public UUID getId() {
        return id;
    }

    public float getAmountSpent() {
        return amountSpent;
    }

    public void setAmountSpent(float amountSpent) {
        this.amountSpent = amountSpent;
    }

    public String getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }
}
