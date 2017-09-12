package com.core;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

public class XMLSchemaOutputResolver extends SchemaOutputResolver {
	
	private StringWriter stringWriter = new StringWriter();    

    public Result createOutput(String namespaceURI, String suggestedFileName) throws IOException  {
        StreamResult result = new StreamResult(stringWriter);
        result.setSystemId(suggestedFileName);
        return result;
    }

    public String getSchema() {
        return stringWriter.toString();
    }

}
