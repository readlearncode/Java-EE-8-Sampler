package servlet4.pushbuilder;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A very simple and naive way to implement a push cache filter!!
 *
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@WebFilter("/PushCacheFilter")
public class PushCacheFilter extends HttpFilter {

    private Map<String, Set<String>> resourceCache = new ConcurrentHashMap<>();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = ((HttpServletRequest) request);
        HttpServletMapping mapping = ((HttpServletRequest) request).getHttpServletMapping();
        String resourceURI = mapping.getMatchValue();

        if (mapping.getServletName().equals("jsp")) {
            // Push resources
            resourceCache.keySet().stream()
                    .filter(resourceURI::contains)
                    .findFirst()
                    .ifPresent(s -> resourceCache.get(s)
                            .forEach(path -> httpServletRequest.newPushBuilder().path(path).push()));

            // create empty resource list if absent
            resourceCache.putIfAbsent(resourceURI, Collections.newSetFromMap(new ConcurrentHashMap<>()));
        } else {
            // Add resource
            resourceCache.keySet().stream()
                    .filter(httpServletRequest.getHeader("Referer")::contains)
                    .forEach(page -> resourceCache.get(page).add(resourceURI));
        }

        chain.doFilter(request, response);
    }

}