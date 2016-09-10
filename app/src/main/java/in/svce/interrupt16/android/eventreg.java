package in.svce.interrupt16.android;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

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

        // For setting fonts:-
        Switch s1= (Switch) view.findViewById(R.id.mybcb);
        Typeface fontRobo1 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Sansation-Regular.ttf");
        s1.setTypeface(fontRobo1 );

        Switch s2= (Switch) view.findViewById(R.id.tabcb);
        Typeface fontRobo2 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Sansation-Regular.ttf");
        s2.setTypeface(fontRobo2 );

        Switch s3= (Switch) view.findViewById(R.id.syncb);
        Typeface fontRobo3 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Sansation-Regular.ttf");
        s3.setTypeface(fontRobo3 );

        Switch s4= (Switch) view.findViewById(R.id.tricb);
        Typeface fontRobo4 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Sansation-Regular.ttf");
        s4.setTypeface(fontRobo4 );

        Switch s5= (Switch) view.findViewById(R.id.bombcb);
        Typeface fontRobo5 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Sansation-Regular.ttf");
        s5.setTypeface(fontRobo5 );

        Switch s6= (Switch) view.findViewById(R.id.dumbcb);
        Typeface fontRobo6 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Sansation-Regular.ttf");
        s6.setTypeface(fontRobo6 );

        Switch s7= (Switch) view.findViewById(R.id.paper);
        Typeface fontRobo7 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Sansation-Regular.ttf");
        s7.setTypeface(fontRobo7 );

        Switch s8= (Switch) view.findViewById(R.id.cfcb);
        Typeface fontRobo8 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Sansation-Regular.ttf");
        s8.setTypeface(fontRobo8 );

        Switch s9= (Switch) view.findViewById(R.id.thcb);
        Typeface fontRobo9 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Sansation-Regular.ttf");
        s9.setTypeface(fontRobo9 );

        TextView textView= (TextView) view.findViewById(R.id.event_heading);
        Typeface fontRobo10 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Sansation-Regular.ttf");
        textView.setTypeface(fontRobo10);



        final Button button = (Button) view.findViewById(R.id.register);
        Typeface fontRobo11 = Typeface.createFromAsset(getActivity().getAssets(),"fonts/Roboto-Medium.ttf");
        button.setTypeface(fontRobo11);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call function to push event booleans onto database

            }

        });
return view;
    }

}
