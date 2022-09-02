package P5_Arraylist;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FormLab_5ArrayList {
    private JButton ordenarButton;
    private JPanel formulario1;
    private JTextField txtRuta;
    private JButton examinarButton;

    public FormLab_5ArrayList(){
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
                String path,line;
                int arreglo[] = new int[0], aux;

                path=txtRuta.getText();
                Ordenar_Arraylist objCSV = new Ordenar_Arraylist();
                BufferedReader br;
                ArrayList<String> secuencia = new ArrayList<>();

                try {
                    br = new BufferedReader(new FileReader(path));

                    while ((line = br.readLine())!=null) {
                        System.out.println(line);
                        String[] cadena=line.split(";");
                        int longitud = cadena.length;
                        arreglo = new int[longitud];

                        for (int i=0;i<longitud;i++){
                            arreglo[i]=Integer.parseInt(cadena[i]);
                        }

                        for (int i=0;i<(longitud-1);i++){
                            for (int j=0;j<(longitud-1);j++){
                                if (arreglo[j]>arreglo[j+1]){
                                    aux= arreglo[j];
                                    arreglo[j] = arreglo[j+1];
                                    arreglo[j+1]=aux;
                                }
                            }
                        }

                        for (int i=0;i<longitud;i++){
                            secuencia.add(String.valueOf(arreglo[i]));
                        }
                        System.out.println(secuencia);
                        objCSV.leer(secuencia);
                    }
                } catch (IOException ex){
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FormLab_4");
        frame.setContentPane(new FormLab_5ArrayList().formulario1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
