import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculadora extends Remote {
    double sumar(double num1, double num2) throws RemoteException;
    double restar(double num1, double num2) throws RemoteException;
    double multiplicar(double num1, double num2) throws RemoteException;
    double dividir(double num1, double num2) throws RemoteException;
}