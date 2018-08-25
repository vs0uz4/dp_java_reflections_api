package br.com.virtualsystems;

import java.lang.reflect.Method;

public class Main {
	
	public static void main(String[] args) throws Exception {
		Class<?> klazz = Class.forName("br.com.virtualsystems.reflection.Person");
		
		// Instânciando a Classe Dinamicamente
		Object person = klazz.newInstance();
		
		// Definindo name Através do Método setName
		Method setName = person.getClass().getMethod("setName", String.class);
		setName.invoke(person, "Vitor");
		
		// Resgatando name Através do Método getName e Guardando o Retorno na Variável name 
		Method getName = person.getClass().getMethod("getName");
		String name = (String) getName.invoke(person);
		
		// Definindo age Através do Método setAge
		Method setAge = person.getClass().getMethod("setAge", Integer.class);
		setAge.invoke(person, 41);
		
		// Resgatando age Através do Método getAge e Guardando o Retorno na Variável age 
		Method getAge = person.getClass().getMethod("getAge");
		Integer age = (Integer) getAge.invoke(person);
		
		// Definindo o Array parameterTypes com os Valores de String e Integer Respectivamente
		Class<?> [] parameterTypes = {String.class, Integer.class};
		// Invokando o Método printPerson e Passando os Parâmetros Resgatados name e age
		Method printPerson = person.getClass().getMethod("printPerson", parameterTypes);
		System.out.println(printPerson.invoke(person, name, age));
	}

}
