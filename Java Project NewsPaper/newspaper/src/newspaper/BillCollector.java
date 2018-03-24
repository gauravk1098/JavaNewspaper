package newspaper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BillCollector 
{
	PreparedStatement pst;
	Connection con;
	Text label;
	Text Cids;
	ListView<String>Cid=new ListView<String>();
	Button Paid;
	Button Refresh;
	ComboBox<String>Months=new ComboBox<String>();
	ComboBox<String>Years=new ComboBox<String>();
	
	BillCollector() 
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
		
		for(int years=2012; years<=Calendar.getInstance().get(Calendar.YEAR); years++) 
		{
		    Years.getItems().add(years+"");
		}
		
		for(int i=1;i<=12;i++) 
		{
		    Months.getItems().add(i+"");
		}
		
		//Refresh.setOnAction(doFillUsers());
		
		GridPane grid=new GridPane();
		grid.setGridLinesVisible(false);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPadding(new Insets(20,20,20,20));
		grid.setPrefSize(600,600);
		
		label=new Text();
		label.setText("Bill Collector");
		label.setFont(Font.font("Verdana",FontWeight.BOLD,40));
		
		Cids=new Text();
		Cids.setText("Select Ids");
		Cids.setFont(Font.font("Verdana",FontWeight.MEDIUM,20));
		
		Image a=new Image(getClass().getResourceAsStream("paid.png"));
		Paid=new Button("Paid",new ImageView(a));
		Paid.setPrefSize(100,100);
		
		Image b=new Image(getClass().getResourceAsStream("refresh.png"));
		Refresh=new Button("Refresh",new ImageView(b));
		Refresh.setPrefSize(100,100);
		
		Cid.setPrefWidth(150);
		
		Image c=new Image(getClass().getResourceAsStream("load.png"));
		Button Load=new Button("Load",new ImageView(c));
		Load.setPrefSize(100, 50);
		
		
		
		HBox hbox1=new HBox();
		hbox1.setPadding(new Insets(50));
		hbox1.getChildren().add(label);
		
	//	HBox hbox2=new HBox();
	//	hbox2.setPadding(new Insets(20,20,20,40));
	//	hbox2.getChildren().add(Cids);
		
		HBox hbox3=new HBox();
		hbox3.setPadding(new Insets(20));
		hbox3.getChildren().add(Cid);
		
		HBox hbox4=new HBox();
		hbox4.setPadding(new Insets(30));
		hbox4.getChildren().add(Paid);
		
		HBox hbox5=new HBox();
		hbox5.setPadding(new Insets(30));
		hbox5.getChildren().add(Refresh);
		
		HBox hbox6=new HBox();
		hbox6.setPadding(new Insets(30));
		hbox6.getChildren().add(Months);
		
		HBox hbox7=new HBox();
		hbox7.setPadding(new Insets(30));
		hbox7.getChildren().add(Years);
		
		HBox hbox8=new HBox();
		hbox8.setPadding(new Insets(20));
		hbox8.getChildren().add(Load);
		
		grid.add(hbox1,1,1,2,1);
	//	grid.add(hbox2,1,2);
		grid.add(hbox3,1,3,1,2);
		grid.add(hbox4,2,3,1,1);
		grid.add(hbox5,3,3);
		grid.add(hbox6,1,2);
		grid.add(hbox7,2,2);
		grid.add(hbox8,3,2);
		
		Paid.setOnAction(e->doPaid());
		Refresh.setOnAction(e->doRefresh());
		Load.setOnAction(e->doFillUsers());
		
		Stage primaryStage=new Stage();
		Scene scene=new Scene(grid);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	void doFillUsers()
	{
		Cid.getSelectionModel().clearSelection();
		Cid.getItems().clear();
		try 
		{
			String st="0";
			pst=con.prepareStatement("select Cid from Bill where Status=? AND Month=? AND Year=?");
			pst.setString(1,st);
			int a=Integer.parseInt(Months.getSelectionModel().getSelectedItem());
			String r=Years.getSelectionModel().getSelectedItem();
			pst.setInt(2,a);
			pst.setString(3,r);
			ResultSet rs= pst.executeQuery();
			ArrayList<String>list=new ArrayList<String>();
			while(rs.next())
			{
				String p=rs.getString("Cid");
				list.add(p);
			}
			Cid.getItems().addAll(list);
			Cid.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			rs.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	void doPaid()
	{
		@SuppressWarnings("unused")
		int x=0;
		ObservableList<String> UsersPiad;
		UsersPiad=Cid.getSelectionModel().getSelectedItems();
		int a=Integer.parseInt(Months.getSelectionModel().getSelectedItem());
		String r=Years.getSelectionModel().getSelectedItem();
		for(String m:UsersPiad)
		{
			try 
			{
						pst=con.prepareStatement("update Bill set Status=? where Cid=? AND Month=? AND year=?");
						String st="1";
						pst.setString(1,st);
						pst.setString(2,m);
						pst.setInt(3,a);
						pst.setString(4,r);
						x=pst.executeUpdate();
								
			} 
			catch (SQLException e) 
			{
					e.printStackTrace();
			}
			
		}
	//	showMsg("Sucessfully Updated");
	}
	void doRefresh()
	{
		Cid.getSelectionModel().clearSelection();
		Cid.getItems().clear();
		doFillUsers();
	}
	void showMsg(String msg)
	{
		Alert alert =new Alert(AlertType.INFORMATION);
		alert.setTitle("Message");
		alert.setHeaderText("Payment Collector:");
		alert.setContentText(msg);
		alert.show();
	}
}
