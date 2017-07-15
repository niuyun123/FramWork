package com.ehome.niuyunyang.nyylib.widget.list_grid_view.recycleradapter.base;


public interface ItemViewDelegate<T>
{

    int getItemViewLayoutId();

    boolean isForViewType(T item, int position);

    void convert(ViewHolder holder, T t, int position);

}
