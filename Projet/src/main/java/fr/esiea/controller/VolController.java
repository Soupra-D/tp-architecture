package fr.esiea.controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import fr.esiea.message.Response;
import fr.esiea.model.Vol;
import fr.esiea.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/vol")
public class VolController {

    List<Vol> vol = new ArrayList<Vol>();

    public static List<Vol> loadVol(){
        ArrayList<Vol> Vols = new ArrayList<>();
        Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();
        try {
            BufferedReader br = new BufferedReader(new FileReader("Projet/src/main/resources/static/json/vol.json"));
            JsonElement jsonElement = jsonParser.parse(br);

            //Create generic type
            Type type = new TypeToken<List<Vol>>() {}.getType();
            return gson.fromJson(jsonElement, type);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Vols;
    }

    @GetMapping(value = "/all")
    public Response getResource() {
        vol = loadVol();
        Response response = new Response("Done", vol);
        return response;
    }
}