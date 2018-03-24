package newspaper;

public class TCCustomers 
{
	String Name,Mobile,Area,Adress,NewsPapers,Hawkers;
	Integer Id;
	
	public TCCustomers() {}
	
	public TCCustomers(Integer id, String name, String mobile, String area, String adress, String newsPapers, String hawkers) 
	{
		super();
		Id = id;
		Name = name;
		Mobile = mobile;
		Area = area;
		Adress = adress;
		NewsPapers = newsPapers;
		Hawkers = hawkers;
	}

	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		Adress = adress;
	}

	public String getNewsPapers() {
		return NewsPapers;
	}

	public void setNewsPapers(String newsPapers) {
		NewsPapers = newsPapers;
	}

	public String getHawkers() {
		return Hawkers;
	}

	public void setHawkers(String hawkers) {
		Hawkers = hawkers;
	}
}
