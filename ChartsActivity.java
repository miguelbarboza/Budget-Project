package edu.lewisu.cs.miguelabarboza.budgetproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

public class ChartsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charts);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("allExpenses");
        float personal = bundle.getFloat("personal");
        float fun = bundle.getFloat("fun");
        float work = bundle.getFloat("work");
        float food = bundle.getFloat("food");
        float commute = bundle.getFloat("commute");
        float bills = bundle.getFloat("bills");


        GraphView graph = (GraphView) findViewById(R.id.graph);

        graph.getGridLabelRenderer().setLabelsSpace(10);

        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
        staticLabelsFormatter.setHorizontalLabels(new String[]{"Per", "Fun",
                "Work", "Food", "Com", "Bills"});
        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);


        BarGraphSeries<DataPoint> series = new BarGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(1, personal),
                new DataPoint(2, fun),
                new DataPoint(3, work),
                new DataPoint(4, food),
                new DataPoint(5, commute),
                new DataPoint(6, bills)
        });



        graph.setTitle("Expenses");
        graph.addSeries(series);


        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX() * 255 / 4, (int) Math.abs(data.getY() * 255 / 6), 100);
            }
        });



        series.setSpacing(45);

        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.BLUE);

        backToMainMenu();
    }

    private void backToMainMenu() {

        Button expenseButton = (Button) findViewById(R.id.chartsButton);
        expenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }


        });
    }


}