package test.qht.com.newss.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.HashMap;

import test.qht.com.newss.R;
import test.qht.com.newss.model.home.HomeBean;
import test.qht.com.newss.model.utils.UriUtils;
import test.qht.com.newss.presender.HomePresenter;
import test.qht.com.newss.view.activity.Detail_Activity;
import test.qht.com.newss.view.adapter.HomefLvAda;
import test.qht.com.newss.view.iview.IHomeView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Homef extends Fragment implements IHomeView<HomeBean>{


    private View view;
    private ListView homefrag_lv;
    private HomePresenter presenter;
    private HomefLvAda ada;
    public String uri;
    private HashMap<String,String> mhashMap ;
    public Homef() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_homefrag, container, false);


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
    }

    private void initData() {
        presenter = new HomePresenter();
        presenter.attach(this);
        ada = new HomefLvAda(getActivity());
        ada.setHomepresenter(presenter);
        homefrag_lv.setAdapter(ada);
        presenter.getDataH(HomeBean.class, UriUtils.uri,mhashMap);
    }

    private void initView(View view) {
        homefrag_lv = (ListView) view.findViewById(R.id.homefrag_lv);

    }

    @Override
    public void callBackDataH(final HomeBean homeBean) {
        ada.setData(homeBean.getResult().getData());
        ada.notifyDataSetChanged();
        homefrag_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(),Detail_Activity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("b",homeBean.getResult().getData().get(i));
                intent.putExtra("bean",bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public void callBackDataErrH(HomeBean homeBean) {

    }
    public void setHashMap(HashMap<String,String> hashMap){
        if (hashMap!=null){
            this.mhashMap = hashMap;
        }
    }
}
