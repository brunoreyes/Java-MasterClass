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

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        try {
//            URI uri = new URI("db://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
            URI baseUri = new URI("http://username:password@myserver.com:5000");
            URI uri = new URI("/catalogue/phones?os=android#samsung"); // URI is not absolute, can get error message
            // can't get an absolute URI from a relative URI.
            // When I want to access a web page on myserver.com host, combining base and relative URIs using resolve()
            URI resolvedUri = baseUri.resolve(uri);

            URL url = resolvedUri.toURL();
//            URL url = uri.toURL();
            System.out.println("URL = " + url);
            //            URI uri = new URI("hello"); //
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
        } catch (URISyntaxException  e){
            System.out.println("URI Bad Syntax: " + e.getMessage());
        } catch (MalformedURLException e){
            System.out.println("URL Malformed: " + e.getMessage());
        }

    }
}
