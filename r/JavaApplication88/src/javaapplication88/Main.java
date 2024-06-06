import java.util.*;
import java.util.stream.Collectors;

class Alumno {
    private int codigo;
    private String nombre;
    private String apellido;
    private String genero;
    private int semestre;

    public Alumno(int codigo, String nombre, String apellido, String genero, int semestre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.semestre = semestre;
    }

    public String getGenero() {
        return genero;
    }

    public int getSemestre() {
        return semestre;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", genero='" + genero + '\'' +
                ", semestre=" + semestre +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear una lista de alumnos
        List<Alumno> alumnos = Arrays.asList(
                new Alumno(1, "John", "Doe", "M", 3),
                new Alumno(2, "Alice", "Smith", "F", 2),
                new Alumno(3, "Bob", "Johnson", "M", 3),
                new Alumno(4, "Emily", "Jones", "F", 2),
                new Alumno(5, "Michael", "Williams", "M", 4)
        );

        // Agrupar la colección de alumnos por género y semestre
        Map<String, Map<Integer, List<Alumno>>> grupos = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getGenero,
                        Collectors.groupingBy(Alumno::getSemestre)));

        // Imprimir los grupos
        grupos.forEach((genero, subgrupos) -> {
            System.out.println("Género: " + genero);
            subgrupos.forEach((semestre, listaAlumnos) -> {
                System.out.println("\tSemestre: " + semestre);
                listaAlumnos.forEach(System.out::println);
            });
        });
    }
}
