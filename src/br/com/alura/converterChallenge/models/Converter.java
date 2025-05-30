package br.com.alura.converterChallenge.models;

import br.com.alura.converterChallenge.apiRequest.ApiConverterCoin;

public class Converter {

    String result;
    String baseCode;
    String targetCode;
    String conversionResult;
    String conversionRate;

    public Converter(String result, String baseCode, String targetCode, String conversionRate, String conversionResult) {
        this.result = result;
        this.baseCode = baseCode;
        this.targetCode = targetCode;
        this.conversionRate = conversionRate;
        this.conversionResult = conversionResult;
    }

    public Converter (ApiConverterCoin apiConverterCoin ){
        this.result = apiConverterCoin.result();
        this.baseCode = apiConverterCoin.base_code();
        this.targetCode = apiConverterCoin.target_code();
        this.conversionRate = apiConverterCoin.conversion_rate();
        this.conversionResult = apiConverterCoin.conversion_result();
    }

    @Override
    public String toString() {
        return  "\n"+
                "   Resultado da requisição = [" + result + "] \n" +
                "   Valor da moeda = R$ "+ conversionRate + "[" + baseCode + "]\n" +
                "   Corresponde ao valor final de =>>> R$ "
                + conversionResult + "[" + targetCode + "]" +
                "\n";
    }
}
