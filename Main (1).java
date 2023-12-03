// Создание класса, представляющего соискателя
class Applicant {
    private String name;
    private String email;

    public Applicant(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // добавляем геттеры и сеттеры для полей класса
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

// Создание перечисления для типов вакансий
enum VacancyType {
    FULL_TIME,
    PART_TIME,
    CONTRACT
}

// Создание класса, представляющего вакансию
class Vacancy {
    private String title;
    private VacancyType type;

    public Vacancy(String title, VacancyType type) {
        this.title = title;
        this.type = type;
    }

    // добавляем геттеры и сеттеры для полей класса
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public VacancyType getType() {
        return type;
    }

    public void setType(VacancyType type) {
        this.type = type;
    }
}

// Создание класса, представляющего компанию
class Company {
    private String name;

    public Company(String name) {
        this.name = name;
    }

    // метод для рассылки вакансий
    public void sendVacancies(Applicant applicant, Vacancy[] vacancies) {
        String message = "Добрый день, " + applicant.getName() + "!\n" +
                "В компании " + this.name + " открыты следующие вакансии:\n";

        for (Vacancy vacancy : vacancies) {
            message += "- " + vacancy.getTitle() + " (" + vacancy.getType() + ")\n";
        }

        message += "Приглашаем вас на собеседование.";

        // здесь бы добавлен код для отправки сообщения на email соискателя
        System.out.println("Сообщение отправлено на email: " + applicant.getEmail());
        System.out.println("Сообщение:\n" + message);
    }
}

public class Main {
    public static void main(String[] args) {
        // создаем нового соискателя
        Applicant applicant = new Applicant("Иван", "ivan@mail.com");
        
        // создаем несколько вакансий
        Vacancy[] vacancies = {
            new Vacancy("Java Developer", VacancyType.FULL_TIME),
            new Vacancy("Frontend Developer", VacancyType.PART_TIME),
            new Vacancy("QA Engineer", VacancyType.CONTRACT)
        };

        // создаем компанию
        Company company = new Company("Наша Компания");
        
        // отправляем вакансии соискателю
        company.sendVacancies(applicant, vacancies);
    }
}