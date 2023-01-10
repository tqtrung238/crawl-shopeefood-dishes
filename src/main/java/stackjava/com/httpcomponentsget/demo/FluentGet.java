package stackjava.com.httpcomponentsget.demo;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;

public class FluentGet {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		Response response = Request.Get("https://www.google.com.vn/").execute();
		HttpResponse httpResponse = response.returnResponse();
		
		System.out.println("Protocol: " + httpResponse.getProtocolVersion());
		System.out.println("Status:" + httpResponse.getStatusLine().toString());
		System.out.println("Content type:" + httpResponse.getEntity().getContentType());
		System.out.println("Locale:" + httpResponse.getLocale());
		System.out.println("Headers:");
		for(Header header : httpResponse.getAllHeaders()) {
			System.out.println("          " + header.getName()+": " + header.getValue());
		}
		System.out.println("Content:");
		String content = IOUtils.toString(httpResponse.getEntity().getContent(), "UTF-8");
//		String content = response.returnContent().asString();
		System.out.println(content);
		
	}
}
