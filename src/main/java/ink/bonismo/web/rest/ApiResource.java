package ink.bonismo.web.rest;

import ink.bonismo.domain.Dictionary;
import ink.bonismo.domain.enumeration.UIStatus;
import ink.bonismo.service.DictionaryService;
import ink.bonismo.service.dto.DictionaryDTO;
import ink.bonismo.service.mapper.DictionaryMapper;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by bonismo@hotmail.com on 2019/3/19 8:17 PM
 *
 * @Description:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api")
public class ApiResource {

    private final Environment environment;

    private final DictionaryMapper dictionaryMapper;

    private final DictionaryService dictionaryService;

    public ApiResource(Environment environment, DictionaryMapper dictionaryMapper, DictionaryService dictionaryService) {
        this.environment = environment;
        this.dictionaryMapper = dictionaryMapper;
        this.dictionaryService = dictionaryService;
    }


    @GetMapping("/test")
    public ResponseEntity<String> get() {
        String va = environment.getProperty("spring.liquibase.contexts");
        return ResponseEntity.ok().body(va);
    }

    @GetMapping("/dict")
    public ResponseEntity<List<DictionaryDTO>> saveDict() {
        List<DictionaryDTO> dtoList = new ArrayList<>();
        List<Dictionary> entityList = new ArrayList<>();
        Dictionary dictionary = new Dictionary();
        dictionary.setParent("root");
        dictionary.setName("about-us");
        String uuid = UUID.randomUUID().toString().replace("-", "");
        dictionary.setUuid(uuid);
        dictionary.setLanguage("zh-CN");
        dictionary.setOrdinal(999);
        dictionary.setStatus(UIStatus.PUBLISHED);
        for (int i = 0; i < 10; i++) {
            entityList.add(dictionary);
        }

        dtoList = dictionaryMapper.toDto(entityList);
        System.out.println(" ===== > " + dtoList);


        List<DictionaryDTO> result = new ArrayList<>();

        for (DictionaryDTO dto : dtoList) {
            DictionaryDTO newDTO = new DictionaryDTO();
            newDTO = dictionaryService.save(dto);
            result.add(newDTO);
        }
        System.out.println("RESULT ===== > " + result);

        return ResponseEntity.ok().body(result);
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.setStatus(UIStatus.PUBLISHED);
        System.out.println(dictionary.getStatus().name().length());
    }
}
