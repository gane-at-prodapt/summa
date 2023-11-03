package com.example.demo.access;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.example.demo.role.Role;
import com.example.demo.role.RoleRepository;

import jakarta.transaction.Transactional;

import com.example.demo.module.Module;
import com.example.demo.module.ModuleRepository;

@Configuration
public class AccessConfig {
	
	private static String roles[]= {"Super Admin", "Network Admin","Network Engineer","Support Analyst","Observer"};
	private static String modules[] = {"Network", "Component", "Incident", "Group","Issue","Role","User", "Module"};
	
	@Bean("Access")
	CommandLineRunner commandlinerunner(
			AccessRepository repo, RoleRepository Rrepo, ModuleRepository Mrepo)
	{
		return args ->
		{

			Role R1 = Rrepo.getById(1);
			Role R2 = Rrepo.getById(2);
			Role R3 = Rrepo.getById(3);
			Role R4 = Rrepo.getById(4);
			Role R5 = Rrepo.getById(5);
			
			Module M1 = Mrepo.getById(1);
			Module M2 = Mrepo.getById(2);
			Module M3 = Mrepo.getById(3);
			Module M4 = Mrepo.getById(4);
			Module M5 = Mrepo.getById(5);
			Module M6 = Mrepo.getById(6);
			Module M7 = Mrepo.getById(7);
        	Module M8 = Mrepo.getById(8);
			
			// Super Admin Access
			Access A11 = new Access();
			A11.setRole(R1);
			A11.setModule(M1);
			A11.setStatus("write");
			A11.setModifiedOn(System.currentTimeMillis()/1000);
			
			
			Access A12= new Access();
			A12.setRole(R1);
			A12.setModule(M2);
			A12.setStatus("write");
			A12.setModifiedOn(System.currentTimeMillis()/1000);
			
			
			Access A13= new Access();
			A13.setRole(R1);
			A13.setModule(M3);
			A13.setStatus("write");
			A13.setModifiedOn(System.currentTimeMillis()/1000);
			
			Access A14= new Access();
			A14.setRole(R1);
			A14.setModule(M4);
			A14.setStatus("write");
			A14.setModifiedOn(System.currentTimeMillis()/1000);
			
		
			Access A15= new Access();
			A15.setRole(R1);
			A15.setModule(M5);
			A15.setStatus("write");
			A15.setModifiedOn(System.currentTimeMillis()/1000);
			
			
			Access A16= new Access();
			A16.setRole(R1);
			A16.setModule(M6);
			A16.setStatus("write");
			A16.setModifiedOn(System.currentTimeMillis()/1000);
			
			
			Access A17= new Access();
			A17.setRole(R1);
			A17.setModule(M7);
			A17.setStatus("write");
			A17.setModifiedOn(System.currentTimeMillis()/1000);
			
			Access A18= new Access();
			A18.setRole(R1);
			A18.setModule(M8);
			A18.setStatus("write");
			A18.setModifiedOn(System.currentTimeMillis()/1000);
			
			//Network Admin Access
			
			Access A21 = new Access();
			A21.setRole(R2);
			A21.setModule(M1);
			A21.setStatus("write");
			A21.setModifiedOn(System.currentTimeMillis()/1000);
			
			
			Access A22= new Access();
			A22.setRole(R2);
			A22.setModule(M2);
			A22.setStatus("write");
			A22.setModifiedOn(System.currentTimeMillis()/1000);
			
			
			Access A23= new Access();
			A23.setRole(R2);
			A23.setModule(M3);
			A23.setStatus("write");
			A23.setModifiedOn(System.currentTimeMillis()/1000);
			
			Access A24= new Access();
			A24.setRole(R2);
			A24.setModule(M4);
			A24.setStatus("write");
			A24.setModifiedOn(System.currentTimeMillis()/1000);
			
		
			Access A25= new Access();
			A25.setRole(R2);
			A25.setModule(M5);
			A25.setStatus("write");
			A25.setModifiedOn(System.currentTimeMillis()/1000);
			
			
			Access A26= new Access();
			A26.setRole(R2);
			A26.setModule(M6);
			A26.setStatus("read");
			A26.setModifiedOn(System.currentTimeMillis()/1000);
			
			
			Access A27= new Access();
			A27.setRole(R2);
			A27.setModule(M7);
			A27.setStatus("read");
			A27.setModifiedOn(System.currentTimeMillis()/1000);
			
			Access A28= new Access();
			A28.setRole(R2);
			A28.setModule(M8);
			A28.setStatus("read");
			A28.setModifiedOn(System.currentTimeMillis()/1000);
			
			// Network Engineer
			
			
			Access A31 = new Access();
			A31.setRole(R3);
			A31.setModule(M1);
			A31.setStatus("read");
			A31.setModifiedOn(System.currentTimeMillis()/1000);
			
			
			Access A32= new Access();
			A32.setRole(R3);
			A32.setModule(M2);
			A32.setStatus("read");
			A32.setModifiedOn(System.currentTimeMillis()/1000);
			
			
			Access A33= new Access();
			A33.setRole(R3);
			A33.setModule(M3);
			A33.setStatus("write");
			A33.setModifiedOn(System.currentTimeMillis()/1000);
			
			Access A34= new Access();
			A34.setRole(R3);
			A34.setModule(M4);
			A34.setStatus("read");
			A34.setModifiedOn(System.currentTimeMillis()/1000);
			
		
			Access A35= new Access();
			A35.setRole(R3);
			A35.setModule(M5);
			A35.setStatus("read");
			A35.setModifiedOn(System.currentTimeMillis()/1000);
			
			
			Access A36= new Access();
			A36.setRole(R3);
			A36.setModule(M6);
			A36.setStatus("read");
			A36.setModifiedOn(System.currentTimeMillis()/1000);
			
			
			Access A37= new Access();
			A37.setRole(R3);
			A37.setModule(M7);
			A37.setStatus("read");
			A37.setModifiedOn(System.currentTimeMillis()/1000);
			
			Access A38= new Access();
			A38.setRole(R3);
			A38.setModule(M8);
			A38.setStatus("read");
			A38.setModifiedOn(System.currentTimeMillis()/1000);
			
			
			//Support Analyst
			

			
			Access A41 = new Access();
			A41.setRole(R4);
			A41.setModule(M1);
			A41.setStatus("read");
			A41.setModifiedOn(System.currentTimeMillis()/1000);
			
			
			Access A42= new Access();
			A42.setRole(R4);
			A42.setModule(M2);
			A42.setStatus("read");
			A42.setModifiedOn(System.currentTimeMillis()/1000);
			
			
			Access A43= new Access();
			A43.setRole(R4);
			A43.setModule(M3);
			A43.setStatus("write");
			A43.setModifiedOn(System.currentTimeMillis()/1000);
			
			Access A44= new Access();
			A44.setRole(R4);
			A44.setModule(M4);
			A44.setStatus("read");
			A44.setModifiedOn(System.currentTimeMillis()/1000);
			
		
			Access A45= new Access();
			A45.setRole(R4);
			A45.setModule(M5);
			A45.setStatus("read");
			A45.setModifiedOn(System.currentTimeMillis()/1000);
			
			
			Access A46= new Access();
			A46.setRole(R4);
			A46.setModule(M6);
			A46.setStatus("read");
			A46.setModifiedOn(System.currentTimeMillis()/1000);
			
			
			Access A47= new Access();
			A47.setRole(R4);
			A47.setModule(M7);
			A47.setStatus("read");
			A47.setModifiedOn(System.currentTimeMillis()/1000);
			
			Access A48= new Access();
			A48.setRole(R4);
			A48.setModule(M8);
			A48.setStatus("read");
			A48.setModifiedOn(System.currentTimeMillis()/1000);
			
			
			
			// Observer
			
			

			Access A51 = new Access();
			A51.setRole(R5);
			A51.setModule(M1);
			A51.setStatus("read");
			A51.setModifiedOn(System.currentTimeMillis()/1000);
			
			
			Access A52= new Access();
			A52.setRole(R5);
			A52.setModule(M2);
			A52.setStatus("read");
			A52.setModifiedOn(System.currentTimeMillis()/1000);
			
			
			Access A53= new Access();
			A53.setRole(R5);
			A53.setModule(M3);
			A53.setStatus("read");
			A53.setModifiedOn(System.currentTimeMillis()/1000);
			
			Access A54= new Access();
			A54.setRole(R5);
			A54.setModule(M4);
			A54.setStatus("read");
			A54.setModifiedOn(System.currentTimeMillis()/1000);
			
		
			Access A55= new Access();
			A55.setRole(R5);
			A55.setModule(M5);
			A55.setStatus("read");
			A55.setModifiedOn(System.currentTimeMillis()/1000);
			
			
			Access A56= new Access();
			A56.setRole(R5);
			A56.setModule(M6);
			A56.setStatus("read");
			A56.setModifiedOn(System.currentTimeMillis()/1000);
			
			
			Access A57= new Access();
			A57.setRole(R5);
			A57.setModule(M7);
			A57.setStatus("read");
			A57.setModifiedOn(System.currentTimeMillis()/1000);
			
			Access A58= new Access();
			A58.setRole(R5);
			A58.setModule(M8);
			A58.setStatus("read");
			A58.setModifiedOn(System.currentTimeMillis()/1000);
			
			
			
			
			
			
			
			repo.saveAll(List.of(
					A11,A12,A13,A14,A15,A16,A17,A18,A21,A22,A23,A24,A25,A26,A27,A28,
					A31,A32,A33,A34,A35,A36,A37,A38,A41,A42,A43,A44,A45,A46,A47,A48,
					A51,A52,A53,A54,A55,A56,A57,A58
					));
			
		};
	}
	
	

}
