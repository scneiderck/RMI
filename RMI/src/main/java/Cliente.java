import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
        try {
            // Obtener una referencia al registro RMI remoto
            Registry registry = LocateRegistry.getRegistry("localhost");

            // Buscar el objeto remoto en el registro
            Hello stub = (Hello) registry.lookup("Hello");

            // Invocar el método remoto e imprimir el resultado
            System.out.println("Mensaje del servidor: " + stub.decirHola());
        } catch (Exception e) {
            System.err.println("Excepción en el cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}