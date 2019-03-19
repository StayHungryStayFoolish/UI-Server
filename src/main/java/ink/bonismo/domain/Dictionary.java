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
@Table(name = "dictionary")
public class Dictionary extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "parent",nullable = false)
    private String parent;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Size(max = 32)
    @Column(name = "uuid", length = 32,nullable = false)
    private String uuid;

    @NotNull
    @Size(max = 5)
    @Column(name = "language",length = 5,nullable = false)
    private String language;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Size(max = 10)
    @Column(name = "status",length = 10,nullable = false)
    private UIStatus status;

    @Size(max = 800)
    @Column(name = "icon",length = 800)
    private String icon;

    @Size(max = 800)
    @Column(name = "url",length = 800)
    private String url;

    @Size(max = 800)
    @Column(name = "links",length = 800)
    private String links;

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
