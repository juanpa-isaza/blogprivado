package itm.grupoz.blogprivado.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conector {

    Connection con;

    public Connection obtenerConector() {
        try {
            //"jdbc:sqlserver://localhost:1433;databaseName=TuBaseDeDatos;user=TuUsuario;password=TuContraseña";
            //Connection connection = DriverManager.getConnection(url)
            //jdbc:oracle:thin:@//localhost:1521/xe
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebablog", "Juan", "zettuu");
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            ex.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {
        Conector conection = new Conector();
        try {
            ResultSet r = conection.obtenerConector().prepareStatement("select * from usuarios").executeQuery();
            if (r.next()) {
                System.out.println("id: " + r.getString(1) + " nombre: " + r.getString(3));
                while (r.next()) {
                    System.out.println("nombres: " + r.getString("nombres"));
                }
            } else {
                System.out.println("NO HAY DATOS");
            }
        } catch (Exception e) {
            System.out.println("#Excepcion: "+e.getMessage());
        }
    }
}