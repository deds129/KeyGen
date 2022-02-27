package com.nchudinov.keygen.model;

import java.util.ArrayList;
import java.util.List;

public enum OperSystems {
	WIN("Winsows"),
	LIN("LINUX"),
	BSD("FreeBSD"),
	SOLARIS("SOLARIS"),
	MAC_OS("MacOS");


	private String title;

	OperSystems(String keyTypeName) {
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
		for (OperSystems curr : OperSystems.values()) {
			licenseKeyTittles.add(curr.getTitle());
		}
		return licenseKeyTittles;
	}

	public static OperSystems parseTitle(String title) {
		OperSystems returned = null;
		for (OperSystems curr : OperSystems.values()) {
			if (curr.title.equalsIgnoreCase(title)) {
				returned = curr;
				break;
			}
		}
		return returned;
	}
}
