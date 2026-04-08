package itm.grupoz.blogprivado.SQL_ids;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private int idUsuario;
    private int cedula;
    private String nombres;
    private String apellidos;
    private String email;
    private Date fechaIngreso;
}
