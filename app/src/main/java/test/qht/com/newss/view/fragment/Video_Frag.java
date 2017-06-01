package test.qht.com.newss.view.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import test.qht.com.newss.R;
import test.qht.com.newss.view.adapter.VideoVpAda;


/**
 * A simple {@link Fragment} subclass.
 */
public class Video_Frag extends Fragment {


    private View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<String> list = new ArrayList<>();

    public Video_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_video_, container, false);
        initView();
        initData();
        return view;
    }

    private void initData() {

        list.add("推荐");
        list.add("音乐");
        list.add("搞笑");
        list.add("社会");
        list.add("小品");
        list.add("生活");
        list.add("影视");
        list.add("娱乐");
        list.add("呆萌");
        list.add("游戏");
        list.add("原创");
        list.add("开眼");
        list.add("再看一遍");
        list.add("火山直播");

        VideoVpAda ada = new VideoVpAda(getFragmentManager());
        ada.setData(list);

        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(Color.BLACK,Color.RED);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setTabsFromPagerAdapter(ada);
        viewPager.setAdapter(ada);
    }

    private void initView() {
        tabLayout = (TabLayout) view.findViewById(R.id.videof_tablayout);
        viewPager = (ViewPager) view.findViewById(R.id.videof_viewpager);

    }

}
