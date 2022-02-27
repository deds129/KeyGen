package com.nchudinov.keygen.model;

import java.util.ArrayList;
import java.util.List;

public enum LicenseKeyTypes {
	TEMP("Temporary"),
	PERM("Permanent"),
	DEV("Development"),
	TRIAL("Trial");


	private String title;

	LicenseKeyTypes(String keyTypeName) {
		this.title = keyTypeName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public static List<String> getAllTitles() {
		List<String> licenseKeyTittles = new ArrayList<>();
		for (LicenseKeyTypes curr : LicenseKeyTypes.values()) {
			licenseKeyTittles.add(curr.getTitle());
		}
		return licenseKeyTittles;
	}

	public static LicenseKeyTypes parseTitle(String title) {
		LicenseKeyTypes returned = null;
		for (LicenseKeyTypes curr : LicenseKeyTypes.values()) {
			if (curr.title.equalsIgnoreCase(title)) {
				returned = curr;
				break;
			}
		}
		return returned;
	}
}
