package ink.bonismo.web.rest;

import ink.bonismo.domain.Dictionary;
import ink.bonismo.domain.User;
import ink.bonismo.domain.enumeration.UIStatus;
import ink.bonismo.service.DictionaryService;
import ink.bonismo.service.dto.DictionaryDTO;
import ink.bonismo.service.mapper.DictionaryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
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

    private Logger logger = LoggerFactory.getLogger(ApiResource.class);

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
        long t1 = 1553243668457L;
        long t2 = 1553243668479L;

        long t3 = 1553243669903L;
        long t4 = 1553243669928L;


        Calendar c=Calendar.getInstance();
        c.setTimeInMillis(t2-t1);

        System.out.println("耗时: " + c.get(Calendar.MINUTE) + "分 " + c.get(Calendar.SECOND) + "秒 " + c.get(Calendar.MILLISECOND) + " 微秒");
    }
}
