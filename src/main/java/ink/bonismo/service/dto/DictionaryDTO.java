package ink.bonismo.service.dto;

import ink.bonismo.domain.enumeration.UIStatus;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by bonismo@hotmail.com on 2019/3/20 12:02 PM
 *
 * @Description:
 * @Version: 1.0
 */
@Data
public class DictionaryDTO implements Serializable {

    private Long id;

    @NotNull
    private String parent;

    @NotNull
    private String name;

    @NotNull
    @Size(max = 32)
    private String uuid;

    @NotNull
    @Size(max = 5)
    private String language;

    @NotNull
    private UIStatus status;

    @Size(max = 800)
    private String icon;

    @Size(max = 800)
    private String url;

    @Size(max = 800)
    private String links;

    @NotNull
    private Integer ordinal;

    @Lob
    private String extension;

    @Lob
    private String description;
}
