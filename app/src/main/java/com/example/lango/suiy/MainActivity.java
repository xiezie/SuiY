package com.example.lango.suiy;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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

    private Fragment bookShelterFragment, bookStoreFragment, personalFragment;
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        switchFragment(R.id.tab_bkshelter);
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
     * @param
     */
    private void switchFragment(int checkedId) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (checkedId) {
            case R.id.tab_bkshelter:
                bookShelterFragment = fragmentManager.findFragmentByTag(BookShelterFragment.class.getSimpleName());
                hideFragments(fragmentTransaction);
                if(bookShelterFragment == null) {
                    bookShelterFragment = new BookShelterFragment();
                    fragmentTransaction.add(R.id.context_fame, bookShelterFragment, BookShelterFragment.class.getSimpleName());
                } else {
                    fragmentTransaction.show(bookShelterFragment);
                }
                break;
            case R.id.tab_bkstore:
                bookStoreFragment = fragmentManager.findFragmentByTag(BookStoreFragment.class.getSimpleName());
                hideFragments(fragmentTransaction);
                if(bookStoreFragment == null) {
                    bookStoreFragment = new BookStoreFragment();
                    fragmentTransaction.add(R.id.context_fame, bookStoreFragment, BookStoreFragment.class.getSimpleName());
                } else {
                    fragmentTransaction.show(bookStoreFragment);
                }
                break;
            case R.id.tab_personal:
                personalFragment = fragmentManager.findFragmentByTag(PersonalFragment.class.getSimpleName());
                hideFragments(fragmentTransaction);
                if(personalFragment == null) {
                    personalFragment = new PersonalFragment();
                    fragmentTransaction.add(R.id.context_fame, personalFragment, PersonalFragment.class.getSimpleName());
                } else {
                    fragmentTransaction.show(personalFragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }

    private void hideFragments(FragmentTransaction fragmentTransaction) {

        if(bookShelterFragment != null) {
            fragmentTransaction.hide(bookShelterFragment);
        }
        if(bookStoreFragment != null) {
            fragmentTransaction.hide(bookStoreFragment);
        }
        if(personalFragment != null) {
            fragmentTransaction.hide(personalFragment);
        }
    }

    /**
     * initinal fragment and view
     * initinal value
     */
    private void init() {

        radioGroup = (RadioGroup) findViewById(R.id.tab_container);
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
