import java.io.*;

class LeerFichero{
    public static void main(String[] args){
        File f = new File(".");
        String[] listDir = f.list();

        for (int i = 0; i < listDir.length; i++){
            File f2 = new File (listDir[i]);
            System.out.println("Información del archivo: " + f2.getName());
            System.out.println("Ruta: " + f2.getPath());
            System.out.println("Ruta absoluta: " + f2.getAbsolutePath());
            System.out.println("Tamaño: " + f2.length());
            System.out.println("Es un directorio: " + f2.isDirectory());
            System.out.println("Es un archivo: " + f2.isFile());
            System.out.println("Se puede leer: " + f2.canRead());
        }        
    }

}