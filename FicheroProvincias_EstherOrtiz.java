import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

public class FicheroProvincias_EstherOrtiz {

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        File nuevoDirectorio = new File("C:/AD/Ejercicios/nuevoDirectorio");
        File miFichero = new File("C:/AD/Ejercicios/nuevoDirectorio/fichero_de_texto2.txt");
        File miFicheroantiguo = new File("C:/AD/Ejercicios/nuevoDirectorio/fichero_de_texto.txt");
        int opcion = 0;
        String[] provincias = {
                "Almería", "Cádiz", "Córdoba", "Granada",
                "Huelva", "Jaén", "Málaga", "Sevilla"
        };

        do {
            System.out.println("Seleccione una opción a realizar:");
            System.out.println("1.- Crear directorio nuevoDirectorio.");
            System.out.println("2.- Crear el fichero fichero_de_texto2.");
            System.out.println("3.- Eliminar el fichero fichero_de_texto.");
            System.out.println("4.- Eliminar el directorio nuevoDirectorio.");
            System.out.println("5.- Añadir al fichero de texto las provincias de Andalucía.");
            System.out.println("6.- Salir.");
            opcion = scan.nextInt();
            System.out.println("Has seleccionado la opcion: " + opcion);
            switch (opcion) {
                case 1:
                    if (nuevoDirectorio.exists()) {
                        System.out.println("El directorio ya existe" + nuevoDirectorio.getAbsolutePath());
                    } else if (nuevoDirectorio.mkdirs()) {
                        System.out.println("Directorio creado: " + nuevoDirectorio.getAbsolutePath());
                    } else {
                        System.out.println("Error: no se ha podido crear el directorio.");
                    }
                    break;

                case 2:
                    if (!nuevoDirectorio.exists()) {
                        System.out.println("Error: no existe el directorio");
                        break;
                    }
                    try {
                        if (miFichero.createNewFile()) {
                            System.out.println("Fichero creado correctamente en: " + miFichero.getAbsolutePath());
                        } else {
                            System.out.println("Error: no se ha podido crear el fichero");
                        }
                    } catch (IOException e) {
                        System.out.println("Error al crear el fichero: " + e.getMessage());
                    }
                    break;
                case 3:

                    if (!miFicheroantiguo.exists()) {
                        System.out.println("No existe el fichero.");
                    } else if (miFicheroantiguo.delete()) {
                        System.out.println("Fichero eliminado correctamente.");
                    } else {
                        System.out.println("Error: no se puede eliminar el fichero.");
                    }
                    break;
                case 4:
                    if (!nuevoDirectorio.exists()) {
                        System.out.println("No existe el directorio.");
                    } else {
                        File [] archivos = nuevoDirectorio.listFiles();
                        for (File archivo : archivos) {
                            archivo.delete();
                        }
                        nuevoDirectorio.delete();
                        System.out.println("Directorio y archivos contenidos (si hubiera) eliminados correctamente.");
                    }
                    break;
                case 5:
                    if (!miFichero.exists()) {
                        System.out.println("El fichero no existe, primero debe crearlo.");
                    } else {
                        try (FileWriter fw = new FileWriter(miFichero)) {
                            for (String provincia : provincias) {
                                fw.write(provincia + "\n");
                                System.out.println(provincia);
                            }
                            fw.close();
                            System.out.println("Provincias añadidas correctamente (FileWriter).");
                        } catch (IOException e) {
                            System.out.println("ERROR: " + e.getMessage());
                        }
                    }
                case 6:
                    System.out.println("Has seleccionado Salir, hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        } while (opcion != 6);
        scan.close();
    }
}