public class Main {
    public static void main(String[] args) { // Добавлен метод main
        try {
            User.userInfo("java_skypro_go", "D_1hWiKjjP_9", "D_1hWiKjjP_9"); // Успешная регистрация
            User.userInfo("java_skypro_go", "D_1hWiKjjP_9", "wrong_password"); // Это вызовет исключение
            User.userInfo("invalid-login", "D_1hWiKjjP_9", "D_1hWiKjjP_9"); // Это вызовет исключение
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}