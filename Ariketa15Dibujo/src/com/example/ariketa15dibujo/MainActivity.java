package com.example.ariketa15dibujo;

import android.app.Activity;
import android.media.audiofx.Visualizer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new VistaPunto(this));
		//setContentView(new VistaCirculo(this));
		//setContentView(new VistaTexto(this));
		setContentView(new VistaPuntosCardinales(this));
	}
}
