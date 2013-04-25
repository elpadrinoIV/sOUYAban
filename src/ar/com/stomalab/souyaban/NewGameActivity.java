package ar.com.stomalab.souyaban;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;
import ar.com.stomalab.souyaban.model.Escenario;
import ar.com.stomalab.souyaban.model.EscenarioLoader;
import android.graphics.Typeface;

public class NewGameActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		EscenarioLoader escenario_loader = new EscenarioLoader();
		ArrayList<String> lineas = new ArrayList<String>();
		
		lineas.add("######  ");
		lineas.add("#  . #  ");
		lineas.add("#    ###");
		lineas.add("# #$$. #");
		lineas.add("#.  ## #");
		lineas.add("#@$ ## #");
		lineas.add("###    #");
		lineas.add("  ######");
		Escenario escenario = escenario_loader.cargarEscenario(lineas);
		char[][] layout_escenario = escenario.getRepresentacion();
		String layout = new String();
		for (int fila = 0; fila < layout_escenario.length; fila++)
		{
			for (int col = 0; col < layout_escenario[fila].length; col++)
			{
				layout += layout_escenario[fila][col];
			}
			
			layout += '\n';
		}
		
		layout += "\nMovimientos: ";
		layout += escenario.getPersona().getCantidadMovimientos();
		layout += '\n';
		// Create the text view
	    TextView textView = new TextView(this);
	    // textView.setTextSize(40);
	    textView.setText(layout);
	    textView.setTypeface(Typeface.MONOSPACE);
	    

	    // Set the text view as the activity layout
	    setContentView(textView);
	    
		// Show the Up button in the action bar.
		setupActionBar();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_game, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
