package data;

import java.util.Map;
import java.util.TreeMap;

public class DataToWrite {
	
	static Map < String, Object[] > empinfo = new TreeMap < String, Object[] >();
	
	{   
	empinfo.put( "1", new Object[] {
       "EMP ID", "EMP NAME", "DESIGNATION" });
    
    empinfo.put( "2", new Object[] {
       "1", "Nikola", "Sr. QA - VIP Mobile Serbia" });
    
    empinfo.put( "3", new Object[] {
       "2", "Nikola", "Car" });
    
    empinfo.put( "4", new Object[] {
       "3", "Nikola", "Kralj" });
    
    empinfo.put( "5", new Object[] {	
       "4", "Loshmi", "Qwerty!" }); 
	}
	
	//Public getter for data
	public static Map <String, Object[]> getEmpinfo(){
		return empinfo;
	}
}

