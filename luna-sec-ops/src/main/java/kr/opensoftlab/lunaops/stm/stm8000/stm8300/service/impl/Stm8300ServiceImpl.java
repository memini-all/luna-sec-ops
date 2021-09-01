package kr.opensoftlab.lunaops.stm.stm8000.stm8300.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import kr.opensoftlab.lunaops.stm.stm8000.stm8300.service.Stm8300Service;



@Service("stm8300Service")
public class Stm8300ServiceImpl extends EgovAbstractServiceImpl implements Stm8300Service {

	
	@Resource(name = "stm8300DAO")
	private Stm8300DAO stm8300DAO;

	
	@SuppressWarnings( "rawtypes" )
	public List<Map> selectStm8300FileCodeAuthList(Map paramMap) throws Exception {
		return  stm8300DAO.selectStm8300FileCodeAuthList(paramMap);
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void insertStm8300FileCodeAuthList(Map paramMap) throws Exception {
		
		
		stm8300DAO.deleteStm8300FileCodeAuthInfo(paramMap);
		
		
    	JSONArray fileCodeList = new JSONArray(paramMap.get("fileCodeList").toString());
    	
    	
    	for(int i=0; i < fileCodeList.length(); i++){
    		
    		JSONObject jsonObj = fileCodeList.getJSONObject(i);
    		
    		
    		HashMap<String, Object> addStrgRepAuthInfoMap = new ObjectMapper().readValue(jsonObj.toString(), HashMap.class) ;
			
    		
    		addStrgRepAuthInfoMap.put("licGrpId", paramMap.get("licGrpId"));
    		addStrgRepAuthInfoMap.put("regUsrId", paramMap.get("regUsrId"));
    		addStrgRepAuthInfoMap.put("regUsrIp", paramMap.get("regUsrIp"));
    		addStrgRepAuthInfoMap.put("modifyUsrId", paramMap.get("modifyUsrId"));
    		addStrgRepAuthInfoMap.put("modifyUsrIp", paramMap.get("modifyUsrIp"));
    		
    		
			stm8300DAO.insertStm8300FileCodeAuthInfo(addStrgRepAuthInfoMap);
    	}
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void deleteStm8300FileCodeAuthList(Map paramMap) throws Exception {
		
		
    	JSONArray fileCodeList = new JSONArray(paramMap.get("fileCodeList").toString());
    	
    	
    	for(int i=0; i < fileCodeList.length(); i++){
    		
    		JSONObject jsonObj = fileCodeList.getJSONObject(i);
    		
    		
    		HashMap<String, Object> addStrgRepAuthInfoMap = new ObjectMapper().readValue(jsonObj.toString(), HashMap.class) ;
    		addStrgRepAuthInfoMap.put("licGrpId", paramMap.get("licGrpId"));
    		
			stm8300DAO.deleteStm8300FileCodeAuthInfo(addStrgRepAuthInfoMap);
    	}
	}
}