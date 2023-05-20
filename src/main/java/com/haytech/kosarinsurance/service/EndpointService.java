package com.haytech.kosarinsurance.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.haytech.kosarinsurance.annotation.Ignores.ExposeIgnore;
import com.haytech.kosarinsurance.model.entity.ApiAddRequest;
import com.haytech.kosarinsurance.model.enums.HttpMethods;
import com.haytech.kosarinsurance.tools.ApplicationProperties;
import org.json.simple.JSONObject;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class EndpointService {
    private final ApplicationContext applicationContext;

    @Autowired
    ApplicationProperties applicationProperties;

    public EndpointService(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public List<ApiAddRequest> getEndpoints() {
        List<ApiAddRequest> endpoints = new ArrayList<>();
        Map<String, Object> restControllers = applicationContext.getBeansWithAnnotation(RestController.class);
        for (String key : restControllers.keySet()) {
            String fullPackageName = restControllers.get(key).toString();
            String classPath = fullPackageName.substring(0, fullPackageName.indexOf('@'));
            Method[] methods;
            Class<?> restController;
            try {
                restController = Class.forName(classPath);
                methods = restController.getMethods();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                break;
            }
            for (Method method : methods) {
                //=======================================================================================================
                String name = "";
                String value = "";
                HttpMethods httpMethod;
                if (method.isAnnotationPresent(ExposeIgnore.class)) continue;
                if (method.isAnnotationPresent(PostMapping.class)) {
                    name = method.getAnnotation(PostMapping.class).name();
                    value = method.getAnnotation(PostMapping.class).value().length > 0 ? method.getAnnotation(PostMapping.class).value()[0] : "";
                    httpMethod = HttpMethods.POST;
                } else if (method.isAnnotationPresent(GetMapping.class)) {
                    name = method.getAnnotation(GetMapping.class).name();
                    value = method.getAnnotation(GetMapping.class).value().length > 0 ? method.getAnnotation(GetMapping.class).value()[0] : "";
                    httpMethod = HttpMethods.GET;
                } else if (method.isAnnotationPresent(PutMapping.class)) {
                    name = method.getAnnotation(PutMapping.class).name();
                    value = method.getAnnotation(PutMapping.class).value().length > 0 ? method.getAnnotation(PutMapping.class).value()[0] : "";
                    httpMethod = HttpMethods.PUT;
                } else if (method.isAnnotationPresent(DeleteMapping.class)) {
                    name = method.getAnnotation(DeleteMapping.class).name();
                    value = method.getAnnotation(DeleteMapping.class).value().length > 0 ? method.getAnnotation(DeleteMapping.class).value()[0] : "";
                    httpMethod = HttpMethods.DELETE;
                } else if (method.isAnnotationPresent(PatchMapping.class)) {
                    name = method.getAnnotation(PatchMapping.class).name();
                    value = method.getAnnotation(PatchMapping.class).value().length > 0 ? method.getAnnotation(PatchMapping.class).value()[0] : "";
                    httpMethod = HttpMethods.PATCH;
                } else if (method.isAnnotationPresent(RequestMapping.class)) {
                    name = method.getAnnotation(RequestMapping.class).name();
                    value = method.getAnnotation(RequestMapping.class).value().length > 0 ? method.getAnnotation(RequestMapping.class).value()[0] : "";
                    RequestMethod requestMethod = method.getAnnotation(RequestMapping.class).method().length > 0 ? method.getAnnotation(RequestMapping.class).method()[0] : RequestMethod.GET;
                    httpMethod = HttpMethods.valueOf(requestMethod.toString().toUpperCase());
                } else continue;
                name = applicationProperties.getProperty(name.replaceFirst("^\\$\\{", "").replaceFirst("}$", ""));
                if (StringUtils.isEmpty(name)) name = "-";
                // String routeUrl = microService + "/" + value.replaceFirst("^/", "");
                String routeUrl = value.replaceFirst("^/", "");
                String url = ("api/" + routeUrl).replaceAll("\\\\/", "");
                ;
                //String url= url.replaceAll("\\\\/","");
                /*if (microService.equals("godar-aggregator"))
                {
                    url = routeUrl;
                    routeUrl = null;
                }*/
                endpoints.add(
                        ApiAddRequest.builder()
                                .url(url)
                                .routeUrl(routeUrl)
                                .method(httpMethod)
                                .title(name)
                                .build());
             /*   ApiAddRequest api = new ApiAddRequest();
                api.setMethod(httpMethod);
                api.setUrl(url);
                api.setTitle(name);
                endpoints.add(api);*/
            }
        }
        List<String> jsonObjectList = new ArrayList<>();
        for (ApiAddRequest apiAddRequest : endpoints) {
            Gson userGson = new GsonBuilder().create();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("title", apiAddRequest.getTitle());
            jsonObject.put("method", apiAddRequest.getMethod());
            jsonObject.put("url", apiAddRequest.getUrl());
            jsonObjectList.add(userGson.toJson(jsonObject));
        }
        Path path = Paths.get("f:/Kosar_EndPoint_output.json");
        //for Linux path
        // Path path = Paths.get("/run/media/hshahian/E452E77552E74ABE/EndPoint_output.json");
        try {
            FileWriter file = new FileWriter(String.valueOf(path));
            file.write(String.valueOf(jsonObjectList));
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return endpoints;
    }

    public List<ApiAddRequest> getEndpoints1() {
        List<ApiAddRequest> endpoints = new ArrayList<>();
        // Scan your project's classes for RestController annotations
        // Adjust the basePackage value to match your project's package structure
        Reflections reflections = new Reflections("com.haytech.kosarinsurance");

        // Get all classes with RestController annotation
        Set<Class<?>> restControllers = reflections.getTypesAnnotatedWith(RestController.class);
        // Iterate over each RestController class
        for (Class<?> controllerClass : restControllers) {
            // Get the base URL path from the class-level RequestMapping annotation
            RequestMapping classRequestMapping = controllerClass.getAnnotation(RequestMapping.class);
            String basePath = classRequestMapping.value()[0];

            // Iterate over each method in the class
            for (Method method : controllerClass.getDeclaredMethods()) {
                // Get the method-level RequestMapping annotation
                RequestMapping methodRequestMapping = method.getAnnotation(RequestMapping.class);

                // Extract the HTTP method and URL path
                RequestMethod requestMethod = methodRequestMapping.method()[0];
                String[] paths = methodRequestMapping.value();

                // Combine the base path and method path to get the complete URL
                for (String path : paths) {
                    String url = basePath + path;

                    // Create an EndpointInfo object and add it to the list
                    ApiAddRequest endpointInfo = new ApiAddRequest(requestMethod.name(), url);
                    endpoints.add(endpointInfo);
                }
            }
        }
        // Convert the endpoint list to JSON
        Gson gson = new Gson();
        String json = gson.toJson(endpoints);
        Path path = Paths.get("f:/Kosar_EndPoint1_output.json");
        try (FileWriter writer = new FileWriter(String.valueOf(path))) {
            // Write the JSON to the file
            writer.write(json);
            System.out.println("Endpoints saved successfully to: " + path);
        } catch (IOException e) {
            System.err.println("Error occurred while saving endpoints as JSON: " + e.getMessage());
        }
        return endpoints;
    }
}
