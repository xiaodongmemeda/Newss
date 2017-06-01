package test.qht.com.newss.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import test.qht.com.newss.R;

/**
 * Created by ASUS on 2017/5/27.
 */

public class VideoRecyAda extends RecyclerView.Adapter<VideoRecyAda.MyViewholder> {
    Context context;
    List<String> list = new ArrayList<>();

    public VideoRecyAda(Context context) {
        this.context = context;
    }

    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.videof_item,null);
        MyViewholder viewholder = new MyViewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(MyViewholder holder, int position) {
        holder.jcVideoPlayer.setUp(list.get(position),"今日视频");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void setData(List<String> data){
        if (data!=null){
            this.list = data;
        }
    }
    static class MyViewholder extends RecyclerView.ViewHolder{

        private final JCVideoPlayer jcVideoPlayer;

        public MyViewholder(View itemView) {
            super(itemView);
            jcVideoPlayer = (JCVideoPlayer) itemView.findViewById(R.id.videocontroller1);
        }
    }
}
