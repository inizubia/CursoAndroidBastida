package com.example.ariketa4generarintfzporcodg;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        RelativeLayout r = (RelativeLayout)findViewById(R.id.contenedor);
        
        String color[] = {"red","yellow","green","black"};
        TextView tx[] = new TextView[color.length];
        
        for (int i=0, y=20; i<color.length;i++,y+=110){
        	tx[i] = new TextView(this);
        	tx[i].setText(color[i]);
        	tx[i].setX(20);
            tx[i].setY(y);
            r.addView(tx[i]);
        }
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
}
