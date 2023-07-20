# Урок 1. Компиляция и интерпретация кода

1. Создать приложение с вложенностью пакетов не менее 3х,
   где будет класс для входа и несколько классов с логикой.
   Пример: приложение для внесения заметок во внешний файл с обязательной фиксацией времени

пример:
```
Введите заметку: Hello, world!
Дозапись в файл: 16.07.2023 -> Hello, world
```

Скомпилируйте и запустите посредством CLI

## Решение
Создадим структуру пакетов и файлов проекта:

JavaCore
- com 
- - mynotesapp
- - - Main.java
- - - logic
- - - - Note.java
- - - - NoteWriter.java
- - - utils
- - - - DateUtils.java
- notes.txt

где:

- Main.java - класс с методом main, который будет точкой входа в приложение.
- Note.java - класс для представления заметки.
- NoteWriter.java - класс для записи заметок в файл.
- DateUtils.java - утилитарный класс для работы с датами.
- notes.txt - файл для хранения заметок.

```agsl
Компиляция исходных файлов
javac -d out com/mynotesapp/Main.java com/mynotesapp/logic/*.java com/mynotesapp/utils/*.java

Запуск приложения
java -classpath out com.mynotesapp.Main

```

2. (доп).Создать два Docker-образа.
   Один должен компилировать Java-проект обратно в папку на компьютере пользователя,
   а второй забирать скомпилированные классы и исполнять их.
   Пример листинга для docker-compose приведен в презентации семинара

## Решение

1. Создадим два Dockerfile для двух контейнеров.
Первый назовём __Dockerfile-compile__:
```agsl
# Используем образ с JDK для компиляции
FROM openjdk:latest

# Копируем исходный код в образ
COPY ./src /app/src

# Устанавливаем рабочую директорию
WORKDIR /app

# Компилируем исходный код
RUN javac -d out com/mynotesapp/Main.java com/mynotesapp/logic/*.java com/mynotesapp/utils/*.java
```
и второй назовём __Dockerfile-run__:
~~~
# Используем образ с JRE для исполнения
FROM openjdk:latest

# Копируем скомпилированные классы в образ
COPY --from=0 /app/out /app/out

# Устанавливаем рабочую директорию
WORKDIR /app

# Запускаем приложение
CMD java -classpath out com.mynotesapp.Main
~~~

Теперь создадим файл docker-compose.yml, 
который определит два сервиса - один для компиляции (compile), другой для запуска (run):
```agsl
version: '3.9'
services:
  compile:
    build:
      context: .
      dockerfile: Dockerfile-compile
    volumes:
      - .:/app
    command: javac -d out com/mynotesapp/Main.java com/mynotesapp/logic/*.java com/mynotesapp/utils/*.java

  run:
    build:
      context: .
      dockerfile: Dockerfile-run
    volumes:
      - .:/app
```
Компилируем и выполняем проект командой:
```agsl
docker-compose up
```