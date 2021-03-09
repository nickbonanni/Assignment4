package edu.temple.Assignment5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.select);

        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setNumColumns(3);

        ArrayList<String> nameArray = new ArrayList<String>();
        nameArray.add(getString(R.string.brady));
        nameArray.add(getString(R.string.brees));
        nameArray.add(getString(R.string.mahomes));
        nameArray.add(getString(R.string.rodgers));
        nameArray.add(getString(R.string.watson));

        int[] qbImageArray = new int[]{R.drawable.brady, R.drawable.brees2,
                R.drawable.mahomes, R.drawable.rodgers, R.drawable.watson2};

        QuarterbackAdapter adapter = new QuarterbackAdapter(this, nameArray, qbImageArray);

        gridView.setAdapter(adapter);

        Intent intent = new Intent(this, DisplayActivity.class);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                String qb = nameArray.get(position);
                intent.putExtra("QBNAME", qb);
                intent.putExtra("QBPOS", position);
                startActivity(intent);

            }
        });
    }
}