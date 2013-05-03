package ar.com.stomalab.souyaban.views;

import ar.com.stomalab.souyaban.R;
import ar.com.stomalab.souyaban.model.Escenario;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.TextView;

public class GameView extends TileView{
	private static final int PARED = 1;
    private static final int DESTINO = 2;
    private static final int CAJA_SOLA = 3;
    private static final int CAJA_SOBRE_DESTINO = 4;
    private static final int TIPITO = 5;
    
    private TextView contador_movimientos;
    private TextView estado;
    
    private Escenario escenario;
    
    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.requestFocus();
        this.setFocusableInTouchMode(true);
        // initGameView(context);
    }

    public GameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.requestFocus();
        this.setFocusableInTouchMode(true);
        
    }
    
    public void setDependentViews(TextView movimientos_view, TextView estado_view){
    	this.contador_movimientos = movimientos_view;
    	this.estado = estado_view;
    }
    
    private void initGameView() {
        setFocusable(true);

        Resources r = this.getContext().getResources();
        resetBitmapMap(6);
        mapearIdADrawable(PARED, r.getDrawable(R.drawable.pared));
        mapearIdADrawable(DESTINO, r.getDrawable(R.drawable.destino));
        mapearIdADrawable(CAJA_SOLA, r.getDrawable(R.drawable.caja_sola));
        mapearIdADrawable(CAJA_SOBRE_DESTINO, r.getDrawable(R.drawable.caja_sobre_destino));
        mapearIdADrawable(TIPITO, r.getDrawable(R.drawable.guy));
    }
    
    public void iniciarNuevoJuego(Escenario escenario) {
        this.escenario = escenario;
        this.setDimensiones(escenario.getAlto(), escenario.getAncho());
        initGameView();
        update();
        this.invalidate();
    }
    
    private void update() {
    	char[][] layout_escenario = escenario.getRepresentacion();
    	clearTiles();
    	for (int fila = 0; fila < layout_escenario.length; fila++)
		{
			for (int columna = 0; columna < layout_escenario[fila].length; columna++)
			{
				switch (layout_escenario[fila][columna]){
				case '#':
					setTile(PARED, fila, columna);
					break;
				case '.':
					setTile(DESTINO, fila, columna);
					break;
				case '$':
					setTile(CAJA_SOLA, fila, columna);
					break;
				case '*':
					setTile(CAJA_SOBRE_DESTINO, fila, columna);
					break;
				case '@':
					setTile(TIPITO, fila, columna);
					break;
				case '+':
					setTile(TIPITO, fila, columna);
					break;
				}
			}
		}
    	String texto_str = "Cantidad movimientos" + escenario.getPersona().getCantidadMovimientos();
    	contador_movimientos.setText(texto_str.toCharArray(), 0, texto_str.length());
    }
    
    @Override
    public boolean onKeyDown (int keyCode, KeyEvent event){
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
    	
    	update();
    	GameView.this.invalidate();
		return super.onKeyDown(keyCode, event);
	}
    
}
