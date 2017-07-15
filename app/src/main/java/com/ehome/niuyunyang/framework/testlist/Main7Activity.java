package com.ehome.niuyunyang.framework.testlist;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.ehome.niuyunyang.framework.R;
import com.ehome.niuyunyang.nyylib.widget.list_grid_view.recycleradapter.CommonAdapter;
import com.ehome.niuyunyang.nyylib.widget.list_grid_view.recycleradapter.MultiItemTypeAdapter;
import com.ehome.niuyunyang.nyylib.widget.list_grid_view.recycleradapter.base.ItemViewDelegate;
import com.ehome.niuyunyang.nyylib.widget.list_grid_view.recycleradapter.base.ViewHolder;
import com.ehome.niuyunyang.nyylib.widget.list_grid_view.recycleradapter.wrapper.EmptyWrapper;
import com.ehome.niuyunyang.nyylib.widget.list_grid_view.recycleradapter.wrapper.HeaderAndFooterWrapper;
import com.ehome.niuyunyang.nyylib.widget.list_grid_view.recycleradapter.wrapper.LoadMoreWrapper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main7Activity extends AppCompatActivity {

    @BindView(R.id.recycleview)
    RecyclerView recycleview;
    private List<String> mDatas=new ArrayList<>();
    private CommonAdapter<String> adapter;
    private MultiItemTypeAdapter multiItemTypeAdapter;
    private HeaderAndFooterWrapper headerAndFooterWrapper;
    private LoadMoreWrapper loadMoreWrapper;
    private EmptyWrapper emptyWrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        ButterKnife.bind(this);
       // initDatas();
        recycleview.setLayoutManager(new GridLayoutManager(this,2));
        recycleview.setLayoutManager(new LinearLayoutManager(this));
        recycleview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        adapter=new CommonAdapter<String>(this,R.layout.listview_item,mDatas) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {
                       holder.setText(R.id.tv_title,s+ " : " + holder.getAdapterPosition() + " , " + holder.getLayoutPosition());
            }
        };
       // recycleview.setAdapter(adapter);
       // mutiitem();
       // initheardview();
       // loadmore();
        empty();
        loadmore();


    }
    private void initDatas()
    {
        for (int i = 'A'; i <= 'z'; i++)
        {
            mDatas.add((char) i + "");
        }
    }
    public void mutiitem(){
        multiItemTypeAdapter = new MultiItemTypeAdapter(this,mDatas);
        multiItemTypeAdapter.addItemViewDelegate(new ItemViewDelegate<String>() {
            @Override
            public int getItemViewLayoutId() {
                return R.layout.header;
            }

            @Override
            public boolean isForViewType(String item, int position) {
                if (position%2==0){
                    return true;
                }else
                return false;
            }

            @Override
            public void convert(ViewHolder holder, String s, int position) {
                holder.setText(R.id.tv_title,s+ " : " + holder.getAdapterPosition() + " , " + holder.getLayoutPosition());
            }
        });
        multiItemTypeAdapter.addItemViewDelegate(new ItemViewDelegate<String>() {
            @Override
            public int getItemViewLayoutId() {
                return R.layout.listview_item;
            }

            @Override
            public boolean isForViewType(String item, int position) {
              if (position%2!=0){
                  return true;
              }else return false;
            }

            @Override
            public void convert(ViewHolder holder, String s, int position) {
                holder.setText(R.id.tv_title,s+ " : " + holder.getAdapterPosition() + " , " + holder.getLayoutPosition());
            }
        });
        recycleview.setAdapter(multiItemTypeAdapter);

    }
    public void initheardview(){
        headerAndFooterWrapper = new HeaderAndFooterWrapper(adapter);
        TextView t1 = new TextView(this);
        t1.setText("Header 1");
        TextView t2 = new TextView(this);
        t2.setText("Header 2");
        TextView t3 = new TextView(this);
        t3.setText("Footer 1");
        headerAndFooterWrapper.addHeaderView(t1);
        headerAndFooterWrapper.addHeaderView(t2);
        headerAndFooterWrapper.addFootView(t3);
        recycleview.setAdapter(headerAndFooterWrapper);
    }
    private void loadmore(){
        loadMoreWrapper = new LoadMoreWrapper(emptyWrapper);
        loadMoreWrapper.setLoadMoreView(R.layout.default_loading);
        loadMoreWrapper.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                     new Handler().postDelayed(new Runnable() {
                         @Override
                         public void run() {
                             for (int i = 0; i < 10; i++)
                             {
                                 mDatas.add("Add:" + i);
                             }
                             loadMoreWrapper.notifyDataSetChanged();
                         }
                     },2000);
            }
        });
        recycleview.setAdapter(loadMoreWrapper);

    }
    private void empty(){
        emptyWrapper = new EmptyWrapper(adapter);
        emptyWrapper.setEmptyView(LayoutInflater.from(this).inflate(R.layout.empty_view, recycleview, false));
        recycleview.setAdapter(emptyWrapper);
    }

}
