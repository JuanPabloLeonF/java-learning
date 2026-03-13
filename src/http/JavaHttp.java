package http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JavaHttp {

    private static final String URL_BASE_API = "https://jsonplaceholder.typicode.com/posts/";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String ACCEPT = "application/json";
    private static final String STATUS_CODE = "status code: ";
    private static final String BODY = "body: ";
    private static final String HEADERS = "headers: ";

    public static void getAll() {
        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL_BASE_API))
                    .GET()
                    .header(CONTENT_TYPE, ACCEPT)
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(STATUS_CODE + response.statusCode());
            System.out.println(BODY + response.body());
            System.out.println(HEADERS + response.headers().toString());


        } catch (IOException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void getById(String id) {
        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL_BASE_API + id))
                    .GET()
                    .header(CONTENT_TYPE, ACCEPT)
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(STATUS_CODE + response.statusCode());
            System.out.println(BODY + response.body());
            System.out.println(HEADERS + response.headers().toString());

        } catch (IOException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void create(DataRequest dataRequest) {
        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL_BASE_API))
                    .POST(HttpRequest.BodyPublishers.ofString(dataRequest.toString()))
                    .header(CONTENT_TYPE, ACCEPT)
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(STATUS_CODE + response.statusCode());
            System.out.println(BODY + response.body());
            System.out.println(HEADERS + response.headers().toString());

        } catch (IOException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void deleteById(String id) {
        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL_BASE_API + id))
                    .DELETE()
                    .header(CONTENT_TYPE, ACCEPT)
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(STATUS_CODE + response.statusCode());
            System.out.println(BODY + response.body());
            System.out.println(HEADERS + response.headers().toString());

        } catch (IOException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void updateByID(String id, DataRequest dataRequest) {
        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL_BASE_API + id))
                    .PUT(HttpRequest.BodyPublishers.ofString(dataRequest.toString()))
                    .header(CONTENT_TYPE, ACCEPT)
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(STATUS_CODE + response.statusCode());
            System.out.println(BODY + response.body());
            System.out.println(HEADERS + response.headers().toString());

        } catch (IOException | InterruptedException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
