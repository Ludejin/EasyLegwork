package com.zero.legwork.app.homepage;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zero.legwork.R;


/**
 * Created by Jin_ on 2015/12/25
 * 邮箱：dejin_lu@creawor.com
 */
public class WorkFragment extends Fragment{

	private View view;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (null == view) {
			view = inflater.inflate(R.layout.frag_work, container, false);
		}
		return view;
	}
}
