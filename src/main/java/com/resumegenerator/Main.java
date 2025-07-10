package com.resumegenerator;

import com.resumegenerator.ui.LoginFrame;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * Главный класс приложения "Генератор резюме"
 * Точка входа в программу
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Устанавливаем системный look and feel для лучшего внешнего вида
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            // Запускаем приложение с окна входа
            new LoginFrame().setVisible(true);
        });
    }
}