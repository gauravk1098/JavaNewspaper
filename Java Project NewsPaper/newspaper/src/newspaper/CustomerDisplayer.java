package newspaper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CustomerDisplayer 
{
		
				
		
		TextField google;
		static Connection con;
		java.sql.PreparedStatement pst;
		ComboBox<String> Lister;
		ComboBox<String> Items;
		String selected;
		@SuppressWarnings("unchecked")
		public CustomerDisplayer()
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
				
				TableView<TCCustomers> table;
				table=new TableView<>();
				table.setPrefWidth(1200);
				
				Text label=new Text();
				label.setText("Customers Record");
				label.setFont(Font.font("Verdana",FontWeight.BOLD,40));
				
				GridPane grid;
				grid=new GridPane();
				grid.setGridLinesVisible(false);
				grid.setVgap(10);
				grid.setHgap(10);
				grid.setPadding(new Insets(20,20,20,20));
				grid.setPrefSize(1200,600);
				
				ArrayList<String>List=new ArrayList<String>();
				List.add("Select");
				List.add("All Customer");
				List.add("Area Wise Customers");
				List.add("NewsPapers Wise Customers");
				List.add("Hawker Wise Customers");
				Lister=new ComboBox<String>();
				Lister.getItems().addAll(List);
				Lister.setPrefWidth(200);
				
				Items=new ComboBox<String>();
				Items.setPrefWidth(200);
						
				Button Load=new Button();
				Load.setText("Load");
				Load.setPrefSize(100,50);
				
				google=new TextField();
				google.setPromptText("Enter Part of Name");
				
				Button BtnGoogler=new Button("Google");
				BtnGoogler.setPrefSize(100,50);
				
				/*
				Button Excel=new Button("Export to\nExcel File");
				BtnGoogler.setPrefSize(100,100);
				try
				{
					Excel.setOnAction(e->writeExcel());
				}
				catch(Exception exp)
				{
					exp.printStackTrace();
				}
				*/
				TableColumn<TCCustomers,Integer>col_Id=new TableColumn<>("Id");
				col_Id.setMinWidth(100);
				col_Id.setCellValueFactory(new PropertyValueFactory<>("Id"));
		
				TableColumn<TCCustomers,String>col_name=new TableColumn<>("Name");
				col_name.setMinWidth(100);
				col_name.setCellValueFactory(new PropertyValueFactory<>("Name"));
		
				TableColumn<TCCustomers, String>col_mob=new TableColumn<>("Mobile No");
				col_mob.setMinWidth(100);
				col_mob.setCellValueFactory(new PropertyValueFactory<>("Mobile"));
		
				TableColumn<TCCustomers, String>col_area=new TableColumn<>("Area");
				col_area.setMinWidth(100);
				col_area.setCellValueFactory(new PropertyValueFactory<>("Area"));
		
				TableColumn<TCCustomers, String>col_addr=new TableColumn<>("Address");
				col_addr.setMinWidth(200);
				col_addr.setCellValueFactory(new PropertyValueFactory<>("Adress"));
		
				TableColumn<TCCustomers, String>col_papers=new TableColumn<>("NewsPapers");
				col_papers.setMinWidth(350);
				col_papers.setCellValueFactory(new PropertyValueFactory<>("NewsPapers"));
		
				TableColumn<TCCustomers, String>col_hawker=new TableColumn<>("Hawker");
				col_hawker.setMinWidth(100);
				col_hawker.setCellValueFactory(new PropertyValueFactory<>("Hawkers"));

				table.getColumns().addAll(col_Id,col_name,col_mob,col_area,col_addr,col_papers,col_hawker);
		
			Lister.getSelectionModel().selectedItemProperty().addListener((property,oldValue,newValue)->{
				String a=newValue;
				if(a=="Select")
				{
				
				}
				else if(a=="All Customer")
				{	
					Load.setOnAction(e->{table.setItems(getAll());});
				}
				else if(a=="Area Wise Customers")
				{	
					Load.setOnAction(e->{table.setItems(getAreaWise());});
				}
				else if(a=="NewsPapers Wise Customers")
				{
					Load.setOnAction(e->{table.setItems(getNewsWise());});
				}
				else if(a=="Hawker Wise Customers")
				{
					Load.setOnAction(e->{table.setItems(getHawkerWise());});
				}	
			
			});
		
			Items.getSelectionModel().selectedItemProperty().addListener((property,oldValue,newValue)->{
					selected=newValue;
			});
		
				HBox hbox1=new HBox();
				hbox1.setPadding(new Insets(20));
				hbox1.getChildren().add(label);
				
				HBox hbox2=new HBox();
				hbox2.setPadding(new Insets(20));
				hbox2.getChildren().add(Lister);
				
				HBox hbox3=new HBox();
				hbox3.setPadding(new Insets(20));
				hbox3.getChildren().add(Items);
				
				HBox hbox4=new HBox();
				hbox4.setPadding(new Insets(20));
				hbox4.getChildren().add(Load);
				
				HBox hbox5=new HBox();
				hbox5.setPadding(new Insets(20));
				hbox5.getChildren().add(google);
				
				HBox hbox6=new HBox();
				hbox6.setPadding(new Insets(20));
				hbox6.getChildren().add(BtnGoogler);
				
				HBox hbox7=new HBox();
				hbox7.setPadding(new Insets(20));
				hbox7.getChildren().add(table);
				
		
				BtnGoogler.setOnAction(e->{table.setItems(getNameWise());});
		
				grid.add(hbox1,1,1,6,1);
				grid.add(hbox2,1,2);
				grid.add(hbox3,2,2);
				grid.add(hbox4,3,2);
				grid.add(hbox5,4,2);
				grid.add(hbox6,5,2);
				grid.add(hbox7,1,3,6,1);
				
				Scene scene=new Scene(grid);
				Stage primaryStage=new Stage();
				primaryStage.setScene(scene);
				primaryStage.show();
				
		
				Lister.getSelectionModel().selectedItemProperty().addListener((property,oldValue,newValue)->{
				String a=newValue;
				if(a=="Select")
				{
						Items.getItems().clear();
				}
				else if(a=="All Customer")
				{
						Items.getItems().clear();
				}
				else if(a=="Area Wise Customers")
				{	
						Items.getItems().clear();
						try 
						{
							pst=con.prepareStatement("select Area from Areas");
							ResultSet rs= pst.executeQuery();
							ArrayList<String>list=new ArrayList<String>();
							while(rs.next())
							{
								String p=rs.getString("Area");
								list.add(p);
							}
							Items.getItems().addAll(list);
							rs.close();
						}
						catch (SQLException e) 
						{
							e.printStackTrace();
						}
				}
				else if(a=="NewsPapers Wise Customers")
				{
						Items.getItems().clear();
						try 
						{
							pst=con.prepareStatement("select NewPaperName from newspapers");
							ResultSet rs= pst.executeQuery();
							ArrayList<String>list=new ArrayList<String>();
							while(rs.next())
							{
								String p=rs.getString("NewPaperName");
								list.add(p);
							}
							Items.getItems().addAll(list);
							rs.close();
						}
						catch (SQLException e) 
						{
							e.printStackTrace();
						}
				}
				else if(a=="Hawker Wise Customers")
				{
						Items.getItems().clear();
						try 
						{
							pst=con.prepareStatement("select Hname from hawkerregistration");
							ResultSet rs= pst.executeQuery();
							ArrayList<String>list=new ArrayList<String>();
							while(rs.next())
							{
								String p=rs.getString("Hname");
								list.add(p);
							}
							Items.getItems().addAll(list);
							rs.close();
						}
						catch (SQLException e) 
						{
							e.printStackTrace();
						}
				}
				
			});
	}
	ObservableList<TCCustomers>getAll()
	{
			ObservableList<TCCustomers>ary=FXCollections.observableArrayList();
			try 
			{
						ResultSet rs;
						pst=con.prepareStatement("select * from users");
						rs=pst.executeQuery();
						while(rs.next())
						{
							ary.add(new TCCustomers(rs.getInt("Id"),rs.getString("Name"),rs.getString("Mobile"),rs.getString("Area")
									,rs.getString("Adress"),rs.getString("NewsPapers"),rs.getString("Hawkers")));
						}

			}
			catch (SQLException e) 
			{
						e.printStackTrace();
			}
			return ary;
	}
	ObservableList<TCCustomers>getNameWise()
	{
				ObservableList<TCCustomers>ary=FXCollections.observableArrayList();
				try 
				{
						ResultSet rs;
						pst=con.prepareStatement("select * from users where Name LIKE '%"+google.getText()+"%'");
						rs=pst.executeQuery();
						while(rs.next())
						{
							ary.add(new TCCustomers(rs.getInt("Id"),rs.getString("Name"),rs.getString("Mobile"),rs.getString("Area")
									,rs.getString("Adress"),rs.getString("NewsPapers"),rs.getString("Hawkers")));
						}
				}
				catch (SQLException e) 
				{
						e.printStackTrace();
				}
			return ary;
	}	
	ObservableList<TCCustomers>getNewsWise()
	{
			ObservableList<TCCustomers>ary=FXCollections.observableArrayList();
			try 
			{
					ResultSet rs;
					pst=con.prepareStatement("select * from users where NewsPapers LIKE '%"+selected+"%'");
					rs=pst.executeQuery();
					while(rs.next())
					{
						ary.add(new TCCustomers(rs.getInt("Id"),rs.getString("Name"),rs.getString("Mobile"),rs.getString("Area")
								,rs.getString("Adress"),rs.getString("NewsPapers"),rs.getString("Hawkers")));
					}

			}
			catch (SQLException e) 
			{
						e.printStackTrace();
			}
			return ary;
	}
	ObservableList<TCCustomers>getAreaWise()
	{
			ObservableList<TCCustomers>ary=FXCollections.observableArrayList();
			try 
			{
					ResultSet rs;
					pst=con.prepareStatement("select * from users where Area=?");
					pst.setString(1,selected);
					rs=pst.executeQuery();
					while(rs.next())
					{
						ary.add(new TCCustomers(rs.getInt("Id"),rs.getString("Name"),rs.getString("Mobile"),rs.getString("Area")
								,rs.getString("Adress"),rs.getString("NewsPapers"),rs.getString("Hawkers")));
					}
			}
			catch (SQLException e) 
			{
					e.printStackTrace();
			}
			return ary;
	}
	ObservableList<TCCustomers>getHawkerWise()
	{
			ObservableList<TCCustomers>ary=FXCollections.observableArrayList();
			try 
			{
					ResultSet rs;
					pst=con.prepareStatement("select * from users where Hawkers=?");
					pst.setString(1,selected);
					rs=pst.executeQuery();
					while(rs.next())
					{
						ary.add(new TCCustomers(rs.getInt("Id"),rs.getString("Name"),rs.getString("Mobile"),rs.getString("Area")
								,rs.getString("Adress"),rs.getString("NewsPapers"),rs.getString("Hawkers")));
					}

			}
			catch (SQLException e) 
			{
					e.printStackTrace();
			}
			return ary;
	 }
	/*
	public void writeExcel () throws Exception
	{
		Writer writer = null;
		try 
		{
				File file = new File("F:\\Customer.csv");
				writer=new BufferedWriter(new FileWriter(file));
				String text="Customer ID,Name,Mobile No,Area,Adress,Newspaper,Hawker\n";
				writer.write(text);
				for(TCCustomers TCC:ary) 
				{
					text = TCC.getId()+","+TCC.getName()+","+TCC.getMobile()+","
						   +TCC.getArea()+","+TCC.getAdress()+","+TCC.getNewsPapers()+","+TCC.getHawkers()+"\n";
					writer.write(text);
				}
		}
		catch (Exception ex) 
		{
					ex.printStackTrace();
		}
		finally 
		{
						writer.flush();
						writer.close();
		}
	}
	*/
	 
}