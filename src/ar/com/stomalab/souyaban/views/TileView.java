package ar.com.stomalab.souyaban.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class TileView extends View {
	private static int tile_size;
	private static int min_tile_size = 20;
	private static int max_tile_size = 50;
	
	private static int ancho_ventana;
	private static int alto_ventana;
	
	private static int cant_filas;
	private static int cant_columnas;
	
	private static int x_offset;
	private static int y_offset;
	
	private Paint paint;
	
	private Bitmap[] map_id_to_bitmap;
	
	private int[][] tile_grid;
	
	
	public TileView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // cant_filas = 10;
        // cant_columnas = 10;
        // tile_size = 20;
        
        // tile_size = 20;
        // TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TileView);
        // mTileSize = a.getDimensionPixelSize(R.styleable.TileView_tileSize, 12);

        // a.recycle();
    }

    public TileView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // cant_filas = 10;
        // cant_columnas = 10;
        // tile_size = 20;
        // cant_filas = 10;
        // cant_columnas = 10;
        // TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TileView);
        // mTileSize = a.getDimensionPixelSize(R.styleable.TileView_tileSize, 12);

        // a.recycle();
    }
    
    /**
     * Resets all tiles to 0 (empty)
     * 
     */
    public void clearTiles() {
        for (int fila = 0; fila < cant_filas; fila++) {
            for (int columna = 0; columna < cant_columnas; columna++) {
                setTile(0, fila, columna);
            }
        }
    }
	
    /**
     * Mapea bitmap a un id
     *
     * @param key
     * @param tile
     */
    public void mapearIdADrawable(int id, Drawable tile) {
        Bitmap bitmap = Bitmap.createBitmap(tile_size, tile_size, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        tile.setBounds(0, 0, tile_size, tile_size);
        tile.draw(canvas);

        map_id_to_bitmap[id] = bitmap;
    }
    
    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int fila = 0; fila < cant_filas; fila++) {
            for (int columna = 0; columna < cant_columnas; columna++) {
                if (tile_grid[fila][columna] > 0) {
                	
                    canvas.drawBitmap(map_id_to_bitmap[tile_grid[fila][columna]], x_offset + columna * tile_size,
                            y_offset + fila * tile_size, paint);
                }
            }
        }

    }
    
    /**
     * Resetea el mapa de id a bitmap y establece el máximo de bitmaps a mapear
     *
     * @param cantidad_bitmaps
     */

    public void resetBitmapMap(int cantidad_bitmaps) {
        map_id_to_bitmap = new Bitmap[cantidad_bitmaps];
    }
    
    public void setTile(int tile_id, int fila, int columna) {
        tile_grid[fila][columna] = tile_id;
    }
    
    public void setDimensiones(int filas, int columnas){
    	cant_filas = filas;
    	cant_columnas = columnas;
    	
    	tile_grid = new int[cant_filas][cant_columnas];
    	clearTiles();
    	acomodar_sizes(ancho_ventana, alto_ventana);
    }
    
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    	// Tengo que ver cual es el tamaño del tile, teniendo en cuenta la cantidad que entran,
    	// pero siempre respetando el minimo y el máximo.
    	ancho_ventana = w;
    	alto_ventana = h;
    	acomodar_sizes(w, h);
    }
    	
    private void acomodar_sizes(int ancho_ventana, int alto_ventana){
    	if (cant_columnas != 0 && cant_filas != 0){
	    	int ancho_tile = (int)Math.floor(ancho_ventana/cant_columnas);
	    	int alto_tile = (int)Math.floor(alto_ventana/cant_filas);
	    	
	    	if (ancho_tile > max_tile_size){
	    		ancho_tile = max_tile_size;
	    	}else if (ancho_tile < min_tile_size){
	    		ancho_tile = min_tile_size;
	    	}
	    	
	    	if (alto_tile > max_tile_size){
	    		alto_tile = max_tile_size;
	    	}else if (alto_tile < min_tile_size){
	    		alto_tile = min_tile_size;
	    	}
	    	
	    	tile_size = Math.min(ancho_tile, alto_tile);
    	}else{
    		tile_size = min_tile_size;
    	}
    	
    	tile_size = 50;
    	x_offset = 0;
    	y_offset = 0;
    }
}
