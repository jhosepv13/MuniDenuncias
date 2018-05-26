package moviles.proyectos.munidenuncias.Models;

/**
 * Created by Alumno on 11/05/2018.
 */

public class Denuncia {

    private Integer id;
    private String titulo;
    private String contenido;
    private String usuarios_id;
    private String fecha;
    private String image;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getUsuarios_id() {
        return usuarios_id;
    }

    public void setUsuarios_id(String usuarios_id) {
        this.usuarios_id = usuarios_id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Denuncia{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", contenido='" + contenido + '\'' +
                ", usuarios_id='" + usuarios_id + '\'' +
                ", fecha='" + fecha + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}

