package org.ikm98.navigationdrawersmaple;

import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();

        initDrawer();
        initDrawerListView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Initialize Toolbar
     */
    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);// bind in code
        mToolbar.setLogo(R.mipmap.ic_launcher);// Set toolbar Logo
        mToolbar.setTitle("Your Title");// Set toolbar title
        setSupportActionBar(mToolbar);// Set toolbar to Activity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);// Enable drawer button
    }

    /**
     * Initialize Navigation Drawer
     */
    private void initDrawer(){
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,    // Set parent
                mToolbar, // Set toolbar
                R.string.open_left_drawer, // Desc on Drawer Opened
                R.string.close_left_drawer // Desc on Drawer Closed
        ) {
            /**
             * Function on drawer opened
             * @param drawerView
             */
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerClosed(drawerView);

            }

            /**
             * Function on drawer closed
             * @param drawerView
             */
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }
        };

        actionBarDrawerToggle.syncState();

        mDrawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    /**
     * Initialize ListView Content
     */
    private void initDrawerListView(){
        mListView = (ListView) findViewById(R.id.navigation_drawer);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.menu_string_list) );


        mListView.setAdapter(adapter);
    }
}
