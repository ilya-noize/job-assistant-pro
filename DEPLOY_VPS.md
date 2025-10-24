## Установка и настройка Java-разработки на Ubuntu с Maven

### 1. Установка необходимых компонентов

#### Установка JDK
```bash
sudo apt update
sudo apt install default-jdk
```

Проверка установки:
```bash
java -version
```

#### Установка Maven
Есть два способа установки:

**Способ 1: Через репозитории**
```bash
sudo apt install maven
```

**Способ 2: Ручная установка последней версии**
1. Скачайте архив с официального сайта
2. Распакуйте в /opt:
```bash
sudo tar xvf ~/Downloads/apache-maven-*.tar.gz -C /opt
```
3. Создайте симлинк:
```bash
sudo ln -s /opt/apache-maven-* /opt/maven
```

### 2. Настройка окружения

Создайте файл с настройками:
```bash
sudo vi /etc/environment.d/100-maven.conf
```

Добавьте следующие строки:
```bash
JAVA_HOME=/usr/lib/jvm/default-java
M2_HOME=/opt/maven
MAVEN_HOME=/opt/maven
PATH=/opt/maven/bin:${PATH}
```

Перезапустите сессию или выполните:
```bash
source /etc/environment.d/100-maven.conf
```

### 3. Создание проекта

Перейдите в директорию для проекта:
```bash
cd /путь/к/проекту
```

Создайте проект через Maven:
```bash
mvn archetype:generate \
    -DgroupId=com.example \
    -DartifactId=my-project \
    -DarchetypeArtifactId=maven-archetype-quickstart \
    -DinteractiveMode=false
```

### 4. Настройка проекта

Откройте файл pom.xml и добавьте настройки:
```xml
<properties>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
</properties>
```

### 5. Сборка проекта

Перейдите в директорию проекта:
```bash
cd my-project
```

Выполните сборку:
```bash
mvn clean package
```

### 6. Запуск приложения

После успешной сборки выполните:
```bash
java -jar target/my-project-1.0-SNAPSHOT.jar
```

### Дополнительные рекомендации

* **Управление зависимостями**: добавляйте необходимые библиотеки в pom.xml
* **Тестирование**: используйте команду `mvn test` для запуска тестов
* **Документация**: генерируйте документацию через `mvn site`
* **Профили**: настройте разные конфигурации для разработки и продакшена

### Проверка работоспособности

Убедитесь, что все компоненты работают корректно:
```bash
mvn -version
java -version
```

После выполнения всех шагов вы получите полностью настроенное окружение для разработки Java-приложений с использованием Maven на Ubuntu.