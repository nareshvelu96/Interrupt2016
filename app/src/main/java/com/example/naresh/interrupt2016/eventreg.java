package com.example.naresh.interrupt2016;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Mathangi on 28-07-2016.
 */
public class eventreg extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.eventreg,container,false);


        if (!Values.is_loggedin) {
            Intent intent = new Intent(getActivity(), Login.class);
            startActivity(intent);
        }
        final Button button = (Button) view.findViewById(R.id.register);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call function to push event booleans onto database

            }

        });
return view;
    }
}
