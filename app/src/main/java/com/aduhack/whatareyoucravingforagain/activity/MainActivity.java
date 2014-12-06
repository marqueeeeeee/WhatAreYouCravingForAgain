package com.aduhack.whatareyoucravingforagain.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.aduhack.whatareyoucravingforagain.R;
import com.aduhack.whatareyoucravingforagain.fragments.MainFragment;
import com.aduhack.whatareyoucravingforagain.fragments.MenuShopFragment;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //somtehing
        setActionbar();
        launchMainFragment();
    }


    @TargetApi(21)
    private void setActionbar() {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP){
            getActionBar().setElevation(10);
        }
    }

    private void launchMainFragment() {

        MainFragment mf = new MainFragment();
        getFragmentManager().beginTransaction().addToBackStack("Main").replace(R.id.container, mf).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void SearchButton (View view) {
        getFragmentManager().beginTransaction().replace(R.id.container, new MenuShopFragment()).commit();
    }

}
