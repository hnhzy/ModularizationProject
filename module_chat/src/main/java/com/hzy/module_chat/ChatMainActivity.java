package com.hzy.module_chat;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.hzy.module_common.adapter.BottomAdapter;
import com.hzy.module_common.utils.ARouterUtils;

import static com.hzy.module_common.config.ARouterConfig.CONTACT_FRAGMENT;
import static com.hzy.module_common.config.ARouterConfig.FIND_FRAGMENT;
import static com.hzy.module_common.config.ARouterConfig.MINE_FRAGMENT;

public class ChatMainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private BottomNavigationView mBv;
    //https://blog.csdn.net/qq_20451879/article/details/79240842
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_activity_main);
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mBv = (BottomNavigationView) findViewById(R.id.bv);
//        BottomNavigationViewHelper.disableShiftMode(mBv);

        //这里可true是一个消费过程，同样可以使用break，外部返回true也可以
        mBv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R2.id.item_tab1:
                        mVp.setCurrentItem(0);
                        return true;

                    case R2.id.item_tab2:
                        mVp.setCurrentItem(1);
                        return true;

                    case R2.id.item_tab3:
                        mVp.setCurrentItem(2);
                        return true;

                    case R2.id.item_tab4:
                        mVp.setCurrentItem(3);
                        return true;
                }
                return false;
            }
        });


        //数据填充
        setupViewPager(mVp);
        //ViewPager监听
        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mBv.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //禁止ViewPager滑动
        //        mVp.setOnTouchListener(new View.OnTouchListener() {
        //                    @Override
        //                    public boolean onTouch(View v, MotionEvent event) {
        //                        return true;
        //                    }
        //                });
    }

    private void setupViewPager(ViewPager viewPager) {
        BottomAdapter adapter = new BottomAdapter(getSupportFragmentManager());
        adapter.addFragment(new ChatMainFragment());
        adapter.addFragment(ARouterUtils.getFragment(FIND_FRAGMENT));
        adapter.addFragment(ARouterUtils.getFragment(CONTACT_FRAGMENT));
        adapter.addFragment(ARouterUtils.getFragment(MINE_FRAGMENT));
        viewPager.setAdapter(adapter);
    }
}
