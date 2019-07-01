package junit_test.tests;

import junit_test.tests.web.entity.TestEntity;
import junit_test.tests.web.repository.TestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class TestsApplicationTests {
    @Autowired
    private TestRepository testRepository;
    @Test
    public void book_save_test(){
        final TestEntity testEntity = new TestEntity("title",1000);
        final TestEntity saveEntity = testRepository.save(testEntity);
        assertThat(saveEntity.getId(),is(notNullValue()));

    }
    @Test
    public void book_save_and_find(){
        final TestEntity testEntity = new TestEntity("title",10000);
        final TestEntity saveTestEntity = testRepository.save(testEntity);
        final TestEntity findTestEntity = testRepository.findById(saveTestEntity.getId()).get();
        assertThat(findTestEntity.getId(),is(notNullValue()));
    }


}
