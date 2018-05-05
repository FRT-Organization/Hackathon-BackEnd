package trashman.modules.distance.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping("/distance")
public class CalculateDistanceController {

    @GetMapping("/get/{originLat},{originLong}/{destinationLat},{destinationLong}")
    public String getDistance(@PathVariable String originLat, @PathVariable String originLong, @PathVariable String destinationLat,
                              @PathVariable String destinationLong) {
        try {
            String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + originLat + "," + originLong +
                         "&destinations=" + destinationLat + "," + destinationLong + "&&language=en&key=AIzaSyAnibQNexDKLUZPTNuGuTBYRddMFIZU-RI";
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode distance = mapper.readTree(response.toString());
            JsonNode rows = distance.findPath("rows").findPath("elements").findPath("distance").findPath("value");

            return rows.toString();
        } catch (Exception e) {
            System.out.println("error");
            return null;
        }

    }
}