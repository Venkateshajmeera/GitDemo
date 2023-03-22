package seleniumLearning.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class DataReader {
	
	public List<HashMap<String, String>> DataReader() throws IOException {
		
		//JSON TO STRING--->
		
	String JsonData=	FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\seleniumLearning\\data\\standAloneData.json"),
			StandardCharsets.UTF_8);
		
	//string to hashmap
	ObjectMapper mapper=new ObjectMapper();
	List<HashMap<String,String>> Data= mapper.readValue(JsonData, new TypeReference<List<HashMap<String,String> >>() {});
	return Data;
	}


}
