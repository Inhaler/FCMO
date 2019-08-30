package context;

import helpers.XMLHelper;

public class ContextManager {

	public static void putObject(){
        XMLHelper.preObjects.add(new PreObjects(XMLHelper.object));
    }
}
