package utilities;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;


import java.util.ArrayList;

public class utils {
    public static JsonNode methodX(ArrayList arrayList){
        return Json.toJson(arrayList);
    }
}