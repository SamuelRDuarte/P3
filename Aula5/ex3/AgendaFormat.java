package Aula5.ex3;
import java.io.IOException;

public interface AgendaFormat {
	
	public Pessoa[] readFromFile(String file) throws IOException;
	public void writeToFile(String file,Pessoa[] lista) throws IOException;

}
