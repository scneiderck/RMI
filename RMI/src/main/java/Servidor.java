import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            // Crear y exportar el registro RMI en el puerto 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Crear una instancia del objeto remoto
            HelloImpl obj = new HelloImpl();

            // Vincular el stub del objeto remoto en el registro
            registry.rebind("Hello", obj);

            System.out.println("El servidor está listo...");
        } catch (Exception e) {
            System.err.println("Excepción en el servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}