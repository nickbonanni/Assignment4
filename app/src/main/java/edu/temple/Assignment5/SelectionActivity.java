package edu.temple.Assignment5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.select);

        spinner = (Spinner) findViewById(R.id.spinner);

        ArrayList<String> nameArray = new ArrayList<String>();
        nameArray.add(getString(R.string.instructions));
        nameArray.add(getString(R.string.brady));
        nameArray.add(getString(R.string.brees));
        nameArray.add(getString(R.string.mahomes));
        nameArray.add(getString(R.string.rodgers));
        nameArray.add(getString(R.string.watson));

        int[] qbImageArray = new int[]{R.drawable.transparent_square, R.drawable.brady, R.drawable.brees,
                R.drawable.mahomes, R.drawable.rodgers, R.drawable.watson};

        QuarterbackAdapter adapter = new QuarterbackAdapter(this, nameArray, qbImageArray);

        spinner.setAdapter(adapter);

        Intent intent = new Intent(this, DisplayActivity.class);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position > 0) {

                    String qb = nameArray.get(position);
                    intent.putExtra("QBNAME", qb);
                    intent.putExtra("QBPOS", position);
                    startActivity(intent);
                    spinner.setSelection(0);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing. This should never happen.
            }

        });
    }
}