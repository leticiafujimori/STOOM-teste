package com.stoom.teste.integracao.geocoding.contratos.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodingResponse {

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("results")
    public List<Results> results;

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Results {
        @JsonProperty("geometry")
        public Geometry geometry;
    }

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Geometry {
        @JsonProperty("location")
        public Location location;
    }

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Location {
        @JsonProperty("lat")
        public String latitude;
        @JsonProperty("lng")
        public String longitude;
    }
}
