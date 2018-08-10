package com.cp.mylibrary.base;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.cp.mylibrary.R;
import com.cp.mylibrary.adapter.BaseRecyclerAdapter;
import com.cp.mylibrary.api.MyResponseHandler;
import com.cp.mylibrary.custom.EmptyLayout;
import com.cp.mylibrary.custom.RecyclerRefreshLayout;
import com.cp.mylibrary.utils.LogCp;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by huanghaibin_devon 16-6-23.
 */
public abstract class BaseRecyclerViewFragment<T> extends MyBaseFragment implements
        BaseRecyclerAdapter.OnItemClickListener,
        RecyclerRefreshLayout.SuperRefreshLayoutListener {


    private RecyclerRefreshLayout mRefreshLayout;

    private RecyclerView mRecyclerView;


    private EmptyLayout recyclerview_loading;


    protected BaseRecyclerAdapter<T> mAdapter;


    public int pageSize = 10;
    public int currentPage = 0;

    protected boolean mIsRefresh;


    //解析数据
    private ParserTask mParserTask;


    @Override
    protected View inflaterView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {

        View view = inflater.inflate(R.layout.activity_base_recycler, container, false);
        return view;
    }

    @Override
    public void initView(View view) {
        super.initView(view);

        mRefreshLayout = (RecyclerRefreshLayout) view.findViewById(R.id.refreshLayout);
        recyclerview_loading = (EmptyLayout) view.findViewById(R.id.recyclerview_loading);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        LogCp.i(LogCp.CP, BaseRecyclerViewFragment.class + " 是不是null " + mRefreshLayout);


        mRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(true);
                onRefreshing();
            }
        });

        mAdapter = mAdapter == null ? getRecyclerAdapter() : mAdapter;
        mRecyclerView.setLayoutManager(getLayoutManager());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
        mRefreshLayout.setSuperRefreshLayoutListener(this);
        mRefreshLayout.setColorSchemeResources(
                R.color.swiperefresh_color1, R.color.swiperefresh_color2,
                R.color.swiperefresh_color3, R.color.swiperefresh_color4);



    }

    @Override
    public void initData() {
        super.initData();

        requestData();
    }

    public MyResponseHandler mHandler = new MyResponseHandler() {
        @Override
        public void dataSuccess(String s) {

            recyclerview_loading.setVisibility(View.GONE);

            currentPage++;

            executeParserTask(s);


        }

        @Override
        public void dataFinish() {
            onLoadingFinish();
        }

        @Override
        public void dataFailuer(int i, String s) {
            //  onFailure(statusCode, headers, responseString, e);

            LogCp.i(LogCp.CP, BaseRecyclerViewFragment.class + " 接口报错 " + i + s);
        }
    };

    private void executeParserTask(String data) {
        cancelParserTask();
        mParserTask = new ParserTask(data);
        mParserTask.execute();
    }

    private void cancelParserTask() {
        if (mParserTask != null) {
            mParserTask.cancel(true);
            mParserTask = null;
        }
    }

    class ParserTask extends AsyncTask<Void, Void, String> {

        private final String reponseData;
        private boolean parserError;

        private List<T>
                currentList = new ArrayList<T>();

        public ParserTask(String data) {
            this.reponseData = data;
        }

        @Override
        protected String doInBackground(Void... params) {
            try {


                currentList = parseList(reponseData);
//                LogCp.i(LogCp.CP, BaseRecyclerViewFragment.class + "解析 出来的数据 的，值 ，，"
//                        + currentList);


            } catch (Exception e) {
                e.printStackTrace();

                parserError = true;
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (parserError) {

                //解析出错了
                //  readCacheData(getCacheKey());

                onLoadingFailure();
            } else {

                setListData(currentList);
                onLoadingSuccess();
            }
        }
    }

    protected List<T> parseList(String is) {
        return null;
    }


    @Override
    public void onItemClick(int position, long itemId) {
        onItemClick(mAdapter.getItem(position), position);
    }

    @Override
    public void onRefreshing() {
        mIsRefresh = true;
        currentPage = 0;

        requestData();
    }

    @Override
    public void onLoadMore() {
        mAdapter.setState(mRefreshLayout.isRefreshing() ? BaseRecyclerAdapter.STATE_HIDE : BaseRecyclerAdapter.STATE_LOADING, true);
        requestData();
    }

    protected void onItemClick(T item, int position) {

    }

    protected void requestData() {

    }

    protected void setListData(List<T> data) {


        if (mIsRefresh) {

            mAdapter.clear();
            mAdapter.addAll(data);

            mRefreshLayout.setCanLoadMore(true);
            mIsRefresh = false;

        } else {
            mAdapter.addAll(data);
        }


        mAdapter.setState(data == null || data.size() < getPageSize() ? BaseRecyclerAdapter.STATE_NO_MORE : BaseRecyclerAdapter.STATE_LOADING, true);

    }

    protected int getPageSize() {
        return pageSize;

    }

    protected void onLoadingStart() {

    }

    protected void onLoadingSuccess() {

    }

    protected void onLoadingFinish() {
        mRefreshLayout.onComplete();
        //     mIsRefresh = false;
    }

    protected void onLoadingFailure() {
        if (mAdapter.getItems().size() == 0) {
            mAdapter.setState(BaseRecyclerAdapter.STATE_LOAD_ERROR, true);
        } else {
            mAdapter.setState(BaseRecyclerAdapter.STATE_NO_MORE, true);
        }
    }


    protected abstract BaseRecyclerAdapter<T> getRecyclerAdapter();


    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getActivity());
    }


}
