package hello;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerBuilder;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;

public class MyBeanSerializerFactory extends BeanSerializerFactory {

	private Set<Class> classes = new HashSet<>();
	private Set<String> fieldsToIgnore = new HashSet<>();

	protected MyBeanSerializerFactory(SerializerFactoryConfig config) {
		super(config);
		// TODO Auto-generated constructor stub
	}
	
	public Set<Class> getClasses() {
		return classes;
	}

	public Set<String> getFieldsToIgnore() {
		return fieldsToIgnore;
	}

	@Override
	protected void processViews(SerializationConfig config, BeanSerializerBuilder builder) {
		super.processViews(config, builder);

		// ignore fields only for concrete class
		// note, that you can avoid or change this check
		if (classes.contains(builder.getBeanDescription().getBeanClass())) {
			// get original writer
			List<BeanPropertyWriter> originalWriters = builder.getProperties();

			// create actual writers
			List<BeanPropertyWriter> writers = new ArrayList<BeanPropertyWriter>();

			for (BeanPropertyWriter writer : originalWriters) {
				String propName = writer.getName();
				// if it isn't ignored field, add to actual writers list
				if (!fieldsToIgnore.contains(propName)) {
					writers.add(writer);
				}
			}

			builder.setProperties(writers);
		}

	}
}