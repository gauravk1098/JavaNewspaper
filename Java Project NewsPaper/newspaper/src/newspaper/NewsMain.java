package newspaper;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class NewsMain
{
			GridPane grid;
			Text Title;
			Text Logo1;
			Text Logo2;
			Text Logo3;
			Text Logo4;
			Text Logo5;
			Text Logo6;
			Text Logo7;
			Text Logo8;
			Text Logo9;
			Text Logo10;
		
			
			ImageView logo1;
			ImageView logo2;
			ImageView logo3;
			ImageView logo4;
			ImageView logo5;
			ImageView logo6;
			ImageView logo7;
			ImageView logo8;
			ImageView logo9;
			ImageView logo10;
			
			public NewsMain() 
			{
				grid=new GridPane();
				grid.setGridLinesVisible(false);
				grid.setVgap(10);
				grid.setHgap(10);
				grid.setPadding(new Insets(10));
				grid.setMaxSize(1200,600);
				
				Title=new Text();
				Title.setText("DashBoard");
				Title.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,50));
				HBox hbox1=new HBox();
				hbox1.setPadding(new Insets(20,20,20,200));
				hbox1.getChildren().add(Title);
				
				logo1=new ImageView(new Image(HawkerRegistration.class.getResourceAsStream("logo1.png")));
				logo1.setFitWidth(80);
				logo1.setFitHeight(80);
				HBox hbox2=new HBox();
				hbox2.setPadding(new Insets(10,10,10,20));
				hbox2.getChildren().add(logo1);
				
				Logo1=new Text();
				Logo1.setText("Bill Generator");
				Logo1.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,20));
				HBox hbox3=new HBox();
				hbox3.setPadding(new Insets(10));
				hbox3.getChildren().add(Logo1);
				logo1.setOnMouseClicked(e->{
					new BillGenerator();
				});
				
				logo2=new ImageView(new Image(HawkerRegistration.class.getResourceAsStream("logo2.png")));
				logo2.setFitWidth(80);
				logo2.setFitHeight(80);
				HBox hbox4=new HBox();
				hbox4.setPadding(new Insets(10,10,10,20));
				hbox4.getChildren().add(logo2);
				
				Logo2=new Text();
				Logo2.setText("User Registration");
				Logo2.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,20));
				HBox hbox5=new HBox();
				hbox5.setPadding(new Insets(10));
				hbox5.getChildren().add(Logo2);
				logo2.setOnMouseClicked(e->{
					new UserEnrollment();
				});
				
				logo3=new ImageView(new Image(HawkerRegistration.class.getResourceAsStream("logo3.jpg")));
				logo3.setFitWidth(80);
				logo3.setFitHeight(80);
				HBox hbox6=new HBox();
				hbox6.setPadding(new Insets(10,10,10,20));
				hbox6.getChildren().add(logo3);
				
				Logo3=new Text();
				Logo3.setText("New Hawker");
				Logo3.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,20));
				HBox hbox7=new HBox();
				hbox7.setPadding(new Insets(10));
				hbox7.getChildren().add(Logo3);
				logo3.setOnMouseClicked(e->{
					new HawkerRegistration();
				});
				
				logo4=new ImageView(new Image(HawkerRegistration.class.getResourceAsStream("logo4.jpg")));
				logo4.setFitWidth(80);
				logo4.setFitHeight(80);
				HBox hbox8=new HBox();
				hbox8.setPadding(new Insets(10,10,10,20));
				hbox8.getChildren().add(logo4);
				
				Logo4=new Text();
				Logo4.setText("Areas");
				Logo4.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,20));
				HBox hbox9=new HBox();
				hbox9.setPadding(new Insets(10));
				hbox9.getChildren().add(Logo4);
				logo4.setOnMouseClicked(e->{
					new AddAreas();
				});
				
				logo5=new ImageView(new Image(HawkerRegistration.class.getResourceAsStream("logo5.jpg")));
				logo5.setFitWidth(80);
				logo5.setFitHeight(80);
				HBox hbox10=new HBox();
				hbox10.setPadding(new Insets(10,10,10,20));
				hbox10.getChildren().add(logo5);
				
				Logo5=new Text();
				Logo5.setText("NewsPapers");
				Logo5.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,20));
				HBox hbox11=new HBox();
				hbox11.setPadding(new Insets(10));
				hbox11.getChildren().add(Logo5);
				logo5.setOnMouseClicked(e->{
					new NewsPaperMaster();
				});
				
				logo6=new ImageView(new Image(HawkerRegistration.class.getResourceAsStream("logo6.gif")));
				logo6.setFitWidth(80);
				logo6.setFitHeight(80);
				HBox hbox12=new HBox();
				hbox12.setPadding(new Insets(10,10,10,20));
				hbox12.getChildren().add(logo6);
				
				Logo6=new Text();
				Logo6.setText("Hawkers Data");
				Logo6.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,20));
				HBox hbox13=new HBox();
				hbox13.setPadding(new Insets(10));
				hbox13.getChildren().add(Logo6);
				logo6.setOnMouseClicked(e->{
					new HawkerDisplayer();
				});
				
				logo7=new ImageView(new Image(HawkerRegistration.class.getResourceAsStream("logo7.png")));
				logo7.setFitWidth(80);
				logo7.setFitHeight(80);
				HBox hbox14=new HBox();
				hbox14.setPadding(new Insets(10,10,10,20));
				hbox14.getChildren().add(logo7);
				
				Logo7=new Text();
				Logo7.setText("Our Customers");
				Logo7.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,20));
				HBox hbox15=new HBox();
				hbox15.setPadding(new Insets(10));
				hbox15.getChildren().add(Logo7);
				logo7.setOnMouseClicked(e->{
					new CustomerDisplayer();
				});
				
				logo8=new ImageView(new Image(HawkerRegistration.class.getResourceAsStream("logo8.jpg")));
				logo8.setFitWidth(80);
				logo8.setFitHeight(80);
				HBox hbox16=new HBox();
				hbox16.setPadding(new Insets(10,10,10,20));
				hbox16.getChildren().add(logo8);
				
				Logo8=new Text();
				Logo8.setText("Bill Collector");
				Logo8.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,20));
				HBox hbox17=new HBox();
				hbox17.setPadding(new Insets(10));
				hbox17.getChildren().add(Logo8);
				logo8.setOnMouseClicked(e->{
					new BillCollector();
				});
				
				logo9=new ImageView(new Image(HawkerRegistration.class.getResourceAsStream("logo9.jpg")));
				logo9.setFitWidth(80);
				logo9.setFitHeight(80);
				HBox hbox18=new HBox();
				hbox18.setPadding(new Insets(10,10,10,20));
				hbox18.getChildren().add(logo9);
				
				Logo9=new Text();
				Logo9.setText("Bill Records");
				Logo9.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,20));
				HBox hbox19=new HBox();
				hbox19.setPadding(new Insets(10));
				hbox19.getChildren().add(Logo9);
				logo9.setOnMouseClicked(e->{
					new BillDisplayer();
				});
				
				logo10=new ImageView(new Image(HawkerRegistration.class.getResourceAsStream("logo10.png")));
				logo10.setFitWidth(80);
				logo10.setFitHeight(80);
				HBox hbox21=new HBox();
				hbox21.setPadding(new Insets(10,10,10,20));
				hbox21.getChildren().add(logo10);
				
				Logo10=new Text();
				Logo10.setText("Developing\n  Team");
				Logo10.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,20));
				HBox hbox20=new HBox();
				hbox20.setPadding(new Insets(10));
				hbox20.getChildren().add(Logo10);
				logo10.setOnMouseClicked(e->{
					new Developers();
				});
			
				grid.add(hbox1,1,1,4,1);
				grid.add(hbox2,1,2);
				grid.add(hbox4,2,2);
				grid.add(hbox6,3,2);
				grid.add(hbox3,1,3);
				grid.add(hbox5,2,3);
				grid.add(hbox7,3,3);
				grid.add(hbox8,1,4);
				grid.add(hbox10,2,4);
				grid.add(hbox12,3,4);
				
				grid.add(hbox9,1,5);
				grid.add(hbox11,2,5);
				grid.add(hbox13,3,5);
				
				grid.add(hbox14,1,6);
				grid.add(hbox16,2,6);
				grid.add(hbox18,3,6);
				
				grid.add(hbox15,1,7);
				grid.add(hbox17,2,7);
				grid.add(hbox19,3,7);
				grid.add(hbox20,4,3);
				grid.add(hbox21,4,2);
				
				Scene scene=new Scene(grid);
				Stage primaryStage=new Stage();
				primaryStage.setScene(scene);
				primaryStage.show();
			}
	}
