import br.victor.desafio.cep.excecao.InvalidCepException;
import br.victor.desafio.cep.modelos.Endereco;
import br.victor.desafio.cep.modelos.EnderecoViaCep;
import br.victor.desafio.cep.modelos.ValidadorCep;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        String busca = "";
        System.out.println("Insira o CEP a ser pesquisado: ");
        busca = leitura.nextLine();
        System.out.println("Insira o número:");
        String numero = leitura.nextLine();
        System.out.println("Insira o complemento: ");
        String complemento = leitura.nextLine();
        List<Endereco> endereco = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String url = "https://viacep.com.br/ws/" + busca + "/json/";

        try {

            ValidadorCep.validarCep(busca);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            EnderecoViaCep meuEnderecoViaCep = gson.fromJson(json, EnderecoViaCep.class);
            Endereco meuEndereco = new Endereco(meuEnderecoViaCep);
            meuEndereco.setNumero(numero);
            meuEndereco.setComplemento(complemento);
            endereco.add(meuEndereco);
            FileWriter escrita = new FileWriter("endereco.json");
            escrita.write(gson.toJson(endereco));
            escrita.close();

        } catch (InvalidCepException e) {
            System.out.println("Cep Inválido" + e.getMessage());
        } finally {
            System.out.println("Programa finalizado! Visualize o Json");
        }
    }

}


