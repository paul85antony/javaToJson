import java.io.File;
import java.io.IOException;


//Jackson api for converting the json file details to java object.
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class extractJson {

	//Json Converting to java object and storing all the values in get method.	
	public static void  main(String[] args) throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper o = new ObjectMapper();
		CustomerDetailsAppium c = o.readValue(new File("/Users/paulantony/eclipse-workspace/JsonJava/CustomerInfo0.json"), CustomerDetailsAppium.class);
		System.out.println(c.getCourseName());	
		System.out.println("Tahst it");

	}
}
