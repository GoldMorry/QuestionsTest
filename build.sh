#!/bin/bash

# Скрипт для сборки исполняемого JAR файла

echo "=== 🔨 Сборка Генератора резюме ==="
echo ""

# Проверяем наличие Maven
if command -v mvn &> /dev/null; then
    echo "📦 Сборка через Maven..."
    
    # Компилируем
    echo "🔧 Компиляция исходного кода..."
    mvn compile
    
    if [ $? -eq 0 ]; then
        echo "✅ Компиляция завершена!"
        
        # Создаем JAR
        echo "📦 Создание исполняемого JAR..."
        mvn package
        
        if [ $? -eq 0 ]; then
            echo ""
            echo "🎉 Сборка завершена успешно!"
            echo ""
            echo "📁 Исполняемый файл: target/resume-generator-1.0.0.jar"
            echo ""
            echo "🚀 Для запуска используйте:"
            echo "   java -jar target/resume-generator-1.0.0.jar"
            echo ""
            echo "🔑 Учетные данные для входа:"
            echo "   👤 Пользователь: newton"
            echo "   🔐 Пароль: newton"
        else
            echo "❌ Ошибка при создании JAR файла!"
            exit 1
        fi
    else
        echo "❌ Ошибка компиляции!"
        exit 1
    fi
else
    echo "⚠️  Maven не найден!"
    echo ""
    echo "Для сборки JAR файла требуется Maven."
    echo "Установите Maven или используйте скрипт run.sh для простого запуска."
    echo ""
    echo "💡 Альтернативный способ:"
    echo "   ./run.sh"
    exit 1
fi