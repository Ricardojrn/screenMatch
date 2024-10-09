package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.exceptions.MinhaException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] Args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        Scanner input = new Scanner(System.in);
        System.out.println("Digite o titulo do filme: ");
        String filme = input.next();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.omdbapi.com/?t="+filme+"&apikey=8765aace"))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        //System.out.println(json);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        //Titulo meuTitulo = gson.fromJson(json, Titulo.class);
        TituloOMDB meuTituloOMDB = gson.fromJson(json, TituloOMDB.class);
        //System.out.println(meuTituloOMDB);
        try{
            Titulo meuTitulo = new Titulo(meuTituloOMDB);
            System.out.println(meuTitulo);
        }catch (NumberFormatException e){
            System.out.println("ERRO: "+e.getMessage());
        }catch (MinhaException e){
            System.out.println(e.getMessage());
        }

    }
}
