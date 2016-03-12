package com.zero.legwork.app.homepage;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.zero.legwork.R;
import com.zero.legwork.adapter.HomePagerAdapter;
import com.zero.legwork.app.BaseActivity;
import com.zero.legwork.widget.TabItemView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener,ViewPager.OnPageChangeListener {

    private List<Fragment> mTabs = new ArrayList<Fragment>();

    //　适配器
    private HomePagerAdapter mAdapter;

    private Context mContext;

    private List<TabItemView> mTabIndicators = new ArrayList<TabItemView>();

    @Bind(R.id.act_title)   TextView mTitle;

    @Bind(R.id.container)   ViewPager mViewPager;

    @Bind(R.id.tab_work)    TabItemView mTabWork;
    @Bind(R.id.tab_visit)   TabItemView mTabVisit;
    @Bind(R.id.tab_report)  TabItemView mTabReport;
    @Bind(R.id.tab_other)   TabItemView mTabOther;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        ButterKnife.bind(this);
        mContext = this;

        initData();
        initEvent();
    }

    /**
     * 初始化所有点击或滑动事件
     */
    private void initEvent() {
        mViewPager.addOnPageChangeListener(this);
        mTabWork.setOnClickListener(this);
        mTabVisit.setOnClickListener(this);
        mTabReport.setOnClickListener(this);
        mTabOther.setOnClickListener(this);
    }
    // 初始化数据
    private void initData() {
        WorkFragment mWorkFragment = new WorkFragment();
        VisitFragment mVisitFragment = new VisitFragment();
        ReportFragment mReportFragment = new ReportFragment();
        OtherFragment mOtherFragment = new OtherFragment();

        mTabs.add(mWorkFragment);
        mTabs.add(mVisitFragment);
        mTabs.add(mReportFragment);
        mTabs.add(mOtherFragment);

        mTabIndicators.add(mTabWork);
        mTabIndicators.add(mTabVisit);
        mTabIndicators.add(mTabReport);
        mTabIndicators.add(mTabOther);

        // 默认日常工作选中
        mTabWork.setIconAlpha(1.0f);

        mAdapter = new HomePagerAdapter(getSupportFragmentManager());

        for (int i = 0; i < mTabs.size(); i++) {
            mAdapter.addFragment(mTabs.get(i));
        }
        mViewPager.setAdapter(mAdapter);
        // 设置默认界面()
        mViewPager.setCurrentItem(0);
        mTitle.setText(getResources().getString(R.string.tab_title_work));
    }

    private void clickTab(View v) {
        resetOtherTabs();

        switch (v.getId()) {
            case R.id.tab_work:
                mTabIndicators.get(0).setIconAlpha(1.0f);
                mViewPager.setCurrentItem(0, false);
                pageChangeLoad(0);
                break;
            case R.id.tab_visit:
                mTabIndicators.get(1).setIconAlpha(1.0f);
                mViewPager.setCurrentItem(1, false);
                pageChangeLoad(1);
                break;
            case R.id.tab_report:
                mTabIndicators.get(2).setIconAlpha(1.0f);
                mViewPager.setCurrentItem(2, false);
                pageChangeLoad(2);
                break;
            case R.id.tab_other:
                mTabIndicators.get(3).setIconAlpha(1.0f);
                mViewPager.setCurrentItem(3, false);
                pageChangeLoad(3);
                break;
        }
    }

    /**
     * 根据下标更新title
     * @param index
     */
    private void pageChangeLoad(int index){
        switch (index){
            case 0:
                mTitle.setText(getResources().getString(R.string.tab_title_work));
                break;
            case 1:
                mTitle.setText(getResources().getString(R.string.tab_title_visit));
                break;
            case 2:
                mTitle.setText(getResources().getString(R.string.tab_title_report));
                break;
            case 3:
                mTitle.setText(getResources().getString(R.string.tab_title_other));
                break;
        }
    }

    /**
     * 重置其他的TabIndicator的颜色
     */
    private void resetOtherTabs() {
        for (int i = 0; i < mTabIndicators.size(); i++) {
            mTabIndicators.get(i).setIconAlpha(0);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (positionOffset > 0) {
            TabItemView left = mTabIndicators.get(position);
            TabItemView right = mTabIndicators.get(position + 1);
            left.setIconAlpha(1 - positionOffset);
            right.setIconAlpha(positionOffset);
        }
    }

    @Override
    public void onPageSelected(int position) {
        pageChangeLoad(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        clickTab(v);
    }
}
