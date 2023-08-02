import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class CoordenadasView extends JFrame {
    private CoordenadasModel modelo;
    private JButton mostrarButton;
    private JButton guardarButton;
    private JPanel jPanel1;


   public CoordenadasView(CoordenadasModel modelo) {
        this.modelo = modelo;

        // Configurar la interfaz gráfica
        setSize(400, 400);
        setTitle("Capturar Coordenadas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
   
        jPanel1 = new JPanel();
        jPanel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                modelo.guardarCoordenadas(x, y); // Guardar las coordenadas en el modelo
                jPanel1.repaint(); // Volver a dibujar las coordenadas en la ventana
            }
        });
        
       
        getContentPane().add(jPanel1, BorderLayout.CENTER);

        guardarButton = new JButton("Guardar Coordenadas");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.guardarCoordenadasEnArchivo(); // Guardar las coordenadas en el archivo
                JOptionPane.showMessageDialog(jPanel1, "Coordenadas guardadas en el archivo 'coordenadas.txt'");
            }
        });
        
        mostrarButton = new JButton("Mostrar Coordenadas");
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCoordenadas(); // Llamar al método para mostrar las coordenadas del archivo
            }
        });
        
   
        
         getContentPane().add(mostrarButton, BorderLayout.NORTH);
        getContentPane().add(guardarButton, BorderLayout.SOUTH);
     
        
    }
   
     private void mostrarCoordenadas() {
        try (BufferedReader reader = new BufferedReader(new FileReader("coordenadas.txt"))) {
            StringBuilder coordenadasTexto = new StringBuilder();
            String linea;
            while ((linea = reader.readLine()) != null) {
                coordenadasTexto.append(linea).append("\n");
            }
            JOptionPane.showMessageDialog(jPanel1, coordenadasTexto.toString(), "Coordenadas Guardadas", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(jPanel1, "Error al leer el archivo 'coordenadas.txt'", "Error", JOptionPane.ERROR_MESSAGE);
        }}
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jButton1)
                .addContainerGap(249, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jButton1)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CoordenadasModel modelo = new CoordenadasModel();
            CoordenadasView ventana = new CoordenadasView(modelo);
            ventana.setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
