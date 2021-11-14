package ru.netology;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator(){}

    public static class Registration{
        private Registration(){}

        public static RegistrationByClientInfo generate(){
            Faker faker = new Faker(new Locale("ru"));
            return new RegistrationByClientInfo(
                    faker.address().city(),
                    faker.name().fullName(),
                    faker.phoneNumber().phoneNumber(),
                    LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    LocalDate.now().plusDays(7).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
            );

        }

    }
}
