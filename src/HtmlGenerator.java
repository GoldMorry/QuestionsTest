public class HtmlGenerator {
    
    public static String generateHtml(ResumeData data) {
        if ("creative".equals(data.getTheme())) {
            return generateCreativeTheme(data);
        } else {
            return generateProfessionalTheme(data);
        }
    }
    
    private static String generateProfessionalTheme(ResumeData data) {
        return "<!DOCTYPE html>\n" +
                "<html lang='ru'>\n" +
                "<head>\n" +
                "    <meta charset='UTF-8'>\n" +
                "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
                "    <title>Резюме - " + data.getFullName() + "</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n" +
                "            line-height: 1.6;\n" +
                "            margin: 0;\n" +
                "            padding: 20px;\n" +
                "            background-color: #f4f4f4;\n" +
                "            color: #333;\n" +
                "        }\n" +
                "        .container {\n" +
                "            max-width: 800px;\n" +
                "            margin: 0 auto;\n" +
                "            background: white;\n" +
                "            padding: 40px;\n" +
                "            border-radius: 10px;\n" +
                "            box-shadow: 0 0 20px rgba(0,0,0,0.1);\n" +
                "        }\n" +
                "        .header {\n" +
                "            text-align: center;\n" +
                "            border-bottom: 3px solid #2c3e50;\n" +
                "            padding-bottom: 20px;\n" +
                "            margin-bottom: 30px;\n" +
                "        }\n" +
                "        .name {\n" +
                "            font-size: 2.5em;\n" +
                "            font-weight: bold;\n" +
                "            color: #2c3e50;\n" +
                "            margin-bottom: 10px;\n" +
                "        }\n" +
                "        .contact {\n" +
                "            font-size: 1.1em;\n" +
                "            color: #666;\n" +
                "        }\n" +
                "        .section {\n" +
                "            margin-bottom: 30px;\n" +
                "        }\n" +
                "        .section-title {\n" +
                "            font-size: 1.5em;\n" +
                "            font-weight: bold;\n" +
                "            color: #2c3e50;\n" +
                "            border-bottom: 2px solid #3498db;\n" +
                "            padding-bottom: 5px;\n" +
                "            margin-bottom: 15px;\n" +
                "        }\n" +
                "        .section-content {\n" +
                "            white-space: pre-line;\n" +
                "            text-align: justify;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class='container'>\n" +
                "        <div class='header'>\n" +
                "            <div class='name'>" + data.getFullName() + "</div>\n" +
                "            <div class='contact'>\n" +
                "                " + data.getEmail() + " | " + data.getPhone() + " | " + data.getAddress() + "\n" +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class='section'>\n" +
                "            <div class='section-title'>О себе</div>\n" +
                "            <div class='section-content'>" + data.getSummary() + "</div>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class='section'>\n" +
                "            <div class='section-title'>Опыт работы</div>\n" +
                "            <div class='section-content'>" + data.getExperience() + "</div>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class='section'>\n" +
                "            <div class='section-title'>Образование</div>\n" +
                "            <div class='section-content'>" + data.getEducation() + "</div>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class='section'>\n" +
                "            <div class='section-title'>Навыки</div>\n" +
                "            <div class='section-content'>" + data.getSkills() + "</div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";
    }
    
    private static String generateCreativeTheme(ResumeData data) {
        return "<!DOCTYPE html>\n" +
                "<html lang='ru'>\n" +
                "<head>\n" +
                "    <meta charset='UTF-8'>\n" +
                "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
                "    <title>Резюме - " + data.getFullName() + "</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: 'Georgia', serif;\n" +
                "            line-height: 1.6;\n" +
                "            margin: 0;\n" +
                "            padding: 20px;\n" +
                "            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);\n" +
                "            color: #333;\n" +
                "            min-height: 100vh;\n" +
                "        }\n" +
                "        .container {\n" +
                "            max-width: 800px;\n" +
                "            margin: 0 auto;\n" +
                "            background: white;\n" +
                "            padding: 40px;\n" +
                "            border-radius: 20px;\n" +
                "            box-shadow: 0 20px 40px rgba(0,0,0,0.2);\n" +
                "            position: relative;\n" +
                "            overflow: hidden;\n" +
                "        }\n" +
                "        .container::before {\n" +
                "            content: '';\n" +
                "            position: absolute;\n" +
                "            top: 0;\n" +
                "            left: 0;\n" +
                "            right: 0;\n" +
                "            height: 5px;\n" +
                "            background: linear-gradient(90deg, #ff6b6b, #4ecdc4, #45b7d1, #96ceb4, #feca57);\n" +
                "        }\n" +
                "        .header {\n" +
                "            text-align: center;\n" +
                "            padding-bottom: 30px;\n" +
                "            margin-bottom: 40px;\n" +
                "            position: relative;\n" +
                "        }\n" +
                "        .name {\n" +
                "            font-size: 3em;\n" +
                "            font-weight: bold;\n" +
                "            background: linear-gradient(45deg, #667eea, #764ba2);\n" +
                "            -webkit-background-clip: text;\n" +
                "            -webkit-text-fill-color: transparent;\n" +
                "            margin-bottom: 15px;\n" +
                "            text-shadow: 2px 2px 4px rgba(0,0,0,0.1);\n" +
                "        }\n" +
                "        .contact {\n" +
                "            font-size: 1.2em;\n" +
                "            color: #666;\n" +
                "            font-style: italic;\n" +
                "        }\n" +
                "        .section {\n" +
                "            margin-bottom: 35px;\n" +
                "            padding: 20px;\n" +
                "            border-radius: 15px;\n" +
                "            background: linear-gradient(135deg, rgba(102, 126, 234, 0.1), rgba(118, 75, 162, 0.1));\n" +
                "            border-left: 5px solid #667eea;\n" +
                "        }\n" +
                "        .section-title {\n" +
                "            font-size: 1.8em;\n" +
                "            font-weight: bold;\n" +
                "            color: #667eea;\n" +
                "            margin-bottom: 15px;\n" +
                "            position: relative;\n" +
                "        }\n" +
                "        .section-title::after {\n" +
                "            content: '✨';\n" +
                "            margin-left: 10px;\n" +
                "            font-size: 0.8em;\n" +
                "        }\n" +
                "        .section-content {\n" +
                "            white-space: pre-line;\n" +
                "            text-align: justify;\n" +
                "            font-size: 1.1em;\n" +
                "            line-height: 1.8;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class='container'>\n" +
                "        <div class='header'>\n" +
                "            <div class='name'>" + data.getFullName() + "</div>\n" +
                "            <div class='contact'>\n" +
                "                📧 " + data.getEmail() + " | 📱 " + data.getPhone() + " | 📍 " + data.getAddress() + "\n" +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class='section'>\n" +
                "            <div class='section-title'>О себе</div>\n" +
                "            <div class='section-content'>" + data.getSummary() + "</div>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class='section'>\n" +
                "            <div class='section-title'>Опыт работы</div>\n" +
                "            <div class='section-content'>" + data.getExperience() + "</div>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class='section'>\n" +
                "            <div class='section-title'>Образование</div>\n" +
                "            <div class='section-content'>" + data.getEducation() + "</div>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class='section'>\n" +
                "            <div class='section-title'>Навыки</div>\n" +
                "            <div class='section-content'>" + data.getSkills() + "</div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";
    }
}