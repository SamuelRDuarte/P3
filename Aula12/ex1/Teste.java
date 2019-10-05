package Aula12.ex1;
import static java.lang.System.*;
import java.lang.reflect.*;
import java.util.*;
import java.lang.Class;

public class Teste {
	static Scanner sc = new Scanner(in); 
	public static void main(String[] args){
		List<Object> objetos = new ArrayList<>();
		Object obj = null;
		boolean continuar = true;
		
		do {
			out.println("Para parar de inserir escreve 0");
			out.print("Class name: ");
			String classe = sc.nextLine();
			if (classe.equals("0"))
				continuar = false;
			else {
				try {
					obj = createObject(classe);
				} catch (ClassNotFoundException e) {
					out.println("Insere uma class válida.");
					continue;
				} catch (InstantiationException e) {
					out.println("É uma interface ou classe abstrata.");
					continue;
				} catch (Exception e) {
					e.printStackTrace();
					exit(1);
				}
				objetos.add(obj);
				dumpObject(obj);
			}
		} while (continuar);
		
		out.println();
		int i = 0;
		for (Object object : objetos) {
			out.println(i+++" - "+object);
		}
		out.println("Object: ");
		try {
			classMethods(objetos.get(Integer.parseInt(sc.nextLine())));
		} catch (Exception e) {
			out.println("Argumentos invalidos");
			exit(1);
		}
	}
	
	private static void dumpObject(Object o){
		Class<?> cl1 = o.getClass();

		out.println();
		out.println("class simple name: " + cl1.getSimpleName());
		out.println();
		
		out.println("--------------Fields--------------");
		for (Field field : cl1.getDeclaredFields()) {
			out.println(field.getName());
		}
		out.println();
		
		out.println("--------------Methods--------------");
		for (Method method : cl1.getMethods()) {
			out.println(method.getName());
		}
		out.println();
		
		out.println("--------------Superclass--------------");
		Class<?> cl2 = cl1.getSuperclass();
		out.println(cl2.getSimpleName());
		out.println();
		
		out.println("--------------Interfaces--------------");
		for (Class<?> class1 : cl1.getInterfaces()) {
			out.println(class1);
		}
		out.println();
		
		out.println("--------------Constructors--------------");
		for (Constructor<?> constructor : cl1.getConstructors()) {
			out.println(constructor);
		}
		out.println();
	}
	
	private static Object createObject(String s) throws InstantiationException,Exception, ClassNotFoundException {
		Class<?> cl1 = Class.forName(s);
		Constructor<?>[] cons = cl1.getConstructors();
		out.println();
		
		for (int i = 0; i < cons.length; i++) {
			out.println(i+" - "+cons[i]);
		}
		
		int op;
		do {
			out.print("Constructor option: ");
			op = Integer.parseInt(sc.nextLine());
		} while (op<0||op>cons.length);
		
		Constructor<?> escolhido = cons[op];
		Class<?>[] params = escolhido.getParameterTypes();
		List<Object> args = new ArrayList<>();
		
		for (Class<?> param : params) {
			args.add(initVar(param));
		}
		return escolhido.newInstance(args.toArray());
	}
	
	private static Object initVar(Class<?> arg) {
		String tipo = arg.getCanonicalName();
		Object obj = null;
		
		do {
			try {
				out.print(tipo+": ");
				switch (tipo) {
				case "byte":
					obj = Byte.parseByte(sc.nextLine());
					break;
				case "char":
					obj = sc.nextLine().charAt(0);
					break;
				case "short":
					obj = Short.parseShort(sc.nextLine());
					break;
				case "int":
					obj = Integer.parseInt(sc.nextLine());
					break;
				case "long":
					obj = Long.parseLong(sc.nextLine());
					break;
				case "float":
					obj = Float.parseFloat(sc.nextLine());
					break;
				case "double":
					obj = Double.parseDouble(sc.nextLine());
					break;
				case "boolean":
					obj = Boolean.parseBoolean(sc.nextLine());
					break;
				default:
					try {
						obj = createObject(tipo);
					} catch (Exception e) {
						e.printStackTrace();
						out.println("Erro desconhecido");
						exit(1);
					}
					break;
				}
			}catch (IllegalFormatException e) {
				out.println("Formato errado");
			}	
		} while (obj == null);
		return obj;
	}
	
	private static void classMethods(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[] metodos = obj.getClass().getDeclaredMethods();
		for (int i = 0; i < metodos.length; i++) {
			out.println(i+" - "+metodos[i].toString());
		}
		
		out.println("Method: ");
		Method metodo = metodos[Integer.parseInt(sc.nextLine())];
		Class<?>[] tipos = metodo.getParameterTypes();
		List<Object> lista = new ArrayList<>();
		for (int i = 0; i < tipos.length; i++) {
			lista.add(initVar(tipos[i]));
		}
		out.println("Output: "+metodo.invoke(obj, lista.toArray()));		
	}
}
