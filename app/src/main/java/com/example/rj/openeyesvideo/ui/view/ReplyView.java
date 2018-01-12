package com.example.rj.openeyesvideo.ui.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.rj.openeyesvideo.R;
import com.example.rj.openeyesvideo.model.bean.ReplyBean;
import com.example.rj.openeyesvideo.ui.adapter.ReplyAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rj on 2018/1/11.
 */

public class ReplyView extends RelativeLayout {
    @BindView(R.id.iv_replyclose)
    public ImageView replyClose;

    @BindView(R.id.view_main)
    public RecyclerView recyclerView;

    Context context;
    LinearLayoutManager linearLayoutManager;
    ReplyAdapter replyAdapter;
    List<ReplyBean.ItemListBean> listBeans=new ArrayList<>();


    public ReplyView(Context context) {

        this(context,null);
    }

    public ReplyView(Context context, AttributeSet attrs) {
        this(context,null,0);
    }

    public ReplyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        initView();
    }

    private void initView() {
        Log.d("hzj", "initView: ");
        View.inflate(context, R.layout.layout_reply,this);
        ButterKnife.bind(this);
        replyAdapter=new ReplyAdapter(context,listBeans);
        Log.d("hzj", "initView: "+replyAdapter.toString());
        recyclerView.setAdapter(replyAdapter);
        linearLayoutManager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    public void getData(ReplyBean replyBean){
        Log.d("hzj", "getData: ");
        replyAdapter.getData(replyBean);
    }

}