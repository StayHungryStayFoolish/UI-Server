package ink.bonismo.service.mapper;

import ink.bonismo.domain.Dictionary;
import ink.bonismo.service.dto.DictionaryDTO;
import org.mapstruct.Mapper;

/**
 * Created by bonismo@hotmail.com on 2019/3/20 12:01 PM
 *
 * @Description:
 * @Version: 1.0
 */
@Mapper(componentModel = "spring",uses = {})
public interface DictionaryMapper extends EntityMapper<DictionaryDTO, Dictionary> {

    default Dictionary fromId(Long id) {
        if (id == null) {
            return null;
        }
        Dictionary dictionary = new Dictionary();
        dictionary.setId(id);
        return dictionary;
    }
}
