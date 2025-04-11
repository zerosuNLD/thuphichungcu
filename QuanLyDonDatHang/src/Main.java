import Model.Model;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Model.getInstance().getViewFactory().showTrangChu();
	}

	public static void main(String[] args) {
		launch(args);
//		System.out.println("Hello World");
	}
}