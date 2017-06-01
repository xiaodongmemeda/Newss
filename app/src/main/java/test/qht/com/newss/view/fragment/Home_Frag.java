package test.qht.com.newss.view.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.HashMap;

import test.qht.com.newss.R;
import test.qht.com.newss.model.home.HomeTitleBean;
import test.qht.com.newss.model.utils.UriUtils;
import test.qht.com.newss.presender.HomePresenter;
import test.qht.com.newss.view.adapter.HomeVpAda;
import test.qht.com.newss.view.iview.IHomeView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Frag extends Fragment implements IHomeView<HomeTitleBean> {


    private HomePresenter homePresenter;
    private ImageView frag_home_jia;
    private TabLayout frag_home_tablayout;
    private ViewPager frag_home_viewpager;
    private HashMap<String,String> hashMap = new HashMap<>();
    private HomeVpAda ada;

    public Home_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_, container, false);


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
    }

    private void initData() {
        homePresenter = new HomePresenter();
        homePresenter.attach(this);
        homePresenter.getDataHt(HomeTitleBean.class, UriUtils.urit,hashMap);
        ada = new HomeVpAda(getActivity().getSupportFragmentManager());

        frag_home_tablayout.setupWithViewPager(frag_home_viewpager);
        frag_home_tablayout.setTabTextColors(Color.BLACK,Color.RED);
        frag_home_tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        frag_home_tablayout.setTabsFromPagerAdapter(ada);
        frag_home_viewpager.setAdapter(ada);
    }

    private void initView(View view) {
        frag_home_jia = (ImageView) view.findViewById(R.id.frag_home_jia);
        frag_home_tablayout = (TabLayout) view.findViewById(R.id.frag_home_tablayout);
        frag_home_viewpager = (ViewPager) view.findViewById(R.id.frag_home_viewpager);

        frag_home_jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getActivity(),)
            }
        });
    }

    @Override
    public void callBackDataH(HomeTitleBean homeTitleBean) {

        ada.setdatat(homeTitleBean.getResult().getDate());
        ada.notifyDataSetChanged();

    }

    @Override
    public void callBackDataErrH(HomeTitleBean homeTitleBean) {

    }


}
