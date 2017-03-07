package com.springmvcdemo.services;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springmvcdemo.entities.User;
import com.springmvcdemo.mappers.UserMapper;

@Service
public class UserService {
	
	@Resource 
    private UserMapper userMapper; 
	
	public User getUserById(int userId) {  
        return this.userMapper.selectByPrimaryKey(userId);  
    }
    
    public boolean addUser(User user){
    	user.setPassword(md5(user.getPassword()));
		return userMapper.insert(user)==1;
    }
    
    public int delUser(int id){
    	return userMapper.deleteByPrimaryKey(id);
    }
    
    public boolean modUser(User user){
    	return userMapper.updateByPrimaryKey(user)==1;
    }
	
	public Map<String,Object> getList(int page,int limit){
    	if(limit<1) return null;
    	int start = (page-1)*limit;
    	int total = this.userMapper.getCount();
    	if(start<0 || start>=total) start = 0;
    	Map<String,Object> map= new HashMap<String,Object>();   	
    	map.put("limit", limit);
    	map.put("total", total);
    	map.put("list", this.userMapper.getList(start,limit));
    	return map;
    }
	
	/**
	 * 对字符串md5加密
	 *
	 * @param str
	 * @return
	 */
	public static String md5(String str) {
	    try {
	        // 生成一个MD5加密计算摘要
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        // 计算md5函数
	        md.update(str.getBytes());
	        // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
	        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
	        return new BigInteger(1, md.digest()).toString(16);
	    } catch (Exception e) {
	        return null;//"MD5加密出现错误";
	    }
	}

}
