
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherAndTimeAPIs{
	
public static WeatherAndTimeReport showWeather (double latitude, double longitude){
WeatherAndTimeReport report = new WeatherAndTimeReport();
try{	
	String linkCall = "https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon="+ longitude + "&APPID=//key//";
	
	HttpURLConnection weatherCall= getResponse(linkCall);
	
	if(weatherCall.getResponseCode() != 200)
	{
		System.out.println("Error");
	}
	
	String jsonResponse = getAPIResponse(weatherCall);
	JSONParser parser = new JSONParser();
	JSONObject jsonObject = (JSONObject) parser.parse(jsonResponse);
	JSONObject weather = (JSONObject) jsonObject.get("main");
	double tempInFaren = Double.valueOf((double) weather.get("temp"));
	long humidity = (long) weather.get("humidity");
	JSONArray description = (JSONArray) jsonObject.get("weather");
	
	JSONObject des = (JSONObject) description.get(0);
	String finalDescription = (String) des.get("description");
	
	String linkCall2 = "https://timeapi.io/api/Time/current/coordinate?latitude=" + latitude + "&longitude=" + longitude;
	
	HttpURLConnection timeCall= getResponse(linkCall2);
	
	if(timeCall.getResponseCode() != 200)
	{
		System.out.println("Error");
	}
	
	String jsonResponse2 = getAPIResponse(timeCall);
	JSONParser parser2 = new JSONParser();
	JSONObject jsonObject2 = (JSONObject) parser2.parse(jsonResponse2);
	
	String timed = (String) jsonObject2.get("time");
	String con = (String) jsonObject2.get("timeZone");
	
	report.setTime(timed);
	report.setTemp(tempInFaren);	 
	report.setHumidity(humidity);
	report.setDes(finalDescription);
	report.setContinent(con);
	
}
catch(Exception e) {e.printStackTrace();}
return report;
}

	private static HttpURLConnection getResponse(String uRL)
	{
		try 
		{
			URL url = new URL(uRL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			return connection;
		}
		catch(IOException e) 
		{e.printStackTrace();}
		return null;
	
	}
	
	private static String getAPIResponse(HttpURLConnection apiCon)
	{
		try {
			StringBuilder endResult = new StringBuilder();
			Scanner scan = new Scanner(apiCon.getInputStream());
			while (scan.hasNext()){
				endResult.append(scan.nextLine());}
			scan.close();
			return endResult.toString();
			
			}
		catch(IOException e ) {e.printStackTrace();}
		return null;
		
	}
	
	public static void main(String[] args)
	{
		WeatherAndTimeReport bob = showWeather(37.56,126.99);
		System.out.println(bob.getDes());
		System.out.println(bob.getTemp());
		System.out.println(bob.getHumidity());
		System.out.println(bob.getTime());
		System.out.print(bob.getContinent());
	}
}
