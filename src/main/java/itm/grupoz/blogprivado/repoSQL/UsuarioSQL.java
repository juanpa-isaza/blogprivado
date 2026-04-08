package itm.grupoz.blogprivado.repoSQL;
import itm.grupoz.blogprivado.SQL_ids.Usuario;
import itm.grupoz.blogprivado.utilities.Conector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioSQL {

    @Autowired
    private UsuarioHelper usuarioHelper;

    //DAO: data access object
    public List<Usuario> getUsuarios() {
        List<Usuario> result = new ArrayList<>();
        Conector conexion = new Conector();
        Connection connection = conexion.obtenerConector();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(usuarioHelper.listarUsuarios());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Usuario user = new Usuario();
                user.setIdUsuario(resultSet.getInt("idUsuario"));
                user.setCedula(resultSet.getInt("cedula"));
                user.setNombres(resultSet.getString("nombres"));
                user.setApellidos(resultSet.getString("apellidos"));
                user.setEmail(resultSet.getString("email"));
                user.setFechaIngreso(resultSet.getDate("fechaIngreso"));
                result.add(user);
            }

        }catch (SQLException exception){
            exception.printStackTrace();
        }finally{
            try{
                connection.close();
                preparedStatement.close();
            }catch (SQLException exc){
                exc.printStackTrace();
            }catch (Exception ladenull){

            }
        }

        return result;
    }

}
