package com.test.projectv3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class StaticPurchase extends AppCompatActivity {

    String score[] = {"Win","Lose"};
    float percentage[] = {50.0f, 50.0f};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_purchase);

        setupPieChart();
    }

    private void setupPieChart(){
        List<PieEntry> pieEntries = new ArrayList<>();
        for(int i = 0; i < percentage.length; i++){
            pieEntries.add(new PieEntry(percentage[i], score[i]));
        }

        PieDataSet dataSet = new PieDataSet(pieEntries, "Percentage");
        PieData data = new PieData(dataSet);
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        PieChart chart = (PieChart)findViewById(R.id.pieChart);
        chart.setData(data);
        chart.animateY(1000);
        chart.invalidate();
    }
}
