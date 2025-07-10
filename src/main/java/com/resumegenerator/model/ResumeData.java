package com.resumegenerator.model;

/**
 * Модель данных резюме
 * Содержит всю информацию о резюме
 */
public class ResumeData {
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private String summary;
    private String experience;
    private String education;
    private String skills;
    private String theme; // "professional" или "creative"
    
    /**
     * Конструктор с инициализацией примерами данных
     */
    public ResumeData() {
        // Инициализация с примерами данных
        this.fullName = "Ньютон Исаак";
        this.email = "newton@example.com";
        this.phone = "+7 (999) 123-45-67";
        this.address = "Москва, Россия";
        this.summary = "Опытный физик и математик с глубокими знаниями в области механики и оптики.";
        this.experience = "1687-1727: Профессор математики в Кембриджском университете\n" +
                         "1703-1727: Президент Лондонского королевского общества\n" +
                         "1696-1727: Смотритель Королевского монетного двора";
        this.education = "1661-1665: Тринити-колледж, Кембриджский университет\n" +
                        "1665-1667: Магистр искусств, Кембриджский университет";
        this.skills = "Математика, Физика, Оптика, Механика, Астрономия";
        this.theme = "professional";
    }
    
    // Геттеры и сеттеры
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }
    
    public String getExperience() { return experience; }
    public void setExperience(String experience) { this.experience = experience; }
    
    public String getEducation() { return education; }
    public void setEducation(String education) { this.education = education; }
    
    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }
    
    public String getTheme() { return theme; }
    public void setTheme(String theme) { this.theme = theme; }
}