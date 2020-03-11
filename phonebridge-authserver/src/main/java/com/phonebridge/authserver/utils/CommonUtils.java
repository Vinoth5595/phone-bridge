package com.phonebridge.authserver.utils;

import org.springframework.stereotype.Component;

/**
 * Phone Bridge User Management utility functions
 *
 * @author Vinoth Manoharan
 * @version 1.0
 * @since 06-March-2020
 */

@Component
public class CommonUtils {

	public static <T> boolean isBlankOrNull(T obj) {

		if (obj instanceof String) {
			String val = (String) obj;
			return val == null || (val!=null && val.trim().equals(""));
		}

		if (obj instanceof Integer) {
			int val = (Integer) obj;
			return val <= 0;
		}

		if (obj instanceof Float) {
			float val = (Float) obj;
			return val <= 0;
		}

		if (obj instanceof Double) {
			double val = (Double) obj;
			return val <= 0;
		}

		if (obj instanceof Long) {
			long val = (Long) obj;
			return val <= 0;
		}

		return obj == null;
	}

}
