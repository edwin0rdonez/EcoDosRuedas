import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Motocicletas {
    public static void ingresarMotocicletas() throws SQLException {
        String sqlMot= "INSERT INTO bicicletas VALUES (?,?,?,?)";
        PreparedStatement senMot = Principal.Conectar().prepareStatement(sqlMot);
        System.out.print("ID: ");
        int Id = Principal.sc.nextInt();
        senMot.setInt(1, Id);
        Principal.sc.nextLine();

        System.out.print("Fabricante: ");
        String nombre= Principal.sc.nextLine();
        senMot.setString(2, nombre);

        System.out.print("Precio: ");
        int precio = Principal.sc.nextInt();
        senMot.setInt(3, precio);
        Principal.sc.nextLine();

        System.out.print("Autonomia: ");
        int autonomia = Principal.sc.nextInt();
        senMot.setInt(4, autonomia);
        Principal.sc.nextLine();

        System.out.print("Proveedor del motor: ");
        String proveedor = Principal.sc.nextLine();
        senMot.setString(5, proveedor);


        int filasIns = senMot.executeUpdate();
        if (filasIns > 0){
            System.out.println("¡ Inserción Exitosa !");
            System.out.println("*----------------------------*");
        }
    }




}
