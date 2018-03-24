package newspaper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UserEnrollment
{
	PreparedStatement pst;
	static Connection con;
	Text label;
	Text CName;
	Text CAdress;
	Text CArea;
	Text CHawkers;
	Text CMobile;
	Text Cnewspaers;
	Text CIdentity;

	TextField Name;
	TextArea Adress;
	ComboBox<String>Area=new ComboBox<String>();
	ComboBox<String>Hawkers=new ComboBox<String>();
	TextField Mobile;
	ListView<String>NewsPapers=new ListView<String>();
	ListView<String>Rates=new ListView<String>();
	TextField Id;

	Button Clear;
	Button Enroll;
	Button Remove;
	Button Update;
	Button Close;
	Button Search;

	String SearchId;
	int IdSearch;

	public UserEnrollment() {
		Stage primaryStage=new Stage();
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
		doFillHawkers();
		doFillAreas();
		doFillNewsPapers();
		doFillRates();
		GridPane grid=new GridPane();
		grid.setGridLinesVisible(false);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPadding(new Insets(20,20,20,20));
		grid.setPrefSize(650,650);

		label=new Text();
		label.setText("Customer Registration");
		label.setFont(Font.font("Verdana",FontWeight.BOLD,35));

		CName=new Text();
		CName.setText("Customer Name");
		CName.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,25));

		CAdress=new Text();
		CAdress.setText("Customer Adress");
		CAdress.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,25));

		CArea=new Text();
		CArea.setText("Customer Area");
		CArea.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,25));

		CHawkers=new Text();
		CHawkers.setText("Hawkers");
		CHawkers.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,25));

		CMobile=new Text();
		CMobile.setText("Mobile Number");
		CMobile.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,25));

		Cnewspaers=new Text();
		Cnewspaers.setText("NewsPapers");
		Cnewspaers.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,25));

		CIdentity=new Text();
		CIdentity.setText("ID");
		CIdentity.setFont(Font.font("Verdana",FontWeight.SEMI_BOLD,25));

		Name=new TextField();
		Name.setPromptText("Enter Name");
		Name.setPrefSize(300,15);

		Adress=new TextArea();
		Adress.setPrefSize(300,50);

		Area.setPrefSize(300,15);

		Hawkers.setPrefSize(300,15);

		Mobile=new TextField();
		Mobile.setPromptText("Enter Mobile");
		Mobile.setPrefSize(300,15);

		NewsPapers.setPrefSize(300,80);
		Rates.setPrefSize(80,80);


		Id=new TextField();
		Id.setPrefSize(300,15);
		Id.setDisable(true);

		Image Cl=new Image(getClass().getResourceAsStream("saaf.png"));
		Clear=new Button("Clear",new ImageView(Cl));
		Clear.setPrefSize(100,50);

		Image add=new Image(getClass().getResourceAsStream("add-contacts.png"));
		Enroll=new Button("Enroll",new ImageView(add));
		Enroll.setPrefSize(100,50);

		Image remove=new Image(getClass().getResourceAsStream("rubbish-bin.png"));
		Remove=new Button("Remove",new ImageView(remove));
		Remove.setPrefSize(100,50);

		Image update=new Image(getClass().getResourceAsStream("refresh-button.png"));
		Update=new Button("Update",new ImageView(update));
		Update.setPrefSize(100,50);

		Image close=new Image(getClass().getResourceAsStream("cancel.png"));
		Close=new Button("Close",new ImageView(close));
		Close.setPrefSize(100,50);

		Image C=new Image(getClass().getResourceAsStream("search.png"));
		Search=new Button("Search",new ImageView(C));
		Search.setPrefSize(100,15);

		ImageView logo=new ImageView(new Image(UserEnrollment.class.getResourceAsStream("add.png")));
		logo.setFitWidth(80);
		logo.setFitHeight(80);

		HBox hbox1=new HBox();
		hbox1.setPadding(new Insets(0,0,0,50));
		hbox1.getChildren().add(logo);

		HBox hbox2=new HBox();
		hbox2.setPadding(new Insets(0));
		hbox2.getChildren().add(label);

		HBox hbox3=new HBox();
		hbox3.setPadding(new Insets(10));
		hbox3.getChildren().add(CName);

		HBox hbox4=new HBox();
		hbox4.setPadding(new Insets(10));
		hbox4.getChildren().add(Name);

		HBox hbox5=new HBox();
		hbox5.setPadding(new Insets(10,10,10,10));
		hbox5.getChildren().add(Search);

		HBox hbox6=new HBox();
		hbox6.setPadding(new Insets(20,0,0,10));
		hbox6.getChildren().add(CAdress);

		HBox hbox7=new HBox();
		hbox7.setPadding(new Insets(10));
		hbox7.getChildren().add(Adress);

		HBox hbox8=new HBox();
		hbox8.setPadding(new Insets(20,0,0,10));
		hbox8.getChildren().add(CArea);

		HBox hbox9=new HBox();
		hbox9.setPadding(new Insets(20,0,0,10));
		hbox9.getChildren().add(Area);

		HBox hbox10=new HBox();
		hbox10.setPadding(new Insets(20,0,0,10));
		hbox10.getChildren().add(CHawkers);

		HBox hbox11=new HBox();
		hbox11.setPadding(new Insets(20,0,0,10));
		hbox11.getChildren().add(Hawkers);

		HBox hbox12=new HBox();
		hbox12.setPadding(new Insets(20,0,0,10));
		hbox12.getChildren().add(CMobile);

		HBox hbox13=new HBox();
		hbox13.setPadding(new Insets(20,0,0,10));
		hbox13.getChildren().add(Mobile);

		HBox hbox14=new HBox();
		hbox14.setPadding(new Insets(20,0,0,10));
		hbox14.getChildren().add(Cnewspaers);

		HBox hbox15=new HBox();
		hbox15.setPadding(new Insets(10));
		hbox15.getChildren().add(NewsPapers);

		HBox hbox16=new HBox();
		hbox16.setPadding(new Insets(10));
		hbox16.getChildren().add(Clear);

		HBox hbox17=new HBox();
		hbox17.setPadding(new Insets(10));
		hbox17.getChildren().add(Enroll);

		HBox hbox18=new HBox();
		hbox18.setPadding(new Insets(10));
		hbox18.getChildren().add(Remove);

		HBox hbox19=new HBox();
		hbox19.setPadding(new Insets(10));
		hbox19.getChildren().add(Update);

		HBox hbox20=new HBox();
		hbox20.setPadding(new Insets(20,10,10,10));
		hbox20.getChildren().add(Close);

		HBox hbox21=new HBox();
		hbox21.setPadding(new Insets(10));
		hbox21.getChildren().add(CIdentity);

		HBox hbox22=new HBox();
		hbox22.setPadding(new Insets(10));
		hbox22.getChildren().add(Id);

		HBox hbox23=new HBox();
		hbox23.setPadding(new Insets(10));
		hbox23.getChildren().add(Rates);

		grid.add(hbox1,1,1,1,2);
		grid.add(hbox2,2,1,2,2);
		grid.add(hbox3,1,3,1,1);
		grid.add(hbox4,2,3,1,1);
		grid.add(hbox5,3,3,1,1);
		grid.add(hbox6,1,4,1,1);
		grid.add(hbox7,2,4,2,1);
		grid.add(hbox8,1,5,1,1);
		grid.add(hbox9,2,5,2,1);
		grid.add(hbox10,1,6,1,1);
		grid.add(hbox11,2,6,2,1);
		grid.add(hbox12,1,7,1,1);
		grid.add(hbox13,2,7,2,1);
		grid.add(hbox14,1,8,1,1);
		grid.add(hbox15,2,8,2,1);
		grid.add(hbox23,3,8);
		grid.add(hbox16,3,4,1,1);
		grid.add(hbox17,3,5,1,1);
		grid.add(hbox18,3,6,1,1);
		grid.add(hbox19,3,7,1,1);
		grid.add(hbox20,3,9);
		grid.add(hbox21,1,9);
		grid.add(hbox22,2,9);
		try
		{
			Search.setOnAction(e->doSearch());
			Clear.setOnAction(e->doNew());
			Enroll.setOnAction(e->doEnroll());
			Remove.setOnAction(e->doRemove());
			Update.setOnAction(e->doUpdate());

			//Event On Click Of Close Button
			Close.setOnAction(e->{
				primaryStage.close();
			});

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}


		Scene scene=new Scene(grid);
		primaryStage.setScene(scene);
		primaryStage.show();

}


	void doSearch()
	{
		 WindowController wc = new WindowController();
         wc.showStage();
         SearchId=wc.getData();

         try
 		{
 				pst=con.prepareStatement("select * from users where Id=?" );
 				pst.setString(1,SearchId);
 				ResultSet rs= pst.executeQuery();
 				if(rs.next())
 				{	Name.setText(rs.getString("Name"));
 					Adress.setText(rs.getString("Adress"));
 					Mobile.setText(rs.getString("Mobile"));
 					Id.setText(SearchId);
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
	}
	void doNew()
	{
		Name.clear();
		Adress.clear();
		Area.getSelectionModel().clearSelection();
		Hawkers.getSelectionModel().clearSelection();
		Mobile.clear();
		Id.clear();
		doFillNewsPapers();
		NewsPapers.getSelectionModel().clearSelection();
		doFillRates();
		Rates.getSelectionModel().clearSelection();

	}
	void doEnroll()
	{
		String message="";
		ObservableList<String> News;
		News = NewsPapers.getSelectionModel().getSelectedItems();
		for(String m:News)
		{
			message+=m+",";
		}

		ObservableList<Integer>indxs=NewsPapers.getSelectionModel().getSelectedIndices();
		for(Integer o : indxs)
		{
			int c=o;
			Rates.getSelectionModel().select(c);
		}
		String message1="";
		ObservableList<String> Rate;
		Rate = Rates.getSelectionModel().getSelectedItems();
		for(String m:Rate)
		{
			message1+=m+"/";
		}
		float bill=0;
		for(String m:Rate)
		{
			float p=Float.parseFloat(m);
			bill+=p;
		}
		try
		{
				 pst=con.prepareStatement("insert into users(Name,Adress,Area,Hawkers,Mobile,NewsPapers,Rates,bill) values(?,?,?,?,?,?,?,?)");
				 pst.setString(1,Name.getText());
				 pst.setString(2,Adress.getText());
				 pst.setString(3,Area.getSelectionModel().getSelectedItem());
				 pst.setString(4,Hawkers.getSelectionModel().getSelectedItem());
				 pst.setString(5,Mobile.getText());
				 pst.setString(6,message);
				 pst.setString(7,message1);
				 pst.setFloat(8,bill);
				 int x=pst.executeUpdate(); //EXECUTING THE QUERY
				 if(x==1)
				 {
					 showMsg("Record Inserted");
				 }
				 else
				 {
					 showMsg("Duplicate Entry");
				 }
				 ///////////////////////////////////////////////////////////////////////////////////////
				 /*
				 try
					{
						ResultSet rs;
						rs = pst.executeQuery("select max(Id) as Id from users");
						int lastid = rs.getInt("Id");
						System.out.println(lastid);
					}
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
					*/
				 //////////////////////////////////////////////////////////////////////////////////////
				 pst.close();
				
		}
		catch (SQLException e)
		{
			 		e.printStackTrace();
		}
	}
	void doRemove()
	{
				try
				{
					pst=con.prepareStatement("delete from users where Id=?");
					pst.setString(1,Id.getText());
					int x=pst.executeUpdate();
					if(x==1)
					{
						doNew();
						showMsg("Record Deleted");
					}
					else
						showMsg("Invalid Id");
				}
				catch (SQLException exp)
				{
					exp.printStackTrace();
				}
	}
	void doUpdate()
	{
		try
		{
					String message="";
					ObservableList<String> News;
					News = NewsPapers.getSelectionModel().getSelectedItems();
					for(String m:News)
					{
						message += m+",";
					}

					ObservableList<Integer>indxs=NewsPapers.getSelectionModel().getSelectedIndices();
					for(Integer o : indxs)
					{
						int c=o;
						Rates.getSelectionModel().select(c);
					}
					String message1="";
					ObservableList<String> Rate;
					Rate = Rates.getSelectionModel().getSelectedItems();
					for(String m:Rate)
					{
						message1+=m+",";
					}
					pst=con.prepareStatement("update users set Name=?,Adress=?,Area=?,Hawkers=?,Mobile=?,NewsPapers=?,Rates=? where Id=?");
					pst.setString(1,Name.getText());
					pst.setString(2,Adress.getText());
					pst.setString(3,Area.getSelectionModel().getSelectedItem());
				    pst.setString(4,Hawkers.getSelectionModel().getSelectedItem());
				    pst.setString(5,Mobile.getText());
				    pst.setString(6,message);
				    pst.setString(8,Id.getText());
				    pst.setString(7,message1);

					int x=pst.executeUpdate();
					if(x==1)
					{
						showMsg("Record Updated");
					}
					else
						showMsg("Invalid Id");

		}
		catch (SQLException e)
		{
				e.printStackTrace();
		}
	}
	void doFillHawkers()
	{
		Area.getSelectionModel().selectedItemProperty().addListener((property,oldValue,newValue)->{
		String a=newValue;
		Hawkers.getItems().clear();
		try
		{
			pst=con.prepareStatement("select Hname from hawkerregistration where Area like '%"+a+"%'");
			ResultSet rs= pst.executeQuery();
			ArrayList<String>list=new ArrayList<String>();
			while(rs.next())
			{
				String p=rs.getString("Hname");
				list.add(p);
			}
			Hawkers.getItems().addAll(list);
			rs.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		});


	}
	void doFillAreas()
	{
		Area.getItems().clear();
		try
		{
			pst=con.prepareStatement("select Area from areas" );
			ResultSet rs= pst.executeQuery();
			ArrayList<String>list=new ArrayList<String>();
			while(rs.next())
			{
				String p=rs.getString("Area");
				list.add(p);
			}
			Area.getItems().addAll(list);
			rs.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	void doFillNewsPapers()
	{
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
			NewsPapers.getItems().addAll(list);
			NewsPapers.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			rs.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	void doFillRates()
	{
		try
		{
			pst=con.prepareStatement("select Price from newspapers");
			ResultSet rs= pst.executeQuery();
			ArrayList<String>list=new ArrayList<String>();
			while(rs.next())
			{
				String p=rs.getString("Price");
				list.add(p);
			}
			Rates.getItems().addAll(list);
			Rates.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
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
		alert.setHeaderText("USERS Enrollment:");
		alert.setContentText(msg);
		alert.show();
	}
}
class WindowController
{
    private String data;
    void showStage()
    {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);

        GridPane grid=new GridPane();
        Scene scene = new Scene(grid);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(20));
        grid.setPrefSize(300,100);


        TextField tf = new TextField();
        Text Id=new Text();
        Id.setText("Enter Id");
        Button submit = new Button("Submit");

        grid.add(Id,1,1);
        grid.add(tf,2,1);
        grid.add(submit,2,2,2,1);

        submit.setOnAction(e -> {
            data = tf.getText();
            stage.close();
        });


        stage.setScene(scene);
        stage.showAndWait();
    }

    String getData()
    {
        return data;
    }
}
