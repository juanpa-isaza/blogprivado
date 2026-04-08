package itm.grupoz.blogprivado;

import java.util.Date;

public class EstructuraBlog {
    private String autor;
    private String titulo;
    private String cuerpo;
    private Date fechaPublicacion;

    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getAutor() {
        return autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
    public String getCuerpo() {
        return cuerpo;
    }

    public void setFecha(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    public Date getFecha() {
        return fechaPublicacion;
    }

    public void Publicar() {
        System.out.println("Autor: " + autor);
        System.out.println("Título: " + titulo);
        System.out.println("Cuerpo: " + cuerpo);
        System.out.println("Fecha de Publicación: " + fechaPublicacion);
    }
}
