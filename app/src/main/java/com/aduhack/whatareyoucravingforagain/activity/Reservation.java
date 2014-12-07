package com.aduhack.whatareyoucravingforagain.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.aduhack.whatareyoucravingforagain.R;
import com.aduhack.whatareyoucravingforagain.database.DataHelper;
import com.aduhack.whatareyoucravingforagain.helper.HttpManager;
import com.aduhack.whatareyoucravingforagain.model.ReservationModel;

public class Reservation extends Activity {

    Button ReserveButton;
    TimePicker timePicker;
    EditText pax;
    int id;

    private ProgressDialog PD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        id = getIntent().getIntExtra("Id", 0);

        ReserveButton = (Button) findViewById(R.id.res_ReserveButton);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        pax = (EditText) findViewById(R.id.pax_et);

        ReserveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayProgressBar();
                ReservationModel rm = new ReservationModel();
                rm.setUser_id("1");
                rm.setReservation_pax(pax.getText().toString());
                rm.setReservation_datetime(timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute());
                rm.setRestaurant_id(id + "");
                PD.show();
                new DownloadData(getApplicationContext(),rm).execute();

            }
        });
    }

    public void displayProgressBar() {
        PD = new ProgressDialog(this);
        PD.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        PD.setMessage("Please wait...");
        PD.setCancelable(false);
    }


    private class DownloadData extends AsyncTask<Void, Void, Void>
    {

        HttpManager hm;
        DataHelper dh;
        ReservationModel rm;
        public DownloadData(Context context, ReservationModel model) {
            dh = new DataHelper(context);
            dh.open();
            hm = new HttpManager(dh);
            rm = model;
        }

        @Override
        protected Void doInBackground(Void... params) {
            hm.setReservation(rm);

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            dh.close();
            Toast.makeText(getApplicationContext(), "Your order is being processed, please wait for confirmation! have a nice day!", Toast.LENGTH_SHORT).show();
            PD.dismiss();
            finish();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.reservation, menu);
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
}
