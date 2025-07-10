package com.resumegenerator.ui;

import com.resumegenerator.model.ResumeData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Главное окно редактора резюме
 * Позволяет редактировать все поля резюме и выбирать тему
 */
public class ResumeGeneratorFrame extends JFrame {
    private ResumeData resumeData;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField addressField;
    private JTextArea summaryArea;
    private JTextArea experienceArea;
    private JTextArea educationArea;
    private JTextArea skillsArea;
    private JComboBox<String> themeComboBox;
    private JButton submitButton;
    
    public ResumeGeneratorFrame() {
        resumeData = new ResumeData();
        initializeComponents();
        setupLayout();
        setupActions();
        loadData();
    }
    
    private void initializeComponents() {
        setTitle("Генератор резюме - Редактор");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 700);
        setLocationRelativeTo(null);
        
        // Создаем поля ввода
        nameField = new JTextField();
        emailField = new JTextField();
        phoneField = new JTextField();
        addressField = new JTextField();
        
        summaryArea = new JTextArea(3, 30);
        experienceArea = new JTextArea(5, 30);
        educationArea = new JTextArea(4, 30);
        skillsArea = new JTextArea(3, 30);
        
        // Настраиваем автоперенос текста
        summaryArea.setLineWrap(true);
        summaryArea.setWrapStyleWord(true);
        experienceArea.setLineWrap(true);
        experienceArea.setWrapStyleWord(true);
        educationArea.setLineWrap(true);
        educationArea.setWrapStyleWord(true);
        skillsArea.setLineWrap(true);
        skillsArea.setWrapStyleWord(true);
        
        // Выбор темы
        themeComboBox = new JComboBox<>(new String[]{"Профессиональная", "Креативная"});
        
        // Кнопка отправки
        submitButton = new JButton("Отправить");
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setBackground(new Color(46, 204, 113));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setPreferredSize(new Dimension(150, 40));
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(248, 249, 250));
        
        // Заголовок
        JLabel titleLabel = new JLabel("Редактор резюме", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(new Color(52, 73, 94));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(titleLabel, BorderLayout.NORTH);
        
        // Основная панель с полями
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(248, 249, 250));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(0, 40, 20, 40));
        
        // Личная информация
        mainPanel.add(createSectionPanel("Личная информация", createPersonalInfoPanel()));
        mainPanel.add(Box.createVerticalStrut(20));
        
        // О себе
        mainPanel.add(createSectionPanel("О себе", createScrollPane(summaryArea)));
        mainPanel.add(Box.createVerticalStrut(20));
        
        // Опыт работы
        mainPanel.add(createSectionPanel("Опыт работы", createScrollPane(experienceArea)));
        mainPanel.add(Box.createVerticalStrut(20));
        
        // Образование
        mainPanel.add(createSectionPanel("Образование", createScrollPane(educationArea)));
        mainPanel.add(Box.createVerticalStrut(20));
        
        // Навыки
        mainPanel.add(createSectionPanel("Навыки", createScrollPane(skillsArea)));
        mainPanel.add(Box.createVerticalStrut(20));
        
        // Тема
        mainPanel.add(createSectionPanel("Тема резюме", themeComboBox));
        
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setBorder(null);
        add(scrollPane, BorderLayout.CENTER);
        
        // Панель с кнопкой
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(248, 249, 250));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        buttonPanel.add(submitButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private JPanel createPersonalInfoPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Имя
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.3;
        panel.add(new JLabel("Полное имя:"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.7;
        panel.add(nameField, gbc);
        
        // Email
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.3;
        panel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.7;
        panel.add(emailField, gbc);
        
        // Телефон
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0.3;
        panel.add(new JLabel("Телефон:"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.7;
        panel.add(phoneField, gbc);
        
        // Адрес
        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0.3;
        panel.add(new JLabel("Адрес:"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.7;
        panel.add(addressField, gbc);
        
        return panel;
    }
    
    private JScrollPane createScrollPane(JTextArea textArea) {
        textArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(0, 120));
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
        return scrollPane;
    }
    
    private JPanel createSectionPanel(String title, Component component) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(230, 230, 230)),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(new Color(52, 73, 94));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        
        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(component, BorderLayout.CENTER);
        
        return panel;
    }
    
    private void setupActions() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
                showPreview();
            }
        });
        
        themeComboBox.addActionListener(e -> {
            String selected = (String) themeComboBox.getSelectedItem();
            resumeData.setTheme("Креативная".equals(selected) ? "creative" : "professional");
        });
    }
    
    private void loadData() {
        nameField.setText(resumeData.getFullName());
        emailField.setText(resumeData.getEmail());
        phoneField.setText(resumeData.getPhone());
        addressField.setText(resumeData.getAddress());
        summaryArea.setText(resumeData.getSummary());
        experienceArea.setText(resumeData.getExperience());
        educationArea.setText(resumeData.getEducation());
        skillsArea.setText(resumeData.getSkills());
        
        themeComboBox.setSelectedItem("creative".equals(resumeData.getTheme()) ? "Креативная" : "Профессиональная");
    }
    
    private void saveData() {
        resumeData.setFullName(nameField.getText());
        resumeData.setEmail(emailField.getText());
        resumeData.setPhone(phoneField.getText());
        resumeData.setAddress(addressField.getText());
        resumeData.setSummary(summaryArea.getText());
        resumeData.setExperience(experienceArea.getText());
        resumeData.setEducation(educationArea.getText());
        resumeData.setSkills(skillsArea.getText());
        
        String selected = (String) themeComboBox.getSelectedItem();
        resumeData.setTheme("Креативная".equals(selected) ? "creative" : "professional");
    }
    
    private void showPreview() {
        SwingUtilities.invokeLater(() -> {
            new ResumePreviewFrame(resumeData).setVisible(true);
        });
    }
}