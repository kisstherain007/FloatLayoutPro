package com.example.zhoubo.floatlayoutpro;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mingwei.floatlayout.ListViewFragment;
import com.mingwei.floatlayout.ScrollViewFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mFloatContent;
    private List<Fragment> mFragments = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mFloatContent = (ViewPager) findViewById(R.id.float_layout_content);
        mFragments.add(ListViewFragment.getInstain());
        mFragments.add(ScrollViewFragment.getInstain());
        mFloatContent.setAdapter(new MyAdapter(getSupportFragmentManager(), mFragments));
    }

    class MyAdapter extends FragmentPagerAdapter {

        private List<Fragment> mList;

        public MyAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            mList = list;
        }

        @Override
        public Fragment getItem(int arg0) {
            return mList.get(arg0);
        }

        @Override
        public int getCount() {
            return mList.size();
        }
    }
}
