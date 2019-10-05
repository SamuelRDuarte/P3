package Aula7.ex2;

public class Pixel {
	final byte R,G,B;

	public Pixel(byte r, byte g, byte b) {	
		R = r;
		G = g;
		B = b;
	}
	
	@Override
	public String toString() {
		return "RGB("+(R & 0xff)+","+(G & 0xff)+","+(B & 0xff)+")";
	}
	
}
