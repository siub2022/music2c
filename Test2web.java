import com.sun.net.httpserver.*;
import java.io.IOException;
import java.net.InetSocketAddress;

public class Test2web {  // Class name remains the same
    public static void main(String[] args) throws IOException {
        // Use Render's PORT or default to 8080
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));
        
        // Create HTTP server
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        
        // Handle root requests
        server.createContext("/", exchange -> {
            String response = "Test2web HTTP server is running!";
            exchange.sendResponseHeaders(200, response.length());
            exchange.getResponseBody().write(response.getBytes());
            exchange.close();
        });
        
        server.start();
        System.out.println("Server running on port " + port);
    }
}