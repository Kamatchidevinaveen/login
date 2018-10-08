package com.someco.helloworld.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class EnumConvertor implements AttributeConverter<UserProfileType, String> {

	@Override
	public String convertToDatabaseColumn(UserProfileType userProfileType) {
		return userProfileType.getUserProfileType();
	}

	@Override
	public UserProfileType convertToEntityAttribute(String userProfileType) {
		return UserProfileType.valueOf(userProfileType);
	}

}
