# java-explore-with-me

```java-explore-with-me``` это spring-boot приложение, предназначенное для создания событий - от выставки до похода в кино - 
до сбора друзей для участия в этих событиях.
Архитектура приложения представляет собой два сервиса:
- Основной сервис содержит все необходимое для работы продукта;
- Сервис статистики - хранит количество просмотров и позволяет делать различные выборки для анализа работы приложения

Основной сервис разделен на 3 части - публичная, приватная и административная. Каждая из частей обеспечивает свою функциональность:

### Функционал приватного API:

- Пользователь может добавлять, редактировать, удалять, а также просматривать созданные мероприятия;
- Пользователь может подавать заявки на участие в мероприятиях других пользователей;
- Создатель мероприятия может принимать или отклонять заявки на участие в мероприятии других пользователей;

### Функционал API администратора:

- Администратор может создавать, редактировать и удалять категории, к которым будут относится созданные пользователями мероприятия;
- Администратор может создавать, редактировать, закреплять на главной и удалять подборки мероприятий;
- Администратор может модерировать, т.е. принимать или отклонять публикацию события, созданного другим пользователем;
- Администратор добавляет, удаляет или редактирует данные пользователей; 

### Функционал публичного API:

- Сортировка списка событий по количеству просмотров, запрашиваемое в сервисе статистики, либо по дате;
- Возможность посмотреть краткую информацию о событии;
- Возможность посмотреть подробную информацию о конкретном событии;
- Возможность посмотреть одну конкретную или все существующие подборки событий с параметрами фильтрации;
- Сервис статистики фиксирует каждый просмотр одного конкретного события, или всех событий с фильтрацией

Сервис статистики в свою очередь обладает следующим функционалом:

- Записывает информацию о том, что был обработан запрос к конкретному эндпоинту приложения;
- Предоставляет статистику за выбранные даты по конкретному эндпоинту

Основной сервис и сервис статистики взаимодействуют между собой через HTTP-клиент, на основе RestTemplate.
Оба сервиса запускаются каждый в своем docker-контейнере. Также у каждого сервиса в докере запускается своя база данных PostgreSQL для хранения данных.

Подробная информация по эндпоинтам приложения описана в спецификациях, которые можно посмотреть в онлайн-редакторе swagger:

- [спецификация основного сервиса](https://raw.githubusercontent.com/yandex-praktikum/java-explore-with-me/main/ewm-main-service-spec.json)
- [спецификация сервиса статистики](https://raw.githubusercontent.com/yandex-praktikum/java-explore-with-me/main/ewm-stats-service-spec.json)
