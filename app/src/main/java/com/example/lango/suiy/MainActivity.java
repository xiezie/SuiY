package com.example.lango.suiy;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;

/**
 * created by lango on 15/8/11.
 */
public class MainActivity extends AppCompatActivity {

    private FragmentFactory fragmentFactory;
    private FragmentManager fragmentManager;
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setTabListener();
        setMyActionBar();
    }

    /**
     * custom action bar
     */
    private void setMyActionBar() {
        // TODO add menu item for different fragment.
    }

    /**
     * event occurs when radio button status changed
     */
    private void setTabListener() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switchFragment(checkedId);
            }
        });
    }

    /**
     * switch whole page of fragment
     * @param checkedId
     */
    private void switchFragment(int checkedId) {
        BaseFragment fragment = fragmentFactory.getFragmentInstance(checkedId);
        Log.i("checkid",checkedId + " fragment:  "+fragment);
        if(fragment != null) {
            fragment.getActionBar(MainActivity.this.getSupportActionBar());
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.context_fame, fragment)
                    .commit();
        }
    }

    /**
     * initinal fragment and view
     * initinal value
     */
    private void init() {
        fragmentFactory = new FragmentFactory();
        fragmentManager = getSupportFragmentManager();
        radioGroup = (RadioGroup) findViewById(R.id.tab_container);
        switchFragment(R.id.tab_bkshelter);
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
}
