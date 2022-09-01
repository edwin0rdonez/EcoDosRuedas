import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultas {
    public static void crearTablas(){
        try{
            String[] sqls = {
                    "CREATE TABLE proveedor(prov_id  int primary key, prov_nombre  char(20),prov_direccion char(45),prov_telefono  char(20))",
                    "CREATE TABLE clientes(alias char(20) primary key,nombre char(20),apellidos char(20),email varchar(45),celular char(20),contraseña int,f_nacimiento date)",
                    "CREATE TABLE  fabricantes(fabricante char(20) primary key)",
                    "CREATE TABLE bicicletas(id int primary key,fabricante char (20),precio int,año int,foreign key (fabricante) references fabricantes (fabricante))",
                    "CREATE TABLE motocicletas (id int primary key,fabricante char (20)precio int,autonomia int,id_prov int,foreign key (fabricante) references fabricantes (fabricante),foreign key (id_prov) references proveedor (prov_id))",
                    "CREATE TABLE compras(id int primary key,alias char(20),fabricante char(20),fecha_hora timestamp,foreign key (alias) references clientes (alias),foreign key (fabricante) references fabricantes (fabricante))"
            };
            for (String i:sqls){
                PreparedStatement sentencia = Principal.Conectar().prepareStatement(i);
                sentencia.executeUpdate();
            }
        }catch(Exception e){

            System.out.println("Tablas  ya Creadas");
        }
    }
    public static void modificarYear() throws SQLException{
        String sql = "UPDATE bicicletaas SET año=? where fabricante=?";
        PreparedStatement sentencia = Principal.Conectar().prepareStatement(sql);
        System.out.println("Por favor ingrese fabricante de la bicicleta y el año a modificar. ");
        System.out.print("Fabricante: ");
        String nombre = Principal.sc.nextLine();
        sentencia.setString(2,nombre);

        System.out.print("Año: ");
        int year = Principal.sc.nextInt();
        sentencia.setInt(1, year);
        Principal.sc.nextLine();

        int filasIns = sentencia.executeUpdate();
        if(filasIns > 0){
            System.out.println("¡ Año Cambiado Correctamente !");
        }
    }
    public static void ModificarTelCliente() throws SQLException {
        String sql = "UPDATE clientes SET celular=? where alias=?";
        PreparedStatement sentencia = Principal.Conectar().prepareStatement(sql);
        System.out.println("Por favor ingrese Alias del Cliente y el nuevo número de celular. ");

        System.out.print("Alias ");
        String alias = Principal.sc.nextLine();
        sentencia.setString(2,alias);

        System.out.print("Celular: ");
        int celular = Principal.sc.nextInt();
        sentencia.setInt(1, celular);

        int filasIns = sentencia.executeUpdate();
        if(filasIns > 0){
            System.out.println("¡ Número de celular Cambiado Correctamente !");


        }
    }
    public static void borrarCompra() throws SQLException {
        String sql = "DELETE FROM compra WHERE alias=? AND fabricante=?";
        PreparedStatement sentencia = Principal.Conectar().prepareStatement(sql);
        System.out.println("Por favor ingrese Alias del Cliente y Fabricante de la intención de compra. ");
        System.out.print("Alias ");
        String alias = Principal.sc.nextLine();
        sentencia.setString(2,alias);

        System.out.print("Fabricante: ");
        String fabricante = Principal.sc.nextLine();
        sentencia.setString(2,fabricante);

        int filasIns = sentencia.executeUpdate();
        if(filasIns > 0){
            System.out.println("¡ Intención de compra ELIMINADA Correctamente !");


        }

    }
    public static void consultaFabricantes() throws SQLException {
        String sql = "SELECT fabricante FROM fabricantes ORDER BY fabricante ";
        Statement sentencia = Principal.Conectar().createStatement();
        ResultSet consulta = sentencia.executeQuery(sql);
        while(consulta.next()){
            String col1 = consulta.getNString(1);
            System.out.println(col1);
        }

    }
    public static void consultaInfoBici() throws SQLException {
        String sql = "SELECT fabricante,precio,año FROM bicicletas WHERE año >= 2019 ORDER BY fabricante";
        Statement sentencia = Principal.Conectar().createStatement();
        ResultSet consulta = sentencia.executeQuery(sql);
        while(consulta.next()){
            String col1 = consulta.getString(1);
            int col2 = consulta.getInt(2);
            String col3 = consulta.getString(3);
            System.out.println(col1 + " " + col2 + " " + col3);

        }
    }
    public static void consutaFabriMoto() throws SQLException {
        String sql = "SELECT fabricante FROM motocicletas WHERE id_prov=101";
        Statement sentencia = Principal.Conectar().createStatement();
        ResultSet consulta = sentencia.executeQuery(sql);
        while(consulta.next()){
            String col1 = consulta.getString(1);
            System.out.println(col1);
        }
    }

    public static void consultaCompBiMo() throws SQLException {
        String sql = "SELECT fabricante FROM compras WHERE alias=\"lucky\" ORDER BY fabricante";
        Statement sentencia = Principal.Conectar().createStatement();
        ResultSet consulta = sentencia.executeQuery(sql);
        while(consulta.next()){
            String col1 = consulta.getString(1);
            System.out.println(col1);
        }
    }
    public static void consultaComBiCli() throws SQLException {
        String sql = "SELECT c.alias, c.nombre, c.apellidos FROM clientes c, compras p WHERE p.alias=c.alias and p.fabricante=\"Yeti\" ORDER BY nombre";
        Statement sentencia = Principal.Conectar().createStatement();
        ResultSet consulta = sentencia.executeQuery(sql);
        while(consulta.next()){
            String col1 = consulta.getString(1);
            String col2 = consulta.getString(2);
            String col3 = consulta.getString(3);
            System.out.println(col1 + " " + col2 + " " + col3);
        }
    }
    public static void consultaBiciFab() throws SQLException {
        String sql = "SELECT count(fabricante) FROM bicicletas WHERE año >= 2019";
        Statement sentencia = Principal.Conectar().createStatement();
        ResultSet consulta = sentencia.executeQuery(sql);
        while(consulta.next()){
            int col1 = consulta.getInt(1);
            System.out.println(col1);
        }
    }
}
