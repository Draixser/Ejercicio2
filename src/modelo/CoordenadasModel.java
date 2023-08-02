import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CoordenadasModel {
    private ArrayList<String> coordenadas;
    private BufferedWriter writer;

    public CoordenadasModel() {
        coordenadas = new ArrayList<>();
        try {
            writer = new BufferedWriter(new FileWriter("coordenadas.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarCoordenadas(int x, int y) {
        String coordenada = x + "," + y;
        coordenadas.add(coordenada);
    }

    public void guardarCoordenadasEnArchivo() {
        try {
            for (String coordenada : coordenadas) {
                writer.write(coordenada + "\n");
            }
            writer.close(); // Cerrar el BufferedWriter para asegurar que los datos se guarden correctamente
            coordenadas.clear(); // Limpiar la lista de coordenadas después de guardarlas en el archivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}