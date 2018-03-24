package newspaper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class HawkerDisplayer
{
	Connection con;
	java.sql.PreparedStatement pst;
	TextField google;
	@SuppressWarnings("unchecked")
	HawkerDisplayer() 
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
		TableView<TCHawkers> table;
		google=new TextField();
		google.setPromptText("Enter Something");
		
		Text label=new Text();
		label.setText("Hawkers Lister");
		label.setStyle("-fx-color:Green;");
		label.setFont(Font.font("Verdana",FontWeight.BOLD,40));
		
		Text Googler=new Text();
		Googler.setText("Googler");
		Googler.setFont(Font.font("Verdana",FontWeight.BOLD,20));
		Button Btn;
		grid=new GridPane();
		Btn=new Button();
		Btn.setText("Load All");
		Btn.setPrefSize(100,50);
		Button BtnGoogler=new Button("Google");
		BtnGoogler.setPrefSize(100,50);
		
		grid.setGridLinesVisible(false);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPadding(new Insets(20,20,20,20));
		grid.setPrefSize(1200,600);
		Btn.setStyle("-fx-border-color:	lightblue;");
	    BtnGoogler.setStyle("-fx-border-color:blue;");
		table=new TableView<>();
		table.setPrefWidth(1200);
		TableColumn<TCHawkers,String>col_name=new TableColumn<>("Hawker Name");
		col_name.setMinWidth(200);
		col_name.setCellValueFactory(new PropertyValueFactory<>("Hname"));

		TableColumn<TCHawkers, String>col_mob=new TableColumn<>("Mobile No");
		col_mob.setMinWidth(200);
		col_mob.setCellValueFactory(new PropertyValueFactory<>("Mobile"));

		TableColumn<TCHawkers, String>col_area=new TableColumn<>("Area");
		col_area.setMinWidth(200);
		col_area.setCellValueFactory(new PropertyValueFactory<>("Area"));

		TableColumn<TCHawkers, String>col_addr=new TableColumn<>("Address");
		col_addr.setMinWidth(500);
		col_addr.setCellValueFactory(new PropertyValueFactory<>("Adress"));

		table.getColumns().addAll(col_name,col_area,col_addr,col_mob);
		Btn.setOnAction(e->{table.setItems(getAll());});
		BtnGoogler.setOnAction(e->{table.setItems(getNewsWise());});
		
		HBox hbox1=new HBox();
		hbox1.setPadding(new Insets(20,20,20,50));
		hbox1.getChildren().add(Btn);
		
		HBox hbox2=new HBox();
		hbox2.setPadding(new Insets(20));
		hbox2.getChildren().add(table);
		
		HBox hbox3=new HBox();
		hbox3.setPadding(new Insets(20,20,20,400));
		hbox3.getChildren().add(label);
		
		HBox hbox4=new HBox();
		hbox4.setPadding(new Insets(20,20,20,100));
		hbox4.getChildren().add(Googler);
		
		HBox hbox5=new HBox();
		hbox5.setPadding(new Insets(20,20,20,100));
		hbox5.getChildren().add(google);
		
		HBox hbox6=new HBox();
		hbox6.setPadding(new Insets(20,20,20,100));
		hbox6.getChildren().add(BtnGoogler);
		
		grid.add(hbox1,1,2);
		grid.add(hbox2,1,3,4,1);
		grid.add(hbox3,1,1,4,1);
		grid.add(hbox4,2,2);
		grid.add(hbox5,3,2);
		grid.add(hbox6,4,2);
		
		Stage primaryStage=new Stage();
		Scene scene=new Scene(grid);
		primaryStage.setScene(scene);
		primaryStage.show();
		}
		ObservableList<TCHawkers>getAll()
		{
				ObservableList<TCHawkers>ary=FXCollections.observableArrayList();
				try 
				{
						ResultSet rs;
						pst=con.prepareStatement("select * from hawkerregistration");
						rs=pst.executeQuery();
						while(rs.next())
						{
							ary.add(new TCHawkers(rs.getString("Hname"),
									rs.getString("Mobile"),
									rs.getString("Area"),
									rs.getString("Adress")));
						}

				}
				catch (SQLException e) 
				{
						e.printStackTrace();
				}
				return ary;
		}
		ObservableList<TCHawkers>getNewsWise()
		{
				ObservableList<TCHawkers>ary=FXCollections.observableArrayList();
				try 
				{
						ResultSet rs1;
						pst=con.prepareStatement("select * from hawkerregistration where Hname LIKE '%"+google.getText()+"%'");
						rs1=pst.executeQuery();
						while(rs1.next())
						{
							ary.add(new TCHawkers(rs1.getString("Hname"),
									rs1.getString("Mobile"),
									rs1.getString("Area"),
									rs1.getString("Adress")));
						}

				}
				catch (SQLException e) 
				{
						e.printStackTrace();
				}
				return ary;
	 }

}
