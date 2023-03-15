package org.example.flightCalc;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class FlightData {

    private List<Ticket> tickets;

    @Data
    public static class Ticket {

        @SerializedName("origin")
        private String origin;

        @SerializedName("origin_name")
        private String originName;

        @SerializedName("destination")
        private String destination;

        @SerializedName("destination_name")
        private String destinationName;

        @SerializedName("departure_date")
        private String departureDate;

        @SerializedName("departure_time")
        private String departureTime;

        @SerializedName("arrival_date")
        private String arrivalDate;

        @SerializedName("arrival_time")
        private String arrivalTime;

        @SerializedName("carrier")
        private String carrier;

        @SerializedName("stops")
        private int stops;

        @SerializedName("price")
        private int price;
    }
}