package com.bf.bfdrawernavigation.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bf.bfdrawernavigation.R;

/**
 * Created by 1 on 2017/12/8.
 */

public class BFDrawerNavigationActivity extends Activity {

    public static final String BFTag = "BFTAG";

    private ActionBarDrawerToggle drawerToggle;

    /* View */
    private DrawerLayout drawerLayout;
    private ListView leftMenu;

    /* Data */
    private String[] leftMenuDataSource;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_navigation);
        this.findViews();
        this.setupDefaultData();
        this.setupLeftMenu();
    }

    /* Private */
    private void findViews() {
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        leftMenu = (ListView)findViewById(R.id.left_menu);
    }

    private void setupDefaultData() {
        leftMenuDataSource = getResources().getStringArray(R.array.drawer_menu_str);
        if (leftMenuDataSource.length > 0) {
            for (int i = 0; i < leftMenuDataSource.length; i++) {
                Log.d(BFTag, "索引号"+i+":"+leftMenuDataSource[i]);
            }
        }
    }

    private void setupLeftMenu() {
        /*设置菜单导航栏数据适配器*/
//        this.leftMenu.setAdapter(new ArrayAdapter<String>(this, null, leftMenuDataSource));
        /*添加点击事件*/
        leftMenu.setOnItemClickListener(new DrawerItemClickListener());

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                null,
                R.string.drawer_open,
                R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Log.d(BFTag, "onDrawerClosed");
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Log.d(BFTag, "onDrawerOpened");
            }
        };
        drawerLayout.addDrawerListener(drawerToggle);
    }


    private void selectItem(int index) {
        Log.d(BFTag, "点击item对应的索引号:" + index);
    }

    /*内部类*/
    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            selectItem(i);
        }
    }
}

