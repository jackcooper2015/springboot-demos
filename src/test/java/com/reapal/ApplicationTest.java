package com.reapal;

import com.reapal.dao.UserRepository;
import com.reapal.domain.User;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

/**
 * Application Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebAppConfiguration
public class ApplicationTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: main(String[] args)
     */
    @Test
    public void test() {
/*        User u = new User();
        u.setName("ccc");
        u.setPassword("ccc");
        u.setEmail("ccc@reapal.com");
        u.setCreateDateTime(new Date());
        u.setModifyDateTime(new Date());
        userRepository.save(u);*/

    }


} 
