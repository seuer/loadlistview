package com.example.loadlistview;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class LoadAdapter extends BaseAdapter {
	LayoutInflater inflater;
	ArrayList<Entity> apkList;

	public LoadAdapter(Context context, ArrayList<Entity> apkList) {
		this.apkList = apkList;
		this.inflater = LayoutInflater.from(context);

	}

	public void DateChanged(ArrayList<Entity> apkList) {
		this.apkList = apkList;
		this.notifyDataSetChanged();
	}

	@Override
	public int getCount() {

		return apkList.size();
	}

	@Override
	public Object getItem(int position) {

		return apkList.get(position);
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Entity apkEntity = apkList.get(position);
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.item_layout, null);
			holder.name_tv = (TextView) convertView
					.findViewById(R.id.item3_apkname);
			holder.des_tv = (TextView) convertView
					.findViewById(R.id.item3_apkinfo);
			holder.info_tv = (TextView) convertView
					.findViewById(R.id.item3_apkdes);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.name_tv.setText(apkEntity.getName());
		holder.info_tv.setText(apkEntity.getInfo());
		holder.des_tv.setText(apkEntity.getDes());
		return convertView;
	}

}

class ViewHolder {
	TextView name_tv;
	TextView des_tv;
	TextView info_tv;

}
