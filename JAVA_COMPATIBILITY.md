# Java Версии и Совместимость

## 🎯 Решенная проблема

### **Ошибка компиляции:**
```
java: no suitable constructor found for FileWriter(java.io.File,java.nio.charset.Charset)
    constructor java.io.FileWriter.FileWriter(java.lang.String,boolean) is not applicable
    constructor java.io.FileWriter.FileWriter(java.io.File,boolean) is not applicable
```

### **Причина:**
Конструктор `FileWriter(File, Charset)` был добавлен **только в Java 11+**, а проект настроен на **Java 8**.

## ✅ Исправление

### **Было (Java 11+):**
```java
import java.io.FileWriter;

try (FileWriter writer = new FileWriter(file, java.nio.charset.StandardCharsets.UTF_8)) {
    writer.write(content);
}
```

### **Стало (Java 8+ совместимо):**
```java
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

try (OutputStreamWriter writer = new OutputStreamWriter(
        new FileOutputStream(file), StandardCharsets.UTF_8)) {
    writer.write(content);
}
```

## 🔧 Конфигурация Maven (pom.xml)

```xml
<properties>
    <maven.compiler.source>8</maven.compiler.source>
    <maven.compiler.target>8</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
</properties>
```

## 🎯 Поддерживаемые версии

| Java Version | Статус | FileWriter(File, Charset) |
|--------------|--------|---------------------------|
| Java 8       | ✅ Поддерживается | ❌ Нет |
| Java 9       | ✅ Поддерживается | ❌ Нет |  
| Java 10      | ✅ Поддерживается | ❌ Нет |
| Java 11+     | ✅ Поддерживается | ✅ Есть |

## 🚀 Настройка IntelliJ IDEA

### **1. Проверить Project SDK:**
- `File → Project Structure → Project`
- Убедиться что SDK: Java 8 или выше
- Language Level: 8 или выше

### **2. Проверить Module SDK:**
- `File → Project Structure → Modules`
- Language Level: Project default

### **3. Maven настройки:**
- `File → Settings → Build → Build Tools → Maven → Importing`
- JDK for importer: Use Project JDK

## 🔍 Другие частые проблемы Java 8 vs 11+

### **1. Local Variable Type Inference:**
```java
// Java 10+ only
var list = new ArrayList<String>();

// Java 8+ compatible
List<String> list = new ArrayList<>();
```

### **2. HTTP Client:**
```java
// Java 11+ only
HttpClient client = HttpClient.newHttpClient();

// Java 8+ compatible
// Использовать URLConnection или Apache HttpClient
```

### **3. String методы:**
```java
// Java 11+ only
String.isBlank(), String.strip(), String.lines()

// Java 8+ compatible
StringUtils из Apache Commons или custom методы
```

## 🛠️ Быстрая проверка совместимости

### **Команда для проверки:**
```bash
# Компиляция с явным указанием версии
javac -source 8 -target 8 *.java

# Проверка байт-кода
javap -verbose ClassName | grep "major version"
```

### **Ожидаемый результат для Java 8:**
- Major version: 52 (Java 8)
- Major version: 55 (Java 11)
- Major version: 17 (Java 17)

## 📋 Чек-лист для совместимости

- [ ] ✅ Используется `OutputStreamWriter` вместо `FileWriter(File, Charset)`
- [ ] ✅ Нет `var` деклараций
- [ ] ✅ Нет Java 9+ API методов
- [ ] ✅ Maven настроен на Java 8
- [ ] ✅ IDE настроена на Java 8 Project SDK
- [ ] ✅ Компиляция проходит без ошибок

## 🎉 Результат

**Проект теперь полностью совместим с Java 8+** и будет работать в любой современной среде разработки! 🚀