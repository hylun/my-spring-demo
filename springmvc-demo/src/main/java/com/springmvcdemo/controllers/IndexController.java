package com.springmvcdemo.controllers;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springmvcdemo.entities.User;
import com.springmvcdemo.services.UserService;


@Controller
public class IndexController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService userService;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/userlist")
	public String list(@RequestParam(required=false,defaultValue="0")int page,Model model){
		model.addAttribute("users",userService.getList(page, 5));
		log.debug("list model{}",model);
		return "userlist";
	}
	
	@RequestMapping(value="useradd")
	public String useradd(@Valid User user,BindingResult result,ModelMap map,HttpServletRequest request){
		String page = "useradd";
		if(request.getMethod().equals("GET")) return page;
		log.debug("useradd post map{}",map);
		if(!result.hasErrors()){
			if(userService.addUser(user)){
				return "redirect:/userlist";
			}else{
				result.rejectValue("password", "","添加用户失败");
			}
		}
		log.debug("login post result{}",result);
		map.addAttribute("result", result);
		return page;
	}
	
	@RequestMapping("userdel/{id}")
	public String userdel(@PathVariable int id,HttpServletRequest request,RedirectAttributes attr){
		if(id==1)
			attr.addFlashAttribute("alertMsg", "此用户不允许删除");
		else if(userService.delUser(id)==0)
			attr.addFlashAttribute("alertMsg", "没有找到对应用户");
		else
			attr.addFlashAttribute("alertMsg", "删除成功");
		
		return "redirect:/userlist";
	}
	
	@RequestMapping("usermod/{id}")
	public String usermod(@PathVariable int id,@RequestParam(required=false) MultipartFile pic,ModelMap map){
		User user = userService.getUserById(id);
		if(user==null) return "redirect:/userlist";
		if (pic!=null && !pic.isEmpty()) {  
            try {  
                // 文件保存路径  
				File path = new File(servletContext.getRealPath("images/upload/"));
				if(!path.exists()) path.mkdirs();
                File file = new File(path.getAbsoluteFile(),pic.getOriginalFilename());
                log.debug("file:"+file.getAbsolutePath());
                // 转存文件  
                pic.transferTo(file); 
                user.setPic(pic.getOriginalFilename());
                userService.modUser(user);
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }
		map.addAttribute("user", user);
		return "usermod";
	}
}
