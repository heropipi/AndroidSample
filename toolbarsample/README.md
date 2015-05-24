<link href='http://google-code-prettify.googlecode.com/svn/trunk/src/prettify.css' type='text/css' rel='stylesheet' />
<script type='text/javascript' src='http://google-code-prettify.googlecode.com/svn/trunk/src/prettify.js'></script>

Toolbar 學習記錄
=====
[重點說明](#0)<br />
[參考文獻](#999)
* * *

<a name="0"/>
## 重點說明 ##
-  設定gradle的函式庫
	- 加入com.android.support:appcompat-v7:22.1.1

<pre class="prettyprint">
<code>
dependencies {
	compile fileTree(dir: 'libs', include: ['*.jar'])
	compile 'com.android.support:appcompat-v7:22.1.1'
}
</code>
</pre>

- 設定Style
	- 修改位於app/res/values/styles.xml
	- 設定Style的parent屬性為"Theme.AppCompat"
	- 將windowActionBar設定為false

<pre class="prettyprint"><code class="language-xml">
&lt;resources&gt;
	&lt;style name="AppTheme" parent="Theme.AppCompat.NoActionBar"&gt;
		&lt;!-- Customize your theme here. --&gt;
	&lt;/style&gt;
&lt;/resources&gt;
</code></pre>

- 設定Layout
	- 於對應的Activity加入toobar, 如app/res/layoutactivity_main.xml
	- 將minHeight屬性設定為?attr/actionBarSize

<pre class="prettyprint"><code class="language-xml">
&lt;android.support.v7.widget.Toolbar
        android:id="@+id/tool_bar"
        android:layout_width="match_parent"
        android:layout_height="?attr/actionBarSize" /&gt;
</code></pre>

- 繫結程式
	- 於對應的*.java內加入內容, 如app/java/MainActivity.java
	- 所需要引用之函式
	- 將Activity繼承AppCompatActivity
	- 建立一個Toolbar物件
	- 建立一個初始化initToolbar()設定toolbar的初始參數
	- 將此initToolbar()放置activity內的onCreate內

<pre class="prettyprint"><code class="language-java">
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
</code></pre>

<pre class="prettyprint"><code class="language-java">
public class MainActivity extends AppCompatActivity
</code></pre>
<pre class="prettyprint"><code class="language-java">
    private Toolbar mToolbar;
</code></pre>
<pre class="prettyprint"><code class="language-java">
    /**
     * Initialize Toolbar
     */
    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);// bind in code
        mToolbar.setLogo(R.mipmap.ic_launcher);// Set toolbar Logo
        mToolbar.setTitle("Your Title");// Set toolbar title
        setSupportActionBar(mToolbar);// Set toolbar to Activity
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);// Enable drawer button
    }
</code></pre>
<pre class="prettyprint"><code class="language-java">
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();
    }
</code></pre>

<a name="999"/>
## 參考文獻 ##
1. [How To Make Material Design App Bar/ActionBar and Style It](http://www.android4devs.com/2014/12/how-to-make-material-design-app.html)
2. [ANDROID – TOOLBAR STEP BY STEP](http://blog.mosil.biz/2014/10/android-toolbar/)
