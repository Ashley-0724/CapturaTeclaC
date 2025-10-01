/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package capturateclac;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author USERJUL20
 */
public class CapturaTeclaC extends JFrame {

    private JList<String> lista;
    private DefaultListModel<String> modelo;

    public CapturaTeclaC() {
        
        // Título y configuración básica
        setTitle("Ejemplo: Captura de tecla 'C'");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Modelo de lista
        modelo = new DefaultListModel<>();
        modelo.addElement("Elemento 1");
        modelo.addElement("Elemento 2");
        modelo.addElement("Elemento 3");
        modelo.addElement("Elemento 4");
        modelo.addElement("Elemento 5");

        lista = new JList<>(modelo);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scroll = new JScrollPane(lista);

        JButton boton = new JButton("Presiona 'C' para acción");
        
        // Opción 1: Con KeyAdapter (escucha directo sobre la lista)
        lista.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'c' || e.getKeyChar() == 'C') {
                    int index = lista.getSelectedIndex();
                    if (index != -1) {
                        
                        // Alternar el texto del elemento seleccionado
                        String actual = modelo.getElementAt(index);
                        String nuevo = actual.endsWith(" [OK]") ? 
                                       actual.replace(" [OK]", "") : 
                                       actual + " [OK]";
                        modelo.set(index, nuevo);

                        System.out.println("Se presionó la tecla C en el elemento: " + actual);
                    } else {
                        System.out.println("Se presionó la tecla C, pero no hay selección.");
                    }
                }
            }
        });

        // Panel de diseño
        setLayout(new BorderLayout());
        add(scroll, BorderLayout.CENTER);
        add(boton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CapturaTeclaC::new);
    }
}