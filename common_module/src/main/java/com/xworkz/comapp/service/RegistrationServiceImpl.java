package com.xworkz.comapp.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.comapp.dao.RegistrationDAO;
import com.xworkz.comapp.dto.RegistrationDTO;
import com.xworkz.comapp.entity.RegistrationEntity;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	private Logger logger;

	@Autowired
	private RegistrationDAO dao;

	public RegistrationServiceImpl() {
		logger = Logger.getLogger(getClass());
	}

	@Override
	public String validateAndSave(RegistrationDTO dto) {
		logger.info("inside {} ");
		RegistrationEntity entity = new RegistrationEntity();
		try {
			RegistrationEntity edEntity = dao.getByEmailId(dto.getEmailId());
			if (edEntity == null) {
				BeanUtils.copyProperties(dto, entity);
				entity.setRegisteredBy("Varsha");
				LocalDateTime ldate = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
				String date = formatter.format(ldate);
				entity.setRegisteredDate(date);
				int affectedRows = dao.save(entity);
				if (affectedRows > 0) {
					logger.info("Successfully registered");
					return "Successfully registered ";
				} else {
					logger.info("Registration failed");
					return "Registration failed ";
				}
			} else {
				logger.info("User already exist");
				return "User already exist ";
			}
		} catch (Exception e) {
			logger.error("Exception occurred in {} " + e.getMessage(), e);
		}
		return "";
	}

}
