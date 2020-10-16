package com.example.template;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout scroll_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scroll_layout = (LinearLayout)findViewById(R.id.horizontal_scroll);
        fillLayout();
    }

    private void fillLayout() {
        ImageButton imageButton;

        for (int i = 0; i < MapDB.descriptions.length; i++) {
            Map map = new Map(MapDB.descriptions[i], MapDB.drawableIDs[i]);
            imageButton = new ImageButton(this);
            imageButton.setMaxHeight(300);
            imageButton.setMaxWidth(300);
            imageButton.setImageDrawable(getDrawable(map.getDrawableID()));
            imageButton.setContentDescription(map.getDescription());

            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String text = ((ImageButton) view).getContentDescription().toString();
                    Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                }
            });

            scroll_layout.addView(imageButton);

        }
    }
}