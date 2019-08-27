package service;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class myservice {
	 public String say(String name){
	        return "Hello " + name + " , this is SayHelloService !" ;
	    }

	    public static void main(String[] args) {
	        Endpoint.publish("http://localhost:9091/Service/myservice", new myservice());
	        System.out.println("service success !");
	    }
}
