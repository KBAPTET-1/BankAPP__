/*
    Импортированные библиотеки
 */

import java.util.Locale;
import java.util.Scanner;

class Main
{
    public static void main(String[] args)
    {



        // Переменные
        Client user = new Client(); // Получаем класс
        Scanner input = new Scanner(System.in).useLocale(Locale.US); // Перевод локали сканера
        boolean exit_mode = true; // флажок для выхода из программы






        while (exit_mode) {
            int code_for_operation; // сюда запишем код операции
            System.out.println("-==< Банковская система >==-\n1. Посмотреть счет.\n2. Положить деньги на счёт.\n3. Снять деньги со счёта.\n4. Выйти.\n-==< Банковская система >==-");
            System.out.print("Введите код операции (Например 1,2... и т.д.): ");
            if(input.hasNextInt()) { // Проверяем что введенное это число!
                code_for_operation = input.nextInt();
                switch (code_for_operation) {
                    case 1: // Проверка баланса пользователя
                        System.out.println("(ИНТЕРКОМ) Балланс: " + user.balance);
                        break;
                    case 2: // Пополнение баланса
                        System.out.println("(ИНТЕРКОМ) Введите сумму которую хотите положить на счет!");
                        System.out.print("Введите сумму: ");
                        if(input.hasNextDouble())
                        {
                            double summ = input.nextDouble();
                            user.payToBallance(summ);
                            input.nextLine();
                            break;
                        } else {
                            System.out.println("(ИНТЕРКОМ) Неккоректное число! Повторите попытку!");
                            input.nextLine();
                        }
                        break;
                    case 3: // снятие баланса
                        System.out.println("(ИНТЕРКОМ) Введите сумму которую хотите снять со счета!");
                        System.out.print("Введите сумму: ");
                        if(input.hasNextDouble())
                        {
                            double var = input.nextDouble();
                            user.takeoffBallance(var);
                            input.nextLine();
                            break;
                        } else {
                            System.out.println("(ИНТЕРКОМ) Неккоректное число! Повторите попытку!");
                            input.nextLine();
                        }
                        break;
                    case 4: // Выход
                        System.out.println("(ИНТЕРКОМ) Выход...");
                        exit_mode = false;
                        break;
                    default: // Если вариант ответ ни с чем не совпал.
                        System.out.println("(ИНТЕРКОМ) Неправильный код операции, пожалуйста проверьте существующие коды согласно таблице выше!");
                        break;
                }
            } else {
                System.out.println("(ИНТЕРКОМ) Неверный код операции!");

            }

        }
        input.close(); // Закрываем сканер

    }
}