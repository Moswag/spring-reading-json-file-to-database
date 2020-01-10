package zw.co.cytex.readjson.readjson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.cytex.readjson.readjson.model.MessageR;

import java.nio.file.LinkOption;



public interface MessageRRepository extends JpaRepository<MessageR, Long> {
}
