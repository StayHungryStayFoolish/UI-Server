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

    private Boolean marry;

    private Integer age;

    private String birth;

    private double weight;

    private double height;
    private float finance;
    private double price;

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

    public Boolean getMarry() {
        return marry;
    }

    public void setMarry(Boolean marry) {
        this.marry = marry;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public float getFinance() {
        return finance;
    }

    public void setFinance(float finance) {
        this.finance = finance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", marry=" + marry +
                ", age=" + age +
                ", birth='" + birth + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", finance=" + finance +
                ", price=" + price +
                '}';
    }
}
