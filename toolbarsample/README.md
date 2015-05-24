<link href='http://google-code-prettify.googlecode.com/svn/trunk/src/prettify.css' type='text/css' rel='stylesheet' />
<script type='text/javascript' src='http://google-code-prettify.googlecode.com/svn/trunk/src/prettify.js'></script>

Toolbar Study Report
=====
[Important](#0)<br />
[Reference](#999)
* * *

<a name="0"/>
## Important ##
-  Setting Libary of gradle
	- Add 'com.android.support:appcompat-v7:22.1.1'

<pre class="prettyprint">
<code>
dependencies {
	compile fileTree(dir: 'libs', include: ['*.jar'])
	compile 'com.android.support:appcompat-v7:22.1.1'
}
</code>
</pre>

- Setting Style
	- Fix on app/res/values/styles.xml
	- Set "Theme.AppCompat.NoActionBar" on "parent" attribute of Style

<pre class="prettyprint"><code class="language-xml">
&lt;resources&gt;
	&lt;style name="AppTheme" parent="Theme.AppCompat.NoActionBar"&gt;
		&lt;!-- Customize your theme here. --&gt;
	&lt;/style&gt;
&lt;/resources&gt;
</code></pre>

- Setting Layout
	- Add toolbar tag in Activity, 如app/res/layoutactivity_main.xml
	- Set "?attr/actionBarSize" on toolbar height attribute

<pre class="prettyprint"><code class="language-xml">
&lt;android.support.v7.widget.Toolbar
        android:id="@+id/tool_bar"
        android:layout_width="match_parent"
        android:layout_height="?attr/actionBarSize" /&gt;
</code></pre>

- Binding code
	- Write on *Actibity.java, 如app/java/MainActivity.java
	- Import libary
	- Activity extend AppCompatActivity
	- Add a toolbar object
	- Create a method named "initToolbar()"
	- Call "initToolbar()" on Activity -> onCreate

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
## Reference ##
1. [How To Make Material Design App Bar/ActionBar and Style It](http://www.android4devs.com/2014/12/how-to-make-material-design-app.html)
2. [ANDROID – TOOLBAR STEP BY STEP](http://blog.mosil.biz/2014/10/android-toolbar/)
