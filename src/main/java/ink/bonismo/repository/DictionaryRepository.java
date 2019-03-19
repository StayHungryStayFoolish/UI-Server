package ink.bonismo.repository;

import ink.bonismo.domain.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by bonismo@hotmail.com on 2019/3/19 8:51 PM
 *
 * @Description:
 * @Version: 1.0
 */
@Repository
public interface DictionaryRepository extends JpaRepository<Dictionary, Long> {

}
