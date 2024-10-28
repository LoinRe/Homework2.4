public class User {
    public static void userInfo(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        // Разрешенные символы
        String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";

        // Проверка логина
        if (login.length() > 20) {
            throw new WrongLoginException("Логин не должен превышать 20 символов");
        }

        for (char c : login.toCharArray()) {
            if (!isAllowedChar(c, allowedCharacters)) {
                throw new WrongLoginException("Логин может содержать только латинские буквы, цифры и знак подчеркивания");
            }
        }

        // Проверка пароля
        if (password.length() > 20) {
            throw new WrongPasswordException("Пароль не должен превышать 20 символов");
        }

        for (char c : password.toCharArray()) {
            if (!isAllowedChar(c, allowedCharacters)) {
                throw new WrongPasswordException("Пароль может содержать только латинские буквы, цифры и знак подчеркивания");
            }
        }

        // Проверка совпадения паролей
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }

        // Если все проверки пройдены
        System.out.println("Пользователь успешно зарегистрирован");
    }

    // Метод для проверки, является ли символ допустимым
    private static boolean isAllowedChar(char c, String allowedCharacters) {
        for (int i = 0; i < allowedCharacters.length(); i++) {
            if (c == allowedCharacters.charAt(i)) {
                return true; // Символ найден в разрешенных
            }
        }
        return false; // Символ не найден в разрешенных
    }
}
