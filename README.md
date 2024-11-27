# Тестовое задание 

### Содержание задания

Сделать мультишаговый сервис аунтефикации.
Кейс:
- Человек вводит номер телефона
- Если пользователь есть, просим пароль, если нет - то к паролю еще требуем Имя Фамилию для создания пользователя
-  Запрашиваем смс код (СМС сервис можно замокать и сделать 111111 как верный код)

Сделать базовое API для получения инфы о юзере используя GraphQL.

Язык: Kotlin
Spring Boot 3+ + Spring GraphQL

# Подключение приложения

- Заполнить application.properties для подключения к БД
- Использовать таблицу, таблица для ее создания в Postgresql

```
CREATE TABLE users (
    id SERIAL PRIMARY KEY,                
    phone_number VARCHAR(15) NOT NULL UNIQUE, 
    first_name VARCHAR(100),              
    last_name VARCHAR(100),               
    is_verified BOOLEAN NOT NULL DEFAULT FALSE
    password VARCHAR(255) NOT NULL;
);
```

- Для работы приложения включен GraphQl UI, работает по адресу http://localhost:8080/graphiql
