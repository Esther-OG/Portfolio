import java.io.BufferedWriter;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class FicheroEmpleados_EstherOrtiz {
    public static void main(String[] args) {
        File fichero = new File("C:/AD/Ejercicios/nuevoDirectorio/Empleados.txt");

        String[] empleados = {
                "Ana López",
                "Juan Pérez",
                "Marta García",
                "Luis Fernández",
                "Sofía Martínez",
                "Carlos Ruiz",
                "Elena Torres",
                "Pablo Gómez",
                "Laura Díaz",
                "Jorge Ramos"
        };

        try (FileWriter fw = new FileWriter(fichero);
                BufferedWriter bw = new BufferedWriter(fw)) {
            int id = 1;

            for (String empleado : empleados) {
                bw.write(id + ".- " + empleado);
                id = id + 1;
                bw.newLine();
            }

            System.out.println("Archivo " + fichero.getName() + "' creado correctamente.\n");

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }

        System.out.println("Contenido del archivo '" + fichero.getName() + "':\n");

        try (FileReader fr = new FileReader(fichero);
                BufferedReader br = new BufferedReader(fr)) {

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
