package com.edu.fireeyes.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.fireeyes.R;
import com.edu.fireeyes.adapter.AddPeopleListViewAdapter;
import com.edu.fireeyes.base.BaseActivity;
import com.edu.fireeyes.bean.AddPeopleItemBean;

public class NewBuildAddPeopleActivity extends BaseActivity{

	private ListView lvPeople;
	private ImageView ivBack;
	private AddPeopleListViewAdapter adapter;
	private ArrayList<String> data;
	private TextView tvSave;
	private ArrayList<String> people = new ArrayList<String>();
	private Intent intent;
	
	@Override
	protected void getIntentData(Bundle savedInstanceState) {
		
	}

	@Override
	protected void loadXml() {
		setContentView(R.layout.activity_add_people);
	}

	@Override
	protected void initView() {
		lvPeople = (ListView) findViewById(R.id.activity_add_people_lv_people);
		ivBack = (ImageView) findViewById(R.id.activity_add_people_iv_back);
		tvSave = (TextView) findViewById(R.id.activity_add_people_tv_save);
	}

	@Override
	protected void registerListener() {
		/**
		 * 返回键监听
		 */
		ivBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});
		
		/**
		 * listview监听
		 */
		lvPeople.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				
				CheckBox cBox = (CheckBox) view.findViewById(R.id.item_listview_add_people_cbox);
				if (!cBox.isChecked()) {
					cBox.setChecked(true);
					people.add(data.get(position));
				}else{
					cBox.setChecked(false);
					people.remove(data.get(position));
				}
				adapter.notifyDataSetChanged();
			}
		});
		tvSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (people.size() == 0) {
					Toast.makeText(NewBuildAddPeopleActivity.this, "组员不得为空", 0).show();
				}else{
					intent = new Intent();
					intent.putStringArrayListExtra("people", people);
					setResult(RESULT_OK, intent);
					finish();
				}
				
			}
		});
		
	}

	@Override
	protected void initData() {
		
		data = new ArrayList<String>();
		adapter = new AddPeopleListViewAdapter(NewBuildAddPeopleActivity.this);
		for (int i = 0; i < 5; i++) {
			data.add("测试小组成员"+i);
		}
		adapter.setDatas(data);
		lvPeople.setAdapter(adapter);
		
	}

}
