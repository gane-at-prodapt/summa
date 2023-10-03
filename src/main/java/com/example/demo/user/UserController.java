package com.example.demo.user;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class UserController {
	@RequestMapping("/hello")
    @ResponseBody
    public String helloWorld()
    {
        return "Hello World!";
    }
	
	@RequestMapping("/")
	@ResponseBody
	public String index() {
		return "firsteyyyy";
	}
	@RequestMapping("/zoro")
	@ResponseBody
	public String index1() {
		JSONObject obj = new JSONObject();
		obj.put("value", "one piece");
		return obj.toString();
	}
}
