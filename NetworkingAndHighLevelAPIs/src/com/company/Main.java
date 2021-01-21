package com.company;

//	URI's can specify a relative path

//  URL's have to specify an absolute path, because it has to contain
//  enough info to locate & access resource it identifies

// A scheme is a part of a URI or URL that appears before the colon like: http, file or ftp.

//        A URL is an HTTP URI

//        When working with low-level APIs, we use classes: Socket, ServerSocket, and DatagramSocket.
//        When working with high-level APIs, we use classes: URI, URL, URLConnection & HttpURLConnection

//        A URI can contain 9 components:
//        1. scheme
//        2. scheme-specific part
//        3. authority
//        4. user-info
//        5. host
//        6. port
//        7. path
//        8. query
//        9. fragment

// URI's that specify schemes are called absolute URIs, else if it doesn't, it's a relative URI

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Main {

    public static void main(String[] args) {
        try {

            URL url = new URL("https://api.flickr.com/services/feeds/photos_public.gne?tags=dogs");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Chrome");
            connection.setReadTimeout(30000);

            int responseCode = connection.getResponseCode();
            System.out.println("Response code: " + responseCode);

            if(responseCode != 200) {
                System.out.println("Error reading web page");
                System.out.println(connection.getResponseMessage());
                return;
            }

            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String line;

            while((line = inputReader.readLine()) != null) {
                System.out.println(line);
            }

            inputReader.close();
// Since all URLs are URIs, you can convert URLs to URIs, and call the methods that return the components of a URI
//            URL url = new URL("http://example.org");
//
////            // 2nd way to read webpage, only able to read from a connection
//            URLConnection urlConnection = url.openConnection();
//            urlConnection.setDoOutput(true); // make sure to do any configuration after opening the connection
//            urlConnection.connect(); // but before calling connect()
//
//
//            // 1st way to read a webpage
//            BufferedReader inputStream = new BufferedReader(
//                    new InputStreamReader(url.openStream())); // opening a connection to the URL, creating socket
//
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            connection.setRequestProperty("User-Agent", "Chrome");
//            connection.setReadTimeout(30000);
//
//            int responseCode = connection.getResponseCode();
//            System.out.println("Response code: " + responseCode);
//
//            if(responseCode != 200) {
//                System.out.println("Error reading web page");
//                return;
//            }
//
//            BufferedReader inputReader = new BufferedReader(
//                    new InputStreamReader(connection.getInputStream()));
//
//            String line;
//
//            while((line = inputReader.readLine()) != null) {
//                System.out.println(line);
//            }
//
//            inputReader.close();

            //            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
//            for(Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
//                String key = entry.getKey();
//                List<String> value = entry.getValue();
//                System.out.println("-----key = " + key);
//                for(String string: value) {
//                    System.out.println("value = " + value);
//                }
//            }


//                    // wrapping the inputStream (url.openStream()) in a InputStreamReader and wrapping that
//            // in a bufferedReader as well.
//            String line = "";
//            while (line != null){
//                line = inputStream.readLine();
//                System.out.println(line);
//            }
//            inputStream.close();


//            URI uri = url.toURI();

//            URI baseUri = new URI("http://username:password@myserver.com:5000");
//            URI uri1 = new URI("/catalogue/phones?os=android#samsung"); // URI is not absolute, can get error message
//            URI uri2 = new URI("/catalogue/tvs?manufacturer=samsung");
//            URI uri3 = new URI("/stores/locations?zip=12345");
//
////            URI uri = new URI("db://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
////            URI uri = new URI("hello"); //
//
//            // can't get an absolute URI from a relative URI.
//            // When I want to access a web page on myserver.com host, combining base and relative URIs using resolve()
//            URI resolvedUri1 = baseUri.resolve(uri1);
//            URI resolvedUri2 = baseUri.resolve(uri2);
//            URI resolvedUri3 = baseUri.resolve(uri3);
//            // better to use a base URI with relative URIs
//
//            URL url1 = resolvedUri1.toURL();
//            System.out.println("URL 1 = " + url1);
//            URL url2 = resolvedUri2.toURL();
//            System.out.println("URL 2 = " + url2);
//            URL url3 = resolvedUri3.toURL();
//            System.out.println("URL 3 = " + url3);
//
//            URI relativizedURI = baseUri.relativize(resolvedUri2);
//            System.out.println("Relative URI = " + relativizedURI);


            //            URL url = uri.toURL();

// gathering the 9 components
//            System.out.println("Scheme = " + uri.getScheme());
//            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
//            System.out.println("Authority = " + uri.getAuthority());
//            System.out.println("User info = " + uri.getUserInfo());
//            System.out.println("Host = " + uri.getHost());
//            System.out.println("Port = " + uri.getPort());
//            System.out.println("Path = " + uri.getPath());
//            System.out.println("Query = " + uri.getQuery());
//            System.out.println("Fragment = " + uri.getFragment());

        }
        catch (MalformedURLException e){
            System.out.println("URL Malformed: " + e.getMessage());
        }
        catch (IOException e){
            System.out.println("IOException: " + e.getMessage());
        }


    }
}
