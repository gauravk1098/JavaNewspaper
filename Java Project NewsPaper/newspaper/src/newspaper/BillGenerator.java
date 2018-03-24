package newspaper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
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

public class BillGenerator 
{
	PreparedStatement pst;
	PreparedStatement pst1;
	 Connection con;
	
	Text label;
	Text Month;
	Text Year;
	Text CId;
	Text NewsPaper;
	Text Price;
	Text StartD;
	Text EndD;
	Text Amount;
	Text Period;
	
	ComboBox<String>Months=new ComboBox<String>();
	ComboBox<String>Years=new ComboBox<String>();
	ComboBox<String>CIds=new ComboBox<String>();
	
	ListView<String>NewsPapers=new ListView<String>();
	ListView<String>Rates=new ListView<String>();

	TextField Amounts;
	TextField Periods;
	
	DatePicker dp,de;
	
	Button GBill;
	
	Button Bill;
	String DOS="";
	String DOE="";
	
	public BillGenerator() {

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
		doFillId();
		GridPane grid=new GridPane();
		grid.setGridLinesVisible(false);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPadding(new Insets(20,20,20,20));
		grid.setPrefSize(750,650);

		label=new Text();
		label.setText("Bill Generator");
		label.setFont(Font.font("Verdana",FontWeight.BOLD,40));

		Month=new Text();
		Month.setText("Select Month");
		Month.setFont(Font.font("Verdana",FontWeight.MEDIUM,20));

		Year=new Text();
		Year.setText("Select Year");
		Year.setFont(Font.font("Verdana",FontWeight.MEDIUM,20));

		CId=new Text();
		CId.setText("Select Id");
		CId.setFont(Font.font("Verdana",FontWeight.MEDIUM,20));

		NewsPaper=new Text();
		NewsPaper.setText("Newspapers");
		NewsPaper.setFont(Font.font("Verdana",FontWeight.MEDIUM,20));

		Price=new Text();
		Price.setText("Prices");
		Price.setFont(Font.font("Verdana",FontWeight.MEDIUM,20));

		StartD=new Text();
		StartD.setText("Start Date");
		StartD.setFont(Font.font("Verdana",FontWeight.MEDIUM,20));

		EndD=new Text();
		EndD.setText("End Date");
		EndD.setFont(Font.font("Verdana",FontWeight.MEDIUM,20));
		
		Amount=new Text();
		Amount.setText("Amount");
		Amount.setFont(Font.font("Verdana",FontWeight.MEDIUM,20));
		
		Period=new Text();
		Period.setText("Period");
		Period.setFont(Font.font("Verdana",FontWeight.MEDIUM,20));
		
		

		Image close=new Image(getClass().getResourceAsStream("Billicon.png"));
		GBill=new Button("Generate Bill",new ImageView(close));
		GBill.setPrefSize(300,50);
		
		
		Bill=new Button("Bill");
		Bill.setPrefSize(300,50);

		Months.setPrefSize(150,15);
		Years.setPrefSize(150,15);
		CIds.setPrefSize(300,15);
		
		NewsPapers.setPrefSize(200,100);
		Rates.setPrefSize(200,100);
		
		Amounts=new TextField();
		Amounts.setPrefWidth(100);
		Amounts.setDisable(true);

		Periods=new TextField();
		Periods.setPrefWidth(100);
		Periods.setDisable(true);
		
		Calendar cal=Calendar.getInstance();
		 dp=new DatePicker(LocalDate.of(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)+1,cal.get(Calendar.DATE)));
		dp.setStyle("-fx-font-size:15");
		 de=new DatePicker(LocalDate.of(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)+1,cal.get(Calendar.DATE)));
		de.setStyle("-fx-font-size:15");
		
		for(int years=2012; years<=Calendar.getInstance().get(Calendar.YEAR); years++) 
		{
		    Years.getItems().add(years+"");
		}
		
		for(int i=1; i<=12;i++) 
		{
		    Months.getItems().add(i+"");
		}
		
		HBox hbox1=new HBox();
		hbox1.setPadding(new Insets(10));
		hbox1.getChildren().add(label);
		
		HBox hbox2=new HBox();
		hbox2.setPadding(new Insets(10));
		hbox2.getChildren().add(Month);
		
		HBox hbox3=new HBox();
		hbox3.setPadding(new Insets(10));
		hbox3.getChildren().add(Year);
		
		HBox hbox4=new HBox();
		hbox4.setPadding(new Insets(10));
		hbox4.getChildren().add(Years);
		
		HBox hbox5=new HBox();
		hbox5.setPadding(new Insets(10));
		hbox5.getChildren().add(Months);
		
		HBox hbox6=new HBox();
		hbox6.setPadding(new Insets(10,10,10,30));
		hbox6.getChildren().add(GBill);
		
		HBox hbox7=new HBox();
		hbox7.setPadding(new Insets(10));
		hbox7.getChildren().add(CId);
		
		HBox hbox8=new HBox();
		hbox8.setPadding(new Insets(10,10,10,20));
		hbox8.getChildren().add(CIds);
	
		HBox hbox10=new HBox();
		hbox10.setPadding(new Insets(10));
		hbox10.getChildren().add(NewsPaper);
		
		HBox hbox11=new HBox();
		hbox11.setPadding(new Insets(10,10,10,20));
		hbox11.getChildren().add(Price);
		
		HBox hbox12=new HBox();
		hbox12.setPadding(new Insets(10));
		hbox12.getChildren().add(NewsPapers);
		
		HBox hbox13=new HBox();
		hbox13.setPadding(new Insets(10));
		hbox13.getChildren().add(Rates);

		HBox hbox14=new HBox();
		hbox14.setPadding(new Insets(10));
		hbox14.getChildren().add(StartD);
		
		HBox hbox15=new HBox();
		hbox15.setPadding(new Insets(10));
		hbox15.getChildren().add(dp);
		
		HBox hbox16=new HBox();
		hbox16.setPadding(new Insets(10));
		hbox16.getChildren().add(EndD);
		
		HBox hbox17=new HBox();
		hbox17.setPadding(new Insets(10));
		hbox17.getChildren().add(de);
		
		HBox hbox18=new HBox();
		hbox18.setPadding(new Insets(10,10,10,30));
		hbox18.getChildren().add(Bill);
		
		HBox hbox19=new HBox();
		hbox19.setPadding(new Insets(10));
		hbox19.getChildren().add(Amount);
		
		HBox hbox20=new HBox();
		hbox20.setPadding(new Insets(10,10,10,25));
		hbox20.getChildren().add(Amounts);
		
		HBox hbox21=new HBox();
		hbox21.setPadding(new Insets(10,10,10,25));
		hbox21.getChildren().add(Periods);
		
		HBox hbox22=new HBox();
		hbox22.setPadding(new Insets(10,10,10,25));
		hbox22.getChildren().add(Period);
		
		grid.add(hbox1,2,1,2,1);
		grid.add(hbox2,1,2);
		grid.add(hbox3,3,2);
		grid.add(hbox4,4,2);
		grid.add(hbox5,2,2);
		grid.add(hbox6,2,3,2,1);
		grid.add(hbox7,1,4,1,1);
		grid.add(hbox8,2,4,2,1);
		grid.add(hbox10,1,5,1,1);
		grid.add(hbox11,3,5,1,1);
		grid.add(hbox12,2,5,1,1);
		grid.add(hbox13,4,5,1,1);
		grid.add(hbox14,1,7,1,1);
		grid.add(hbox15,2,7,1,1);
		grid.add(hbox16,3,7,1,1);
		grid.add(hbox17,4,7,1,1);
		grid.add(hbox18,2,9,2,1);
		grid.add(hbox19,3,10);
		grid.add(hbox20,4,10);
		grid.add(hbox21,2,10);
		grid.add(hbox22,1,10);
		
		
		CIds.getSelectionModel().selectedItemProperty().addListener((property,oldValue,newValue)->{
		try 
	 	{
					String IdSelected=newValue;
	 				pst=con.prepareStatement("select * from users where Id=?" );
	 				pst.setString(1,IdSelected);
	 				ResultSet rs= pst.executeQuery();
	 				if(rs.next())
	 				{
	 					NewsPapers.getItems().clear();
	 					String[] List=rs.getString("NewsPapers").split(",");
	 					for(String m:List)
	 					{
	 						NewsPapers.getItems().add(m);
	 						
	 					}
	 					NewsPapers.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	 					Rates.getItems().clear();
	 					String[] List1=rs.getString("Rates").split("/");
	 					for(String m:List1)
	 					{
	 						Rates.getItems().add(m);
	 					}
	 					Rates.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
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
		

		GBill.setOnAction(e->doCalculate());
		Bill.setOnAction(e->doBill());
			
		Scene scene=new Scene(grid);
		Stage primaryStage=new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
}
	void doFillId()
	{
		CIds.getItems().clear();
		try 
		{
			pst=con.prepareStatement("select Id from users" );
			ResultSet rs= pst.executeQuery();
			ArrayList<String>list=new ArrayList<String>();
			while(rs.next())//GETTING ALL USERS ONE BY ONE AND INSERTING IN THE ARRAY
			{
				String p=rs.getString("Id");
				list.add(p);
			}
			CIds.getItems().addAll(list);//ADDING THE USER LIST OT THE COMBO LIST
			rs.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}
	void doCalculate()
	{
		int x = 0;
		try 
		{
			pst=con.prepareStatement("select Id,bill from users");
			ResultSet rs= pst.executeQuery();
			while(rs.next())
			{
				int a=Integer.parseInt(Months.getSelectionModel().getSelectedItem());
				String p=rs.getString("Id");
				String r=Years.getSelectionModel().getSelectedItem();
				double q=rs.getDouble("bill");
				double MonthBill = 0;
				if(a==1||a==3||a==5||a==7||a==8||a==10||a==12)
				{
					MonthBill=q*31.0;
				}
				else if(a==2)
				{
					MonthBill=q*28.0;
				}
				else
				{
					MonthBill=q*30.0;
				}
				
					pst=con.prepareStatement("insert into Bill values(?,?,?,?,?)");
					pst.setString(1,p);
					pst.setDouble(2,MonthBill);
					pst.setString(3,"0");
					pst.setInt(4,a);
					pst.setString(5,r);
					x=pst.executeUpdate();	
			}
			if(x == 1)
				showMsg("Bill Generated");
			rs.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			showMsg("Already Generated");
		}
	
	}
	void showMsg(String msg)
	{
		Alert alert =new Alert(AlertType.INFORMATION);
		alert.setTitle("Message");
		alert.setHeaderText("Bill Generator:");
		alert.setContentText(msg);
		alert.show();
	}
	void doBill()
	{
		String AmountPayable = null;
		Integer Mon = null;
		Integer Year;
		long Period = 0;
		double bill =0;
		DOS=dp.getValue().toString();
		DOE=de.getValue().toString();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dosObj = null;
		Mon=dp.getValue().getMonthValue();
		java.util.Date doeObj = null;
		Year=dp.getValue().getYear();
		String Ye=Integer.toString(Year);
		try 
		{
			dosObj = format.parse(DOS);
			doeObj = format.parse(DOE);
			long diff = doeObj.getTime() - dosObj.getTime();
			Period=(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
			
		}
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		ObservableList<Integer>indxs=NewsPapers.getSelectionModel().getSelectedIndices();
		for(Integer o : indxs)
		{
			int c=o;
			Rates.getSelectionModel().select(c);
		}
		ObservableList<String>selected =Rates.getSelectionModel().getSelectedItems();
		for(String one:selected)
		{
			bill=bill+Double.parseDouble(one);
		}
		if(Period >=0)
		{
			long PeriodBill=(long) (bill*Period);
			AmountPayable=String.valueOf(PeriodBill);
			String p=String.valueOf(Period);
			Amounts.setText(AmountPayable);
			Periods.setText(p);
		}
		else
		{
			showMsg("End Date Should be Greater");
		}
		try 
		{
				pst=con.prepareStatement("insert into bill values(?,?,?,?,?)");
				String st="1";
				pst.setString(3,st);
				pst.setString(1,CIds.getSelectionModel().getSelectedItem());
				pst.setString(2,AmountPayable);
				pst.setInt(4,Mon);
				pst.setString(5,Ye);
				@SuppressWarnings("unused")
				int x = pst.executeUpdate();
			//	showMsg("Sucessfull");
		} 
		catch (SQLException e) 
		{
					e.printStackTrace();
		}
			
	}
	
}
