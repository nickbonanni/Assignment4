package edu.temple.Assignment5;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.graphics.Color.WHITE;

public class QuarterbackAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> names;
    int[] images;

    public QuarterbackAdapter(Context context, ArrayList<String> names, int[] images) {
        this.context = context;
        this.names = names;
        this.images = images;
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setPadding(10,10,10,10);

        // Initializing text view
        TextView qbTextView = new TextView(context);
        qbTextView.setTextSize(23);
        qbTextView.setTextColor(WHITE);
        qbTextView.setText(names.get(position));
        qbTextView.setTypeface(null, Typeface.BOLD);

        // Initializing image
        ImageView qbImageView = new ImageView(context);
        qbImageView.setImageResource(images[position]);
        RelativeLayout.LayoutParams imageParams = new RelativeLayout.LayoutParams(600, 500);
        qbImageView.setLayoutParams(imageParams);

        // Adding center params
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.CENTER_IN_PARENT);

        relativeLayout.addView(qbImageView);
        relativeLayout.addView(qbTextView, lp);

        return relativeLayout;

    }
}
