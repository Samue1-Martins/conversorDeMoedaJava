package br.com.alura.converterChallenge.apiRequest;

public record ApiConverterCoin(String result,
                               String base_code,
                               String conversion_rate,
                               String conversion_result,
                               String target_code) {
}
