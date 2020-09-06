package Project_1;


public class ReserveVO {
	private int num;
	private String departureDate;
	
	private String arrivalDate;
	
	private String departurePlace;
	private String arrivalPlace;
	
	private String sitGrade;
	
	private String departureTime;
	private String arrivalTime;
	
	
	
	
	public ReserveVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public ReserveVO(int num,String departureDate, String arrivalDate, String departurePlace, String arrivalPlace,
			String sitGrade, String departureTime, String arrivalTime) {
		super();
		this.num=num;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.departurePlace = departurePlace;
		this.arrivalPlace = arrivalPlace;
		this.sitGrade = sitGrade;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}


	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getDeparturePlace() {
		return departurePlace;
	}
	public void setDeparturePlace(String departurePlace) {
		this.departurePlace = departurePlace;
	}
	public String getArrivalPlace() {
		return arrivalPlace;
	}
	public void setArrivalPlace(String arrivalPlace) {
		this.arrivalPlace = arrivalPlace;
	}
	public String getSitGrade() {
		return sitGrade;
	}
	public void setSitGrade(String sitGrade) {
		this.sitGrade = sitGrade;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	

}
