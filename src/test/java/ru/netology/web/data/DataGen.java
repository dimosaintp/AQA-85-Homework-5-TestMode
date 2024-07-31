package ru.netology.web.data;

import static ru.netology.web.data.ApiHelp.sendRequest;
import com.github.javafaker.Faker;
import java.util.Locale;
import lombok.Value;

public class DataGen {

    private static final Faker faker = new Faker(new Locale("en"));

    private DataGen(){
    }

    public static String getRandomLogin() {
        return faker.name().username();

    }
    public static String getRandomPassword() {
        return faker.internet().password();
    }

    public static class Registration {
        private Registration () {
        }
        public static RegistrationDto getUser(String status) {
            return new RegistrationDto(getRandomLogin(), getRandomPassword(), status);
        }
        public static RegistrationDto getRegisteredUser(String status) {
            return sendRequest(getUser(status));
        }

    }

    @Value
    public static class RegistrationDto {
        String login;
        String password;
        String status;
    }
}