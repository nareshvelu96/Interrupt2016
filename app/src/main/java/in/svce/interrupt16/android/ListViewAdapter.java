package in.svce.interrupt16.android;

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
public class ListViewAdapter extends ArrayAdapter<event> {

    private Activity activity;

    public ListViewAdapter(Activity activity, int resource, List<event> events) {
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


        if (getItem(position).getEvent_name().equals("MYB V4.0")) {
            holder.eventIcon.setImageResource(R.drawable.myb);
        }else if (getItem(position).getEvent_name().equals("GAME OF ARCHIVES")) {
            holder.eventIcon.setImageResource(R.drawable.database1);
        }else if (getItem(position).getEvent_name().equals("DATA DE-QUEUE")){
            holder.eventIcon.setImageResource(R.drawable.datastructures1);
        }else if (getItem(position).getEvent_name().equals("CODE NINJA")) {
            holder.eventIcon.setImageResource(R.drawable.codeninja1);
        }else if (getItem(position).getEvent_name().equals("COGNITION QUEST")) {
            holder.eventIcon.setImageResource(R.drawable.paper1);
        }else if (getItem(position).getEvent_name().equals("DON OF LOGIC")) {
            holder.eventIcon.setImageResource(R.drawable.donoflogic1);
        }else if (getItem(position).getEvent_name().equals("CODE SPRINT")) {
            holder.eventIcon.setImageResource(R.drawable.onlinecoding1);
        }else if (getItem(position).getEvent_name().equals("PICTURESQUE")) {
            holder.eventIcon.setImageResource(R.drawable.photography1);
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