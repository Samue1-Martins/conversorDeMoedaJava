import br.com.alura.converterChallenge.apiRequest.ApiConverterCoin;
import br.com.alura.converterChallenge.apiRequest.ApiRequest;
import br.com.alura.converterChallenge.models.Converter;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner reader = new Scanner(System.in);
        ApiRequest apiRequest = new ApiRequest();
        List<Converter> converterList = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        String main = """
                ******************************************************
                Escolha uma opção para conversão:

                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real Brasileiro
                4) Real Brasileiro =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Sair
                
                Escolha uma opção válida:
                ******************************************************
                """;

        int value = 0;

        while (value != 7){

            System.out.println(main);

            value = reader.nextInt();
            String coin = "";
            Double amount = 0.0;
            String messageAmout = "Digite o valor da quantia que deseja converter: ";

            switch (value){
                case 1:
                    coin = "USD/ARS";
                    break;
                case 2 :
                    coin = "ARS/USD";
                    break;
                case 3:
                    coin = "USD/BRL";
                    break;
                case 4:
                    coin = "BRL/USD";
                    break;
                case 5:
                    coin = "COP/USD";
                    break;
                case 6:
                    coin = "USD/COP";
                    break;
                case 7:
                    value = 7;
                    System.out.println("Finalizando a aplicação.");
                    break;
            }

            System.out.println(messageAmout);
            amount = reader.nextDouble();

            try {
                ApiConverterCoin newApiConverterCoin = apiRequest.searchCoin(coin, amount);
                Converter converter = new Converter(newApiConverterCoin);
                converterList.add(converter);
                System.out.println("Conversão de R$ " + amount + " "+ coin);
                System.out.println(converter);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando a aplicação");
            }
            FileWriter writeJson = new FileWriter("apiResquestList.json");
            writeJson.write(gson.toJson(converterList));
            writeJson.close();
        }
    }
}