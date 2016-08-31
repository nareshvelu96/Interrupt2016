package com.example.naresh.interrupt2016;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.manuelpeinado.fadingactionbar.extras.actionbarcompat.FadingActionBarHelper;

/**
 * Created by Mathangi on 28-07-2016./
 */
public class aboutInterrupt extends Fragment  {
    private FadingActionBarHelper mFadingHelper;
    private Bundle mArguments;
    public static final String ARG_IMAGE_RES = "image_source";
    public static final String ARG_ACTION_BG_RES = "image_action_bs_res";

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = mFadingHelper.createView(inflater);

        //For font style:-
        TextView textView = (TextView) view.findViewById(R.id.about_title1);
        Typeface fontRobo1 = Typeface.createFromAsset(getActivity().getAssets(),"fonts/BOMBARD_.ttf");
        textView.setTypeface(fontRobo1);

        TextView textView2 = (TextView) view.findViewById(R.id.about_title2);
        Typeface fontRobo2 = Typeface.createFromAsset(getActivity().getAssets(),"fonts/BOMBARD_.ttf");
        textView2.setTypeface(fontRobo2);

        TextView textView3 = (TextView) view.findViewById(R.id.about_secondary1);
        Typeface fontRobo3 = Typeface.createFromAsset(getActivity().getAssets(),"fonts/DroidSans.ttf");
        textView3.setTypeface(fontRobo3);

        TextView textView4 = (TextView) view.findViewById(R.id.about_secondary2);
        Typeface fontRobo4 = Typeface.createFromAsset(getActivity().getAssets(),"fonts/DroidSans.ttf");
        textView4.setTypeface(fontRobo4);








        if (mArguments != null){
            ImageView img = (ImageView) view.findViewById(R.id.image_header);
            img.setImageResource(mArguments.getInt(ARG_IMAGE_RES));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        AppCompatActivity a = (AppCompatActivity) context;

        mArguments = getArguments();
        Drawable actionBarBg = getActivity().getResources().getDrawable(R.drawable.headerbg);

        mFadingHelper = new FadingActionBarHelper()
                .actionBarBackground(actionBarBg)
                .headerLayout(R.layout.header)
                .contentLayout(R.layout.about);

        mFadingHelper.initActionBar(a);

    }
}
