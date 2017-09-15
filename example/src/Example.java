import java.util.HashMap;

import pfg.config.Config;
import pfg.config.ConfigInfo;

/*
 * Copyright (C) 2013-2017 Pierre-François Gimenez
 * Distributed under the MIT License.
 */

/**
 * An example of the config library usage
 * @author Pierre-François Gimenez
 *
 */

public class Example
{

	public static void main(String[] args)
	{		
		/*
		 * The config file is "config_example.ini"
		 */
		Config config = new Config(ConfigInfoExample.values(), "config_example.ini", true);
				
		/*
		 * There are several getters depending on the type of the variable
		 */
		double valDouble = config.getDouble(ConfigInfoExample.SOME_DOUBLE_VALUE);
		System.out.println("The double value hasn't been overridden : " + valDouble + " = " + ConfigInfoExample.SOME_DOUBLE_VALUE.getDefaultValue());

		String valString = config.getString(ConfigInfoExample.SOME_STRING_VALUE);
		System.out.println("The string value has been overridden with the config file : " + valString + " != " + ConfigInfoExample.SOME_STRING_VALUE.getDefaultValue());
		
		boolean valBool = config.getBoolean(ConfigInfoExample.SOME_BOOLEAN_VALUE);
		System.out.println("The boolean value has been overridden with the config file : " + valBool + " != " + ConfigInfoExample.SOME_BOOLEAN_VALUE.getDefaultValue());

		/*
		 * We override the value of "SOME_STRING_VALUE" with "override-value"
		 */
		HashMap<ConfigInfo, Object> override = new HashMap<ConfigInfo, Object>();
		override.put(ConfigInfoExample.SOME_STRING_VALUE, "override-value");
		config.override(override);
		
		String newValString = config.getString(ConfigInfoExample.SOME_STRING_VALUE);
		System.out.println("The string value has been overridden with the HashMap : " + newValString + " != " + valString);
		
	}

}
