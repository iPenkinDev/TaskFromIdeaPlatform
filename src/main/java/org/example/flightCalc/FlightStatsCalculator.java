package org.example.flightCalc;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlightStats {
    public static void main(String[] args) throws IOException {
        // Чтение JSON файла
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File("tickets.json"));
        JsonNode ticketsNode = rootNode.path("tickets");

        // Сбор данных о полетах между Владивостоком и Тель-Авивом
        List<Integer> flightTimes = new ArrayList<>();
        for (JsonNode ticketNode : ticketsNode) {
            String origin = ticketNode.path("origin").asText();
            String destination = ticketNode.path("destination").asText();
            if (origin.equals("VVO") && destination.equals("TLV")) {
                int flightTime = ticketNode.path("flightTime").asInt();
                flightTimes.add(flightTime);
            }
        }

        // Вычисление среднего времени полета
        double averageFlightTime = flightTimes.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("Среднее время полета между Владивостоком и Тель-Авивом: " + averageFlightTime);

        // Вычисление 90-го процентиля времени полета
        double percentile90 = flightTimes.stream()
                .sorted()
                .skip((int) (flightTimes.size() * 0.9))
                .findFirst()
                .orElse(0);
        System.out.println("90-й процентиль времени полета между Владивостоком и Тель-Авивом: " + percentile90);
    }
}
