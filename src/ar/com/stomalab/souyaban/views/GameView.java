package ar.com.stomalab.souyaban.views;

import ar.com.stomalab.souyaban.R;
import ar.com.stomalab.souyaban.model.Escenario;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;

public class GameView extends TileView{
	private static final int PARED = 1;
    private static final int DESTINO = 2;
    private static final int CAJA_SOLA = 3;
    private static final int CAJA_SOBRE_DESTINO = 4;
    private static final int TIPITO = 5;
    
    private Escenario escenario;
    
    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // initGameView(context);
    }

    public GameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        
    }
    
    private void initGameView() {
        // setFocusable(true);

        Resources r = this.getContext().getResources();
        resetBitmapMap(6);
        mapearIdADrawable(PARED, r.getDrawable(R.drawable.pared));
        mapearIdADrawable(DESTINO, r.getDrawable(R.drawable.destino));
        mapearIdADrawable(CAJA_SOLA, r.getDrawable(R.drawable.caja));
        mapearIdADrawable(CAJA_SOBRE_DESTINO, r.getDrawable(R.drawable.caja_sobre_destino));
        mapearIdADrawable(TIPITO, r.getDrawable(R.drawable.tipito));
    }
    
    public void iniciarNuevoJuego(Escenario escenario) {
        this.escenario = escenario;
        this.setDimensiones(escenario.getAlto(), escenario.getAncho());
        initGameView();
        update();
    }
    
    private void update() {
    	char[][] layout_escenario = escenario.getRepresentacion();
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
    }
}
