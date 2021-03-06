package zhumeng.com.uimei.kafka.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Title: SerializationBeanUtils.java
 * @Package zhumeng.com.uimei.interfaces.kafka.serialization
 * @Description: TODO(用一句话描述该文件做什么)
 * @author z
 * @date 2018年7月2日
 * @version V1.0
 */
public class SerializationBeanUtils {

	/**
	 * @Description: TODO
	 * @param        @param data
	 * @param        @return    
	 * @return       byte [] 
	 * @throws
	 * @author       z
	 * @datetime     2018年7月2日下午2:46:52
	*/
	public static byte[] bean2Byte(Object obj) {
		
		byte[] bb = null;
		try (ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
			 ObjectOutputStream outputStream = new ObjectOutputStream(byteArray)){
			outputStream.writeObject(obj);
			outputStream.flush();
			bb = byteArray.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bb;
	}

	/**
	 * @Description: TODO
	 * @param        @param data
	 * @param        @return    
	 * @return       Object 
	 * @throws
	 * @author       z
	 * @datetime     2018年7月2日下午2:49:26
	*/
	public static Object byte2Obj(byte[] bytes) {
		Object readObject = null;
		try (ByteArrayInputStream in = new ByteArrayInputStream(bytes);
			 ObjectInputStream inputStream = new ObjectInputStream(in)){
			 readObject = inputStream.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return readObject; 

	}

	
}
