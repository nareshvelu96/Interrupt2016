package in.svce.interrupt16.android;

import android.app.Fragment;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.pedrovgs.DraggableView;

import java.util.LinkedList;

/**
 * Created by Mathangi on 28-07-2016.
 */
public class events_fragment extends Fragment {
    private ListView listView;
    private ImageView image;
    private TextView name, type, desc, rounds, rules, sample;
    private DraggableView draggableView;
     int check=0;
    private LinkedList<event> events;
    private ListViewAdapter adapter;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.events,container,false);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        /*view.setOnKeyListener(new View.OnKeyListener() {
           @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){

                    // handle back button
                    // Toast.makeText(getActivity(),"lol",Toast.LENGTH_LONG).show();
                    draggableView.minimize();
                    MainActivity.inevent=true;
                    return true;

                }

                return false;
            }
        });*/
        locateView();
        setListViewAdapter();
        listView.setOnItemClickListener(onItemClickListener());

        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){

                    // handle back button
                    // Toast.makeText(getActivity(),"lol",Toast.LENGTH_LONG).show();
                    draggableView.minimize();
                    MainActivity.inevent=false;
                    return true;

                }

                return false;
            }
        });

        return view;

    }

    private void setListViewAdapter() {
        Resources res = getResources();
        String[] myb = res.getStringArray(R.array.myb);
        String[] datas = res.getStringArray(R.array.datasurfer);
        String[] dataD = res.getStringArray(R.array.datadoss);
        String[] con = res.getStringArray(R.array.codenin);
        String[] paperR = res.getStringArray(R.array.paperRe);
        String[] hintf = res.getStringArray(R.array.hintforage);
        String[] dumbc = res.getStringArray(R.array.dumbc);
        String[] coc = res.getStringArray(R.array.coc);
        String[] quiz = res.getStringArray(R.array.quizzler);

        events = new LinkedList<event>();
        events.add(new event(myb[0], myb[1], myb[2], myb[3]));
        events.add(new event(datas[0], datas[1], datas[2], datas[3]));
        events.add(new event(dataD[0], dataD[1], dataD[2], dataD[3]));
        events.add(new event(con[0], con[1], con[2], con[3]));
        events.add(new event(paperR[0], paperR[1], paperR[2], paperR[3]));
        events.add(new event(hintf[0], hintf[1], hintf[2], hintf[3]));
        events.add(new event(dumbc[0], dumbc[1], dumbc[2], dumbc[3]));
        events.add(new event(coc[0], coc[1], coc[2], coc[3]));
        events.add(new event(quiz[0], quiz[1], quiz[2], quiz[3]));
        //create - attach adapter to listview
        adapter = new ListViewAdapter(getActivity(), R.layout.item_list_events, events);
        listView.setAdapter(adapter);
        Toast.makeText(getActivity(),"Click event icons for event information.",Toast.LENGTH_SHORT).show();


    }

    private void locateView() {
        listView = (ListView)view.findViewById(R.id.list_view);
        image = (ImageView) view.findViewById(R.id.image);
        name = (TextView) view.findViewById(R.id.event_name);
        type = (TextView) view.findViewById(R.id.event_type);
        desc = (TextView) view.findViewById(R.id.desc);
        rounds = (TextView) view.findViewById(R.id.rounds);
        draggableView = (DraggableView) view.findViewById(R.id.draggable_view);
        //set some feature for draggable panel
        draggableView.setVisibility(View.GONE);
        draggableView.setClickToMaximizeEnabled(true);
        draggableView.setClickToMinimizeEnabled(true);
    }



    private AdapterView.OnItemClickListener onItemClickListener() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                event event = (event) parent.getAdapter().getItem(position);
                if (event.getEvent_name().equals("MYB V4.0")) {
                    image.setImageResource(R.drawable.myb);
                } else if (event.getEvent_name().equals("GAME OF ARCHIVES")) {
                    image.setImageResource(R.drawable.database1);
                } else if (event.getEvent_name().equals("DATA DE-QUEUE")) {
                    image.setImageResource(R.drawable.datastructures1);
                } else if (event.getEvent_name().equals("CODE NINJA")) {
                    image.setImageResource(R.drawable.codeninja1);
                } else if (event.getEvent_name().equals("COGNITION QUEST")) {
                    image.setImageResource(R.drawable.paper1);
                } else if (event.getEvent_name().equals("DON OF LOGIC")) {
                    image.setImageResource(R.drawable.donoflogic1);
                } else if (event.getEvent_name().equals("CODE SPRINT")) {
                    image.setImageResource(R.drawable.onlinecoding1);
                } else if (event.getEvent_name().equals("PICTURESQUE")) {
                    image.setImageResource(R.drawable.photography1);
                } else if (event.getEvent_name().equals("QUIZZLER")) {
                    image.setImageResource(R.drawable.quizzler);
                }
                name.setText(event.getEvent_name());

                type.setText(event.getEvent_type());

                desc.setText(event.getDescription());

                rounds.setText(event.getRounds());

                draggableView.setVisibility(View.VISIBLE);

                //restore draggable view height
           if(check==0)
{Toast.makeText(getActivity(),"Swipe down to minimize",Toast.LENGTH_SHORT).show();
 check++;
}               MainActivity.inevent=true;
                draggableView.maximize();
            }
        };
    }


}