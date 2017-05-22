package test.qht.com.newss.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import test.qht.com.newss.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Headline_Frag extends Fragment {


    public Headline_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_headline_, container, false);
        return view;
    }

}
