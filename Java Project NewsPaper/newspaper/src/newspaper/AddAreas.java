package newspaper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

	public class AddAreas
	{
	Connection con;
	ComboBox<String> Areas=new ComboBox<String>();
	Text label;
	Text Area;
	Button Save;
	PreparedStatement pst;
	Button Close;
	AddAreas() 
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
		
		doFill();
		GridPane grid=new GridPane();
		Stage primaryStage=new Stage();
		grid.setGridLinesVisible(false);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPadding(new Insets(20,60,20,20));
		grid.setPrefSize(400,400);
		
		Areas.setPrefWidth(200);
		Areas.setEditable(true);
		
		Area=new Text();
		Area.setText("Area");
		Area.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,25));
		
		label=new Text();
		label.setText("Area Master");
		label.setFont(Font.font("Verdana",FontWeight.BOLD,40));

		Image add=new Image(getClass().getResourceAsStream("add-contacts.png"));
		Save=new Button("Save",new ImageView(add));
		Save.setPrefSize(150,50);
		
		Image close=new Image(getClass().getResourceAsStream("cancel.png"));
		Close=new Button("Close",new ImageView(close));
		Close.setPrefSize(150,50);
		
		HBox hbox=new HBox();
		hbox.setPadding(new Insets(50));
		hbox.getChildren().addAll(label);
		
		HBox hbox1=new HBox();
		hbox1.setPadding(new Insets(30));
		hbox1.getChildren().add(Save);
		
		HBox hbox2=new HBox();
		hbox2.setPadding(new Insets(30));
		hbox2.getChildren().add(Close);
		
		HBox hbox3=new HBox();
		hbox3.setPadding(new Insets(0));
		hbox3.getChildren().add(Areas);
		
		HBox hbox4=new HBox();
		hbox4.setPadding(new Insets(0,0,0,50));
		hbox4.getChildren().add(Area);
		
		grid.add(hbox,1,1,4,1);
		grid.add(hbox4,2,2);
		grid.add(hbox3,3,2,3,1);
		grid.add(hbox1,2,3);
		grid.add(hbox2,3,3);
		
		Scene scene=new Scene(grid);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Close.setOnAction(e->{
			primaryStage.close();
		});
		Save.setOnAction(e->{
			try 
			{
					 pst=con.prepareStatement("insert into areas values(?)");
					 pst.setString(1,Areas.getSelectionModel().getSelectedItem());
					
					 int x=pst.executeUpdate(); //EXECUTING THE QUERY
					 if(x==1)
					 {
						 showMsg("Area Added Sucessfully");
					 }
					 else
					 {
						 showMsg("Area Not Added");
					 }
					 pst.close();
			} 
			catch (SQLException exp) 
			{
				 		exp.printStackTrace();
			}
			
	   });
	}
	void showMsg(String msg)
	{
		Alert alert =new Alert(AlertType.INFORMATION);
		alert.setTitle("Message");
		alert.setHeaderText("Add Areas:");
		alert.setContentText(msg);
		alert.show();
	}
	void doFill()
	{
		Areas.getItems().clear();
		try 
		{
			pst=con.prepareStatement("select Area from Areas" );
			ResultSet rs= pst.executeQuery();
			ArrayList<String>list=new ArrayList<String>();
			while(rs.next())
			{
				String p=rs.getString("Area");
				list.add(p);
			}
			Areas.getItems().addAll(list);
			rs.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}
}
