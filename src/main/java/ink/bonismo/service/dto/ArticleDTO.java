package ink.bonismo.service.dto;

import lombok.Data;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by bonismo@hotmail.com on 2019/3/20 1:11 PM
 *
 * @Description:
 * @Version: 1.0
 */
@Data
public class ArticleDTO implements Serializable {

    private Long id;

    @NotNull
    private Long dictId;

    @NotNull
    @Size(max = 32)
    private String uniqueId;

    @NotNull
    @Size(max = 800)
    private String title;

    @NotNull
    @Lob
    private String text;

    @NotNull
    @Size(max = 5)
    private String language;

    @Size(max = 800)
    private String icon;

    @Size(max = 800)
    private String thumbnail;

    @Size(max = 800)
    private String tag;

    @NotNull
    private Integer ordinal;

    @Lob
    private String extension;

    @Lob
    private String description;
}
