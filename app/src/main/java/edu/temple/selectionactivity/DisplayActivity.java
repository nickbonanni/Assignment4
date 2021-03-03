package edu.temple.selectionactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {

    TextView qbName;
    ImageView qbImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        qbName = (TextView) findViewById(R.id.qbName);
        qbImage = (ImageView) findViewById(R.id.qbImage);

        ArrayList<String> nameArray = new ArrayList<String>();
        nameArray.add(getString(R.string.instructions));
        nameArray.add(getString(R.string.brady));
        nameArray.add(getString(R.string.brees));
        nameArray.add(getString(R.string.mahomes));
        nameArray.add(getString(R.string.rodgers));
        nameArray.add(getString(R.string.watson));

        int[] qbImageArray = new int[]{R.drawable.transparent_square, R.drawable.brady, R.drawable.brees,
                R.drawable.mahomes, R.drawable.rodgers, R.drawable.watson};

        Intent intent = getIntent();
        String qb = intent.getStringExtra("QBNAME");
        int pos = intent.getIntExtra("QBPOS", 0);

        qbName.setText(qb);
        qbImage.setImageResource(qbImageArray[pos]);

    }
}