package Aula12.ex3;
import java.io.IOException;

public interface Plugin {
	
	public Pessoa[] readFromFile(String file) throws IOException;
	public void writeToFile(String file,Pessoa[] lista) throws IOException;

}
