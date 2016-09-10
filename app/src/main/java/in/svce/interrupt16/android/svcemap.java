package in.svce.interrupt16.android;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

public class svcemap extends Fragment {
    View view;
        PhotoView mImageView;
        PhotoViewAttacher mAttacher;
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            view = inflater.inflate(R.layout.svcemap,container,false);
// Any implementation of ImageView can be used!
            mImageView = (PhotoView) view.findViewById(R.id.svce_map);
// Set the Drawable displayed
            // Attach a PhotoViewAttacher, which takes care of all of the zooming    functionality.
            mAttacher = new PhotoViewAttacher(mImageView);
// If you later call mImageView.setImageDrawable/setImageBitmap/setImageResource/etc then you just need to call
            mAttacher.update();
            return view;
        }
    }
