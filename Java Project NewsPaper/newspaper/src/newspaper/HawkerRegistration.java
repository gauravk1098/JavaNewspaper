package newspaper;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
public class HawkerRegistration 
{
	Connection con;
	Button AddNew;
	Button Update;
	Button Save;
	Button Remove;
	Button Close;
	Button Browse;
	Text label;
	Text HName;
	Text Hmobile;
	Text HArea;
	Text HAdress;
	Text HIdproof;
	Text Path;
	TextField Mobile;
	TextField PATH;
	TextArea Adress;
	ComboBox<String>Name=new ComboBox<String>();
	ListView<String>Area=new ListView<String>();
	PreparedStatement pst;
	ImageView logo;
	
	HawkerRegistration() {
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
		
		doFill();
		doFillAreas();
		GridPane grid=new GridPane();
		grid.setGridLinesVisible(false);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPadding(new Insets(20,20,20,20));
		
	  Rectangle r1 = new Rectangle(600,370);
		r1.setFill(Color.LIGHTBLUE);
		r1.setArcWidth(20);
		r1.setArcHeight(20);
		/*	
		Rectangle r2 = new Rectangle(200,370);
		r1.setFill(Color.LIGHTSEAGREEN);
		r1.setArcWidth(20);
		r1.setArcHeight(20);
	*/
		label=new Text();
		label.setText("Hawker Console");
		label.setFont(Font.font("Verdana",FontWeight.BOLD,35));
		
		HName=new Text();
		HName.setText("Hawker Name");
		HName.setFont(Font.font(null, FontPosture.ITALIC,20));
		
		Hmobile=new Text();
		Hmobile.setText("MobileNo");
		Hmobile.setFont(Font.font(null, FontPosture.ITALIC,20));
		
		HArea=new Text();
		HArea.setText("Area");
		HArea.setFont(Font.font(null, FontPosture.ITALIC,20));
		
		HAdress=new Text();
		HAdress.setText("Adress");
		HAdress.setFont(Font.font(null, FontPosture.ITALIC,20));
		
		HIdproof=new Text();
		HIdproof.setText("IdProof");
		HIdproof.setFont(Font.font(null, FontPosture.ITALIC,20));
		
		Path=new Text();
		Path.setText("Path");
		Path.setFont(Font.font(null, FontPosture.ITALIC,20));
		
		PATH=new TextField();
		
		Name.setEditable(true);
		Name.setPrefSize(400,15);
		
		Mobile=new TextField();
		
		Area.setPrefSize(400,100);
		
		Adress=new TextArea();
		Adress.setPrefSize(400,50);
	
		Image add=new Image(getClass().getResourceAsStream("add-contacts.png"));
		AddNew=new Button("Add New",new ImageView(add));
		AddNew.setPrefSize(100,40);
		AddNew.setStyle("-fx-background-color:#FFE4B5");
		
		Image save=new Image(getClass().getResourceAsStream("save.png"));
		Save=new Button("Save",new ImageView(save));
		Save.setPrefSize(100,40);
		Save.setStyle("-fx-background-color:#FFE4B5");
		
		Image remove=new Image(getClass().getResourceAsStream("rubbish-bin.png"));
		Remove=new Button("Remove",new ImageView(remove));
		Remove.setPrefSize(100,40);
		Remove.setStyle("-fx-background-color:#FFE4B5");
		
		Image update=new Image(getClass().getResourceAsStream("refresh-button.png"));
		Update=new Button("Update",new ImageView(update));
		Update.setPrefSize(100,40);
		Update.setStyle("-fx-background-color:#FFE4B5");
		
		Image close=new Image(getClass().getResourceAsStream("cancel.png"));
		Close=new Button("Close",new ImageView(close));
		Close.setPrefSize(100,40);
		Close.setStyle("-fx-background-color:#FFE4B5");
		
		Browse=new Button("Browse");
		
		logo=new ImageView(new Image(HawkerRegistration.class.getResourceAsStream("no-img-preview.png")));
		logo.setFitWidth(100);
		logo.setFitHeight(100);
		
		HBox hbox=new HBox();
		hbox.getChildren().addAll(label);
		hbox.setPadding(new Insets(0,0,0,150));
		//grid.add(r1,1,1,3,8);
		
		grid.add(hbox    ,1,1,2,2);
		grid.add(HName   ,1,3,1,1);
		grid.add(Hmobile ,1,4,1,1);
		grid.add(HArea   ,1,5,1,1);
		grid.add(HAdress ,1,6,1,1);
		grid.add(HIdproof,1,7,1,1);
		grid.add(Path    ,1,8,1,1);
		
		grid.add(Name    ,2,3,2,1);
		grid.add(Mobile  ,2,4,2,1);
		grid.add(Area    ,2,5,2,1);
		grid.add(Adress  ,2,6,2,1);
		grid.add(Browse  ,2,7,2,1);
		grid.add(PATH    ,2,8,2,1);
		
		
		grid.add(AddNew  ,5,3);
		grid.add(Save    ,5,4);
		grid.add(Update  ,5,5);
		grid.add(Remove  ,5,6);
		grid.add(Close   ,5,7);
		grid.add(logo    ,5,8);
		
		
		Name.getSelectionModel().selectedItemProperty().addListener((property,oldValue,newValue)->{
		try 
		{
				pst=con.prepareStatement("select * from HawkerRegistration where Hname=?" );
				pst.setString(1,Name.getSelectionModel().getSelectedItem());
				ResultSet rs= pst.executeQuery();
				if(rs.next())
				{
					Area.getItems().clear();
					String[] List=rs.getString("Area").split(",");
					for(String m:List)
					{
						Area.getItems().add(m);
					}
					Mobile.setText(rs.getString("Mobile"));
					Adress.setText(rs.getString("Adress"));
					PATH.setText(rs.getString("IdProof"));
					Mobile.setText(rs.getString("Mobile"));
					logo.setImage(new Image(rs.getString("IdProof")));
					
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
		
		try
		{
			AddNew.setOnAction(e->doNew());
			Save.setOnAction(e->doSave());
			Update.setOnAction(e->doUpdate());
			Remove.setOnAction(e->doRemove());
			//ACTION ON CLICK OF BROWSE BUTTON
			Browse.setOnAction(e->{
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Choose The File");
				File file = fileChooser.showOpenDialog(null);
		        try 
		        {
		                BufferedImage bufferedImage = ImageIO.read(file);
		                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
		                String imageUrl = file.toURI().toURL().toExternalForm();
		                PATH.setText(imageUrl);
		                logo.setImage(image);
		        } 
		        catch (IOException ex) 
		        {
		                Logger.getLogger(HawkerRegistration.class.getName()).log(Level.SEVERE, null, ex);
		        }
			});
			
			//ACTION ON CLICK OF CLOSE BUTTON
			Close.setOnAction(e->{
				primaryStage.close();
			});
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		grid.setMaxSize(700,700);
		Scene scene=new Scene(grid);
		primaryStage.setScene(scene);
	    grid.setStyle("-fx-background-color:#FFFFE0");
		primaryStage.show();
}
	
	void doSave()
	{
		String message="";
		ObservableList<String> News;
		News = Area.getSelectionModel().getSelectedItems();
		for(String m:News)
		{
			message+=m+",";
		}
		try 
		{
				 pst=con.prepareStatement("insert into HawkerRegistration values(?,?,?,?,?,curdate())");
				 pst.setString(1,Name.getSelectionModel().getSelectedItem());
				 pst.setString(2,Mobile.getText());
				 pst.setString(3,message);
				 pst.setString(4,Adress.getText());
				 pst.setString(5,PATH.getText());
				 int x=pst.executeUpdate(); //EXECUTING THE QUERY
				 if(x==1)
				 {
						showMsg("Record Inserted");
				 }
				 else
				 {
						showMsg("Not Inserted");
				 }
				 pst.close();
		} 
		catch (SQLException e) 
		{
			 		e.printStackTrace();
		}
	}
	void doUpdate()
	{
		
		try 
		{
			String message="";
			ObservableList<String> News;
			News = Area.getSelectionModel().getSelectedItems();
			for(String m:News)
			{
				message+=m+",";
			}
					pst=con.prepareStatement("update HawkerRegistration set Mobile=?,Area=?,Adress=?,IdProof=? where Hname=?");
					pst.setString(5,Name.getSelectionModel().getSelectedItem());
					pst.setString(1,Mobile.getText());
					pst.setString(2,message);
					pst.setString(3,Adress.getText());
					pst.setString(4,PATH.getText());
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
	void doRemove()
	{
		 try 
			{
				pst=con.prepareStatement("delete from  HawkerRegistration where Hname=?");
				pst.setString(1,Name.getSelectionModel().getSelectedItem());
				int x=pst.executeUpdate();
				if(x==1)
				{
					showMsg("Record Deleted");
					doNew();
					doFill();
				}
				else
					showMsg("Invalid Id");		
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
	}
	void doNew()
	{
		Mobile.clear();
		Adress.clear();
		PATH.clear();
		Area.getSelectionModel().clearSelection();
		logo.setImage(new Image(HawkerRegistration.class.getResourceAsStream("no-img-preview.png")));
		Name.getSelectionModel().clearSelection();
		doFillAreas();
	}
	void doFill()
	{
		Name.getItems().clear();
		try 
		{
			pst=con.prepareStatement("select distinct Hname from HawkerRegistration" );
			ResultSet rs= pst.executeQuery();
			ArrayList<String>list=new ArrayList<String>();
			while(rs.next())//GETTING ALL USERS ONE BY ONE AND INSERTING IN THE ARRAY
			{
				String p=rs.getString("Hname");
				list.add(p);
			}
			Name.getItems().addAll(list);//ADDING THE USER LIST OT THE COMBO LIST
			rs.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

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
			Area.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
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
		alert.setHeaderText("Hawkers Enrollment:");
		alert.setContentText(msg);
		alert.show();
	}
}
