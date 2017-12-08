package com.bf.bfdrawernavigation;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bf.bfdrawernavigation.activity.BFDrawerNavigationActivity;

public class MainActivity extends AppCompatActivity {

    public static final String BFTAG = "BFTAG";

    /* View */
    private DrawerLayout mainLayout;
    private ListView leftMenuList;

    /* Data*/
    private String[] leftMenuArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_drawer_navigation);
    }

    /* Private */
    private void findViews() {
        Log.d(BFTAG, "findViews");
//        mainLayout = (DrawerLayout)findViewById(R.id.dn_main_fragment);
        leftMenuList = (ListView)findViewById(R.id.left_menu);
    }

    private void setupDefaultData() {
        leftMenuArr = getResources().getStringArray(R.array.drawer_menu_str);
        Log.d(BFTAG, "left menu data source count:" + leftMenuArr.length);
    }

    private void setupViews() {
        Log.d(BFTAG, "setupViews");
        /* 左侧菜单ListView */
        leftMenuList.setAdapter(new ArrayAdapter<String>(this, R.layout.view_item, leftMenuArr));
        leftMenuList.setOnItemClickListener(new DrawerItemClickListener());
    }

    /* Listener */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            selectItem(i);
        }
    }

    private void selectItem(int position) {
        Log.d(BFTAG, "点击索引号:"+position);
    }
}
