package com.finex.cloudera.web;

import com.finex.cloudera.web.entity.User;
import com.finex.cloudera.web.serviceiml.UserServiceImp;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sound.midi.Soundbank;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CloudcombWebApplicationTests {

	@Autowired
	UserServiceImp userServiceImp;

	@Test
	public void contextLoads() {
/*
		User u=new User("lordorr","root");
		User user = userServiceImp.findUserByNameAndPwd(u);
		System.out.print(u.toString());*/
	}

}
