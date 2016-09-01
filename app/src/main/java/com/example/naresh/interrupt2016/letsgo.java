package com.example.naresh.interrupt2016;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.zxing.integration.android.IntentIntegrator;

/**
 * Created by Mathangi on 28-07-2016.
 */
public class letsgo extends Fragment {
    View rootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.letsgo, container, false);
        Button bt = (Button) rootView.findViewById(R.id.btn);
        Typeface fontRobo1 = Typeface.createFromAsset(getActivity().getAssets(),"fonts/Roboto-Medium.ttf");
        bt.setTypeface(fontRobo1);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if (Values.is_loggedin){
                    Intent i = new Intent(getActivity().getApplicationContext(), QRinfo.class);
                    i.putExtra("tag","main");
                    startActivity(i);
                }
                else {
                    Intent i = new Intent(getActivity().getApplicationContext(), Login.class);
                    i.putExtra("tag", "update");
                    startActivity(i);
                }
            }

        });
        return rootView;


    }
}
