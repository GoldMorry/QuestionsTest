import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    
    public LoginFrame() {
        initializeComponents();
        setupLayout();
        setupActions();
    }
    
    private void initializeComponents() {
        setTitle("Генератор резюме - Вход в систему");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Создаем компоненты
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Войти");
        
        // Настраиваем стиль
        usernameField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setBackground(new Color(52, 152, 219));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(236, 240, 241));
        
        // Заголовок
        JLabel titleLabel = new JLabel("Добро пожаловать!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(52, 73, 94));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));
        add(titleLabel, BorderLayout.NORTH);
        
        // Центральная панель с формой
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(new Color(236, 240, 241));
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Пользователь
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 5, 10);
        gbc.anchor = GridBagConstraints.WEST;
        JLabel userLabel = new JLabel("Пользователь:");
        userLabel.setFont(new Font("Arial", Font.BOLD, 14));
        centerPanel.add(userLabel, gbc);
        
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 10, 15, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        usernameField.setPreferredSize(new Dimension(200, 30));
        usernameField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199)),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        centerPanel.add(usernameField, gbc);
        
        // Пароль
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 10, 5, 10);
        gbc.fill = GridBagConstraints.NONE;
        JLabel passLabel = new JLabel("Пароль:");
        passLabel.setFont(new Font("Arial", Font.BOLD, 14));
        centerPanel.add(passLabel, gbc);
        
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 10, 20, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        passwordField.setPreferredSize(new Dimension(200, 30));
        passwordField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199)),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        centerPanel.add(passwordField, gbc);
        
        // Кнопка входа
        gbc.gridy = 4;
        gbc.insets = new Insets(10, 10, 10, 10);
        loginButton.setPreferredSize(new Dimension(100, 35));
        centerPanel.add(loginButton, gbc);
        
        add(centerPanel, BorderLayout.CENTER);
        
        // Подсказка внизу
        JLabel hintLabel = new JLabel("<html><center>Для входа используйте:<br>Пользователь: <b>newton</b><br>Пароль: <b>newton</b></center></html>", SwingConstants.CENTER);
        hintLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        hintLabel.setForeground(new Color(127, 140, 141));
        hintLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        add(hintLabel, BorderLayout.SOUTH);
    }
    
    private void setupActions() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authenticate();
            }
        });
        
        // Вход по Enter в любом поле
        usernameField.addActionListener(e -> authenticate());
        passwordField.addActionListener(e -> authenticate());
    }
    
    private void authenticate() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        
        if ("newton".equals(username) && "newton".equals(password)) {
            // Успешный вход
            dispose();
            SwingUtilities.invokeLater(() -> {
                new ResumeGeneratorFrame().setVisible(true);
            });
        } else {
            // Ошибка входа
            JOptionPane.showMessageDialog(this, 
                "Неверный пользователь или пароль!\nИспользуйте: newton/newton", 
                "Ошибка входа", 
                JOptionPane.ERROR_MESSAGE);
            passwordField.setText("");
            usernameField.requestFocus();
        }
    }
}