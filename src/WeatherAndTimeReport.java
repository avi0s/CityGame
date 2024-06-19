
public class WeatherAndTimeReport {

	private double temperature;
	private long humidity;
	private String description;
	private String time;
	private String continent;
	
	public WeatherAndTimeReport(double temperature, long humidity, String description, String time,String continent)
	{
	this.temperature =temperature ;
	this.humidity=humidity;
	this.description=description;
	this.time = time;
	}
	
	public WeatherAndTimeReport()
	{
	this.temperature =0.0 ;
	this.humidity=0;
	this.description=null;
	this.time = null;
	this.continent = null;
	}
	
	public double getTemp() {
		return temperature;
	}
	
	public int getHumidity() {
		return Math.toIntExact(humidity);
	}
	
	public String getDes() 
	{
		return description;
	}
	
	public String getTime()
	{
		int first =  Integer.valueOf(time.substring(0,2));
		if (first == 0)
			return 12 + time.substring(2)+" am";
		if (first<12)
			return time + " am";
		if (first ==  12) 
			{return time +"pm";}
		return (first-12)+time.substring(2)+" pm";
	}	
	
	public String getContinent()
	{
		return continent.substring(0,continent.indexOf("/"));
	}
	public void setTemp(double t) {
		 temperature=t;
	}
	
	public void setHumidity(long l) {
		 humidity=l;
	}
	
	public void setDes(String d) {
		 description=d;
	}
	
	public void setTime(String t)
	{
		time = t;
	}
	
	public void setContinent(String c)
	{
		continent = c;
	}
}
