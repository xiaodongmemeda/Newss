package test.qht.com.newss.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import test.qht.com.newss.view.fragment.Videof;

/**
 * Created by ASUS on 2017/5/27.
 */

public class VideoVpAda extends FragmentPagerAdapter {

    List<String> list = new ArrayList<>();

    public VideoVpAda(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Videof videof = new Videof();

        return videof;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
    public void setData(List<String> data){
        if (data!=null){
            this.list = data;
        }
    }
}
