package br.com.audsat.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket docket() {
		//Adding Header
		var parameterBuilder = new ParameterBuilder();
//		parameterBuilder.name("Authorization")
//						.modelRef(new ModelRef("string"))
//						.parameterType("header")
//						.required(false)
//						.build();
//		var parameters = new ArrayList<Parameter>();
//		parameters.add(parameterBuilder.build());
		
		return new Docket(DocumentationType.SWAGGER_2)
//					.host("localhost:8080")
//					.groupName("All")
					.apiInfo(apiInfo())
					.select()
					.apis(RequestHandlerSelectors.basePackage("br.com.audsat.controllers"))
					.paths(PathSelectors.any())
					.build()
					.useDefaultResponseMessages(false)
					.globalResponseMessage(RequestMethod.GET, getResponse())
//					.enableUrlTemplating(true)//.globalOperationParameters(parameters)
					
//					.ignoredParameterTypes(ApiIgnore.class)
					;
	}

	private ApiInfo apiInfo() {
		
		return new ApiInfoBuilder()
					.title("Audsat-teste-API")
					.description("API que retorna o valor final do produto com o calculo de comissão, lucro e desconto que é dado ao Cliente para compras acima de 5 mil reais.")
					.termsOfServiceUrl("")
					.license("")
					.licenseUrl("")
					.version("1.0.0")
					.build();
		
	}
	
	private List<ResponseMessage> getResponse()
	{
	    return new ArrayList<ResponseMessage>() {
			private static final long serialVersionUID = 1L;
		{
			add(new ResponseMessageBuilder()
				.code(400)
				.message("Quano é informado um valor invalido.")
				.build());
	        add(new ResponseMessageBuilder()
	            .code(500)
	            .message("Quando ocorre um erro interno.\n" +
            		"{\r\n" + 
            		"	\"status\": \"int\",\r\n" + 
            		"	\"erro\": \"string\",\r\n" + 
            		"	\"mensagem\": \"string.\"\r\n" + 
            		"}")
	            .build());
	    }};
	}
	
}
