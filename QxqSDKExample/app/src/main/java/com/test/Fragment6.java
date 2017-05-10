package com.test;

import android.os.Handler;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qxq.utils.DividerItemDecoration;
import com.qxq.base.QxqBaseFragment;
import com.qxq.base.QxqBaseRecyclerViewAdapter;
import com.qxq.base.adapter_base.OnRecyclerViewListener;
import com.qxq.utils.QxqToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/2/16.
 */
public class Fragment6 extends QxqBaseFragment{

    @Bind(R.id.list)
    RecyclerView mRecyclerView;

    private TestAdapter adapter;
    private int page = 1;
    private List<TestModel> list = new ArrayList<>();
    @Override
    protected int setContentView() {
        return R.layout.fragment6;
    }

    @Override
    protected void initData() {

        list.add(new TestModel("name1","123456789@qq.com"));
        list.add(new TestModel("name2","123456789@qq.com"));
        list.add(new TestModel("name3","123456789@qq.com"));
        list.add(new TestModel("name4","123456789@qq.com"));
        list.add(new TestModel("name5","123456789@qq.com"));
        list.add(new TestModel("name6","123456789@qq.com"));
        list.add(new TestModel("name7","123456789@qq.com"));
        list.add(new TestModel("name8","123456789@qq.com"));
        list.add(new TestModel("name9","123456789@qq.com"));
        list.add(new TestModel("name10","123456789@qq.com"));
    }

    @Override
    public void initLayout(View view) {
        ButterKnife.bind(this,view);
        adapter = new TestAdapter(getActivity());
        adapter.setIsLoadMore(true);
        adapter.setPageCount(10);
        adapter.setOnRecyclerViewListener(onItemClickListener);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        adapter.setLoadMore(mRecyclerView, layoutManager, new QxqBaseRecyclerViewAdapter.RecyclerViewLoadMoreCallBack() {
            @Override
            public void loadMore() {
                page ++;
                int num = 10;
                if(page == 4){
                    num = 8;
                }
                for(int i = 0 ; i < num ; i ++){
                    list.add(new TestModel("name"+(10+i+1),"123456789@qq.com"));
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.update(list,page);
                    }
                },1000);
            }
        });
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL,R.color.index_item_grey));
        mRecyclerView.setAdapter(adapter);


        adapter.update(list,page);
    }

    private OnRecyclerViewListener onItemClickListener = new OnRecyclerViewListener() {
        @Override
        public void onItemClick(int position) {
            TestModel testModel = (TestModel) adapter.getItem(position);
            QxqToastUtil.getInstance(getActivity()).showLongToast(testModel.getName());
        }
        @Override
        public boolean onItemLongClick(int position) {
            return false;
        }

    };



    @Override
    public void initListener(View view) {
        view.findViewById(R.id.refresh).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.refresh:
                adapter.update_XS(true);
                break;
        }
    }


}
