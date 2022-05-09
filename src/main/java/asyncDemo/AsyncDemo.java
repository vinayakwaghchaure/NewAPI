package asyncDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.asynchttpclient.Dsl;
import org.asynchttpclient.Response;

public class AsyncDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

	Future<Response> responseFuture=Dsl.asyncHttpClient().prepareGet("https://reqres.in/api/users?delay=3").execute();
	
	Response  response =responseFuture.get();
	
	System.out.println(response);
	
	System.out.println(response.getStatusCode());
	}

}
