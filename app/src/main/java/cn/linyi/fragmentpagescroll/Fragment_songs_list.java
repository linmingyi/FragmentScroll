package cn.linyi.fragmentpagescroll;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by linyi on 2016/3/30.
 */
public class Fragment_songs_list extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_songs_list,container,false);
        Log.i("LIN", view.getId() + "   "+R.layout.fragment_songs_list);
        return view;
    }
}
