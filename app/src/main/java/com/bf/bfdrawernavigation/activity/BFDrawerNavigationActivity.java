package com.bf.bfdrawernavigation.activity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.widget.ListView;

import com.bf.bfdrawernavigation.R;

/**
 * Created by 1 on 2017/12/8.
 */

public class BFDrawerNavigationActivity extends Activity {

    public static final String BFTag = "BFTAG";

    /* View */
    private DrawerLayout mainLayout;
//    private Fragment mainFragment;
//    private Fragment drawerView;
    private ListView leftMenu;

    /* Data */
    private String[] leftMenuDataSource;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_drawer_navigation);
        this.findViews();
        this.setupDefaultData();
        this.setupLeftMenu();
    }

    /* Private */
    private void findViews() {
        mainLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
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
//        this.leftMenu.setAdapter(new ArrayAdapter<String>(this, null, leftMenuDataSource));
    }
}
