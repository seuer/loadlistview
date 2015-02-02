package com.example.loadlistview;

import java.util.ArrayList;

import com.example.loadlistview.LoadListView.ILoadListener;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends Activity implements ILoadListener {

	ArrayList<Entity> apkList = new ArrayList<Entity>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		showListView(apkList);
		getData();
	}

	LoadListView listview;
	LoadAdapter adapter;

	// 显示listview
	public void showListView(ArrayList<Entity> apkList) {
		if (adapter == null) {
			listview = (LoadListView) findViewById(R.id.listview);
			listview.setInterface(this);
			adapter = new LoadAdapter(this, apkList);
			listview.setAdapter(adapter);

		} else {
			adapter.DateChanged(apkList);
		}
	}

	// 加载数据
	public void getData() {
		for (int i = 0; i < 10; i++) {
			Entity entity = new Entity();
			entity.setDes("这是一个神奇的应用！");
			entity.setName("测试程序");
			entity.setInfo("50W用户");
			apkList.add(entity);
		}
	}

	// 加载更多数据
	public void getMoreData() {
		for (int i = 0; i < 2; i++) {
			Entity entity = new Entity();
			entity.setDes("这是一个神奇的应用！");
			entity.setName("测试程序");
			entity.setInfo("50W用户");
			apkList.add(entity);
		}
	}

	@Override
	public void onLoad() {
	
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
			getMoreData();
			showListView(apkList);
			listview.loadComplete();
				
			}
		}, 3000);

	}

}
