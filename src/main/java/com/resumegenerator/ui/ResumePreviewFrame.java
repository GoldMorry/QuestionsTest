package com.resumegenerator.ui;

import com.resumegenerator.model.ResumeData;
import com.resumegenerator.service.HtmlGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Окно предварительного просмотра резюме
 * Отображает HTML резюме и позволяет сохранить его в файл
 */
public class ResumePreviewFrame extends JFrame {
    private ResumeData resumeData;
    private JEditorPane htmlPane;
    private JButton saveButton;
    private JButton backButton;
    private String htmlContent;
    
    public ResumePreviewFrame(ResumeData resumeData) {
        this.resumeData = resumeData;
        initializeComponents();
        setupLayout();
        setupActions();
        generateAndDisplayHtml();
    }
    
    private void initializeComponents() {
        setTitle("Предварительный просмотр резюме");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        
        // HTML панель для отображения резюме
        htmlPane = new JEditorPane();
        htmlPane.setContentType("text/html");
        htmlPane.setEditable(false);
        
        // Кнопки
        saveButton = new JButton("Сохранить HTML");
        saveButton.setFont(new Font("Arial", Font.BOLD, 14));
        saveButton.setBackground(new Color(52, 152, 219));
        saveButton.setForeground(Color.WHITE);
        saveButton.setFocusPainted(false);
        
        backButton = new JButton("Назад к редактору");
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setBackground(new Color(149, 165, 166));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(248, 249, 250));
        
        // Заголовок
        JLabel titleLabel = new JLabel("Предварительный просмотр резюме", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(52, 73, 94));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        add(titleLabel, BorderLayout.NORTH);
        
        // Панель с HTML
        JScrollPane scrollPane = new JScrollPane(htmlPane);
        scrollPane.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(10, 20, 10, 20),
            BorderFactory.createLineBorder(new Color(189, 195, 199), 1)));
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);
        
        // Панель с кнопками
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        buttonPanel.setBackground(new Color(248, 249, 250));
        buttonPanel.add(backButton);
        buttonPanel.add(saveButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void setupActions() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveHtmlFile();
            }
        });
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    
    private void generateAndDisplayHtml() {
        try {
            htmlContent = HtmlGenerator.generateHtml(resumeData);
            htmlPane.setText(htmlContent);
            htmlPane.setCaretPosition(0); // Прокрутка в начало
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                "Ошибка при генерации HTML: " + e.getMessage(),
                "Ошибка",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void saveHtmlFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Сохранить резюме как HTML");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".html");
            }
            
            @Override
            public String getDescription() {
                return "HTML файлы (*.html)";
            }
        });
        
        // Предлагаем имя файла по умолчанию
        String fileName = resumeData.getFullName().replaceAll("[^a-zA-Zа-яА-Я0-9\\s]", "").replaceAll("\\s+", "_");
        if (fileName.isEmpty()) {
            fileName = "resume";
        }
        fileChooser.setSelectedFile(new File(fileName + ".html"));
        
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            
            // Добавляем расширение .html если его нет
            if (!file.getName().toLowerCase().endsWith(".html")) {
                file = new File(file.getParentFile(), file.getName() + ".html");
            }
            
            try (FileWriter writer = new FileWriter(file, java.nio.charset.StandardCharsets.UTF_8)) {
                writer.write(htmlContent);
                JOptionPane.showMessageDialog(this,
                    "Резюме успешно сохранено в файл:\n" + file.getAbsolutePath(),
                    "Сохранение завершено",
                    JOptionPane.INFORMATION_MESSAGE);
                    
                // Предлагаем открыть файл
                int choice = JOptionPane.showConfirmDialog(this,
                    "Хотите открыть сохраненный файл?",
                    "Открыть файл",
                    JOptionPane.YES_NO_OPTION);
                    
                if (choice == JOptionPane.YES_OPTION) {
                    try {
                        Desktop.getDesktop().open(file);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this,
                            "Не удалось открыть файл автоматически.\nФайл сохранен в: " + file.getAbsolutePath(),
                            "Информация",
                            JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this,
                    "Ошибка при сохранении файла:\n" + e.getMessage(),
                    "Ошибка сохранения",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}