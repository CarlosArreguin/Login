package log;

import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;



public class log {
	
		private final static Logger LOG_MONITOREO = Logger.getLogger("Login");
		
		public static String login(String usuario, String password){
		     String res = "";
		try {
		     Handler consoleHandler = new ConsoleHandler();
		     Handler fileHandler = new FileHandler("C:/Users/Carlos Arreguin/Desktop/Monitoreo.log", true);
		
		     
		      SimpleFormatter simpleFormatter = new SimpleFormatter();
		      fileHandler.setFormatter(simpleFormatter);
		      LOG_MONITOREO.addHandler(consoleHandler);
		      LOG_MONITOREO.addHandler(fileHandler);

		      consoleHandler.setLevel(Level.ALL); 
		      fileHandler.setLevel(Level.ALL); 

		LOG_MONITOREO.log(Level.INFO, "Nueva Solicitud de Logueo");
		LOG_MONITOREO.log(Level.INFO, "Usuario: " + usuario);
		Scanner scanner = new Scanner(System.in);
		usuario = scanner.nextLine();
		LOG_MONITOREO.log(Level.INFO, "Contraseña: " + password);
		password = scanner.nextLine();

		

		if(usuario.equals(DefineConstants.user) && password.equals(DefineConstants.pass)){
		    LOG_MONITOREO.log(Level.INFO, "Logueo exitoso!");
		    res = "Logueo exitoso, Bienvenido!";
		}else{
		    LOG_MONITOREO.log(Level.WARNING, "Usuario o contraseña incorrecto");
		    res = "Usuario o contraseña incorrecto, Verifica tus datos!";
		}

		

		fileHandler.close();
		consoleHandler.close();

		} catch (Exception e) {
		
		    LOG_MONITOREO.log(Level.SEVERE, e.getMessage());
		    res = "Error, consulte con su proveedor del servicio";
		}
		return res;
	}
		
		public static void main(String[] args) {
		    String loginResponse = login("","");
		    System.out.println("Informacion: " + loginResponse );
		}
		
		final class DefineConstants
		{
			public static final String user = "kawa";
			public static final String pass = "1234";
		}
	}


