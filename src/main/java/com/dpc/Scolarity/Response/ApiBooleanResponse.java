package com.dpc.Scolarity.Response;

import java.util.Map;
import java.util.TreeMap;

public class ApiBooleanResponse {

	Map<String, Boolean> success;
	Map<String, Boolean> echec;
	
	public Map<String, Boolean> getSuccess() {
		Map<String, Boolean> success = new TreeMap<String, Boolean>();
		success.put("response", true);
		return success;
	}
	
	public Map<String, Boolean> getEchec() {
		Map<String, Boolean> echec = new TreeMap<String, Boolean>();
		echec.put("response", false);
		return echec;
	}
	
	
}
