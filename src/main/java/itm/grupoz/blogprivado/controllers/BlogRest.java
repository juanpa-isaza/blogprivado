package itm.grupoz.blogprivado.controllers;
import itm.grupoz.blogprivado.EstructuraBlog;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class BlogRest {

    @GetMapping("/infoblog")
    public EstructuraBlog getBlog(EstructuraBlog eB, @RequestParam int idBlog) {
        return new EstructuraBlog(eB.getAutor(), eB.getTitulo(), eB.getCuerpo());
    }

    @Operation(
            tags = {"Blog"},
            summary = "post con RequestBody",
            description = "permite hacer un post con RequestBody",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "se ejecuta bien el servicio",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = EstructuraBlog.class))
                            })
            }
    )
    @PostMapping("/crearblog")
    public ResponseEntity<EstructuraBlog> crearBlog(@RequestBody EstructuraBlog eB, @RequestParam String autor, @RequestParam String titulo, @RequestParam String cuerpo, @RequestParam int idBlog) {
        System.out.println("datos recibidos: \n" +
                "\n autor: " + eB.getAutor() +
                "\n titulo: " + eB.getTitulo() +
                "\n cuerpo: " + eB.getCuerpo() +
                "\n fecha de publicación: " + eB.getFecha());
        return new ResponseEntity<>(eB, HttpStatus.CREATED);
    }
    
    @PutMapping("/actualizarblog")
    public ResponseEntity<EstructuraBlog> actualizarBlog(@RequestBody EstructuraBlog eB, @RequestParam String autor, @RequestParam String titulo, @RequestParam String cuerpo, @RequestParam int idBlog) {
        System.out.println("Blog actualizado: \n" +
                "\n autor: " + eB.getAutor() +
                "\n titulo: " + eB.getTitulo() +
                "\n cuerpo: " + eB.getCuerpo() +
                "\n fecha de publicación: " + eB.getFecha());
        return new ResponseEntity<>(eB, HttpStatus.OK);
    }
    
    @DeleteMapping("/borrarblog")
    public ResponseEntity<String> eliminarBlog(@RequestParam int idBlog) {
        return new ResponseEntity<>("ID del blog borrado: " + idBlog, HttpStatus.OK);
    }

}

