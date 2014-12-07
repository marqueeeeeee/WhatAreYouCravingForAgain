package com.aduhack.whatareyoucravingforagain.activity;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.aduhack.whatareyoucravingforagain.R;
import com.aduhack.whatareyoucravingforagain.common.TileProvider;
import com.aduhack.whatareyoucravingforagain.database.DataHelper;
import com.aduhack.whatareyoucravingforagain.fragments.MainFragment;
import com.aduhack.whatareyoucravingforagain.fragments.MenuShopFragment;
import com.aduhack.whatareyoucravingforagain.helper.HttpManager;
import com.aduhack.whatareyoucravingforagain.model.ListViewAdapterModelWithAvatar;
import com.aduhack.whatareyoucravingforagain.model.OrderItem;
import com.aduhack.whatareyoucravingforagain.model.OrderModel;
import com.aduhack.whatareyoucravingforagain.model.RatingModel;
import com.aduhack.whatareyoucravingforagain.model.ReservationModel;
import com.aduhack.whatareyoucravingforagain.model.UserModel;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionbar();
        launchMainFragment();

        new DownloadData(getApplicationContext()).execute();
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
        Intent i = new Intent(this, SearchActivity.class);
        startActivity(i);
    }


    private class DownloadData extends AsyncTask<Void, Void, Void>
    {

        HttpManager hm;
        DataHelper dh;
        public DownloadData(Context context) {
            dh = new DataHelper(context);
            dh.open();
            hm = new HttpManager(dh);
        }

        @Override
        protected Void doInBackground(Void... params) {
            hm.getRestaurants();
            hm.getMenu();
            hm.getRestaurantImage();

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            dh.close();
       }

    }

    public void predefinedTagsClicked(View v){
        String tags = String.valueOf(v.getTag());
        Intent i = new Intent(getApplicationContext(), MenuShopActivity.class);
        i.putExtra("tag", tags);

        startActivity(i);
    }



}
