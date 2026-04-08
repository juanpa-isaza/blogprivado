package itm.grupoz.blogprivado.repoSQL;
import org.springframework.stereotype.Service;

@Service
public class UsuarioHelper {
    public String listarUsuarios(){
        return " Select idUsuario, cedula, nombres, apellidos, email, fechaIngreso from usuario";
    }
}
