package components;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonToDTOConverter {
	
	private static Gson gson = new Gson();

	public static String convertirAJason(Object DTO) {
		String json = gson.toJson(DTO);
		return json;
	}
	
	public static Object convertListJsonToDTO(String json) {
		
		return 	gson.fromJson(json, new TypeToken<List<Object>>(){}.getType());
		
	}
	
	public static <T> Object convertJsonToDTO(String json, Class<T> entityClass) {
		
		return gson.fromJson(json, entityClass);
		
		
	}
}
