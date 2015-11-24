package com.shell.server.base.shell;

import com.shell.server.base.model.HttpRequest;
import com.shell.server.base.model.HttpResponse;

/**
 * Created by liquanmin on 15/11/24.
 */
public interface Servlet {
    void init();

    void service(HttpRequest httpRequest, HttpResponse httpResponse);

    void destroy();
}
