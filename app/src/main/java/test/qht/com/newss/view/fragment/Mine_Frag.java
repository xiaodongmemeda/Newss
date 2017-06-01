package test.qht.com.newss.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.shareboard.SnsPlatform;

import java.util.ArrayList;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;
import test.qht.com.newss.R;
import test.qht.com.newss.model.utils.UiUtils;
import test.qht.com.newss.view.activity.MainActivity;
import test.qht.com.newss.view.activity.Phone_Activity;

/**
 * A simple {@link Fragment} subclass.
 */
public class Mine_Frag extends Fragment {
    public ArrayList<SnsPlatform> platforms = new ArrayList<SnsPlatform>();
    private SHARE_MEDIA[] list = {SHARE_MEDIA.QQ};

   /* public static Handler handlers=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:

                    String s = (String) msg.obj;

                    mine_rela_01.setVisibility(View.GONE);
                    mine_rela_02.setVisibility(View.VISIBLE);

                    Glide.with(context).load(R.mipmap.qp).into(qq_login_img);
                    qq_login_text.setText(s);

                    break;

                default:
                    break;
            }
        }
    };*/
    private UMAuthListener authListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {

        }

        @Override
        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
            switch (i) {
                case ACTION_AUTHORIZE:
                    Toast.makeText(getActivity(), "登陆成功了", Toast.LENGTH_LONG).show();
                    UMShareAPI.get(getActivity()).getPlatformInfo(getActivity(), platforms.get(0).mPlatform, authListener);
                    break;
                case ACTION_GET_PROFILE:
                    MainActivity.handler.sendEmptyMessage(1);
                    mine_rela_01.setVisibility(View.GONE);
                    mine_rela_02.setVisibility(View.VISIBLE);

                    Glide.with(getActivity()).load(map.get("iconurl")).into(qq_login_img);
                    qq_login_text.setText(map.get("name"));

                    break;
                case ACTION_DELETE:
                    Toast.makeText(getActivity(), "取消授权", Toast.LENGTH_LONG).show();
                    break;
            }
        }

        @Override
        public void onError(SHARE_MEDIA share_media, int i, Throwable t) {
            Toast.makeText(getActivity(), "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media, int i) {
            Toast.makeText(getActivity(), "取消了", Toast.LENGTH_LONG).show();
        }
    };

    private View view;
    private TextView textView;
    private ImageView imageView;
    private static RelativeLayout mine_rela_01;
    private static CircleImageView qq_login_img;
    private static TextView qq_login_text;
    private static RelativeLayout mine_rela_02;
    private ImageView Image_phone;

    public Mine_Frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_mine_, container, false);

        initView();
        initPlatforms();
        return view;
    }

   /* @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(getActivity());
    }*/

    /*@Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(getActivity());
    }
    @Subscribe(threadMode = ThreadMode.ASYNC) //在ui线程执行
    public void onDataSynEvent(String event) {
        mine_rela_01.setVisibility(View.GONE);
        mine_rela_02.setVisibility(View.VISIBLE);

        Glide.with(context).load(R.mipmap.qp).into(qq_login_img);
        qq_login_text.setText(event);
    }*/

    private void initView() {
        textView = (TextView) view.findViewById(R.id.Text_night);
        imageView = (ImageView) view.findViewById(R.id.Image_QQ);
        mine_rela_01 = (RelativeLayout) view.findViewById(R.id.mine_rela_01);
        qq_login_img = (CircleImageView) view.findViewById(R.id.qq_login_img);
        qq_login_text = (TextView) view.findViewById(R.id.qq_login_text);
        mine_rela_02 = (RelativeLayout) view.findViewById(R.id.mine_rela_02);
        Image_phone = (ImageView) view.findViewById(R.id.Image_phone);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UiUtils.switchAppTheme(getActivity());
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.reload();

            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "授权成功", Toast.LENGTH_SHORT).show();
                UMShareAPI.get(getActivity()).isAuthorize(getActivity(), platforms.get(0).mPlatform);
                UMShareAPI.get(getActivity()).doOauthVerify(getActivity(), platforms.get(0).mPlatform, authListener);
            }
        });

        Image_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Phone_Activity.class);
                startActivity(intent);
            }
        });
    }


    private void initPlatforms() {
        platforms.clear();
        for (SHARE_MEDIA e : list) {
            if (!e.toString().equals(SHARE_MEDIA.GENERIC.toString())) {
                platforms.add(e.toSnsPlatform());
            }
        }
    }
}
