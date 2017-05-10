package com.test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.qxq.base.QxqBaseRecyclerViewAdapter;
import com.qxq.base.adapter_base.OnRecyclerViewListener;

import java.util.List;

/**
 * Created by Administrator on 2017/2/16.
 */
public class TestAdapter extends QxqBaseRecyclerViewAdapter {

    private Context mContext;

    private boolean bool = false;

    public TestAdapter(Context context) {
        super(context);
        mContext =  context;
    }

    @Override
    public RecyclerView.ViewHolder getHolder(ViewGroup parent,int viewType) {
        if(viewType == ITEM_TYPE_CONTENT1){
            return new TestHolder(mContext, parent,R.layout.item1,onRecyclerViewListener);
        }else if(viewType == ITEM_TYPE_CONTENT2){
            return new Test2Holder(mContext, parent,R.layout.item2,onRecyclerViewListener);
        }
        return null;
    }

    @Override
    public void onMyBindViewHolder(RecyclerView.ViewHolder holder, int position, List payload) {
        if(payload.isEmpty()){
            if(holder instanceof TestHolder){
                ((TestHolder) holder).bindData(getItem(position),bool);
            }else if(holder instanceof Test2Holder){
                ((Test2Holder) holder).bindData(getItem(position));
            }
        }else{
            TestHolder holder1 = (TestHolder) holder;
            holder1.name.setText("1234");
        }
    }

    public static final int ITEM_TYPE_CONTENT1 = 1;
    public static final int ITEM_TYPE_CONTENT2 = 2;

    @Override
    public int getItemType(int position) {
        if(position % 2 == 0){
            return ITEM_TYPE_CONTENT1;
        }else{
            return ITEM_TYPE_CONTENT2;
        }
    }

    private OnRecyclerViewListener onRecyclerViewListener;

    public void setOnRecyclerViewListener(OnRecyclerViewListener onRecyclerViewListener) {
        this.onRecyclerViewListener = onRecyclerViewListener;
    }

    public void update_JB(int position){
        notifyItemChanged(position,"update Name");
    }

    public void update_XS(boolean bool){
        this.bool = bool;
        notifyDataSetChanged();
    }

}
