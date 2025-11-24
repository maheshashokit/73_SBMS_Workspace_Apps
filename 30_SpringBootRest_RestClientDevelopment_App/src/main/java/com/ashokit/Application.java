package com.ashokit;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private RestTemplate restTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	public void run(String... args) throws Exception {
		
		//getRequestByHttpClient();
		
		//postRequestByHttpClient();
		
		//getRequestWithOutPathVariableByRestTemplate();

		//getRequestWithPathVariableByRestTemplate();
		
		//getRequestWithTwoPathVariableByRestTemplate();
		
		//getRequestWithExchange();
		
		//getRequestWithPathVariableUsingExchange();
		
		//postRequestByRestTemplate();
		
		//postRequestWithExchange();
		
	    //getRequestWithWebClient();
		
		postRequestWithWebClient();
	     
	}
	
	public void postRequestWithWebClient() throws Exception{
		
		PersonDTO dto = new PersonDTO("Test-5","Delhi","test-5@ashokit.com","ABC Street");
	    
	    //converting the Java Object into JSON
	   	ObjectMapper objectMapper = new ObjectMapper();
    	String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto);
    	System.out.println("JSON String::::" + jsonString);
	    	
		//creating webclient with BaseURI....
		WebClient webClient = WebClient.create();
		
		Mono<String> apiResponse = webClient.post()
				 .uri(new URI("http://localhost:8899/api/persons/"))
				 .contentType(MediaType.APPLICATION_JSON)
				 //.header("Content-Type", "application/json")
				 .bodyValue(jsonString)
				 .accept(MediaType.APPLICATION_JSON)
				 .retrieve()
				 .bodyToMono(String.class);
		
		System.out.println("POST API Response:::" + apiResponse);
		//apiResponse.subscribe(str -> System.out.println("PostAPI Response::::" + str));
		apiResponse.subscribe(Application :: responseHandling);
	}
	
	public void getRequestWithWebClient() throws Exception {
		
		//Creating the WebClient
		WebClient webClient = WebClient.create();
		
		//Defining the endpoint URL
		String endPointURL = "http://localhost:8899/api/login/";
		System.out.println("1111" + Thread.currentThread().getName());
		/*String responseMessage = webClient.get() //This is for testing Get Request API
		         			     .uri(new URI(endPointURL)) //This for defining the REST API URL
		                         .retrieve() //This for retrieving API Response Body
		                         .bodyToMono(String.class)//Defining Response Type
		                         .block();//It will block thread until we got response from Rest API
		
		System.out.println("API Response::::::" +responseMessage);*/
		
		 webClient.get()
                  .uri(new URI(endPointURL))
                  .retrieve()
                  .bodyToMono(String.class)
                  .subscribe(Application :: responseHandling);
		
		/*
		 	 Mono<ResponseEntity<Person>> entityMono = client.get()
				     .uri("/persons/1")
				     .accept(MediaType.APPLICATION_JSON)
				     .retrieve()
				     .toEntity(Person.class);
		     Mono<Person> entityMono = client.get()
				     .uri("/persons/1")
				     .accept(MediaType.APPLICATION_JSON)
				     .retrieve()
				     .bodyToMono(Person.class);
	    */
	}
	
	
	public void postRequestWithExchange() throws Exception {
		//Preparing PersonDTO object for Request Body
		PersonDTO person = new PersonDTO("Suman", "Mumbai", "Suman@gmail.com", "XYZ Street");
		
		//Creating ObjectMapper object
		ObjectMapper mapper = new ObjectMapper();
		
		//Converting the JavaObject into JSON String
		String requestBody = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
		
		System.out.println("Request Body:::"+ requestBody);
		
		//Preparing HttpHeaders 
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(List.of(MediaType.APPLICATION_JSON));
		
		//Preparing HttpRequest with Headers,Payload
		HttpEntity<String> httpEntity = new HttpEntity<>(requestBody,headers);
		
		//calling for PostEntity
		ResponseEntity<String> postResponse = 
		restTemplate.exchange("http://localhost:8899/api/persons/",
							  HttpMethod.POST,
							  httpEntity,
							  String.class);
		
		if(postResponse.getStatusCode() == HttpStatus.CREATED) {
			String responseBody = postResponse.getBody();
			System.out.println(responseBody);
		}
	}
	
	public void postRequestByRestTemplate() throws Exception{
		//Preparing PersonDTO object for Request Body
		PersonDTO person = new PersonDTO("UdayKiran", "Mumbai", "Udaykiran@gmail.com", "XYZ Street");
		
		//Creating ObjectMapper object
		ObjectMapper mapper = new ObjectMapper();
		
		//Converting the JavaObject into JSON String
		String requestBody = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
		
		System.out.println("Request Body:::"+ requestBody);
		
		//Preparing HttpHeaders 
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(List.of(MediaType.APPLICATION_JSON));
		
		//Preparing HttpEntity with Headers,Payload
		HttpEntity<String> httpEntity = new HttpEntity<>(requestBody,headers);
		
		//calling for PostEntity
		ResponseEntity<String> postResponse = restTemplate.postForEntity("http://localhost:8899/api/persons/", httpEntity, String.class);
		
		if(postResponse.getStatusCode() == HttpStatus.CREATED) {
			String responseBody = postResponse.getBody();
			System.out.println(responseBody);
		}
	}
	
	public void getRequestWithPathVariableUsingExchange() {
		String endPointURL = "http://localhost:8899/api/login/{username}";
		ResponseEntity<String> responseEntity = restTemplate.exchange(endPointURL,HttpMethod.GET, null,String.class,Map.of("username","Mahesh"));
		if(responseEntity.getStatusCode() == HttpStatus.OK) {
			System.out.println("API Response::::" + responseEntity.getBody());
		}
	}
	
	public void getRequestWithExchange() {
		String endPointURL = "http://localhost:8899/api/wishes/";
		ResponseEntity<String> responseEntity = restTemplate.exchange(endPointURL,HttpMethod.GET, null,String.class);
		if(responseEntity.getStatusCode() == HttpStatus.OK) {
			System.out.println(responseEntity.getBody());
		}
	}
	
	public void getRequestWithOutPathVariableByRestTemplate() {
		String endPointURL = "http://localhost:8899/api/wishes/";
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(endPointURL, String.class);
		if(responseEntity.getStatusCode() == HttpStatus.OK) {
			System.out.println(responseEntity.getBody());
		}
	}
	
	public void getRequestWithPathVariableByRestTemplate() {
		String endPointURL = "http://localhost:8899/api/login/{username}";
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(endPointURL, String.class,Map.of("username","Mahesh"));
		if(responseEntity.getStatusCode() == HttpStatus.OK) {
			System.out.println(responseEntity.getBody());
		}
	}
	
	public void getRequestWithTwoPathVariableByRestTemplate() {
		String endPointURL = "http://localhost:8899/api/login/{username}/{password}";
		String responseBody = 
				restTemplate.getForObject(
				endPointURL, 
				String.class,
				Map.of("username","Mahesh","password","Ashok@123"));
		if(responseBody != null && !"".equals(responseBody)) {
			System.out.println(responseBody);
		}
	}	
	
	public void getRequestByHttpClient()throws Exception {
		// Creating the HttpClient Object
		HttpClient httpClient = HttpClient.newHttpClient();

		// Creating HttpRequest Object
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8899/api/wishes/")).GET()
				.build();

		// Sending request to RestAPI
		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		if (response.statusCode() == 200) {
			String responseBody = response.body();
			System.out.println(responseBody);
		} else {
			System.out.println("HttpRequest Has beeen failed......" + response.statusCode());
		}
	}
	
	public void postRequestByHttpClient()throws Exception{
		
	     //Preparing PersonDTO objet for Request Body
		PersonDTO person = new PersonDTO("Kiran7", "Chennai", "kiran@gmail.com", "XYZ Street");
		
		//Creating ObjectMapper object
		ObjectMapper mapper = new ObjectMapper();
		
		//Converting the JavaObject into JSON String
		String requestBody = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
		System.out.println("Request Body:::"+ requestBody);
		
		// Creating the HttpClient Object
		HttpClient httpClient = HttpClient.newHttpClient();
		
		// Creating HttpRequest Object
		HttpRequest request = HttpRequest.newBuilder()
				   .header("Content-Type", "application/json")
				   .header("Accept", "application/json")
				   .uri(URI.create("http://localhost:8899/api/persons/"))
				   .POST(HttpRequest.BodyPublishers.ofString(requestBody))
				   .build();
		
		//Sending the Request
		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		
		//checking response
		if(response.statusCode() == 201) {
			String jsonResponse = response.body();
			System.out.println(jsonResponse);		
			//converting the JSon String into Java Object
			PersonDTO personDTO = mapper.readValue(jsonResponse, PersonDTO.class);
			System.out.println(personDTO);
		}else {
			System.out.println("HttpRequest Has been failed :::::" + response.statusCode());
		}		
	}
	
	public static void responseHandling(String message) {
		System.out.println("API Response::::::" + message);
	}
}
