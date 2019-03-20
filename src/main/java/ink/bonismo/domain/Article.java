package ink.bonismo.domain;

import ink.bonismo.domain.enumeration.UIStatus;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by bonismo@hotmail.com on 2019/3/19 7:20 PM
 *
 * @Description:
 * @Version: 1.0
 */
@Data
@Entity
@Table(name = "article")
public class Article extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "dict_id", nullable = false)
    private Long dictId;

    @NotNull
    @Size(max = 32)
    @Column(name = "unique_id", length = 32, nullable = false)
    private String uniqueId;

    @NotNull
    @Size(max = 800)
    @Column(name = "title", length = 800, nullable = false)
    private String title;

    @NotNull
    @Lob
    @Column(name = "text", nullable = false)
    private String text;

    @NotNull
    @Size(max = 5)
    @Column(name = "language", length = 5, nullable = false)
    private String language;

    @Size(max = 800)
    @Column(name = "icon", length = 800)
    private String icon;

    @Size(max = 800)
    @Column(name = "thumbnail", length = 800)
    private String thumbnail;

    @Size(max = 800)
    @Column(name = "tag", length = 800)
    private String tag;

    @NotNull
    @Column(name = "ordinal", nullable = false)
    private Integer ordinal;

    @Lob
    @Column(name = "extension")
    private String extension;

    @Lob
    @Column(name = "description")
    private String description;

}
