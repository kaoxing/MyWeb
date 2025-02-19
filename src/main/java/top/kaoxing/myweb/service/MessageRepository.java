package top.kaoxing.myweb.service;

import org.springframework.data.jpa.repository.JpaRepository;
import top.kaoxing.myweb.pojo.message.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
}