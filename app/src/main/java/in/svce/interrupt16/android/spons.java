package in.svce.interrupt16.android;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
        ImageButton imageButton =(ImageButton) view.findViewById(R.id.sponsI1);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://harmonyhomesonline.com/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });


        TextView textView2 = (TextView) view.findViewById(R.id.spons2);
        Typeface fontRobo2 = Typeface.createFromAsset(getActivity().getAssets(),"fonts/Caviar_Dreams_Bold.ttf");
        textView2.setTypeface(fontRobo2);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setTextColor(Color.parseColor("#FFFFFF"));

        ImageButton iB =(ImageButton) view.findViewById(R.id.sponsI2);
        iB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.cooperelevators.com/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });
        return view;
    }
}
