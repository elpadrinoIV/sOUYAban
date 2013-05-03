package ar.com.stomalab.souyaban;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;
import ar.com.stomalab.souyaban.model.Escenario;
import ar.com.stomalab.souyaban.model.EscenarioLoader;
import ar.com.stomalab.souyaban.views.GameView;

public class NewGameActivity extends Activity {
	Escenario escenario;
	GameView game_view;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		EscenarioLoader escenario_loader = new EscenarioLoader();
		ArrayList<String> lineas = new ArrayList<String>();
		
		lineas.add("######  ");
		lineas.add("#  . #  ");;
		lineas.add("#    ###");
		lineas.add("# #$$. #");
		lineas.add("#.  ## #");
		lineas.add("#@$ ## #");
		lineas.add("###    #");
		lineas.add("  ######");
		escenario = escenario_loader.cargarEscenario(lineas);
		
        setContentView(R.layout.activity_new_game);
        game_view = (GameView) this.findViewById(R.id.GAME);
        TextView contador = (TextView)this.findViewById(R.id.CONTADOR_MOVIMIENTOS);
        TextView estado = (TextView)this.findViewById(R.id.ESTADO_JUEGO);
        game_view.setDependentViews(contador,  estado);
        // game_view.setOnKeyListener(this);
        game_view.iniciarNuevoJuego(escenario);
        	    
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
	
	 @Override
    public boolean onKeyDown(int keyCode, KeyEvent msg) {

	 switch(keyCode){
    	case KeyEvent.KEYCODE_A:
    		escenario.getPersona().moverIzquierda();
    		break;
    	case KeyEvent.KEYCODE_D:
    		escenario.getPersona().moverDerecha();
    		break;
    	case KeyEvent.KEYCODE_W:
    		escenario.getPersona().moverArriba();
    		break;
    	case KeyEvent.KEYCODE_S:
    		escenario.getPersona().moverAbajo();
    		break;
    	case KeyEvent.KEYCODE_SPACE:
    		escenario.deshacer();
    	}
    	
    	
    	game_view.update();

        return super.onKeyDown(keyCode, msg);
    }
}
