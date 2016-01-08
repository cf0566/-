package com.edu.fireeyes.activity;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.edu.fireeyes.R;
import com.edu.fireeyes.adapter.DivideTaskAdapter;
import com.edu.fireeyes.base.BaseActivity;

public class DivideTaskActivity extends BaseActivity{
	
	private ImageView ivBack;
	private ArrayList<String> people;
	private ExpandableListView lvName;
	private LinearLayout linear;
	private CheckBox cBox;
	private TextView tvSave,tvSelect,tvChange;
	private String [] name = {"周杰伦","郎静茹","詹姆斯"};
	private String [][] task = {{"测试一下","测试两下","测试三下"},{"测试两下"},{"测试三下"}};
	ArrayList<String> task1 =  new ArrayList<String>();
	
	@Override
	protected void getIntentData(Bundle savedInstanceState) {
		
	}

	@Override
	protected void loadXml() {
		setContentView(R.layout.activity_divide_task);
	}

	@Override
	protected void initView() {
		ivBack = (ImageView) findViewById(R.id.activity_divide_task_back);
		lvName = (ExpandableListView) findViewById(R.id.activity_divide_task_elv_name);
		tvSave = (TextView) findViewById(R.id.activity_divide_task_save);
	}

	@Override
	protected void registerListener() {
		/**
		 * 返回监听
		 */
		ivBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});
		/**
		 * 保存监听
		 */
		tvSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				linear.setVisibility(View.VISIBLE);
				cBox.setVisibility(View.GONE);
			}
		});
		lvName.setOnChildClickListener(new OnChildClickListener() {
			
			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				linear = (LinearLayout) v.findViewById(R.id.item_divide_task_listview_item_ll);
				tvSelect = (TextView) v.findViewById(R.id.item_divide_task_listview_item_tv_select);
				tvChange = (TextView) v.findViewById(R.id.item_divide_task_listview_item_tv_change);
				cBox = (CheckBox) v.findViewById(R.id.item_divide_task_listview_item_cbox);
				if (!cBox.isChecked()){
					cBox.setChecked(true);
					StringBuilder sb = new StringBuilder();
					sb.append(cBox.getText()+" ");
					tvSelect.setText(sb.toString());
				} else  {
					cBox.setChecked(false);
				}
				
				tvChange.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						linear.setVisibility(View.GONE);
						cBox.setVisibility(View.VISIBLE);
					}
				});
				return false;
			}
		});
		
	}

	@Override
	protected void initData() {
		DivideTaskAdapter adapter = new DivideTaskAdapter(DivideTaskActivity.this);
		adapter.setDatas(name, task);
		lvName.setAdapter(adapter);
	
	}

}
