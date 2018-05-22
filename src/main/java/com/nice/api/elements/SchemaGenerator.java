package com.nice.api.elements;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nice.api.annotations.Schema;
import com.nice.model.Model;

public class SchemaGenerator  {

	String dataType, format;

	String[] enumValues;

	int maxLength;

	Schema schemaObj;

	Map<String, Object> enumProperties = new HashMap<String, Object>();

	List<Map<String, String>> staticEnumList = new ArrayList<Map<String, String>>();

	Map<String,String> staticEnumMap = new HashMap<String, String>();

//	@Autowired
//	private ApplicationContext appContext;

	private Map<String,Object> fieldMap = new HashMap<String,Object>();
	private Map<String,Object> propertyMap = new HashMap<String,Object>();
	private String delimiterAdder="",baseClass;
//	private List<Object[]> propertyValuesList = null;	

//	@PersistenceContext
//	private EntityManager em; 
//
//	private AtomicReference<Repository<?, ?>> repository = new AtomicReference<Repository<?, ?>>();

	public <ModelImpl>Map<String,Object> SchemaGeneratorHandler(Class<ModelImpl> className, String capturedClassName) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		List<String> requiredList = new ArrayList<String>();
		Field[] fields = className.getDeclaredFields();
		

		for (Field field : fields) {

			HashMap<String,Object> schemaMap=new HashMap<String,Object>();

			if (Model.class.isAssignableFrom(field.getType())) {
				if(!capturedClassName.isEmpty()||(!capturedClassName.equals(""))){
					delimiterAdder = capturedClassName;
				}
				else{
					baseClass = className.getSimpleName().toLowerCase()+":";
				}
				capturedClassName = delimiterAdder + field.getType().getSimpleName().toLowerCase()+":";

				SchemaGeneratorHandler(field.getType(), capturedClassName);
				capturedClassName=field.getDeclaringClass().getSimpleName().toLowerCase().toString()+":";

			}
			else{
				if (field.isAnnotationPresent(Schema.class)) {

					schemaObj = field.getAnnotation(Schema.class);
					if(((schemaObj.format() == null) || schemaObj.format().isEmpty())&&(schemaObj.enums()!=true)){
						setMaxLengthSchema(schemaObj, schemaMap, capturedClassName, field, requiredList);
					}
//					else if(schemaObj.enums()==true && schemaObj.repoName()!=void.class){
//						setEnums(field,schemaMap, requiredList);
//					}
					else if(schemaObj.enums()==true && schemaObj.enumValues()!=null && schemaObj.repoName() == void.class){
						setStaticEnums(field,schemaMap, requiredList);
					}
					else{
						setDateFormat(field, schemaMap, capturedClassName, requiredList);						
					}
				}
				else {
					setDefaultSchema(field,schemaMap);
				}			
			}
		}
		capturedClassName="";	
		return propertyMap;
	}
	private void setMaxLengthSchema(Schema schemaObj, Map<String,Object> schemaMap,String capturedClassName, Field field, List<String> requiredList ){
		dataType = schemaObj.dataType();
		maxLength = schemaObj.maxLength();

		schemaMap.put("type", dataType);
		schemaMap.put("maxLength", maxLength);
		if(baseClass !=null){ 
			if((baseClass).equals(capturedClassName)){
				fieldMap.put(field.getName(), schemaMap);
			}}else{
				fieldMap.put(capturedClassName+field.getName(), schemaMap);
			}
		if(schemaObj.required()==true){
			requiredList.add(field.getName().toString());
		}
		propertyMap.put("properties", fieldMap);
		propertyMap.put("required",requiredList);

	}
//	@SuppressWarnings("unchecked")
//	private void setEnums(Field field,Map<String,Object> schemaMap, List<String> requiredList) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
//		try{
//			enumProperties = (Map<String, Object>)appContext.getBean("EnumMappings");
//		}catch(BeansException ex){
//			enumProperties = new HashMap<String, Object>();
//		}
//		String key = null;
//		String value = null;
//		Method method = null;
//		Class<Repository<?, ?>> repoName =  (Class<Repository<?, ?>>)schemaObj.repoName();
//		dataType = schemaObj.dataType();
//		if(enumProperties.containsKey(field.getName().toUpperCase())){
//			method = repoName.getDeclaredMethod("getEnums",String.class);
//		}else{
//			method = repoName.getDeclaredMethod("getEnums");
//		}
//		Map<String,String> enumMap = new HashMap<String, String>();
//		ArrayList<Map<String, String>> enumList = new ArrayList<Map<String, String>>();
//
//		if(method!=null){
//			if (repository.get() == null) { 
//				synchronized (this) { 
//					if (repository.get() == null) { 
//						repository.set(new MongoRepositoryFactory(em).getRepository(repoName)); 
//						if(enumProperties.containsKey(field.getName().toUpperCase())){
//							propertyValuesList = (List<Object[]>)method.invoke(repository.get(),enumProperties.get(field.getName().toUpperCase()));
//						}
//						else
//						{
//							propertyValuesList = (List<Object[]>)method.invoke(repository.get());
//						}
//					} 
//				} 
//			} 
//		}
//		for(Object[] enumObject : propertyValuesList){
//			key =  enumObject[0].toString();
//			value =  enumObject[1].toString();
//			if(key!= null && value != null){
//				if(value.trim().isEmpty()) {
//					enumMap.put(key.trim(), key.trim());
//				}else {
//					enumMap.put(key.trim(), value.trim());
//				}
//			}
//		}
//		enumList.add(enumMap);
//
//		schemaMap.put("enum", enumList);
//		schemaMap.put("type", dataType);
//
//		if(schemaObj.required()==true){
//			requiredList.add(field.getName().toString());
//		}
//		fieldMap.put(field.getName(), schemaMap);
//		propertyMap.put("properties", fieldMap);
//		repository = new AtomicReference<Repository<?, ?>>();
//
//	}
	private void setStaticEnums(Field field, Map<String, Object> schemaMap, List<String> requiredList){
		dataType = schemaObj.dataType();
		enumValues = schemaObj.enumValues();


		for(String enumString : enumValues)
		{
			staticEnumMap.put(enumString, enumString);
		}
		staticEnumList.add(staticEnumMap);

		schemaMap.put("type", dataType);
		schemaMap.put("enum", staticEnumList);

		if(schemaObj.required()==true){
			requiredList.add(field.getName().toString());
		}
		fieldMap.put(field.getName(), schemaMap);
		propertyMap.put("properties", fieldMap);
	}
	private void setDateFormat(Field field, Map<String, Object> schemaMap,String capturedClassName, List<String> requiredList){
		format = schemaObj.format();
		dataType = schemaObj.dataType();

		schemaMap.put("format", format);
		schemaMap.put("type", dataType);
		if(baseClass !=null){ 
			if((baseClass).equals(capturedClassName)){
				fieldMap.put(field.getName(), schemaMap);
			}
		}else{
			fieldMap.put(capturedClassName+field.getName(), schemaMap);
		}
		if(schemaObj.required()==true){
			requiredList.add(field.getName().toString());
		}
		propertyMap.put("properties", fieldMap);
		propertyMap.put("required",requiredList);
	}
	private void setDefaultSchema(Field field, Map<String, Object> schemaMap){

		dataType = field.getType().getSimpleName().toLowerCase();
		schemaMap.put("type", dataType);

		fieldMap.put(field.getName(), schemaMap);
		propertyMap.put("properties", fieldMap);
	}
}
