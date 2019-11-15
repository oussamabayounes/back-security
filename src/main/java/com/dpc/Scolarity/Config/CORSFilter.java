package com.dpc.Scolarity.Config;




import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


@Component
public class CORSFilter extends OncePerRequestFilter {
	private final List<String> allowedOrigins = Arrays.asList("http://localhost:4200"); 

    @Override
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
                                    final FilterChain filterChain) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, PATCH, HEAD, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers,Authorization");
        response.setHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Max-Age", "3600");
        filterChain.doFilter(request, response);
    }
}

//@Component
//SLIM CHAANBI
//public class CORSFilter extends OncePerRequestFilter {
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//    	response.addHeader("Access-Control-Allow-Origin", "*");
//
//        if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
//            // CORS "pre-flight" request
//            response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
//            response.addHeader("Access-Control-Allow-Headers", "Authorization");
//            response.addHeader("Access-Control-Allow-Headers",
//                    "Content-Type,origin,content-type,accept," + "X-Requested-With");
//            response.addHeader("Access-Control-Max-Age", "1");
//            response.addHeader("Access-Control-Expose-Headers", "access_token");
//            // Set to true if you need the website to include cookies in the requests sent
//            // to the API (e.g. in case you use sessions)
//             response.addHeader("Access-Control-Allow-Credentials", "true");
//        }
//
//        filterChain.doFilter(request, response);
//    }
//
//}
