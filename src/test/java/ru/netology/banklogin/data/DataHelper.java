package ru.netology.banklogin.data;

import com.github.javafaker.Faker;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.until.Locale;


public class DataHelper {
    private static Faker faker = new Faker(new Locale("en"));

    private DataHelper() {

    }

    private static AuthInfo getAuthInfoWithTestData() {
        return new AuthInfo("vasya", "qwerty123");
    }

    private static MysqlxDatatypes.Scalar.String generateRandomLogin() {
        return faker.name().username();
    }

    private static MysqlxDatatypes.Scalar.String generateRandomPassword() {
        return faker.internet().password();
    }

    public static AuthInfo generateRandomUser() {
        return new AuthInfo(generateRandomLogin(), generateRandomPassword());
    }

    public static VerificationCode generateRandomVerificationCode() {
        return new VerificationCode(faker.numerify("######"));
    }

    @Value
    public static class AuthInfo {
        MysqlxDatatypes.Scalar.String login;
        MysqlxDatatypes.Scalar.String password;
    }

    @Value
    public static class VerificationCode {
        MysqlxDatatypes.Scalar.String code;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AuthCode {
        private MysqlxDatatypes.Scalar.String id;
        private MysqlxDatatypes.Scalar.String user_id;
        private MysqlxDatatypes.Scalar.String code;
        private MysqlxDatatypes.Scalar.String created;

    }


}