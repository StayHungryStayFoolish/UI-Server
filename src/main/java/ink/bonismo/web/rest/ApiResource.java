package ink.bonismo.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bonismo@hotmail.com on 2019/3/19 8:17 PM
 *
 * @Description:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api")
public class ApiResource {

    @GetMapping("/test")
    public ResponseEntity<String> get() {
        return ResponseEntity.ok().body("Hello World !");
    }
}
