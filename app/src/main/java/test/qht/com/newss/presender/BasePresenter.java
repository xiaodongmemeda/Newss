package test.qht.com.newss.presender;

import android.widget.ImageView;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import test.qht.com.newss.R;
import test.qht.com.newss.view.iview.IView;

/**
 * Created by ${仇海涛} on 2017/5/11.
 * 类的用途 ：
 */

public class BasePresenter<T extends IView> {
    private T mt;
    ImageOptions options = new ImageOptions.Builder().setLoadingDrawableId(R.mipmap.ic_launcher).build();

    public void attach(T t){
        this.mt = t;
    }
    public T getIview(){
        return mt;
    }
    public void setImg( ImageView img,String uri){
        x.image().bind(img,uri,options);
    }

}
