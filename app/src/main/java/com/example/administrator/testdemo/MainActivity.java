package com.example.administrator.testdemo;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.testdemo.fragment.Buttom_Fragment_one;
import com.example.administrator.testdemo.fragment.Buttom_Fragment_three;
import com.example.administrator.testdemo.fragment.Buttom_Fragment_two;
import com.example.mylibrary.base.CM_BaseActivity;

public class MainActivity extends CM_BaseActivity implements View.OnClickListener{
    ImageView iv_intelligence, iv_moneypay, iv_unionpay;
    TextView main_bottom1, main_bottom2, main_bottom3;
    LinearLayout lv_1, lv_2, lv_3;


    Buttom_Fragment_one buttom_fragment_one;
    Buttom_Fragment_two buttom_fragment_two;
    Buttom_Fragment_three buttom_fragment_three;


    FragmentManager fragmentManager;
    Fragment currentFragment;
    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        inID();
        initdata();
        buttom_fragment_one = new Buttom_Fragment_one();
        buttom_fragment_two = new Buttom_Fragment_two();
        buttom_fragment_three = new Buttom_Fragment_three();

        fragmentManager = getSupportFragmentManager();
        currentFragment = buttom_fragment_one;
        fragmentManager.beginTransaction().add(R.id.tab_home, buttom_fragment_one, "topBar_fm_first").commit();

    }
    //初始化控件
    public void initdata() {
        iv_intelligence.setImageResource(R.mipmap.ic_launcher);
        iv_unionpay.setImageResource(R.mipmap.ic_launcher);
        iv_moneypay.setImageResource(R.mipmap.ic_launcher);

        main_bottom1.setTextColor(Color.GRAY);
        main_bottom2.setTextColor(Color.GRAY);
        main_bottom3.setTextColor(Color.GRAY);
    }

    private void inID(){
        iv_intelligence = (ImageView) findViewById(R.id.iv_intelligence);
        iv_moneypay = (ImageView) findViewById(R.id.iv_moneypay);
        iv_unionpay = (ImageView) findViewById(R.id.iv_unionpay);
        main_bottom1 = (TextView) findViewById(R.id.main_bottom1);
        main_bottom2 = (TextView) findViewById(R.id.main_bottom2);
        main_bottom3 = (TextView) findViewById(R.id.main_bottom3);

        lv_1 = (LinearLayout) findViewById(R.id.lv_1);
        lv_2 = (LinearLayout) findViewById(R.id.lv_2);
        lv_3 = (LinearLayout) findViewById(R.id.lv_3);
        lv_1.setOnClickListener(this);
        lv_2.setOnClickListener(this);
        lv_3.setOnClickListener(this);
        //默认
        main_bottom1.setTextColor(Color.parseColor("#ff40ab54"));
        iv_intelligence.setImageResource(R.mipmap.ic_launcher);


    }
    /***
     * 高效切换fragment
     *
     * @param fragment1
     * @param tag
     */
    public void change(Fragment fragment1, String tag) {

        Fragment fragment = fragmentManager.findFragmentByTag(tag);//判断此Fragment是否已经被add //若不曾被add
        if (fragment == null) {
            fragmentManager.beginTransaction().hide(currentFragment).add(R.id.tab_home, fragment1, tag).addToBackStack(null).commit();
            currentFragment = fragment1;
        } else {  //如果已经被add并且处于隐藏状态     //将当前Fragment隐藏并显示fragment1
            fragmentManager.beginTransaction().hide(currentFragment).show(fragment1).addToBackStack(null).commit();
            currentFragment = fragment1;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lv_1:
                initData();
                change(buttom_fragment_one, "topBar_fm_first");
                main_bottom1.setTextColor(Color.parseColor("#ff40ab54"));
//                iv_intelligence.setImageResource(R.mipmap.widget_bar_news_over);
                break;
            case R.id.lv_2:
                initData();
                change(buttom_fragment_two, "topBar_fm_second");
                main_bottom2.setTextColor(Color.parseColor("#ff40ab54"));
//                iv_unionpay.setImageResource(R.mipmap.widget_bar_question_over);
                break;
            case R.id.lv_3:
                initData();
                change(buttom_fragment_three, "topBar_fm_thirty");
                main_bottom3.setTextColor(Color.parseColor("#ff40ab54"));
//                iv_moneypay.setImageResource(R.mipmap.widget_bar_tweet_over);
                break;
        }
    }
}
