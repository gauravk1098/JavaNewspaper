package newspaper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BillDisplayer 
{
	
		
	
	String b;
	Integer a;
	static Connection con;
	java.sql.PreparedStatement pst;
	@SuppressWarnings("unchecked")
	public BillDisplayer() 

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

		GridPane grid;
		grid=new GridPane();
		grid.setGridLinesVisible(false);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPadding(new Insets(20,20,20,20));
		grid.setPrefSize(700,600);
		
		TableView<TCBill> table;
		table=new TableView<>();
		table.setPrefWidth(600);
		HBox hbox2=new HBox();
		hbox2.setPadding(new Insets(20));
		hbox2.getChildren().add(table);
		
		RadioButton All=new RadioButton("All");
		HBox hbox5=new HBox();
		hbox5.setPadding(new Insets(20,20,20,30));
		hbox5.getChildren().add(All);
		
		RadioButton Paid=new RadioButton("Paid");
		HBox hbox6=new HBox();
		hbox6.setPadding(new Insets(20));
		hbox6.getChildren().add(Paid);
		
		RadioButton Balance=new RadioButton("Balance");
		HBox hbox7=new HBox();
		hbox7.setPadding(new Insets(20));
		hbox7.getChildren().add(Balance);
		
		ToggleGroup group=new ToggleGroup();
		All.setToggleGroup(group);
		Paid.setToggleGroup(group);
		Balance.setToggleGroup(group);
		
		ComboBox<String>Months=new ComboBox<String>();
		Months.setPrefSize(150,15);
		HBox hbox3=new HBox();
		hbox3.setPadding(new Insets(20));
		hbox3.getChildren().add(Months);
		
		ComboBox<String>Years=new ComboBox<String>();
		Years.setPrefSize(150,15);
		HBox hbox4=new HBox();
		hbox4.setPadding(new Insets(20));
		hbox4.getChildren().add(Years);
		
		Text label=new Text();
		label.setText("Bill Watcher");
		label.setFont(Font.font("Verdana",FontWeight.BOLD,40));
		HBox hbox1=new HBox();
		hbox1.setPadding(new Insets(20,20,20,200));
		hbox1.getChildren().add(label);

		Button btn=new Button("Show");
		btn.setPrefSize(100,50);
		HBox hbox8=new HBox();
		hbox8.setPadding(new Insets(20));
		hbox8.getChildren().add(btn);

		Text month=new Text("Month");
		month.setFont(Font.font("Verdana",FontWeight.BOLD,20));
		HBox hbox9=new HBox();
		hbox9.setPadding(new Insets(20));
		hbox9.getChildren().add(month);
		
		Text year=new Text("Year");
		year.setFont(Font.font("Verdana",FontWeight.BOLD,20));
		HBox hbox10=new HBox();
		hbox10.setPadding(new Insets(20));
		hbox10.getChildren().add(year);
		
		for(int years=2012; years<=Calendar.getInstance().get(Calendar.YEAR); years++) 
		{
		    Years.getItems().add(years+"");
		}
		
		for(int i=1;i<=12;i++) 
		{
		    Months.getItems().add(i+"");
		}
		
		Months.getSelectionModel().selectedItemProperty().addListener((property,oldValue,newValue)->{
			a=Integer.parseInt(newValue);
		});
		

		Years.getSelectionModel().selectedItemProperty().addListener((property,oldValue,newValue)->{
			b=newValue;
		});
		
		
		TableColumn<TCBill,String>col_Id=new TableColumn<>("Id");
		col_Id.setMinWidth(100);
		col_Id.setCellValueFactory(new PropertyValueFactory<>("Cid"));

		TableColumn<TCBill,String>col_Bill=new TableColumn<>("Bill Amount");
		col_Bill.setMinWidth(500);
		col_Bill.setCellValueFactory(new PropertyValueFactory<>("Bill"));

		table.getColumns().addAll(col_Id,col_Bill);

		
			btn.setOnAction(e->
			{
				if(All.isSelected())
				{
					table.setItems(getAll());
				}
				else if(Paid.isSelected())
				{
					table.setItems(getPaid());
				}
				else if(Balance.isSelected())
				{
					table.setItems(getBalance());
				}
			});
				
		grid.add(hbox1,1,1,4,1);
		grid.add(hbox2,1,4,4,1);
		grid.add(hbox3,2,2);
		grid.add(hbox4,4,2);
		grid.add(hbox5,1,3);
		grid.add(hbox6,2,3);
		grid.add(hbox7,3,3);
		grid.add(hbox8,4,3);
		grid.add(hbox9,1,2);
		grid.add(hbox10,3,2);
		
		Scene scene=new Scene(grid);
		Stage primaryStage=new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	ObservableList<TCBill>getAll()
	{
			ObservableList<TCBill> ary =FXCollections.observableArrayList();
			try 
			{
						ResultSet rs;
						pst=con.prepareStatement("select * from bill where Month=? AND Year=?");
						pst.setInt(1,a);
						pst.setString(2,b);
						rs=pst.executeQuery();
						while(rs.next())
						{
							ary.add(new TCBill(rs.getString("Cid"),rs.getDouble("Bill")));
						}

			}
			catch (SQLException e) 
			{
						e.printStackTrace();
			}
			return ary;
	}
	ObservableList<TCBill>getPaid()
	{
			ObservableList<TCBill> ary =FXCollections.observableArrayList();
			try 
			{
						int a1=1;
						ResultSet rs;
						pst=con.prepareStatement("select * from bill where Month=? AND Year=? AND Status=?");
						pst.setInt(1,a);
						pst.setString(2,b);
						pst.setInt(3,a1);
						rs=pst.executeQuery();
						while(rs.next())
						{
							ary.add(new TCBill(rs.getString("Cid"),rs.getDouble("Bill")));
						}

			}
			catch (SQLException e) 
			{
						e.printStackTrace();
			}
			return ary;
	}
	ObservableList<TCBill>getBalance()
	{
			ObservableList<TCBill> ary =FXCollections.observableArrayList();
			try 
			{
						ResultSet rs;
						int a1=0;
						pst=con.prepareStatement("select * from bill where Month=? AND Year=? AND Status=?");
						pst.setInt(1,a);
						pst.setString(2,b);
						pst.setInt(3,a1);
						rs=pst.executeQuery();
						while(rs.next())
						{
							ary.add(new TCBill(rs.getString("Cid"),rs.getDouble("Bill")));
						}

			}
			catch (SQLException e) 
			{
						e.printStackTrace();
			}
			return ary;
	}
}
