package com.aduhack.whatareyoucravingforagain.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.aduhack.whatareyoucravingforagain.R;
import com.aduhack.whatareyoucravingforagain.common.CustomListViewAdapter;
import com.aduhack.whatareyoucravingforagain.database.DataHelper;
import com.aduhack.whatareyoucravingforagain.helper.HttpManager;
import com.aduhack.whatareyoucravingforagain.model.ListViewAdapterModelWithAvatar;
import com.aduhack.whatareyoucravingforagain.model.OrderItem;
import com.aduhack.whatareyoucravingforagain.model.OrderModel;

import java.util.ArrayList;
import java.util.List;

public class OrderAheadActivity extends Activity {

    Button OrderAhead;
    ListView OrderList;

    ArrayList<OrderItem> orderlist;
    int id;
    ArrayList<ListViewAdapterModelWithAvatar> lvadp;
    String time ="";

    float amountdue = 0;
    private ProgressDialog PD;
    int resto_id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_ahead);

        displayProgressBar();

        lvadp = new ArrayList<ListViewAdapterModelWithAvatar>();
        id = getIntent().getIntExtra("Id", 0);
        resto_id = id;
        orderlist = new ArrayList<OrderItem>();
        OrderList = (ListView) findViewById(R.id.lv_orderlist);

        OrderAhead = (Button) findViewById(R.id.btn_order_ahead);

        OrderList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                CustomListViewAdapter adapter = (CustomListViewAdapter) parent.getAdapter();

                ListViewAdapterModelWithAvatar lvm = (ListViewAdapterModelWithAvatar) adapter.getItem(position);



                Intent i = new Intent(getApplicationContext(), AddQtyDialog.class);
                i.putExtra("Id", lvm.Id);
                i.putExtra("Price", lvm.PriceText);
                startActivityForResult(i,1);

            }
        });
        getData();

        OrderAhead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert();
            }
        });
    }

    public void displayProgressBar() {
        PD = new ProgressDialog(this);
        PD.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        PD.setMessage("Please wait...");
        PD.setCancelable(false);
    }

    public void AddQty(View view) {
        showAlert();
    }

    public void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Order Ahead!").setMessage(
                "Dine-In or Take Out?");
        builder.setNegativeButton("Dine-in",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PD.show();

                        new DownloadData(getApplicationContext(), false, orderlist, time, amountdue + "").execute();
                    }
                });
        builder.setPositiveButton("Take-out", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                PD.show();
                new DownloadData(getApplicationContext(), true, orderlist, time, amountdue + "").execute();
            }
        });
        builder.create().show();
    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                String result = data.getStringExtra("result");
                int ids = data.getIntExtra("Id",0);
                time = data.getStringExtra("time");
                float price = Float.valueOf(data.getStringExtra("Price"));

                amountdue = amountdue + ( price * Integer.parseInt(result));

                Toast.makeText(getApplicationContext(), "Total Amount Due:" + amountdue, Toast.LENGTH_SHORT).show();

                OrderItem item = new OrderItem();

                item.setMenu_id(ids + "");
                item.setQty(result);

                orderlist.add(item);
            }
            if (resultCode == RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//on

    private void getData() {
        DataHelper dh = new DataHelper(getApplicationContext());
        dh.open();

        List<com.aduhack.whatareyoucravingforagain.model.Menu> menu = dh.GetMenusDetails(id);

        for (com.aduhack.whatareyoucravingforagain.model.Menu item : menu) {
            ListViewAdapterModelWithAvatar lv = new ListViewAdapterModelWithAvatar();
            lv.MainText = item.food_name;
            lv.SubText = item.description;
            lv.Id = item.Menu_id;
            lv.PriceText = item.price;

            lvadp.add(lv);
        }

        OrderList.setAdapter(new CustomListViewAdapter(getApplicationContext(), lvadp));




    }

    private class DownloadData extends AsyncTask<Void, Void, Void>
    {

        HttpManager hm;
        DataHelper dh;
        boolean dineortakeout =false;
        ArrayList<OrderItem> ori;
        String _time;
        String AmtDues;


        public DownloadData(Context context, boolean dineortake, ArrayList<OrderItem> order, String time, String AmtDue) {
            dh = new DataHelper(context);
            dh.open();
            hm = new HttpManager(dh);
            dineortakeout = dineortake;
            ori = order;
            _time = time;
            AmtDues = AmtDue;
        }

        @Override
        protected Void doInBackground(Void... params) {

            OrderModel model = new OrderModel();
            model.setOrderItems(ori);
            model.setPickup_datetime(time);
            model.setUser_id("1");
            model.setAmountDue(AmtDues);

            model.setReservation_id(resto_id + "");

            if(dineortakeout)
                model.setIsTogo("0");
            else
                model.setIsTogo("1");

            hm.setOrder(model);

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            dh.close();
            PD.dismiss();
            finish();
        }

    }


}
