package Model;

import View.ViewFactory;

public class Model {
	private final ViewFactory viewFactory;
	private static Model model;

	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/dathangonline?useSSL=false&allowPublicKeyRetrieval=true";
	private static final String USER = "root";
	private static final String PASS = "1234";

	private Model() {
		this.viewFactory = new ViewFactory();

		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static synchronized Model getInstance() {
		if (model == null) {
			model = new Model();
		}
		return model;
	}


	public ViewFactory getViewFactory() {
		return viewFactory;
	}

}
