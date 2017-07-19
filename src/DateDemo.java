import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
	
	public static void main(String args[]){
		
		
		Date date  = new Date();
		
		
		System.out.println(date);
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		System.out.println(dateFormat.format(date));
		
		
		
	}
	
	
	
	
	
	

}
