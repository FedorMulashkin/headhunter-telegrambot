package ru.mulashkin.hhtb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mulashkin.hhtb.entity.TelegramUser;

import java.util.*;
/**
 * {@link Repository} for handling with {@link TelegramUser} entity.
 */
@Repository
public interface TelegramUserRepository extends JpaRepository<TelegramUser, String> {
    List<TelegramUser> findAllByActiveTrue();

    Optional<TelegramUser> findByChatId(String id);
}
