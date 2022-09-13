package ru.mulashkin.hhtb.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import ru.mulashkin.hhtb.entity.TelegramUser;

import java.util.List;
import java.util.Optional;

/**
 * Integration-level testing for {@link TelegramUserRepository}.
 */
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TelegramUserRepositoryIT {

    private final TelegramUserRepository telegramUserRepository;

    @Autowired
    public TelegramUserRepositoryIT(TelegramUserRepository telegramUserRepository) {
        this.telegramUserRepository = telegramUserRepository;
    }

    @Sql(scripts = {"/sql/clearDbs.sql", "/sql/telegram_users.sql"})
    @Test
    public void shouldProperlyFindAllActiveUsers() {
        // when
        List<TelegramUser> users = telegramUserRepository.findAllByActiveTrue();
        // then
        Assertions.assertEquals(5, users.size());
    }

    @Sql(scripts = {"/sql/clearDbs.sql"})
    @Test
    public void shouldProperlySaveTelegramUser() {
        // given
        TelegramUser telegramUser = new TelegramUser();
        telegramUser.setChatId("1234567890");
        telegramUser.setActive(false);
        telegramUserRepository.save(telegramUser);

        // when
        Optional<TelegramUser> saved = telegramUserRepository.findByChatId(telegramUser.getChatId());

        // then
        Assertions.assertTrue((saved.isPresent()));
        Assertions.assertEquals(telegramUser, saved.get());
    }
}
