package edu.temple.Assignment5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    TextView qbName;
    ImageView qbImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        setTitle(R.string.display);

        qbName = (TextView) findViewById(R.id.qbName);
        qbImage = (ImageView) findViewById(R.id.qbImage);

        int[] qbImageArray = new int[]{R.drawable.brady, R.drawable.brees2,
                R.drawable.mahomes, R.drawable.rodgers, R.drawable.watson2};

        Intent intent = getIntent();
        String qb = intent.getStringExtra("QBNAME");
        int pos = intent.getIntExtra("QBPOS", 0);

        qbName.setText(qb);
        qbName.setGravity(Gravity.CENTER);
        qbImage.setImageResource(qbImageArray[pos]);

    }
}