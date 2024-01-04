import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitor = new Scanner(System.in);
        System.out.printf("Digite a primmeira palavra do prato que você quer ver a receita(em inglês): ");
        var nome = leitor.nextLine();
        nome = nome.replaceAll(" ","");
        String pesquisa = "https://www.themealdb.com/api/json/v1/1/search.php?s="+nome;
        System.out.println(pesquisa);



        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(URI.create(pesquisa))
                .build();
        HttpResponse<String> resposta = cliente
                .send(requisicao, HttpResponse.BodyHandlers.ofString());

        System.out.println(resposta.body());
    }
}