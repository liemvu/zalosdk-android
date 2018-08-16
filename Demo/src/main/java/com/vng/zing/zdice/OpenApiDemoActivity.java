package com.vng.zing.zdice;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.zing.zalo.zalosdk.oauth.ZaloOpenAPICallback;
import com.zing.zalo.zalosdk.oauth.ZaloSDK;

import org.json.JSONObject;

public class OpenApiDemoActivity extends ZBaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.openapi_demo);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		findViewById(R.id.btn_back).setVisibility(View.GONE);
		findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		((TextView)findViewById(R.id.title_text)).setText(R.string.title_open_api);

	}
	
	@Override
	protected void onResume() {
		super.onResume();
		requestChangeFocusImage();
	}
	
	public void getprofileclick(View v){
		showProgress();
		ZaloSDK.Instance.getProfile(this, new ZaloOpenAPICallback() {
			
			@Override
			public void onResult(JSONObject arg0) {
				hideProgress();
				((TextView)findViewById(R.id.output_value)).setText(arg0.toString());
			}
		});
	}
	
	public void getfriendlist_click(View v){
		showProgress();
		ZaloSDK.Instance.getFriendList(this, 0, 999, new ZaloOpenAPICallback() {
			@Override
			public void onResult(JSONObject arg0) {
				hideProgress();
				((TextView)findViewById(R.id.output_value)).setText(arg0.toString());
			}
		});
	}
}
