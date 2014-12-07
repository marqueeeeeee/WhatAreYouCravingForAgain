package com.aduhack.whatareyoucravingforagain.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import com.aduhack.whatareyoucravingforagain.R;

public class AddQtyDialog extends Activity {

    EditText QtyET;
    Button SaveButton;
    TimePicker timepicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_qty_dialog);

        QtyET = (EditText) findViewById(R.id.editTextQty);
        SaveButton = (Button) findViewById(R.id.buttonQty);
        timepicker = (TimePicker) findViewById(R.id.timePickerqty);

        SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String time = timepicker.getCurrentHour().toString() + ":" + timepicker.getCurrentMinute().toString();

                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", QtyET.getText().toString());
                returnIntent.putExtra("Id", getIntent().getIntExtra("Id", 0));
                returnIntent.putExtra("time", time);
                returnIntent.putExtra("Price", getIntent().getStringExtra("Price"));
                setResult(RESULT_OK, returnIntent);
                finish();

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_qty_dialog, menu);
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
