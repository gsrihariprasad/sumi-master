package com.hcl.services;

import org.springframework.core.convert.converter.Converter;

import com.mongodb.DBObject;

public class DBObjectToStringConverter implements Converter<DBObject, String> {
	  public String convert(DBObject source) {
		    return source == null ? null : source.toString();
		  }
		}