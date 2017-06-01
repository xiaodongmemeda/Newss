package test.qht.com.newss.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import test.qht.com.newss.R;
import test.qht.com.newss.view.adapter.VideoRecyAda;

/**
 * A simple {@link Fragment} subclass.
 */
public class Videof extends Fragment {


    private View view;
    private RecyclerView recyclerView;
    private List<String> list = new ArrayList<>();
    public Videof() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_videofrag, container, false);
        initView();
        initData();
        return view;
    }

    private void initData() {
        for (int i = 0; i <12 ; i++) {
            list.add("http://baobab.kaiyanapp.com/api/v1/playUrl?vid=221"+i+"1&editionType=default&source=ucloud");
        }
        VideoRecyAda ada = new VideoRecyAda(getActivity());
        ada.setData(list);
        recyclerView.setAdapter(ada);

    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    private void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.videof_f_recy);

        recyclerView.setLayoutManager(manager);



    }

}
