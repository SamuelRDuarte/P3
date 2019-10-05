package Aula9.ex1;

import java.io.File;
import java.io.IOException;
import static java.lang.System.*;
public class Test {
	
	public static void main(String[] args)	throws IOException{
		
		ScannerAbeirense sc = new ScannerAbeirense(in);
		ScannerAbeirense scf = new ScannerAbeirense(new File("C:\\Users\\samue\\OneDrive - Universidade de Aveiro\\Universidade\\2Ano\\P3\\aula8_material\\aula8_material\\QQSM\\questions.txt"));
		out.print("Test-Next: ");
		out.println(sc.next());
		out.print("Test-NextLine: ");
		sc.nextLine();
		out.println(sc.nextLine());
		sc.close();
		
		while(scf.hasNext()) {
			out.println(scf.nextLine());
		}
		
		scf.close();
		
	}

}
