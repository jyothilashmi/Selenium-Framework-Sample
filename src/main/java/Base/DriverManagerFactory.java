package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverManagerFactory {
	
	/*public DriverManagerFactory()
	{
		this.driverManager=null;
	}*/
	public static Properties prop;
	public static DriverManager driverManager;
	public DriverManagerFactory(){
	try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\j.lakshmi.s\\Documents\\OPUS\\learn\\selenium\\env.properties");
		prop.load(ip);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
	public static DriverManager getWebDriver(DriverType type)
	{
		DriverManager driverManager=null;
		switch(type)
		{
		
		case CHROME:
			driverManager=new ChromeDiverManager();
		break;
		
		default:
			System.out.print("error");
			break;
		}
		return driverManager;
	}

}
