package com.baidu.ueditor.upload;

import com.baidu.ueditor.PathFormat;
import com.baidu.ueditor.define.AppInfo;
import com.baidu.ueditor.define.BaseState;
import com.baidu.ueditor.define.FileType;
import com.baidu.ueditor.define.State;
import com.ldb.utils.QiNiuUploadUtil;
import org.apache.commons.codec.binary.Base64;

import java.util.Map;

public final class Base64Uploader {

	public static State save(String content, Map<String, Object> conf) {
		
		byte[] data = decode(content);

		long maxSize = ((Long) conf.get("maxSize")).longValue();
		if(data.length>maxSize){
			return new BaseState(false, AppInfo.MAX_SIZE);
		}

		if (!validSize(data, maxSize)) {
			return new BaseState(false, AppInfo.MAX_SIZE);
		}

		String suffix = FileType.getSuffix("JPG");

		String savePath = PathFormat.parse((String) conf.get("savePath"),
				(String) conf.get("filename"));
		
		savePath = savePath + suffix;
		//String physicalPath = (String) conf.get("rootPath") + savePath;

		boolean result= QiNiuUploadUtil.upload(data,savePath);
		if(result){
			State storageState=new BaseState();
			storageState.putInfo("url", PathFormat.format(savePath));
			storageState.putInfo("type", suffix);
			storageState.putInfo("original", "");
			return storageState;
		}else{
			return new BaseState(false, AppInfo.NOT_ALLOW_FILE_TYPE);
		}


	}

	private static byte[] decode(String content) {
		return Base64.decodeBase64(content);
	}

	private static boolean validSize(byte[] data, long length) {
		return data.length <= length;
	}
	
}