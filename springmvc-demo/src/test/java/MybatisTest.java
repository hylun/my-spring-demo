import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springmvcdemo.entities.User;
import com.springmvcdemo.mappers.UserMapper;


@RunWith(SpringJUnit4ClassRunner.class)//表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 

public class MybatisTest {
	
	@Resource(name="userMapper")  
    private UserMapper userMapper; 


	@Before  
	public void before() { 
	} 

	@Test  
	public void test1() {
		System.out.println(userMapper.selectByPrimaryKey(1));        
	} 
	
	@Test  
	public void test2() {
		User user = new User();
		user.setId(2);
		user.setUsername("user_2");
		user.setPassword("userpass2");
		System.out.println(userMapper.insert(user));        
	}
	
	@Test  
	public void test3() {
		System.out.println(userMapper.deleteByPrimaryKey(2));        
	}

}
