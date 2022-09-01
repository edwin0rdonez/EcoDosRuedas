import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Proveedor {
    public static void ingresarProveedor() throws SQLException {
        String sqlProv = "INSERT INTO proveedor VALUES (?,?,?,?)";
        PreparedStatement senProv = Principal.Conectar().prepareStatement(sqlProv);

        System.out.print("ID: ");
        int Id = Principal.sc.nextInt();
        senProv.setInt(1, Id);
        Principal.sc.nextLine();

        System.out.print("Nombre Proveedor: ");
        String nombre= Principal.sc.nextLine();
        senProv.setString(2, nombre);

        System.out.print("Dirección: ");
        String direccion = Principal.sc.nextLine();
        senProv.setString(3, direccion);


        System.out.print("Teléfono: ");
        String telefono =  Principal.sc.nextLine();
        senProv.setString(4, telefono);


        int filasIns = senProv.executeUpdate();
        if (filasIns > 0){
            System.out.println("¡ Inserción Exitosa !");
            System.out.println("*----------------------------*");
        }
    }
}
