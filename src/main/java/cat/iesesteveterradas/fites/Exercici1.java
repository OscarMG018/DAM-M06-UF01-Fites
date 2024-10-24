package cat.iesesteveterradas.fites;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Implementa codi que compleixi el següent:
 * 
 * - Llegeix un fitxer de text d'entrada amb codificació UTF-8.
 * - Inverteix el text de cada línia utilitzant el mètode 'giraText'.
 * - Escriu les línies invertides en un fitxer de sortida amb codificació UTF-8.
 * - El fitxer de sortida es crea o sobrescriu si ja existeix.
 * - Si hi ha un error en llegir o escriure els fitxers, l'excepció es mostra a la consola.
 */
public class Exercici1 {

    private String filePathIn;
    private String filePathOut;


    public static void main(String args[]) {
        Exercici1 exercici = new Exercici1();
        // Configurar els fitxers d'entrada i sortida
        exercici.configuraRutaFitxerEntrada(System.getProperty("user.dir") + "/data/exercici1/Exercici1Entrada.txt");
        exercici.configuraRutaFitxerSortida(System.getProperty("user.dir") + "/data/exercici1/Exercici1Solucio.txt");
        // Executar la lògica principal
        exercici.executa();
    }    

    // Processa el fitxer d'entrada i genera el fitxer de sortida.
    public void executa() {
        //* - Llegeix un fitxer de text d'entrada amb codificació UTF-8.
        File inpuFile = new File(filePathIn);
        File outputFIle = new File(filePathOut);
        FileInputStream reader = null;
        BufferedReader br = null;
        FileWriter writer = null;
        BufferedWriter bw = null;
        try {
            reader = new FileInputStream(inpuFile);
            br = new BufferedReader(new InputStreamReader(new FileInputStream(inpuFile), "UTF-8"));
            writer = new FileWriter(outputFIle);
            bw = new BufferedWriter(writer);
            String line = "";
            boolean firtsLine = true;
            while ((line = br.readLine()) != null) {
                if (!firtsLine)
                    bw.write("\n");
                bw.write(giraText(line));
                bw.flush();
                firtsLine = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (reader != null)
                    reader.close();
                if (br != null)
                    br.close();
                if (writer != null)
                    writer.close();
                if (bw != null)
                    bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //* - El fitxer de sortida es crea o sobrescriu si ja existeix.
        
        //* - Inverteix el text de cada línia utilitzant el mètode 'giraText'.
        //* - Escriu les línies invertides en un fitxer de sortida amb codificació UTF-8.

        //* - Si hi ha un error en llegir o escriure els fitxers, l'excepció es mostra a la consola.*/

    }

    // Mètode per invertir el text d'una línia
    public static String giraText(String text) {
        StringBuilder reverser = new StringBuilder();
        reverser.append(text);
        reverser.reverse();
        return reverser.toString();
    }

    /****************************************************************************/
    /*                          NO CAL MODIFICAR                                */
    /****************************************************************************/
    // Mètode per configurar el fitxer d'entrada
    public void configuraRutaFitxerEntrada(String filePathIn) {
        this.filePathIn = filePathIn;
    }

    // Mètode per configurar el fitxer de sortida
    public void configuraRutaFitxerSortida(String filePathOut) {
        this.filePathOut = filePathOut;
    }
}
