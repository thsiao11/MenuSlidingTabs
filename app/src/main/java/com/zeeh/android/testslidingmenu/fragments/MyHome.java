package com.zeeh.android.testslidingmenu.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;

import com.zeeh.android.testslidingmenu.R;
import com.zeeh.android.testslidingmenu.adapters.MyFragmentPagerAdapter;
import com.zeeh.android.testslidingmenu.inner.fragments.Tab1Fragment;
import com.zeeh.android.testslidingmenu.inner.fragments.Tab2Fragment;
import com.zeeh.android.testslidingmenu.inner.fragments.Tab3Fragment;

import java.util.ArrayList;
import java.util.List;

public class MyHome extends Fragment implements ViewPager.OnPageChangeListener, TabHost.OnTabChangeListener {

    private TabHost tabHost;
    private ViewPager viewPager;
    View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.tabs_viewpager_layout, container, false);

        //we put TabHostView Pager here:
        /* part1*********************/

        initViewPager();
        initTabHost();

        /* part1*********************/
        return v;
    }

    private void initViewPager() {
        viewPager = (ViewPager)v.findViewById(R.id.view_pager);
        List<Fragment> listFragments = new ArrayList<Fragment>();
        listFragments.add(new Tab1Fragment());
        listFragments.add(new Tab2Fragment());
        listFragments.add(new Tab3Fragment());

        listFragments.add(new Tab1Fragment());
        listFragments.add(new Tab2Fragment());
        listFragments.add(new Tab3Fragment());

        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(
                getChildFragmentManager(), listFragments);
        viewPager.setAdapter(myFragmentPagerAdapter);
        viewPager.setOnPageChangeListener(this);
    }

    private void initTabHost() {
        tabHost = (TabHost)v.findViewById(R.id.tabHost);
        tabHost.setup();

        String[] tabNames = {"Tab1","Tab2","Tab3","Tab4","Tab5","Tab6"};

        for (int i=0;i<tabNames.length;i++){
            TabHost.TabSpec tabSpec = tabHost.newTabSpec(tabNames[i]);
            tabSpec.setIndicator(tabNames[i]);
            tabSpec.setContent(new FakeContent(getActivity()));
            tabHost.addTab(tabSpec);
        }
        tabHost.setOnTabChangedListener(this);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int selectedItem) {
        tabHost.setCurrentTab(selectedItem);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onTabChanged(String tabId) {
        int selectedItem = tabHost.getCurrentTab();
        viewPager.setCurrentItem(selectedItem);

        HorizontalScrollView hScrollView = (HorizontalScrollView)v.findViewById(R.id.h_scroll_view);
        View tabView = tabHost.getCurrentTabView();
        int scrollPos = tabView.getLeft() - (hScrollView.getWidth() - tabView.getWidth())/2;
        hScrollView.smoothScrollTo(scrollPos, 0);
    }

    // fake content for tabhose
    public class FakeContent implements TabHost.TabContentFactory {
        Context context;

        public FakeContent(Context mContext) {
            context = mContext;
        }

        @Override
        public View createTabContent(String tag) {

            View fakeView = new View(context);
            fakeView.setMinimumHeight(0);
            fakeView.setMinimumWidth(0);
            return fakeView;
        }
    }

}
