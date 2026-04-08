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

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/titulo")
    public EstructuraBlog getTitulo() {return new EstructuraBlog();}

    @PostMapping("/publicar")
    public ResponseEntity<String> publicar(@RequestBody EstructuraBlog estructuraBlog) {
        System.out.println("datos recibidos: \n" +
                "\n autor: " + estructuraBlog.getAutor() +
                "\n titulo: " + estructuraBlog.getTitulo() +
                "\n cuerpo: " + estructuraBlog.getCuerpo() +
                "\n fecha de publicación: " + estructuraBlog.getFecha());
        return new ResponseEntity<>("se publica el blog " + estructuraBlog.getTitulo(), HttpStatus.CREATED);
    }

}

