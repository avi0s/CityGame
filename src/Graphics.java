
import javax.imageio.ImageIO;
import javax.swing.*;  
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;

public class Graphics extends JFrame implements ActionListener{
	
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	JTextField txtdata;
	JLabel label;
	JButton text1;
	JButton question;
	JLabel photo;
	Cities myCity;
	JPanel gradient;
	JButton caption;
	JButton caption2;
	Image image;
	
Graphics(int n,Cities c)
  {
  myCity = c;
  ImageIcon logo = new ImageIcon("Globe_red_image_Citydle.jpg");
  
  if (n==99)
  {
	  JLabel label = new JLabel();
	  
	  label.setText("You win!");
	  label.setForeground(Color.BLACK);
	  label.setFont(new Font("Roboto", Font.BOLD,50));
	  label.setHorizontalAlignment(SwingConstants.CENTER); 
	  label.setVerticalAlignment(SwingConstants.CENTER);
	  
	  this.setTitle("Citydle");
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setSize(820,620);
	  this.setIconImage(logo.getImage());
	  this.getContentPane().setBackground(new Color(0,255,0)); //green
	  this.add(label);
	  this.setVisible(true);
  }
  
  if (n==100)
  {
	  JLabel label = new JLabel();
	  
	  label.setText("You lost! It was " + myCity.getName());
	  label.setForeground(Color.BLACK);
	  label.setFont(new Font("Roboto", Font.BOLD,50));
	  label.setHorizontalAlignment(SwingConstants.CENTER); 
	  label.setVerticalAlignment(SwingConstants.CENTER);
	  
	  this.setTitle("Citydle");
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setSize(820,620);
	  this.setIconImage(logo.getImage());
	  this.getContentPane().setBackground(new Color(255,0,0)); //red
	  this.add(label);
	  this.setVisible(true);
  }
  
  if (n==0)
  {
  
	  this.setSize(820, 620);  
	  this.setTitle("Citydle");
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setIconImage(logo.getImage());
		 
	  button1 = new JButton("Next");
	  button1.setBackground(Color.GREEN);
	  button1.setBounds(315,500,150,50);
	  button1.addActionListener(this);
	  button1.setFocusable(false);
	  button1.setFont(new Font("Comic Sans", Font.BOLD,15));
	  
	  button2 = new JButton("Ready to Play?");
	  button2.setOpaque(false);
	  button2.setBackground(Color.BLUE);
	  button2.setForeground(Color.ORANGE);
	  button2.setBounds(185,200,450,100);
	  button2.setFocusable(false);
	  button2.setBorderPainted(false);
	  button2.setFont(new Font("Comic Sans", Font.BOLD,45));
	      
	  gradient = new Gradient(); 
	       
	  this.add(button1);
	  this.add(button2);
	  this.add(gradient);
	  this.setVisible(true);  
  }
  }

public void level1()
{
	this.remove(button1);
	this.remove(gradient);
	this.remove(button2);
	
	this.setTitle("Citydle");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setResizable(false);
	this.setSize(820,620);
	  
	gradient = new Gradient(); 
	    
	WeatherAndTimeReport w = new WeatherAndTimeReport();
	w = WeatherAndTimeAPIs.showWeather(myCity.getLat(),myCity.getLong());
	   	 
	text1 = new JButton("The weather in this city is: " + w.getDes() + ", " + w.getTemp() + " degrees farenheit, and the humidity is " + w.getHumidity()+"%.");
	text1.setOpaque(false);
	text1.setBackground(Color.WHITE);
	text1.setForeground(Color.WHITE);
	text1.setFont(new Font("Roboto", Font.BOLD,17));
	text1.setBounds(25,100,795,100);
	text1.setFocusable(false);
	text1.setBorderPainted(false);
	
	caption2 = new JButton("The Current time in this city is " + w.getTime() + "."); 
	caption2.setOpaque(false);
	caption2.setBackground(Color.WHITE);
	caption2.setForeground(Color.WHITE);
	caption2.setFont(new Font("Roboto", Font.BOLD,17));
	caption2.setBounds(160,130,500,100);
	caption2.setFocusable(false);
	caption2.setBorderPainted(false);
	
	txtdata = new JTextField("");
	txtdata.setForeground(new Color(0,0,0));
	txtdata.setPreferredSize(new Dimension(200, 50));
	txtdata.setBounds(300,300,150,50);
	txtdata.setHorizontalAlignment(SwingConstants.CENTER); 
	txtdata.addActionListener(this);
	txtdata.setOpaque(true);
	  
	question = new JButton("What city is this?:");
	question.setOpaque(false);
	question.setForeground(Color.WHITE);
	question.setBackground(Color.BLACK);
	question.setFont(new Font("Roboto", Font.BOLD,17));
	question.setBounds(130,300,180,50);
	question.setBorderPainted(false);
	
	button2 = new JButton("SUBMIT");
	button2.setBackground(Color.GREEN);
	button2.setBounds(460,310,100,30);
	button2.addActionListener(this);
	button2.setFocusable(false);
	button2.setFont(new Font("Comic Sans", Font.BOLD,15));
	
	this.add(text1);
	this.add(question);
	this.add(txtdata);
	this.add(caption2);
	this.add(button2);
	this.add(gradient);
	this.setVisible(true);      
}

public void level2(String s)
{
	if (s.equalsIgnoreCase(myCity.getName()))
	{
		new Graphics(99,new Cities());
	}
	
	else
	{  
		this.remove(button2);
		this.remove(gradient);
		this.remove(txtdata);
		this.remove(question);
		this.remove(text1);
		this.remove(caption2);

		this.setTitle("Citydle");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(820, 620);
		this.getContentPane().setBackground(new Color(135, 206, 235)); // sky blue

		gradient = new Gradient2();

		Image image = null;
		URL url = null;

		try {
			url = new URL("https://maps.googleapis.com/maps/api/staticmap?center=" + myCity.getLat() + "," + myCity.getLong()+ "&zoom=15&size=800x800&maptype=satellite&key=//KEY");
			image = ImageIO.read(url);} 
		catch (MalformedURLException ex) {}
		catch (IOException iox) {}

		Image newImage = image.getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		photo = new JLabel(new ImageIcon(newImage));
		photo.setBounds(300, 300, 300, 300);
		gradient.add(photo);

		txtdata = new JTextField("");
		txtdata.setForeground(new Color(0, 0, 0));
		txtdata.setPreferredSize(new Dimension(200, 50));
		txtdata.setBounds(300, 400, 150, 50);
		txtdata.setHorizontalAlignment(SwingConstants.CENTER);
		txtdata.addActionListener(this);
		txtdata.setOpaque(true);

		question = new JButton("What city is it?:");
		question.setOpaque(false);
		question.setForeground(Color.WHITE);
		question.setBackground(Color.BLACK);
		question.setFont(new Font("Roboto", Font.BOLD, 17));
		question.setBounds(130, 400, 180, 50);
		question.setBorderPainted(false);

		caption = new JButton("This is a satellite image of the city.");
		caption.setOpaque(false);
		caption.setForeground(Color.ORANGE);
		caption.setBackground(Color.BLACK);
		caption.setFont(new Font("Roboto", Font.BOLD, 20));
		caption.setBounds(205, 300, 400, 60);
		caption.setEnabled(false);
		caption.setBorderPainted(false);

		WeatherAndTimeReport w = new WeatherAndTimeReport();
		w = WeatherAndTimeAPIs.showWeather(myCity.getLat(), myCity.getLong());

		caption2 = new JButton("This city is in " + w.getContinent() + ".");
		caption2.setOpaque(false);
		caption2.setBackground(Color.WHITE);
		caption2.setForeground(Color.ORANGE);
		caption2.setFont(new Font("Roboto", Font.BOLD, 17));
		caption2.setBounds(120, 340, 600, 50);
		caption2.setFocusable(false);
		caption2.setBorderPainted(false);

		button3 = new JButton("SUBMIT");
		button3.setBackground(Color.GREEN);
		button3.setBounds(460, 410, 100, 30);
		button3.setFocusable(false);
		button3.setFont(new Font("Comic Sans", Font.BOLD, 15));
		button3.addActionListener(this);

		this.add(question);
		this.add(caption);
		this.add(txtdata);
		this.add(caption2);
		this.add(button3);
		this.add(gradient);
		this.setVisible(true);
	}
}

public void level3(String s)
{
	if (s.equalsIgnoreCase(myCity.getName()))
	{
    new Graphics(99,new Cities());
	}
	else
	{
		this.remove(button2);
		this.remove(gradient);
		this.remove(txtdata);
		this.remove(question);
		this.remove(caption);
		this.remove(text1);
		this.remove(caption2);
		this.remove(button3);

		this.setTitle("Citydle");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(820, 620);
		this.getContentPane().setBackground(new Color(135, 206, 235)); // sky blue

		gradient = new Gradient2();

		Image image = null;
		URL url = null;
		try {
			url = new URL("https://maps.googleapis.com/maps/api/streetview?size=400x400&location=" + myCity.getLat()+ "," + myCity.getLong()+ "&fov=80&heading=70&pitch=0&key=//KEY");
			image = ImageIO.read(url);
		} 
		catch (MalformedURLException ex) {}
		catch (IOException iox) {}

		Image newImage = image.getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		photo = new JLabel(new ImageIcon(newImage));
		photo.setBounds(300, 300, 300, 300);
		gradient.add(photo);

		txtdata = new JTextField("");
		txtdata.setForeground(new Color(0, 0, 0));
		txtdata.setPreferredSize(new Dimension(200, 50));
		txtdata.setBounds(300, 400, 150, 50);
		txtdata.setHorizontalAlignment(SwingConstants.CENTER);
		txtdata.setOpaque(true);
		txtdata.addActionListener(this);

		question = new JButton("What city is it?:");
		question.setOpaque(false);
		question.setForeground(Color.WHITE);
		question.setBackground(Color.BLACK);
		question.setFont(new Font("Roboto", Font.BOLD, 17));
		question.setBounds(130, 400, 180, 50);
		question.setBorderPainted(false);

		caption = new JButton("This is a street view of the city.");
		caption.setOpaque(false);
		caption.setForeground(Color.ORANGE);
		caption.setBackground(Color.BLACK);
		caption.setFont(new Font("Roboto", Font.BOLD, 20));
		caption.setBounds(205, 300, 400, 60);
		caption.setEnabled(false);
		caption.setBorderPainted(false);

		caption2 = new JButton("This city's population is " + NumberFormat.getNumberInstance().format(myCity.getPop()));
		caption2.setOpaque(false);
		caption2.setBackground(Color.WHITE);
		caption2.setForeground(Color.ORANGE);
		caption2.setFont(new Font("Roboto", Font.BOLD, 17));
		caption2.setBounds(115, 340, 600, 50);
		caption2.setFocusable(false);
		caption2.setBorderPainted(false);

		button4 = new JButton("SUBMIT");
		button4.setBackground(Color.GREEN);
		button4.setBounds(460, 410, 100, 30);
		button4.setFocusable(false);
		button4.setFont(new Font("Comic Sans", Font.BOLD, 15));
		button4.addActionListener(this);

		this.add(question);
		this.add(caption);
		this.add(txtdata);
		this.add(caption2);
		this.add(button4);
		this.add(gradient);
		this.setVisible(true);
	}
}

public void level4(String s)
{
	if (s.equalsIgnoreCase(myCity.getName()))
	{
	 new Graphics(99,new Cities());
	}
	else
		{

			this.remove(question);
			this.remove(caption);
			this.remove(txtdata);
			this.remove(caption2);
			this.remove(button4);
			this.remove(gradient);

			this.setTitle("Citydle");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
			this.setSize(820, 620);
			this.getContentPane().setBackground(new Color(135, 206, 235)); // sky blue

			gradient = new Gradient2();

			Image image = null;
			URL url = null;
			try {
				url = new URL(myCity.getImage());
				image = ImageIO.read(url);
			} catch (MalformedURLException ex) {}
			catch (IOException iox) {}

			Image newImage = image.getScaledInstance(300, 300, Image.SCALE_DEFAULT);
			photo = new JLabel(new ImageIcon(newImage));
			photo.setBounds(300, 300, 300, 300);
			gradient.add(photo);

			txtdata = new JTextField("");
			txtdata.setForeground(new Color(0, 0, 0));
			txtdata.setPreferredSize(new Dimension(200, 50));
			txtdata.setBounds(300, 400, 150, 50);
			txtdata.setHorizontalAlignment(SwingConstants.CENTER);
			txtdata.setOpaque(true);
			txtdata.addActionListener(this);

			question = new JButton("What city is it?:");
			question.setOpaque(false);
			question.setForeground(Color.WHITE);
			question.setBackground(Color.BLACK);
			question.setFont(new Font("Roboto", Font.BOLD, 17));
			question.setBounds(130, 400, 180, 50);
			question.setBorderPainted(false);

			caption = new JButton("This is a landmark of the city.");
			caption.setOpaque(false);
			caption.setForeground(Color.ORANGE);
			caption.setBackground(Color.BLACK);
			caption.setFont(new Font("Roboto", Font.BOLD, 20));
			caption.setBounds(205, 300, 400, 60);
			caption.setEnabled(false);
			caption.setBorderPainted(false);

			button5 = new JButton("SUBMIT");
			button5.setBackground(Color.GREEN);
			button5.setBounds(460, 410, 100, 30);
			button5.setFocusable(false);
			button5.setFont(new Font("Comic Sans", Font.BOLD, 15));
			button5.addActionListener(this);

			this.add(question);
			this.add(caption);
			this.add(txtdata);
			this.add(button5);
			this.add(gradient);
			this.setVisible(true);
		}
	}

public void level5(String s)
{
	if (s.equalsIgnoreCase(myCity.getName()))
	{new Graphics(99,new Cities());}
	else
	{
		this.remove(question);
		this.remove(caption);
		this.remove(txtdata);
		this.remove(button5);
		this.remove(gradient);

		gradient = new Gradient();

		text1 = new JButton("The scrambled name of the city is " + myCity.getScrambledName());
		text1.setOpaque(false);
		text1.setBackground(Color.WHITE);
		text1.setForeground(Color.WHITE);
		text1.setFont(new Font("Roboto", Font.BOLD, 17));
		text1.setBounds(25, 100, 795, 100);
		text1.setFocusable(false);
		text1.setBorderPainted(false);

		txtdata = new JTextField("");
		txtdata.setForeground(new Color(0, 0, 0));
		txtdata.setPreferredSize(new Dimension(200, 50));
		txtdata.setBounds(300, 300, 150, 50);
		txtdata.setHorizontalAlignment(SwingConstants.CENTER);
		txtdata.addActionListener(this);
		txtdata.setOpaque(true);

		this.setTitle("Citydle");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(820, 620);

		question = new JButton("What city is it?:");
		question.setOpaque(false);
		question.setForeground(Color.WHITE);
		question.setBackground(Color.BLACK);
		question.setFont(new Font("Roboto", Font.BOLD, 17));
		question.setBounds(130, 300, 180, 50);
		question.setBorderPainted(false);

		button6 = new JButton("SUBMIT");
		button6.setBackground(Color.GREEN);
		button6.setBounds(460, 310, 100, 30);
		button6.addActionListener(this);
		button6.setFocusable(false);
		button6.setFont(new Font("Comic Sans", Font.BOLD, 15));

		this.add(question);
		this.add(txtdata);
		this.add(text1);
		this.add(button6);
		this.add(gradient);
		this.setVisible(true);
	}

}

public void level6(String s)
{
	if (s.equalsIgnoreCase(myCity.getName())) {
		new Graphics(99, new Cities());
	} else {
		new Graphics(100, myCity);
	}
}

      public static void main(String[] args)
      {       
    		Cities tokyo = new Cities ("Tokyo",35.6897,139.6922,37468000,"https://i.natgeofe.com/n/f2dfb6c5-a8e2-4fd1-9e4d-83ad28948437/tokyo_travel_square.jpg");
    	    Cities delhi = new Cities ("Delhi", 28.6100,77.2300,32226000,"https://img.etimg.com/thumb/width-1200,height-1200,imgsize-144818,resizemode-75,msid-89547849/news/india/new-delhi-was-inaugurated-91-years-ago-as-indias-grand-capital.jpg");
    	    Cities shaghai = new Cities ("Shanghai",31.2286,121.4747,23073000,"https://static.independent.co.uk/2023/08/07/12/iStock-587787576%20shanghai.jpg?width=1200&height=1200&fit=crop");
    	    Cities saompaulo = new Cities ("Sao Paulo",-23.55,-46.6333,23086000,"https://www.mensjournal.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cq_auto:good%2Cw_1200/MTk2MTM3MzYwNDM3OTQ1ODYx/saopaulo.jpg");
    	    Cities mexicuty = new Cities ("Mexico City",19.4333,-99.1333,21804000,"https://hips.hearstapps.com/toc.h-cdn.co/assets/16/44/3200x3200/square-1478185359-mexicocity.jpg?resize=1200:*");
    	    Cities csiro = new Cities ("Cairo",30.0444,31.2358,20296000,"https://www.kevinandamanda.com/wp-content/uploads/2019/08/cairo-egypt-30.jpg");
    	    Cities mimbai = new Cities ("Mumbai",19.0761,72.8775,24973000,"https://cdn.britannica.com/26/84526-050-45452C37/Gateway-monument-India-entrance-Mumbai-Harbour-coast.jpg");
    	    Cities beijing = new Cities ("Beijing",39.9067,116.3975,18522000,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ6EbBIlTvnLdLPtzJg-Gi12v2_se0sbGwFM8oYWPPePQ&s");
    	    Cities osaka = new Cities ("Osaka",34.6919,135.5092,15126000,"https://a.storyblok.com/f/51678/900x900/4f5167f5a7/hero-mobile-best-things-to-do-in-osaka.jpg/m/900x0/");
    	    Cities newyoek = new Cities ("New York",40.6890,-74.0443,18908608,"https://media.cntraveler.com/photos/63483e15ef943eff59de603a/1:1/w_2001,h_2001,c_limit/New%20York%20City_GettyImages-1347979016.jpg");
    	    Cities boston = new Cities ("Boston",42.3694,-71.0577,1675000,"https://www.hillel.org/wp-content/uploads/college-images/Harvard_University.png");
    	    Cities buenosaries = new Cities ("Buenos Aires",-34.603,-58.3817,16710000,"https://i.natgeofe.com/n/a2e54fd2-f71b-420b-b9dd-8a35cc5c6f75/ArgentinaLead_square.jpg");
    	    Cities istambul = new Cities ("Istanbul",41.0136,28.955,16079000,"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/09/76/41/be/mezquita-azul.jpg?w=1400&h=1400&s=1");
    	    Cities kolkata = new Cities ("Kolkata",22.5675,88.37,18502000,"https://images.lifestyleasia.com/wp-content/uploads/sites/7/2023/01/25135225/Untitled-design-12.jpg");
    	    Cities manila = new Cities ("Manila",14.5958,120.9772,24922000,"https://i.natgeofe.com/n/4b3822ac-1ddc-4be7-b448-17e42014f1c7/ST_wheretostay_RBJA66_HR_square.jpg");
    	    Cities lagos = new Cities ("Lagos",6.455,3.3841,16637000,"https://i.guim.co.uk/img/media/f7d77a132336a2adff15a6936f6c252db67a31a6/0_227_4000_2403/master/4000.jpg?width=1200&height=1200&quality=85&auto=format&fit=crop&s=95bc55425707ae68b35a837bf364429f");
    	    Cities rio = new Cities ("Rio de Janeiro", -22.9111,-43.2056,12592000,"https://i.natgeofe.com/n/560b293d-80b2-4449-ad6c-036a249d46f8/rio-de-janeiro-travel_square.jpg");
    	    Cities tianjin = new Cities ("Tianjin",39.1336,117.2054,10368000,"https://img.atlasobscura.com/Ft8nzJnDFuY29RQ9OVenE7XREPnyXXugBtmQ7Cj0lno/rs:fill:580:580:1/g:ce/q:81/sm:1/scp:1/ar:1/aHR0cHM6Ly9hdGxh/cy1kZXYuczMuYW1h/em9uYXdzLmNvbS91/cGxvYWRzL3BsYWNl/X2ltYWdlcy9iZmU2/YjEyZS1iNTIyLTRl/N2EtYjMyOS1lNzNl/NGJhMzA5Njc1YTUw/ZDhmMDM0ZDkwNzFm/NTRfODAwcHgt54Kr/5b2p5rSl6ZeoMTFU/aWFuamluX0V5ZV9h/bmRfSGFpaGVfUml2/ZXIuanBlZw.jpg");
    	    Cities rome = new Cities ("Rome",41.8967, 12.4822,2748000,"https://i.natgeofe.com/k/a6c9f195-de20-445d-9d36-745ef56042c5/OG_Colosseum_Ancient-Rome_KIDS_1122_square.jpg");
    	    Cities losanagkes = new Cities ("Los Angeles",33.8121,-117.9190,11922389,"https://media-cdn.tripadvisor.com/media/photo-s/1b/6f/73/1f/losangeles-california.jpg"); 
    	    Cities mosciw = new Cities ("Moscow",55.7558,37.6172,17332000,"https://cdn.britannica.com/83/84883-131-1A166B57/Red-Square-Moscow.jpg?w=200&h=200&c=crop");
    	    Cities shenzen = new Cities ("Shenzhen",22.5415,114.0596,17619000,"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/29/dd/9a/01/caption.jpg?w=300&h=300&s=1");
    	    Cities lahore = new Cities ("Lahore",31.5497,74.3436,12306000,"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/29/50/fc/02/caption.jpg?w=300&h=300&s=1");
    	    Cities bangalore = new Cities ("Bangalore",12.9789,77.5917,15386000,"https://img.etimg.com/thumb/width-1200,height-1200,imgsize-40491,resizemode-75,msid-45002333/news/politics-and-nation/bangalore-becomes-bengaluru-11-other-cities-renamed.jpg");
    	    Cities paris = new Cities ("Paris",48.8567,2.3522,11060000,"https://media.cntraveller.com/photos/653783ab9da3a22eb97452f9/1:1/w_3456,h_3456,c_limit/Cheapest_time_to_go_to_Paris_October23_Getty_Images.jpg");
    	    Cities bogota = new Cities ("Bogota",4.7111,-74.0722,7968095,"https://www.usatoday.com/gcdn/-mm-/fe0960b1b9f9ac9c949b9e74f02108bfa86673b2/c=818-0-2922-2104/local/-/media/2022/03/18/USATODAY/usatsports/Bogota-Skyline-2---Credit-ProColombia.jpg");
    	    Cities sanfra = new Cities ("San Francisco",37.7749 ,-122.4194,874000,"https://static.amazon.jobs/locations/150/thumbnails/SanFrancisco_Thumbnail.jpg?1469044076");
    	    Cities chennai = new Cities ("Chennai",13.0825,80.275,12395000,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRFqv36QzWORfX9MdRksWOmi4ulP_hA_3xIe4Hl_-Ah2g&s");
    	    Cities lima = new Cities ("Lima",-12.06,-77.0375,10320000,"https://www.casayolandalima.com/images/destinazioni/lima/lima.jpg");
    	    Cities bangkok = new Cities ("Bangkok",13.7525,100.4942,18007000,"https://i.natgeofe.com/n/19c95966-50f6-403a-a6ab-c5504955ec7f/bangkok-travel_square.jpg");
    	    Cities seoul = new Cities ("Seoul",37.56,126.99,23016000,"https://www.new7wonders.com/app/uploads/sites/5/2016/09/South-Korea-Seoul.jpg");
    	    Cities nagoya = new Cities ("Nagoya",35.1833,136.9,9197000,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRCz_QuptXEQUjau3eE6Oqty1pEoGtVObzPKAR0DCJ5pw&s");
    	    Cities hyderbad = new Cities ("Hyderabad",17.3617,78.4747,10494000,"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0f/98/f7/df/charminar.jpg?w=1400&h=1400&s=1");
    	    Cities london = new Cities ("London",51.5072,-0.1275,11262000,"https://cms.finnair.com/resource/blob/653780/68a843d4659786d6b381603c8e394e42/london-main-data.jpg?impolicy=crop&width=2666&height=2666&x=667&y=0");
    	    Cities tehran = new Cities ("Tehran",35.6892,51.3889,14148000,"https://www.iranchamber.com/cities/tehran/images/azadi_square.jpg");
    	    Cities chicago = new Cities ("Chicago",41.8781,-87.6308,8497759,"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/14/b4/91/a3/the-bean.jpg?w=500&h=500&s=1");
    	    Cities seattle = new Cities ("Seattle",47.6061,-122.3328,1737000,"https://i.natgeofe.com/n/0652a07e-42ed-4f3d-b2ea-0538de0c5ba3/seattle-travel_square.jpg");
    	    Cities hochiminh = new Cities ("Ho Chi Minh City",10.7756,106.7019,15136000,"https://turuhi.com/resources/wp-content/uploads/2023/06/The-Best-Way-to-Spend-24-Hours-in-Ho-Chi-Minh-City-Turuhi.jpg");
    	    Cities olso = new Cities ("Oslo",59.9139,10.7522, 703000,"https://workingwithnorwegians.com/wp-content/uploads/b4b0821a22b92fee233210732c1c99222c0a73d5.jpeg");
    	    Cities ahmedabad = new Cities ("Ahmedabad",23.0224,72.5714,8009000,"https://i.pinimg.com/236x/2d/63/10/2d63102bd3569ca2f88bfa96d563dc31.jpg");
    	    Cities athens = new Cities ("Athens",37.9838,23.7275,644000,"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/1c/c0/98/c5/caption.jpg?w=1400&h=1400&s=1&cx=960&cy=638&chk=v1_dd51d42e9a888a6b338f");
    	    Cities hongkong = new Cities ("Hong Kong",22.3,114.2,7450000,"https://hips.hearstapps.com/hmg-prod/images/hong-kong-travel-guide-656f89506c8af.jpg?crop=0.352xw:0.701xh;0.332xw,0.131xh&resize=640:*");
    	    Cities baghdad = new Cities ("Baghdad",33.3153,44.3661,6183000,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTe-iFNHLuRfYuIbIPCpviYrDqCuD6oDL6RXJdj_4v3gAQ6XQ3TCuyQeQCv-oj7Z7nlq74&usqp=CAU");
    	    Cities madrid = new Cities ("Madrid", 40.4169,-3.7033,6211000,"https://cdn.vox-cdn.com/thumbor/Lu1hFod8SoUL6XK3FtIMDtu2nC4=/1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/25247567/1949850410.jpg");
    	    Cities houston = new Cities ("Houston",29.786,-95.3885,5970127,"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0e/c4/f9/24/view.jpg?w=1200&h=1200&s=1");
    	    Cities amsterdam  = new Cities ("Amsterdam",52.3676,4.9041,2480000,"https://static.independent.co.uk/2023/10/12/16/newFile-1.jpg?width=1200&height=1200&fit=crop");
    	    Cities venice =  new Cities ("Venice",45.4404,12.3160,262000,"https://images.saymedia-content.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cq_auto:eco%2Cw_1200/MTkwOTYxOTc5MzM3MzUyODU5/how-was-venice-the-floating-city-built.jpg");
    	    Cities vienna = new Cities("Vienna",48.2081,16.3713,1960000,"https://lp-cms-production.imgix.net/2019-06/shutterstock_249139849.jpg?auto=format&fit=crop&ar=1:1&q=75&w=1200");
    	    Cities prague = new Cities("Prague",50.0755,14.4378,1309000,"https://lp-cms-production.imgix.net/2019-06/f85e77a2c778437b49223c44ff4da206-prague-castle.jpg?auto=format&fit=crop&ar=1:1&q=75&w=1200");
    	    Cities barclona = new Cities("Barcelona",41.3874,2.1686,1656000,"https://lp-cms-production.imgix.net/2024-01/shutterstock756015418.jpg?auto=format&fit=crop&ar=1:1&q=75&w=1200");
    	    
    	    Cities [] array = {seoul, amsterdam,sanfra,saompaulo,istambul,prague,barclona,venice ,baghdad,seattle,chicago,bangkok,mosciw,manila,osaka,beijing, shaghai,tokyo, delhi ,mexicuty ,csiro  , mimbai  , newyoek ,boston ,buenosaries  , kolkata , lagos , rio, tianjin,rome ,losanagkes ,shenzen ,lahore, bangalore,paris,bogota ,chennai,lima ,nagoya,hyderbad ,london,tehran  , hochiminh ,olso ,ahmedabad ,athens,hongkong, madrid , houston , vienna}; 
    	    Cities randomCity = array[(int) (Math.random()*50)];
    	    new Graphics(0,randomCity);   
      }

@Override
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==button1)
	{level1();}
	if(e.getSource()== button2)
	{level2(txtdata.getText());}
	if(e.getSource()== button3)
	{level3(txtdata.getText());}
	if(e.getSource()== button4)
	{level4(txtdata.getText());}
	if(e.getSource()== button5)
	{level5(txtdata.getText());}
	if(e.getSource()== button6)
	{level6(txtdata.getText());}
}
	}
