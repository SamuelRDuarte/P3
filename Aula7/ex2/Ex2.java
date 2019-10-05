package Aula7.ex2;

public class Ex2 {

	public static void main(String[] args) {
		
				Bitmap image = new Bitmap("C:\\Users\\samue\\Desktop\\aula7_material\\aula7_material\\Figura.bmp");
				System.out.println(image);
				image.saveAsRawType("Figura");
				image.saveResize("Figura_resized");
				image.saveFlipHorizontal("Figura_Hflip");
				image.saveFlipVertical("Figura_Vflip");

	}

}
