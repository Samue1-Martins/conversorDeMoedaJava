package br.com.alura.converterChallenge.apiRequest;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequest {

    public ApiConverterCoin searchCoin(String coin, Double amount) {

        URI url = URI.create("https://v6.exchangerate-api.com/v6/4d89f1e96845e690e2aafba7/pair/" + coin + "/" + amount);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        HttpResponse<String> response = null;
        try {
            response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não foi possivel concluir a solicitação." + e.getMessage());
        }
        return new Gson().fromJson(response.body(), ApiConverterCoin.class);
    }
}