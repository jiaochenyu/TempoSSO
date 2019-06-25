package com.temposso.demo.sso;

import com.meritdata.tempo.user.model.User;
import com.meritdata.tempo.user.service.IUserService;
import com.meritdata.tempo.utils.MupBeanUtils;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class SysSSO implements IPortalSSO{


    private String userField;
    private String tokenField;



    @Override
    public String[] readUserToken(HttpServletRequest req, ServletResponse resp) throws Exception {
        if ((this.userField == null) || (this.tokenField == null)) {
            return null;
        }
        String user = req.getParameter(this.userField);
        String token = req.getParameter(this.tokenField);
        if ((user != null) && (token != null)){
            IUserService userService = (IUserService) MupBeanUtils.getBean("userService");
            User user2 = userService.findUserByUserId(user);
            if (user2 != null) {
                return new String[] { user, token };
            }
            return new String[2];
        }
        return null;
    }


    public String getUserField()
    {
        return this.userField;
    }
    public void setUserField(String userField)
    {
        this.userField = userField;
    }
    public String getTokenField()
    {
        return this.tokenField;
    }
    public void setTokenField(String tokenField)
    {
        this.tokenField = tokenField;
    }
}
