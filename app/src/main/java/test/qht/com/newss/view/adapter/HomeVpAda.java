package test.qht.com.newss.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import test.qht.com.newss.model.home.HomeTitleBean;
import test.qht.com.newss.view.fragment.Homef;

/**
 * Created by ${仇海涛} on 2017/5/12.
 * 类的用途 ：
 */

public class HomeVpAda extends FragmentPagerAdapter {


    private List<HomeTitleBean.ResultBean.DateBean> mdatat = new ArrayList<>();

    public HomeVpAda(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Homef homef = Homef.getInstance(mdatat.get(position).getUri());


        return homef;
    }

    @Override
    public int getCount() {
        return mdatat.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mdatat.get(position).getTitle();
    }

    public void setdatat(List<HomeTitleBean.ResultBean.DateBean> datat) {
        if (datat!=null){
            mdatat.addAll(datat);
        }

    }
}
