package com.safosamson.Ecommerce.UnrelatedTests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

class HttpConnection {
    private static final String BASE_URL = "https://api.gleif.org/api/v1/lei-records";

    public static void main(String[] args) {
        // Example usage of dynamic filters
        Map<String, String> filters = new HashMap<>();

        // Dynamically setting values
//        filters.put("entity.legalName", "bloomberg");               // Filter by legal name
        filters.put("lei", "213800YMYFD4JWIXS420,549300KQC5M45N4PKV05");  // Filter by LEI
//        filters.put("bic", "ALETITMMXXX");                          // Filter by BIC
//        filters.put("isin", "DE000ST8MPP0");                        // Filter by ISIN
        filters.put("entity.legalAddress.country", "GB");           // Filter by country
//        filters.put("registration.status", "ACTIVE");               // Filter by registration status

        HttpURLConnection connection = null;
        try {
            // Build the URL with filters
            URL url = buildFilteredUrl(BASE_URL, filters);
            System.out.println("URL: " + url);

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/vnd.api+json");
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                System.out.println("Success");
                JsonNode jsonNode = new ObjectMapper().readTree(connection.getInputStream());

                for (int i = 0; i < jsonNode.get("data").size(); i++) {
                    System.out.println("LEI Name : " + jsonNode.get("data").at("/" + i + "/attributes/entity/legalName").toPrettyString());
                }

            } else {
                System.out.println("Failed to fetch LEI data. Status Code: " + responseCode);
            }
            System.out.println("Done");
        } catch (Exception e) {
            System.out.println("Error fetching LEI data: " + e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    // Method to build URL with dynamic filters
    public static URL buildFilteredUrl(String baseUrl, Map<String, String> filters) throws Exception {
        StringBuilder urlBuilder = new StringBuilder(baseUrl);

        if (!filters.isEmpty()) {
            urlBuilder.append("?");
            for (Map.Entry<String, String> filter : filters.entrySet()) {
                String key = filter.getKey();
                String value = filter.getValue();

                // Append each filter in the format "filter[key]=value"
                urlBuilder.append("filter[").append(key).append("]=").append(value).append("&");
            }

            // Remove the trailing "&" at the end
            urlBuilder.setLength(urlBuilder.length() - 1);
        }

        return new URL(urlBuilder.toString());
    }
}
