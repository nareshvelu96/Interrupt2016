package com.example.naresh.interrupt2016;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import info.hoang8f.widget.FButton;

/**
 * Created by Mathangi on 28-07-2016.
 */
public class contact extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.contact, container, false);
        ImageButton call1,call2,call3,call4;

        call1=(ImageButton)view.findViewById(R.id.call1);
        call2=(ImageButton)view.findViewById(R.id.call2);
        call3=(ImageButton)view.findViewById(R.id.call3);
        call4=(ImageButton)view.findViewById(R.id.call4);



        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numberToDial = "tel:"+"9043567123";
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(numberToDial)));


            }
        });

        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numberToDial = "tel:"+"9003124651";
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(numberToDial)));


            }
        });
        call3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numberToDial = "tel:"+"9043567123";
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(numberToDial)));


            }
        });
        call4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numberToDial = "tel:"+"9842092575";
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(numberToDial)));


            }
        });



        FButton fb;
        fb = (FButton) view.findViewById(R.id.feedback);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Email = new Intent(Intent.ACTION_SEND);
                Email.setType("text/email");
                Email.putExtra(Intent.EXTRA_EMAIL, new String[]{"interrupt16@gmail.com"});
                Email.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
                Email.putExtra(Intent.EXTRA_TEXT, "" + "");
                startActivity(Intent.createChooser(Email, "Send Feedback:"));
            }
        });
        return view;
    }
    /*public View fb(){
        FButton gm=(FButton)view.findViewById(R.id.back);
        gm.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
            String facebookUrl = getFacebookPageURL(view.getContext());
            facebookIntent.setData(Uri.parse(facebookUrl));
            startActivity(facebookIntent);

        }
    });
        return view;
    }
    public String getFacebookPageURL(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            } else { //older versions of fb app
                return "fb://page/" + FACEBOOK_PAGE_ID;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return FACEBOOK_URL; //normal web url
        }
    }

}*/
}
