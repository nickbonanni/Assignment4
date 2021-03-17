package edu.temple.Assignment5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class SelectionActivity extends AppCompatActivity {

    GridView gridView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.select);

        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setNumColumns(3);

        textView = (TextView) findViewById(R.id.textInstructions);
        textView.setGravity(Gravity.CENTER);

        String[] quarterbacks = getResources().getStringArray(R.array.quarterbacks);

        int[] qbImageArray = new int[]{R.drawable.brady, R.drawable.brees2,
                R.drawable.mahomes, R.drawable.rodgers, R.drawable.watson2};

        QuarterbackAdapter adapter = new QuarterbackAdapter(this, quarterbacks, qbImageArray);

        gridView.setAdapter(adapter);

        Intent intent = new Intent(this, DisplayActivity.class);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                String qb = quarterbacks[position];
                intent.putExtra("QBNAME", qb);
                intent.putExtra("QBPOS", position);
                startActivity(intent);

            }
        });
    }
}