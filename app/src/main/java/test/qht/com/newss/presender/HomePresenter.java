package test.qht.com.newss.presender;

import java.util.HashMap;

import test.qht.com.newss.model.utils.HttpUtils;
import test.qht.com.newss.view.iview.IHomeView;

/**
 * Created by ${仇海涛} on 2017/5/11.
 * 类的用途 ：
 */

public class HomePresenter extends BasePresenter<IHomeView> {

    //private HashMap<String,String> hashMap = new HashMap<>();

    public <T> void getDataH(Class<T> cla,String uri,HashMap<String,String> hashMap){
        HttpUtils.getDataFromeM( uri,hashMap, new HttpUtils.CallBackData<T>() {
            @Override
            public void callBackDataF(T o) {
                getIview().callBackDataH(o);
            }
        },cla);
    }
    public <T> void getDataHt(Class<T> cla,String uri,HashMap<String,String> hashMap){
        HttpUtils.getDataFromeM(uri, hashMap, new HttpUtils.CallBackData<T>() {
            @Override
            public void callBackDataF(T o) {
                getIview().callBackDataH(o);
            }
        },cla);
    }

}
