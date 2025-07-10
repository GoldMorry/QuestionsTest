#!/bin/bash

# Скрипт для быстрого запуска приложения "Генератор резюме"

echo "=== 🚀 Запуск Генератора резюме ==="
echo ""
echo "Для входа используйте:"
echo "👤 Пользователь: newton"
echo "🔐 Пароль: newton"
echo ""

# Проверяем наличие Maven
if command -v mvn &> /dev/null; then
    echo "📦 Запуск через Maven..."
    mvn -q exec:java
else
    echo "⚠️  Maven не найден. Попытка компиляции вручную..."
    
    # Создаем папку для классов
    mkdir -p target/classes
    
    # Компилируем
    echo "🔨 Компиляция..."
    javac -cp src/main/java -d target/classes \
        src/main/java/com/resumegenerator/*.java \
        src/main/java/com/resumegenerator/*/*.java
    
    if [ $? -eq 0 ]; then
        echo "✅ Компиляция завершена!"
        echo "🚀 Запуск приложения..."
        java -cp target/classes com.resumegenerator.Main
    else
        echo "❌ Ошибка компиляции!"
        exit 1
    fi
fi