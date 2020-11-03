package pages;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Base.DriverManager;
import Base.DriverManagerFactory;

public class HomePage{
	
	 WebDriver driver;
	 //this.wait= 
	 WebDriverWait wait;
	//Page Factory - OR:
		

		
		//Initializing the Page Objects:
		public HomePage(WebDriver driver){
			
			this.driver=driver;
			this.wait=new WebDriverWait(driver,100);
			
			PageFactory.initElements(driver, this);
		}
		@FindBy(id="search_query_top")
		WebElement search;
		
		@FindBy(name="submit_search")
		WebElement serachbuton;
		@FindBy(xpath="//select[@id='selectProductSort']")
		WebElement sortBy;
		
		@FindBy(how=How.XPATH,using="//span[@itemprop='price']")
		List<WebElement> price;
		


		private void waitForVisibility(WebElement element) throws Error{
		       new WebDriverWait(driver, 30)
		            .until(ExpectedConditions.visibilityOf(sortBy));
		}
		private List<WebElement> waitForVisibilityofElements(List<WebElement> element) throws Error{
		      
		            wait.until(ExpectedConditions.visibilityOfAllElements(price));
		            return price;
		}
		   public void searchKeyword(String keyword){

			   search.sendKeys(keyword);     
		    }
		   public void search()
		   {
			   serachbuton.click();
		   }
		   public void sorting(String criteria) throws InterruptedException
		   {
			   //Thread.sleep(1000);
			  /* 
			   WebDriverWait wait= new WebDriverWait(driver, 50);
	            WebElement el=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("selectProductSort form-control")));
			   Select sorting=new Select(el);
			   
			   sorting.selectByVisibleText("Price: Lowest first");*/
			   List<WebElement>priceText=new ArrayList<WebElement>();
			   
			   //priceText=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@itemprop='price']")));
			 
			   	priceText=waitForVisibilityofElements(price);
			   
			   
			   //priceText=driver.findElements(By.xpath("//span[@itemprop='price']"));
			   
			   List<String>actualPrice1=new ArrayList<String>();
			   for(int i=0;i<priceText.size();i++)
			   {
				   System.out.println(priceText.get(i).getText());
				   String price=priceText.get(i).getText().replace("$", "").replace("/^,?'/"," ");
				 
			  
				   	System.out.println(price);
			   
				   		actualPrice1.add(price);
				   		
				   	  	
			   
		   }
			   //actualPrice1.removeAll(Arrays.asList(" ",null));
			   
			  
			   
			   
			   System.out.println(actualPrice1);
			   Iterator<String> i = actualPrice1.iterator();
			   while (i.hasNext())
			   {
			       String s = i.next();
			       if (s == null || s.isEmpty())
			       {
			           i.remove();
			       }
			   }
			   System.out.println(actualPrice1);
			   //using list and collection sort
			  /* List<String>templist=actualPrice1.stream().collect(Collectors.toList());
			   
			   
			   System.out.println("this is originalList before Sorting tempList"+ actualPrice1);
					  System.out.println("this is tempList"+ templist);
					  Collections.sort(templist);
				System.out.println("this is originalList after Sorting tempList"+ actualPrice1);
					  System.out.println("this is tempList"+ templist);
					  Assert.assertEquals(templist, actualPrice1);*/
					  
				//using tree set
					  Set<String>treeset=new TreeSet(actualPrice1);
					  System.out.println("this is TreeSet "+ treeset);
							 System.out.println("this is actuallist after sorting treeset"+ actualPrice1);
							 Assert.assertEquals(treeset, actualPrice1);
			

			   
			  /* String[] convertedRankArray = new String[actualPrice1.size()];
			   convertedRankArray=actualPrice1.toArray(convertedRankArray);
			   
			   
			   System.out.println(convertedRankArray.toString());*/
			   
			   
			   /*int intVal = 0;
			   String text = "N/A";
			   
			   List<Integer> l =new  ArrayList<Integer>();
			   
			   try
			   {
			   for (String number : convertedRankArray) {
				  
				   
				   l.add(Integer.parseInt(number.trim()));
				   
				   if(number.equals(text))
				   {
					  
				   }
			   }  
			   }
				   catch(NumberFormatException e)
				   {
					   System.out.println(e);
				   }
*/				   
				   // l.add(Integer.parseInt(number.trim()));
				
					  // : new ArrayList<Integer>();

			   
			  /* for (String myInt : actualPrice1) {

			        l.add(Integer.parseInt(myInt));
			        
			        System.out.println(l);
			    }
			   System.out.println(l);*/
			  /* System.out.println(l);
			   List<Integer>templist=l.stream().collect(Collectors.toList());
			   
			   
			   System.out.println("this is originalList before Sorting tempList"+ l);
					  System.out.println("this is tempList"+ templist);
					  Collections.sort(templist);
				System.out.println("this is originalList after Sorting tempList"+ l);
					  System.out.println("this is tempList"+ templist);
					  Assert.assertEquals(templist, l);*/

			   
		   
			
}
}

