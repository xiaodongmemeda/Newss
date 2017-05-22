package test.qht.com.newss.application;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import org.xutils.BuildConfig;
import org.xutils.x;

/**
 * Created by ${仇海涛} on 2017/5/12.
 * 类的用途 ：
 */

public class MyApplication extends Application {

    {
        PlatformConfig.setQQZone("1106086767", "pC2wfXv6quTcZgPg");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
        UMShareAPI.get(this);
    }
}
