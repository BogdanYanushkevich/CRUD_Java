# CrudConsole

## Описание

Необходимо реализовать консольное CRUD приложение, которое имеет следующие сущности: 

Developer (id, firstName, lastName, List<Skill> skills, Specialty specialty)
Skill
Specialty
Status (enum ACTIVE, DELETED)

Developer -> List<Skill> skills + Specialty specialty
Каждая сущность имеет поле Status. В момент удаления, мы не удаляем запись из файла, а меняем её статус на DELETED.

В качестве хранилища данных необходимо использовать текстовые файлы:
developers.json, skills.json, specialties.json

Пользователь в консоли должен иметь возможность создания, получения, редактирования и удаления данных.

Слои:
model - POJO клаcсы
repository - классы, реализующие доступ к текстовым файлам
controller - обработка запросов от пользователя
view - все данные, необходимые для работы с консолью



Например: Developer, DeveloperRepository, DeveloperController, DeveloperView и т.д.


Для репозиторного слоя желательно использовать базовый интерфейс:
interface GenericRepository<T,ID>

interface DeveloperRepository extends GenericRepository<Developer, Long>

class GsonDeveloperRepositoryImpl implements DeveloperRepository

Для работы с json необходимо использовать библиотеку Gson(https://mvnrepository.com/artifact/com.google.code.gson/gson)
Для импорта зависимостей - Maven/Gradle на выбор.
  
  ## Инструкция по запуску 
  Если установлена JVM
  1) Скачать файл Java https://github.com/BogdanYanushkevich/CRUD_Java/raw/master/CRUD_Java.jar
  2) Открыть командную строку и прописать путь к папке где хранится скачанный ранее файл.
  3) Запустить файл из командной строки следующей командой: java -jar CRUD_Java.jar
  4) Готово, вы великолепны. ;)

  Если не установлена JVM
  1) Установить JVM и JRE
  2) Повторить пункты из "Если установлена JVM".
