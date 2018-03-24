package newspaper;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Developers 
{

	Developers() 
	{
		GridPane grid=new GridPane();
		grid.setGridLinesVisible(false);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPadding(new Insets(20,20,20,20));
		
		Text label = new Text();
		label.setText("About Developer And Trainer");
		label.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,40));

		Text me = new Text();
		me.setText("Developer Name-Gaurav Kumar\nDeveloped During Training Period-June~July 2017\nTechnology Used-JavaFx\n"
				+"Developed At-Bangalore Computer Education Bathinda\nContactNo-8906214155\\9465394551\n"
				+"Email-gauravk1098@gmail.com");
		me.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,20));

		Text sir1 = new Text();
		sir1.setText("Trainer Name-Rajesh Kumar Bansal\nAcademic Qualification-M.Sc(IT),MCA\n"
				+"Training Exp.-16 Years\nExpert In-Core&Advance Java,Android,PHP,etc\n"
				+ "Sun Certified Java Programmer\nMicrosoft Certified Specialist\nFounder & Director of-Banglore Computer Education\n"
				+ "Training Head at-Sun-Soft Technologies\nAuthor Of Book-Real Java");
		sir1.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,20));

		Separator separator2 = new Separator();
		separator2.setOrientation(Orientation.VERTICAL);
		
		ImageView logo=new ImageView(new Image(UserEnrollment.class.getResourceAsStream("FB_IMG_1449244509530.jpg")));
		logo.setFitWidth(200);
		logo.setFitHeight(200);
		
		ImageView sir=new ImageView(new Image(UserEnrollment.class.getResourceAsStream("Sir.jpg")));
		sir.setFitWidth(200);
		sir.setFitHeight(200);
		
		HBox hbox1=new HBox();
		hbox1.setPadding(new Insets(20,20,20,300));
		hbox1.getChildren().add(label);
		
		HBox hbox2=new HBox();
		hbox2.setPadding(new Insets(20,20,20,200));
		hbox2.getChildren().add(logo);
		
		HBox hbox3=new HBox();
		hbox3.setPadding(new Insets(20,20,20,200));
		hbox3.getChildren().add(sir);
		
		HBox hbox4=new HBox();
		hbox4.setPadding(new Insets(40,20,20,20));
		hbox4.getChildren().add(me);
		
		HBox hbox5=new HBox();
		hbox5.setPadding(new Insets(20));
		hbox5.getChildren().add(sir1);
		
		HBox hbox6=new HBox();
		hbox6.getChildren().add(separator2);
		
		
		grid.add(hbox1,1,1,3,1);
		grid.add(hbox2,1,2,1,1);
		grid.add(hbox3,3,2,1,1);
		grid.add(hbox4,1,3,1,1);
		grid.add(hbox5,3,3,1,1);
		grid.add(hbox6,2,2,1,2);
		
		Stage primaryStage=new Stage();
		Scene scene=new Scene(grid);
		primaryStage.setScene(scene);
		primaryStage.show();
	 }
}
