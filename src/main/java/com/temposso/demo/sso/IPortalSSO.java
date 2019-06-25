package com.temposso.demo.sso;


import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public interface IPortalSSO {
    public abstract String[] readUserToken(HttpServletRequest paramHttpServletRequest, ServletResponse paramServletResponse)
            throws Exception;
}
