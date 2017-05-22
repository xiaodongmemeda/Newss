package test.qht.com.newss.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import test.qht.com.newss.R;
import test.qht.com.newss.model.home.HomeBean;
import test.qht.com.newss.presender.HomePresenter;

/**
 * Created by ${仇海涛} on 2017/5/11.
 * 类的用途 ：
 */

public class HomefLvAda extends BaseAdapter {

    Context context;
    List<HomeBean.ResultBean.DataBean> mlist = new ArrayList<>();
    private HomePresenter mhomePresenter;

    public HomefLvAda(Context context) {
        this.context = context;
    }

    private static final int TYPE1 = 0;
    private static final int TYPE2 = 1;

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public HomeBean.ResultBean.DataBean getItem(int i) {
        return mlist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        int itemViewType = getItemViewType(i);
        ViewHolder holder = null;


            switch (itemViewType) {

                case TYPE2:
                    holder = new ViewHolder();
                    if (view == null){
                        view = View.inflate(context, R.layout.homef_lv_item2,null);
                        holder.imageView1 = (ImageView) view.findViewById(R.id.homef_item2_image1);
                        holder.imageView2 = (ImageView) view.findViewById(R.id.homef_item2_image2);
                        holder.imageView3 = (ImageView) view.findViewById(R.id.homef_item2_image3);
                        holder.textView1 = (TextView) view.findViewById(R.id.homef_item2_textview1);
                        view.setTag(holder);
                    } else {
                        holder = (ViewHolder) view.getTag();
                    }
                        holder.textView1.setText(getItem(i).getTitle());
                        mhomePresenter.setImg(holder.imageView1,getItem(i).getThumbnail_pic_s());
                        mhomePresenter.setImg(holder.imageView2,getItem(i).getThumbnail_pic_s02());
                        mhomePresenter.setImg(holder.imageView3,getItem(i).getThumbnail_pic_s03());

                    break;
                case TYPE1:
                    holder = new ViewHolder();
                    if (view == null){
                        view = View.inflate(context,R.layout.homef_lv_item1,null);
                        holder.textView1 = (TextView) view.findViewById(R.id.homef_item1_text1);
                        holder.textView2 = (TextView) view.findViewById(R.id.homef_item1_text2);
                        holder.imageView1 = (ImageView) view.findViewById(R.id.homef_item1_img);
                        view.setTag(holder);
                    } else {
                        holder = (ViewHolder) view.getTag();
                    }
                    holder.textView1.setText(getItem(i).getTitle());
                    holder.textView2.setText(getItem(i).getAuthor_name());
                    mhomePresenter.setImg(holder.imageView1,getItem(i).getThumbnail_pic_s());

                    break;

                default:
                    break;
            }


        return view;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        String thumbnail_pic_s = mlist.get(position).getThumbnail_pic_s();
        String thumbnail_pic_s02 = mlist.get(position).getThumbnail_pic_s02();
        String thumbnail_pic_s03 = mlist.get(position).getThumbnail_pic_s03();

        if (!"".equals(thumbnail_pic_s03) && !"".equals(thumbnail_pic_s) && !"".equals(thumbnail_pic_s02)
                && thumbnail_pic_s != null && thumbnail_pic_s02 != null && thumbnail_pic_s03 != null) {
            return TYPE2;
        } else {
            return TYPE1;
        }

    }

    public void setData(List<HomeBean.ResultBean.DataBean> list){
        if (list!=null){
          mlist.addAll(list);
        }
    }

    public void setHomepresenter(HomePresenter homepresenter){
        this.mhomePresenter = homepresenter;
    }

    class ViewHolder{
        ImageView imageView1;
        ImageView imageView2;
        ImageView imageView3;

        TextView textView1;
        TextView textView2;
    }
}
