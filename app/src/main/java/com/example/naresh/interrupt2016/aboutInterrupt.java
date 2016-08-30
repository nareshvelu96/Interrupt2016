package com.example.naresh.interrupt2016;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

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


        if (mArguments != null){
            ImageView img = (ImageView) view.findViewById(R.id.image_header);
            img.setImageResource(mArguments.getInt(ARG_IMAGE_RES));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity a = (Activity) context;


        mArguments = getArguments();
        int actionBarBg = R.drawable.headerbg;

        mFadingHelper = new FadingActionBarHelper()
                .actionBarBackground(actionBarBg)
                .headerLayout(R.layout.header)
                .contentLayout(R.layout.about);


        mFadingHelper.initActionBar(a);

    }
}
