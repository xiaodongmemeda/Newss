package test.qht.com.newss.view.iview;

/**
 * Created by ${仇海涛} on 2017/5/11.
 * 类的用途 ：
 */

public interface IHomeView<T> extends IView {
    void callBackDataH(T t);
    void callBackDataErrH(T t);

}
