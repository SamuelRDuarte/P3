package Aula9.ex1;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Scanner;

public class ScannerAbeirense implements Iterator<String>, Closeable {
	
	private Scanner sc;
	
	public ScannerAbeirense(InputStream arg) {
		sc = new Scanner(arg);
	}
	
	public ScannerAbeirense(File arg) throws FileNotFoundException {
		sc = new Scanner(arg);
	}
	
	public void close() {
		sc.close();
	}

	@Override
	public boolean hasNext() {
		return sc.hasNext();
	}

	@Override
	public String next() {
		String s = sc.next();
		s= s.replaceAll("v", "b");
		s= s.replaceAll("V", "B");
		return s;
	}
	
	public String nextLine() {
		String s = sc.nextLine();
		s=s.replaceAll("v", "b");
		s.replaceAll("V", "B");
		return s;
	}

}
