package ink.bonismo.domain;

import io.bonismo.UserProviderOuterClass;
import net.badata.protobuf.converter.annotation.ProtoClass;
import net.badata.protobuf.converter.annotation.ProtoField;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by bonismo@hotmail.com on 2019/3/21 4:53 PM
 *
 * @Description:
 * @Version: 1.0
 */
@ProtoClass(UserProviderOuterClass.UserVoReplay.class)
public class User implements Serializable {

    @ProtoField
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The user email
    @ProtoField
//    @NotNull
    private String email;

//     The user name
    @ProtoField
//    @NotNull
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
