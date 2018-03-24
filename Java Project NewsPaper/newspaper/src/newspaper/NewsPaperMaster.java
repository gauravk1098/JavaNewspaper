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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NewsPaperMaster 
{
	ComboBox<String>NewsPaperName=new ComboBox<String>();
	PreparedStatement pst;
	static Connection con;
	TextField Rate;
	Text label;
	Text Newspaper;
	Text Price;
	Button Save;
	Button Clear;
	Button Delete;
	Button Update;
	
	 NewsPaperMaster() {
	
	
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
		grid.setGridLinesVisible(false);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPadding(new Insets(20,20,20,20));
		grid.setPrefSize(550,450);

		label=new Text();
		label.setText("NewsPapers Handler");
		label.setFont(Font.font("Verdana",FontWeight.BOLD,35));
	
		Newspaper=new Text();
		Newspaper.setText("NewsPaper");
		Newspaper.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,25));
		
		NewsPaperName.setEditable(true);
		NewsPaperName.setPrefSize(300,15);
		
		Price=new Text();
		Price.setText("Price");
		Price.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,25));
		
		Rate=new TextField();
		Rate.setPrefWidth(200);
		Rate.setPromptText("Enter Rate in Rupees:");

		Image add=new Image(getClass().getResourceAsStream("saaf.png"));
		Clear=new Button("Clear",new ImageView(add));
		Clear.setPrefSize(150,50);
		Clear.setStyle("-fx-border-color:#ade2ff");

		Image save=new Image(getClass().getResourceAsStream("save.png"));
		Save=new Button("Save",new ImageView(save));
		Save.setPrefSize(150,50);
		Save.setStyle("-fx-border-color:#ade2ff");
		
		Image remove=new Image(getClass().getResourceAsStream("rubbish-bin.png"));
		Delete=new Button("Delete",new ImageView(remove));
		Delete.setPrefSize(150,50);
		Delete.setStyle("-fx-border-color:#ade2ff");

		Image update=new Image(getClass().getResourceAsStream("refresh-button.png"));
		Update=new Button("Update",new ImageView(update));
		Update.setPrefSize(150,50);
		Update.setStyle("-fx-border-color:#ade2ff");

		HBox hbox=new HBox();
		hbox.setPadding(new Insets(50));
		hbox.getChildren().addAll(label);
		
		HBox hbox1=new HBox();
		hbox1.setPadding(new Insets(10));
		hbox1.getChildren().add(Clear);
		
		HBox hbox2=new HBox();
		hbox2.setPadding(new Insets(10,10,10,60));
		hbox2.getChildren().add(Save);
		
		HBox hbox3=new HBox();
		hbox3.setPadding(new Insets(10,10,10,60));
		hbox3.getChildren().add(Delete);
		
		HBox hbox4=new HBox();
		hbox4.setPadding(new Insets(10));
		hbox4.getChildren().add(Update);

		HBox hbox6=new HBox();
		hbox6.setPadding(new Insets(0,0,0,20));
		hbox6.getChildren().add(Newspaper);
		

		HBox hbox7=new HBox();
		hbox7.setPadding(new Insets(0,0,0,20));
		hbox7.getChildren().add(NewsPaperName);

		HBox hbox8=new HBox();
		hbox8.setPadding(new Insets(0,0,0,20));
		hbox8.getChildren().add(Price);

		HBox hbox9=new HBox();
		hbox9.setPadding(new Insets(0,0,0,50));
		hbox9.getChildren().add(Rate);
		
		grid.add(hbox,1,1,3,1);
		grid.add(hbox6,1,2);
		grid.add(hbox7,2,2,2,1);
		grid.add(hbox8,1,3);
		grid.add(hbox9,2,3,2,1);
		grid.add(hbox1,1,4);
		grid.add(hbox2,3,4);
		grid.add(hbox3,3,5);
		grid.add(hbox4,1,5);
		
		
		Stage primaryStage=new Stage();
		Scene scene=new Scene(grid);
		primaryStage.setScene(scene);
		primaryStage.show();
	
		NewsPaperName.getSelectionModel().selectedItemProperty().addListener((property,oldValue,newValue)->{
		try 
		{
				pst=con.prepareStatement("select * from NewsPapers where NewPaperName=?" );
				pst.setString(1,NewsPaperName.getSelectionModel().getSelectedItem());
				ResultSet rs= pst.executeQuery();
				if(rs.next())
				{
						Rate.setText(rs.getString("Price"));
				}
				else
				{
					
				}
				rs.close();
		} 
		catch (SQLException e) 
		{
					e.printStackTrace();
		}
	});
			
		Clear.setOnAction(e->{
			Rate.clear();
			NewsPaperName.getSelectionModel().clearSelection();

		});
		
		
		Save.setOnAction(e->{
			try 
			{
					 pst=con.prepareStatement("insert into NewsPapers values(?,?)");
					 pst.setString(1,NewsPaperName.getSelectionModel().getSelectedItem());
					 pst.setString(2,Rate.getText());
					 int x=pst.executeUpdate(); //EXECUTING THE QUERY
					 if(x==1)
					 {
						 showMsg("NewsPaper Inserted");
						 doFill();
					 }
					 else
					 {
						 System.out.println("NewsPaper Not Inserted");
					 }
					 pst.close();
			} 
			catch (SQLException exp) 
			{
				 		exp.printStackTrace();
			}
			
	   });
		
		Delete.setOnAction(e->{
			try 
				{
					pst=con.prepareStatement("delete from  NewsPapers where NewPaperName=?");
					pst.setString(1,NewsPaperName.getSelectionModel().getSelectedItem());
					int x=pst.executeUpdate();
					if(x==1)
					{
						showMsg("NewsPaper Deleted");
						Rate.clear();
						doFill();
					}
					else
						showMsg("Newspaper Does Not Exist");			
				} 
				catch (SQLException exp) 
				{
					exp.printStackTrace();
				}
			
		});
		
		Update.setOnAction(e->{
			try 
			{
						pst=con.prepareStatement("update NewsPapers set Price=? where NewPaperName=?");
						pst.setString(2,NewsPaperName.getSelectionModel().getSelectedItem());
						pst.setString(1,Rate.getText());
						int x=pst.executeUpdate();
						if(x==1)
						{
							showMsg("Record Updated");
						}
						else
							showMsg("Newspaper Does Not Exist");
												
			} 
			catch (SQLException exp) 
			{
					exp.printStackTrace();
			}
			
		});
	}

	void doFill()
	{
		NewsPaperName.getItems().clear();
		try 
		{
			pst=con.prepareStatement("select NewPaperName from NewsPapers" );
			ResultSet rs= pst.executeQuery();
			ArrayList<String>list=new ArrayList<String>();
			while(rs.next())//GETTING ALL USERS ONE BY ONE AND INSERTING IN THE ARRAY
			{
				String p=rs.getString("NewPaperName");
				list.add(p);
			}
			NewsPaperName.getItems().addAll(list);//ADDING THE USER LIST OT THE COMBO LIST
			rs.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}
	void showMsg(String msg)
	{
		Alert alert =new Alert(AlertType.INFORMATION);
		alert.setTitle("Message");
		alert.setHeaderText("NewsPapers Maintainence:");
		alert.setContentText(msg);
		alert.show();
	}
}


