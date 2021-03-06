package in.svce.interrupt16.android;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
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




        if (mArguments != null){
            ImageView img = (ImageView) view.findViewById(R.id.image_header);
            img.setImageResource(mArguments.getInt(ARG_IMAGE_RES));
        }
        Button event= (Button)view.findViewById(R.id.onclick_event);

        Typeface fontRobo = Typeface.createFromAsset(getActivity().getAssets(),"fonts/Roboto-Medium.ttf");
        event.setTypeface(fontRobo);


        event.setClickable(true);
        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, new events_fragment()).commit();

                //setTitle(navMenuTitles[position]);

            }

        });
            return view;
        }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity a = (Activity) context;

        mArguments = getArguments();
        Drawable actionBarBg = getActivity().getResources().getDrawable(R.drawable.headerbg);

        mFadingHelper = new FadingActionBarHelper()
                .actionBarBackground(actionBarBg)
                .headerLayout(R.layout.header)
                .contentLayout(R.layout.about);

        mFadingHelper.initActionBar(a);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);


        mArguments = getArguments();
        Drawable actionBarBg = getActivity().getResources().getDrawable(R.drawable.headerbg);

        mFadingHelper = new FadingActionBarHelper()
                .actionBarBackground(actionBarBg)
                .headerLayout(R.layout.header)
                .contentLayout(R.layout.about);

        mFadingHelper.initActionBar(activity);
    }
}