package br.gov.cidadania.hadoop.cnpj;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.axis.encoding.Base64;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class EmpresaHadoopDTODeserializer implements JsonDeserializer<EmpresaHadoop> {

	public EmpresaHadoop deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext)
			throws JsonParseException {
		
		if (jsonElement.isJsonObject() || !jsonElement.getAsString().equalsIgnoreCase("Not")) {
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			JsonObject row = jsonObject.get("Row").getAsJsonArray().get(0).getAsJsonObject();
			String cnpj = decode(row.get("key").getAsString());
			JsonArray cell = row.get("Cell").getAsJsonArray();

			Iterator<JsonElement> iterator = cell.iterator();
			Map<String, String> colunas = new HashMap<>();

			while (iterator.hasNext()) {
				JsonElement element = iterator.next();
				JsonObject asJsonObject = element.getAsJsonObject();
				colunas.put(decode(asJsonObject.get("column").getAsString()),
						decode(asJsonObject.get("$").getAsString()));
			}
			
			return new EmpresaHadoop(cnpj, colunas);
			
		}
		
		return null;
		
	}

	private String decode(String base64) {
		return new String(Base64.decode(base64));
	}
}
