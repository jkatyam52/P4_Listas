package P5_CollectionsortLinkedlist;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Ordenar_Collectionsort {
    public void leer(LinkedList<String> secuencia) throws IOException {
        try {
            imprimirtxt(secuencia);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en el metodo leer"+e);
        }
    }

    public File verificarRuta() throws IOException {
        File file = new File("C:/Laboratorio4/Lab4_CollectiosortLinkedlist.txt");
        File secuencia_n = new File(file.getParent());
        if (secuencia_n.isFile()){
            if (!file.exists()){
                file.createNewFile();
            }
        }else{
            secuencia_n.mkdir();
            file.createNewFile();
        }
        return file;
    }

    public void imprimirtxt(LinkedList<String> secuncia_C) throws IOException{
        try {
            File file = verificarRuta();
            FileWriter fw = new FileWriter(file);
            try(BufferedWriter bw = new BufferedWriter(fw)){
                for (int x=0;x<secuncia_C.size();x++){
                    bw.write(secuncia_C.get(x));
                    bw.write("; ");
                }
                JOptionPane.showMessageDialog(null,"El Registro ha sido ordenado y grabado en el archivo Problema3a_odernado.txt exitosamente");
            }
            fw.close();
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }
}
