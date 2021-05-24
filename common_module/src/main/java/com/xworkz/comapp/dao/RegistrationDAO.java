package com.xworkz.comapp.dao;

import com.xworkz.comapp.entity.RegistrationEntity;

public interface RegistrationDAO {

	public Integer save(RegistrationEntity entity);

	public RegistrationEntity getByEmailId(String emailId);
}
