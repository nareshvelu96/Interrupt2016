package com.example.naresh.interrupt2016;

/**
 * Created by Mathangi on 24-08-2016.
 */
import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Hong Thai
 */
public class ListViewAdapter extends ArrayAdapter<com.example.naresh.interrupt2016.event> {

    private Activity activity;

    public ListViewAdapter(Activity activity, int resource, List<com.example.naresh.interrupt2016.event> events) {
        super(activity, resource, events);
        this.activity = activity;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        LayoutInflater inflater = (LayoutInflater) activity
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        // If holder not exist then locate all view from UI file.
        if (convertView == null) {
            // inflate UI from XML file
            convertView = inflater.inflate(R.layout.item_list_events, parent, false);
            // get all UI view
            holder = new ViewHolder(convertView);
            // set tag for holder
            convertView.setTag(holder);
        } else {
            // if holder created, get tag from view
            holder = (ViewHolder) convertView.getTag();
        }

        holder.eventName.setText(getItem(position).getEvent_name());
        Typeface fontRobo = Typeface.createFromAsset(getContext().getAssets(), "fonts/CaviarDreams.ttf");
        holder.eventName.setTypeface(fontRobo );


        if (getItem(position).getEvent_name().equals("MYB V3.0")) {
            holder.eventIcon.setImageResource(R.drawable.myb);
        }else if (getItem(position).getEvent_name().equals("DATA SURFER")) {
            holder.eventIcon.setImageResource(R.drawable.datasurf);
        }else if (getItem(position).getEvent_name().equals("DATA DOSSIER")){
            holder.eventIcon.setImageResource(R.drawable.datados);
        }else if (getItem(position).getEvent_name().equals("CODE NINJA")) {
            holder.eventIcon.setImageResource(R.drawable.codeninja);
        }else if (getItem(position).getEvent_name().equals("PAPIER REMISE")) {
            holder.eventIcon.setImageResource(R.drawable.paperr);
        }else if (getItem(position).getEvent_name().equals("DUMBC")) {
            holder.eventIcon.setImageResource(R.drawable.dumbcport);
        }else if (getItem(position).getEvent_name().equals("HINT FORAGE")) {
            holder.eventIcon.setImageResource(R.drawable.hint);
        }else if (getItem(position).getEvent_name().equals("COC")) {
            holder.eventIcon.setImageResource(R.drawable.clashofcoders);
        }else if (getItem(position).getEvent_name().equals("QUIZZLER")) {
            holder.eventIcon.setImageResource(R.drawable.quizzler);
        }

        return convertView;
    }

    private static class ViewHolder {
        private TextView eventName;
        private ImageView eventIcon;

        public ViewHolder(View v) {
            eventName = (TextView) v.findViewById(R.id.name);
            eventIcon = (ImageView) v.findViewById(R.id.icon);
        }
    }
}