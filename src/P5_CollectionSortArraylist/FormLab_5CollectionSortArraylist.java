package P5_CollectionSortArraylist;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FormLab_5CollectionSortArraylist {
    private JPanel formulario1;
    private JTextField txtRuta;
    private JButton ordenarButton;
    private JButton examinarButton;

    public FormLab_5CollectionSortArraylist() {

        examinarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                javax.swing.JFileChooser j = new javax.swing.JFileChooser();
                j.showOpenDialog(j);
                txtRuta.setText(j.getSelectedFile().getAbsolutePath());
            }
        });

        ordenarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path, line;
                int arreglo[] = new int[0], aux;

                path = txtRuta.getText();
                Ordenar_CollectionsortArraylist objCSV = new Ordenar_CollectionsortArraylist();
                BufferedReader br;
                ArrayList<Integer> secuencia = new ArrayList<>();
                ArrayList<String> ordenado=new ArrayList<>();

                try {
                    br = new BufferedReader(new FileReader(path));

                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                        String[] cadena = line.split(";");
                        int longitud = cadena.length;
                        arreglo = new int[longitud];

                        for (int i = 0; i < longitud; i++) {
                            secuencia.add(Integer.parseInt(cadena[i]));
                        }

                        Collections.sort(secuencia);

                        for (int i = 0; i < longitud; i++) {
                            ordenado.add(String.valueOf(secuencia.get(i)));
                        }

                        System.out.println(secuencia);

                        objCSV.leer(ordenado);
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("FormLab_4CollectionSortArraylist");
        frame.setContentPane(new FormLab_5CollectionSortArraylist().formulario1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
