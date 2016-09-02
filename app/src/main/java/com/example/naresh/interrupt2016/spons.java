package com.example.naresh.interrupt2016;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Mathangi on 28-07-2016.
 */
public class spons extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.sponsors,container,false);

        TextView textView = (TextView) view.findViewById(R.id.spons1);
        Typeface fontRobo1 = Typeface.createFromAsset(getActivity().getAssets(),"fonts/Caviar_Dreams_Bold.ttf");
        textView.setTypeface(fontRobo1);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setTextColor(Color.parseColor("#FFFFFF"));

        TextView textView2 = (TextView) view.findViewById(R.id.spons2);
        Typeface fontRobo2 = Typeface.createFromAsset(getActivity().getAssets(),"fonts/Caviar_Dreams_Bold.ttf");
        textView2.setTypeface(fontRobo2);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setTextColor(Color.parseColor("#FFFFFF"));

        return view;
    }
}
