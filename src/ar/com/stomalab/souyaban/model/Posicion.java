package ar.com.stomalab.souyaban.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Posicion {
	int x;
	int y;
	
	public Posicion(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setPosicion(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Posicion plus(Posicion posicion) {
		Posicion p = new Posicion(0, 0);
		p.setPosicion(this.getX() + posicion.getX(), this.getY() + posicion.getY());
		return p;
	}
	
	@Override
	public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof Posicion))
            return false;

        Posicion p = (Posicion) obj;
        return new EqualsBuilder().
                // if deriving: appendSuper(super.equals(obj)).
                append(this.x, p.x).
                append(this.y, p.y).
                isEquals();
    }
	
	@Override
	public int hashCode() {
        return new HashCodeBuilder(17, 31). // two randomly chosen prime numbers
            // if deriving: appendSuper(super.hashCode()).
            append(x).
            append(y).
            toHashCode();
    }
	
}
