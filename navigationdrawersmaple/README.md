<link href='http://google-code-prettify.googlecode.com/svn/trunk/src/prettify.css' type='text/css' rel='stylesheet' />
<script type='text/javascript' src='http://google-code-prettify.googlecode.com/svn/trunk/src/prettify.js'></script>

NavigationDrawer學習記錄
=====
[重點說明](#0)<br />
[參考文獻](#999)
* * *

<a name="0"/>
## 重點說明 ##
- 建立Toolbar並且產生NavigationDrawer之按鈕
	- 依照ToolbarSample步驟建立Toolbar
	- 修改MainActivity.java -> initToolbar函式

<pre class="prettyprint"><code class="language-java">
private void initToolbar() {
	mToolbar = (Toolbar) findViewById(R.id.tool_bar);// bind in code
	mToolbar.setLogo(R.mipmap.ic_launcher);// Set toolbar Logo
	mToolbar.setTitle("Your Title");// Set toolbar title
	setSupportActionBar(mToolbar);// Set toolbar to Activity
	getSupportActionBar().setDisplayHomeAsUpEnabled(true);// Enable drawer button
}
</code></pre>

- 設定Layout
	- 依下Layout進行設定

<pre class="prettyprint"><code class="language-xml">
&lt;android.support.v4.widget.DrawerLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/drawer_layout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"&gt;
    &lt;!-- Content --&gt;
    &lt;LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical" &gt;
        &lt;android.support.v7.widget.Toolbar
            android:id="@+id/tool_bar"
            android:layout_width="match_parent"
            android:layout_height="?attr/actionBarSize"&gt;
        &lt;/android.support.v7.widget.Toolbar&gt;
        &lt;!-- Main Content --&gt;
        &lt;FrameLayout
            android:id="@+id/main_frame"
            android:layout_width="match_parent"
            android:layout_height="match_parent" /&gt;
    &lt;/LinearLayout&gt;
    &lt;!-- The navigation drawer --&gt;
    &lt;ListView android:id="@+id/navigation_drawer"
        android:layout_width="240dp"
        android:layout_height="match_parent"
        android:fitsSystemWindows="true"
        android:layout_gravity="start"
        android:choiceMode="singleChoice"
        android:dividerHeight="0dp" /&gt;
&lt;/android.support.v4.widget.DrawerLayout&gt;
</code></pre>

- 繫結程式
	- 所需要引用之函式
	- 建立物件
		- 一個DrawerLayout物件
		- 一個ListView物件, 用以顯示Drawer內容
	- 新增Method
		- initDrawer(), 用以初始化Drawer動作
		- initDrwerListView(), 用以設定DrawerListView顯示之內容
	- 將Method放入onCreate()

<pre class="prettyprint"><code class="language-java">
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
</code></pre>
<pre class="prettyprint"><code class="language-java">
    private DrawerLayout mDrawerLayout;
    private ListView mListView;
</code></pre>
<pre class="prettyprint"><code class="language-java">
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
</code></pre>
<pre class="prettyprint"><code class="language-java">
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
</code></pre>
<pre class="prettyprint"><code class="language-java">
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();

        initDrawer();
        initDrawerListView();
    }
</code></pre>

<a name="999"/>
## 參考文獻 ##
1. [ANDROID – TOOLBAR 上的 NAVIGATION DRAWER](http://blog.mosil.biz/2014/10/navigation-drawer-on-toolbar/)
