package com.example.otes06.repository;

import com.example.otes06.models.User;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UserRepository {
    public String getUsers() throws Exception {
        try {
            // Cria a URL da requisição
            URL url = new URL("http://localhost:8080/user");

            // Abre a conexão
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Define o método da requisição
            connection.setRequestMethod("GET");

            // Obtém a resposta
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_BAD_REQUEST
                    || responseCode != HttpURLConnection.HTTP_INTERNAL_ERROR) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                connection.disconnect();
                // Processa a resposta
                return response.toString();
            } else {
                System.out.println("Erro na requisição. Código de resposta: " + responseCode);
                connection.disconnect();
                return "deu ruim";
            }

            // Fecha a conexão

        } catch (Exception e) {
            e.printStackTrace();
            return "deu ruim";
        }

    }

    public void saveUser(User user) {
        try {
            // URL da API ou endpoint para salvar o objeto
            URL url = new URL("http://localhost:8080/user");

            // Abrir conexão HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configurar a conexão para enviar uma requisição POST
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Criar o objeto a ser enviado como JSON
            String jsonInputString = "{\n" + //
                    "    \"name\": \"leo\",\n" + //
                    "    \"score\": 1\n" + //
                    "}";

            // Enviar o objeto como payload da requisição
            try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
                outputStream.writeBytes(jsonInputString);
                outputStream.flush();
            }

            // Verificar o código de resposta HTTP
            int responseCode = connection.getResponseCode();
            System.out.println("Código de resposta: " + responseCode);

            // Ler a resposta da requisição
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                System.out.println("Resposta do servidor: " + response.toString());
            }

            // Fechar a conexão
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getRanking() throws Exception {
        try {
            // Cria a URL da requisição
            URL url = new URL("http://localhost:8080/user/ranking");

            // Abre a conexão
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Define o método da requisição
            connection.setRequestMethod("GET");

            // Obtém a resposta
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_BAD_REQUEST
                    || responseCode != HttpURLConnection.HTTP_INTERNAL_ERROR) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                connection.disconnect();
                // Processa a resposta
                return response.toString();
            } else {
                System.out.println("Erro na requisição. Código de resposta: " + responseCode);
                connection.disconnect();
                return "deu ruim";
            }

            // Fecha a conexão

        } catch (Exception e) {
            e.printStackTrace();
            return "deu ruim";
        }

    }
}
