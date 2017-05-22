package test.qht.com.newss.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.umeng.socialize.UMShareAPI;

import test.qht.com.newss.R;
import test.qht.com.newss.view.fragment.Headline_Frag;
import test.qht.com.newss.view.fragment.Home_Frag;
import test.qht.com.newss.view.fragment.Mine_Frag;
import test.qht.com.newss.view.fragment.Video_Frag;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private RadioButton frontpage_rb;
    private RadioButton video_rb;
    private RadioButton headlines_rb;
    private static RadioButton me_rb;
    private RadioGroup main_rg;
    private RelativeLayout main_rela;
    private FragmentManager manager;

    private Home_Frag home_frag = new Home_Frag();
    private Video_Frag video_frag = new Video_Frag();
    private Headline_Frag headline_frag = new Headline_Frag();
    private Mine_Frag mine_frag = new Mine_Frag();
    public static Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    //me_rb.drawable(R.drawable.mine_login_sel);
                    break;

                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.main_rela,home_frag).commit();
    }

    private void initView() {
        frontpage_rb = (RadioButton) findViewById(R.id.frontpage_rb);
        video_rb = (RadioButton) findViewById(R.id.video_rb);
        headlines_rb = (RadioButton) findViewById(R.id.headlines_rb);
        me_rb = (RadioButton) findViewById(R.id.me_rb);
        main_rg = (RadioGroup) findViewById(R.id.main_rg);
        main_rela = (RelativeLayout) findViewById(R.id.main_rela);

        frontpage_rb.setOnClickListener(this);
        video_rb.setOnClickListener(this);
        headlines_rb.setOnClickListener(this);
        me_rb.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.frontpage_rb:
                manager.beginTransaction().replace(R.id.main_rela,home_frag).commit();
                break;
            case R.id.video_rb:
                manager.beginTransaction().replace(R.id.main_rela,video_frag).commit();
                break;
            case R.id.headlines_rb:
                manager.beginTransaction().replace(R.id.main_rela,headline_frag).commit();
                break;
            case R.id.me_rb:
                manager.beginTransaction().replace(R.id.main_rela,mine_frag).commit();
                break;
            default:
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
