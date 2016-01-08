package com.edu.fireeyes.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;

import com.edu.fireeyes.R;
import com.edu.fireeyes.adapter.WaitTaskClickListViewClickAdapter;
import com.edu.fireeyes.base.BaseActivity;

public class WaitTaskClickListViewClickActivity extends BaseActivity{

	private ListView lv;
	private WaitTaskClickListViewClickAdapter adapter;
	private List<String> data = new ArrayList<String>();
	private ImageView ivBack;
	@Override
	protected void getIntentData(Bundle savedInstanceState) {
		
	}

	@Override
	protected void loadXml() {
		setContentView(R.layout.activity_wait_task_click_listview_click);
	}

	@Override
	protected void initView() {
		lv = (ListView) findViewById(R.id.activity_wait_task_click_listview_click_lv);
		ivBack = (ImageView) findViewById(R.id.activity_wait_task_click_listview_click_iv_back);
		
	}

	@Override
	protected void registerListener() {
		ivBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});
	}

	@Override
	protected void initData() {
		adapter = new WaitTaskClickListViewClickAdapter(WaitTaskClickListViewClickActivity.this);
		for (int i = 0; i < 5; i++) {
			data.add("我的中国心");
		}
		adapter.setDatas(data);
		lv.setAdapter(adapter);
		
	}

}
