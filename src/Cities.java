import java.util.*; 

public class Cities {
	
	    private String cityName;
	    private int population;
	    private double latitude; 
	    private double longitude;
	   private String imageLink;
	   
	   
	    public Cities(String name, double lat , double lon, int pop, String im1)
	    {
	     cityName = name;
	     population = pop;
	     latitude = lat;
	     longitude = lon;
	     imageLink = im1;
	     
	    }
	    public Cities()
	    {
	     cityName = null;
	     population = 0;
	     latitude = 0;
	     longitude = 0;
	     imageLink = null;
	     
	    }
	      public String getScrambledName()
	    {
	 
	        String res = "";
	        ArrayList<String> list = new ArrayList<String>(cityName.length());
	        
	       for(int i=0;i<cityName.length();i++)
	       {
	           list.add(cityName.substring(i,i+1));
	       }
	       int h = cityName.length();
	       for (int r=h;r>0;r--)
	      {
	          int num = (int) (Math.random()*r);
	          res +=list.remove(num);
	      }
	      return res;
	    }
	    public double getLat()
	    {
	        return latitude;
	    }
	    
	    public double getLong()
	    {
	        return longitude;
	    }
	    
	    public int getPop()
	    {
	        return population;
	    }
	    
	    public String getImage()
	    {
	    	return imageLink;
	    }
	    
	    public String getName()
	    {
	        return cityName;
	    }
	    
	    public static void main(String[] args)
	    {
	       
	    }
}
