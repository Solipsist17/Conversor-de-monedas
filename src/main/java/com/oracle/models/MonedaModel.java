package com.oracle.models;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MonedaModel {

    private final String[] currency = {"PEN", "USD", "EUR", "GBP", "JPY", "KRW"};

    private final Map<Integer, String> currencyMap;

    public MonedaModel() {
        this.currencyMap = new HashMap<>();

        // permutamos el array
        for (int i = 0; i < this.currency.length - 1; i++) {
            this.currencyMap.put(i, currency[0] + "/" + currency[i + 1]);
            this.currencyMap.put(((this.currency.length - 1) * 2) - ( i + 1), currency[(this.currency.length - 1) - i] + "/" + currency[0]);
        }

        this.currencyMap.forEach((clave, valor) -> {
            System.out.println("clave: " + clave + ", valor: " + valor);
        });
    }

    public double convertir(double valor, int selectedIndex) throws RuntimeException, IOException {
        String c = this.currencyMap.get(selectedIndex);
        String[] valores = c.split("/");
        String inCurrency = valores[0];
        String outCurrency = valores[1];

        double exchangeRate = httpRequest(inCurrency, outCurrency);

        return valor * exchangeRate;
    }

    private double httpRequest(String inCurrency, String outCurrency) throws RuntimeException, IOException{
        // connect to endpoint
        URL url = new URL("https://v6.exchangerate-api.com/v6/d4f3538e42f6744bb585fff7/latest/" + inCurrency);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        // validate with 200 status code
        int responseCode = conn.getResponseCode();

        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("ocurrió un error " + responseCode);
        } else {
            // read data
            StringBuilder dataString = new StringBuilder();
            Scanner scanner = new Scanner(conn.getInputStream());
            while (scanner.hasNext()) {
                dataString.append(scanner.nextLine());
            }
            scanner.close();

            // use library org.json
            JSONObject jsonObject = new JSONObject(dataString.toString());
            double exchangeRate = jsonObject.getJSONObject("conversion_rates").getDouble(outCurrency);
            System.out.println("De " + inCurrency + " a " + outCurrency + ": " + exchangeRate);

            return exchangeRate;
        }

    }

}
