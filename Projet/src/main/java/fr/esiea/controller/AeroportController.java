package fr.esiea.controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.sun.tools.javac.file.RelativePath;
import fr.esiea.message.Response;
import fr.esiea.model.Aeroport;
import fr.esiea.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/aeroport")
public class AeroportController {

	List<Aeroport> aero = new ArrayList<Aeroport>();

	public static List<Aeroport> loadAeroport(){
		ArrayList<Aeroport> Aeroports = new ArrayList<>();
		Gson gson = new Gson();
		JsonParser jsonParser = new JsonParser();
		try {
			BufferedReader br = new BufferedReader(new FileReader("resources/aeroport.json"));
			JsonElement jsonElement = jsonParser.parse(br);

			//Create generic type
			Type type = new TypeToken<List<Aeroport>>() {}.getType();
			return gson.fromJson(jsonElement, type);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return Aeroports;
	}

	@GetMapping(value = "/all")
	public Response getResource() {
		aero = loadAeroport();
		Response response = new Response("Done", aero);
		return response;
	}
}