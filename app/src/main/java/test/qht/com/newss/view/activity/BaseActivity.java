package test.qht.com.newss.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import test.qht.com.newss.R;
import test.qht.com.newss.model.utils.Night_styleutils;

/**
 * Created by ${仇海涛} on 2017/5/12.
 * 类的用途 ：
 */

public class BaseActivity extends AppCompatActivity {
    private int theme = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Night_styleutils.changeStyle(this, theme, savedInstanceState);
        super.onCreate(savedInstanceState);

    }
    public void reload() {
        Intent intent = getIntent();
        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);//进入动画
        finish();
        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
        startActivity(intent);
    }
}
