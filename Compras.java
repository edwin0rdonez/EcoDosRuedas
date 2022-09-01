import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Compras {
    public static void ingresarCompras() throws SQLException {
        String sqlCom = "INSERT INTO compras VALUES (?,?,?,?)";
        PreparedStatement senCom = Principal.Conectar().prepareStatement(sqlCom);

        System.out.print("ID: ");
        int Id = Principal.sc.nextInt();
        senCom.setInt(1, Id);
        Principal.sc.nextLine();

        System.out.print("Alias: ");
        String alias = Principal.sc.nextLine();
        senCom.setString(2, alias);

        System.out.print("Nombre Fabricante: ");
        String fabricante = Principal.sc.nextLine();
        senCom.setString(3, fabricante);

        System.out.print("Fecha: ");
        String fecha = Principal.sc.nextLine();
        senCom.setString(4, fecha);

        int filasIns = senCom.executeUpdate();
        if (filasIns > 0){
            System.out.println("¡ Inserción Exitosa !");
            System.out.println("*----------------------------*");
        }
    }