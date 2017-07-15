package com.ehome.niuyunyang.nyylib.widget.list_grid_view.baseadapter;

public interface MultiItemTypeSupport<T>
{
	int getLayoutId(int position, T t);

	int getViewTypeCount();

	int getItemViewType(int postion, T t);
}