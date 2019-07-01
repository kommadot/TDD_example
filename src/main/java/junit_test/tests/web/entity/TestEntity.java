package junit_test.tests.web.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "Test")
public class TestEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String title;

    @Column
    private double price;

    @Builder
    public TestEntity(String title,double price){
        this.title=title;
        this.price=price;
    }
}
