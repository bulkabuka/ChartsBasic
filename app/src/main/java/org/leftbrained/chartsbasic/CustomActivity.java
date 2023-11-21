package org.leftbrained.chartsbasic;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class CustomActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        ArrayList<Integer> steps = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            steps.add((int) (Math.random() * 10000));
        }
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < steps.size(); i++) {
            entries.add(new BarEntry(steps.get(i), i));
        }
        BarDataSet dataset = new BarDataSet(entries, "Шаги");
        ArrayList<String> labels = new ArrayList<>();
        for (int i = 0; i < steps.size(); i++) {
            labels.add("День " + (i + 1));
        }
        BarChart chart = new BarChart(this);
        BarData data = new BarData(labels, dataset);
        chart.setData(data);
        setContentView(chart);
        chart.setDescription("Количество шагов в месяц");
    }
}