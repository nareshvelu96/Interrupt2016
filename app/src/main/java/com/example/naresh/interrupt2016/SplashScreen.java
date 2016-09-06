package com.example.naresh.interrupt2016;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

/**
 * Created by Mathangi on 05-09-2016.
 */
public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.interrupt1);
        float lengthbmp = bitmap.getHeight();
        float widthbmp = bitmap.getWidth();

        // Get Screen width
        DisplayMetrics displaymetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        float hight = displaymetrics.heightPixels / 3;
        float width = displaymetrics.widthPixels / 3;

        int convertHighet = (int) hight, convertWidth = (int) width;

        // high length
        if (lengthbmp > hight) {
            convertHighet = (int) hight - 20;
            bitmap = Bitmap.createScaledBitmap(bitmap, convertWidth,
                    convertHighet, true);
        }

        // high width
        if (widthbmp > width) {
            convertWidth = (int) width - 20;
            bitmap = Bitmap.createScaledBitmap(bitmap, convertWidth,
                    convertHighet, true);
        }
        finish();
    }


}
