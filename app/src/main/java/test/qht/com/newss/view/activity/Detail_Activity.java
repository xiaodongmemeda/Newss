package test.qht.com.newss.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMWeb;

import test.qht.com.newss.R;
import test.qht.com.newss.model.home.HomeBean;

public class Detail_Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView detail_back;
    private WebView detail_webview;
    private ImageView detail_collect;
    private ImageView share;
    private HomeBean.ResultBean.DataBean databean;
    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调
        }

        @Override
        public void onResult(SHARE_MEDIA platform) {
            Log.d("plat", "platform" + platform);

            Toast.makeText(Detail_Activity.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(Detail_Activity.this, platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            if (t != null) {
                Log.d("throw", "throw:" + t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(Detail_Activity.this, platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_);
        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bean");
        databean = (HomeBean.ResultBean.DataBean) bundle.getSerializable("b");

        //设置WebView属性，能够执行Javascript脚本
        detail_webview.getSettings().setJavaScriptEnabled(true);
        //加载需要显示的网页
        detail_webview.loadUrl(databean.getUrl());
}

    private void initView() {
        detail_back = (ImageView) findViewById(R.id.detail_back);
        detail_webview = (WebView) findViewById(R.id.detail_webview);
        detail_collect = (ImageView) findViewById(R.id.detail_collect);
        share = (ImageView) findViewById(R.id.detail_share);

        detail_back.setOnClickListener(this);
        share.setOnClickListener(this);
    }
    @Override
    //设置回退
    //覆盖Activity类的onKeyDown(int keyCoder,KeyEvent event)方法
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && detail_webview.canGoBack()) {
            detail_webview.goBack(); //goBack()表示返回WebView的上一页面
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.detail_back:
                finish();
                break;
            case R.id.detail_share:

                UMWeb web = new UMWeb(databean.getUrl());
                web.setTitle("This is music title");//标题
                //web.setThumb(thumb);  //缩略图
                web.setDescription("my description");//描述


                new ShareAction(Detail_Activity.this)
                        .withText("hello")
                        .withMedia(web)
                        .setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN)
                        .setCallback(umShareListener).open();
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
