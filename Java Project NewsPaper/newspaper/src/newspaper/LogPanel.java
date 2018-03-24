package newspaper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LogPanel extends Application
{
	static Connection con;
	PreparedStatement pst;
	public static void main(String[] args) 
	{
		try 
		{
			//JDBC CONNECTION FROM SQL SIDE
			Class.forName("com.mysql.jdbc.Driver");
			try 
			{
				//JDBC CONNECTION FROM JAVA SIDE
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/newspaper","root","bce");
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		launch(args);
	}
	TextField txtuid;
	PasswordField txtpwd;
	GridPane grid;
	public void start(Stage stage) throws Exception 
	{
		grid=new GridPane();
		grid.setGridLinesVisible(false);
		grid.setHgap(0);
		grid.setVgap(20);
		grid.setPadding(new Insets(50,100,50,100));

		txtuid=new TextField();
		txtuid.setPromptText("Enter User Name");
		txtpwd=new PasswordField();
		txtpwd.setPromptText("Enter Password");
		
		ImageView logo=new ImageView(new Image(LogPanel.class.getResourceAsStream("loglogo.png")));
		logo.setFitWidth(150);
		logo.setFitHeight(150);
		
		Text uid=new Text();
		uid.setText("USERNAME");
		Text pwd=new Text();
		pwd.setText("PASSWORD");
		
		Button Login=new Button("LOGIN");
		Login.setPrefSize(100,50);
		
		grid.add(logo,1,1);
		grid.add(uid,1,2);
		grid.add(txtuid,1,3);
		grid.add(pwd,1,4);
		grid.add(txtpwd,1,5);
		
		HBox hbox=new HBox();
		HBox.setMargin(Login, new Insets(20,0,0,20));
		hbox.getChildren().addAll(Login);
		grid.add(hbox, 1,6);
		
		Login.setOnAction(e->{
			try 
			{
				pst=con.prepareStatement("select * from logusers where Uid=? AND Password=?");
				pst.setString(1,txtuid.getText());
				pst.setString(2,txtpwd.getText());
				ResultSet rs=pst.executeQuery();
				if(rs.next()==true)
				{
					new NewsMain();
					stage.close();
				}
				else
				{
					showMsg("Invalid Id Or Password");
				}
				rs.close();
			}
			catch (SQLException exp) 
			{
				exp.printStackTrace();
			}
			
		});
		
		Scene scene=new Scene(grid);
		stage.setScene(scene);
		stage.show();
	}
	void showMsg(String msg)
	{
		Alert alert =new Alert(AlertType.INFORMATION);
		alert.setTitle("Message");
		alert.setHeaderText("Login Panel:");
		alert.setContentText(msg);
		alert.show();
	}
}
