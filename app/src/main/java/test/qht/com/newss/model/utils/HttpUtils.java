package test.qht.com.newss.model.utils;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by ${仇海涛} on 2017/5/11.
 * 类的用途 ：
 */

public class HttpUtils {
    public static <T>void getDataFromeM( String uri,HashMap<String,String> hashMap, final CallBackData callBackData, final Class<T> cla){

        RequestParams params = new RequestParams();
        params.setUri(uri);
        if (hashMap!=null){
            Iterator<String> iterator = hashMap.keySet().iterator();
            while (iterator.hasNext()){
                String key = iterator.next();
                String value = hashMap.get(key);
                params.addQueryStringParameter(key,value);
            }
        }

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                T t = gson.fromJson(result, cla);
                callBackData.callBackDataF(t);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }


    public interface CallBackData<T>{
        void callBackDataF(T t);
    }
}
