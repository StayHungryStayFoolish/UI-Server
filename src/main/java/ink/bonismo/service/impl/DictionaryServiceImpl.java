package ink.bonismo.service.impl;

import ink.bonismo.domain.Dictionary;
import ink.bonismo.repository.DictionaryRepository;
import ink.bonismo.service.DictionaryService;
import ink.bonismo.service.dto.DictionaryDTO;
import ink.bonismo.service.mapper.DictionaryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by bonismo@hotmail.com on 2019/3/19 8:49 PM
 *
 * @Description:
 * @Version: 1.0
 */
@Service
@Transactional
public class DictionaryServiceImpl implements DictionaryService {

    private final Logger logger = LoggerFactory.getLogger(DictionaryServiceImpl.class);

    private final DictionaryMapper dictionaryMapper;

    private final DictionaryRepository dictionaryRepository;

    public DictionaryServiceImpl(DictionaryMapper dictionaryMapper, DictionaryRepository dictionaryRepository) {
        this.dictionaryMapper = dictionaryMapper;
        this.dictionaryRepository = dictionaryRepository;
    }

    @Override
    public DictionaryDTO save(DictionaryDTO dictionaryDTO) {
        logger.debug("Request to save Dictionary : {}", dictionaryDTO);
        Dictionary dictionary = dictionaryMapper.toEntity(dictionaryDTO);
        dictionary = dictionaryRepository.save(dictionary);
        return dictionaryMapper.toDto(dictionary);
    }
}
