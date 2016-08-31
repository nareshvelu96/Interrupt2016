package com.example.naresh.interrupt2016;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

/**
 * Created by Mathangi on 28-07-2016.
 */
public class transport extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.transport,container,false);
        //For font:-
        Button button= (Button) view.findViewById(R.id.search);
        Typeface fontRobo = Typeface.createFromAsset(getActivity().getAssets(),"fonts/Caviar_Dreams_Bold.ttf");
        button.setTypeface(fontRobo);

        AutoCompleteTextView autoCompleteTextView= (AutoCompleteTextView) view.findViewById(R.id.searchBar);
        Typeface fontRobo2 = Typeface.createFromAsset(getActivity().getAssets(),"fonts/Sansation-Regular.ttf");
        autoCompleteTextView.setTypeface(fontRobo2);

        return view;
    }
}
