package xxxx.mobile;

import xxxx.mobile.service.LoginService;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.amx.event.ValueChangeEvent;
import oracle.adfmf.bindings.dbf.AmxAttributeBinding;
import oracle.adfmf.bindings.dbf.AmxIteratorBinding;
import oracle.adfmf.bindings.iterator.BasicIterator;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;



public class login_control {
    
    private boolean validated = false;
    public login_control() {
    }

    public void rememberMeChanged(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.rememberMe}", valueChangeEvent.getNewValue());
    }

    public void usernameChanged(ValueChangeEvent valueChangeEvent) {
        AdfmfJavaUtilities.setELValue("#{applicationScope.usercheck}", "Yes");
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.username}", valueChangeEvent.getNewValue());
    }

    public void passwordChanged(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        AdfmfJavaUtilities.setELValue("#{applicationScope.pwdcheck}", "Yes");
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.password}", valueChangeEvent.getNewValue());
    }

    public void loginButtonClick(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("loginButtonClick start");
        String usercheck = AdfmfJavaUtilities.getELValue("#{applicationScope.usercheck}").toString();
        String pwdcheck = AdfmfJavaUtilities.getELValue("#{applicationScope.pwdcheck}").toString();
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.loginMessage}", "");
        System.out.println("usercheck:" + usercheck);
        System.out.println("pwdcheck:" + pwdcheck);
        this.validated = false;
    if (usercheck.equals("Yes") && pwdcheck.equals("Yes")) {
        String userName = AdfmfJavaUtilities.getELValue("#{pageFlowScope.username}").toString();
        String password = AdfmfJavaUtilities.getELValue("#{pageFlowScope.password}").toString();

        System.out.println("username:" + userName);
        System.out.println("password:" + password);

        LoginService loginservice = new LoginService();
        //if (userName.equals("admin") && password.equals("password")) {
        if (loginservice.validateLogin()){
            System.out.println("valid:");
            this.validated = true;
            
        } else if (!userName.equals("") && !password.equals("")) {
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.loginMessage}", "Invalid Credentials Provided.");
        } 
        else if (password.equals("") && userName.equals(""))
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.loginMessage}", "Enter Username/Password");
        else if (userName.equals(""))
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.loginMessage}", "Enter Username");
        else if (password.equals(""))
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.loginMessage}", "Enter Password");

    } else if (usercheck.equals("No") && pwdcheck.equals("No")) {
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.loginMessage}", "Enter Username/Password");
    } else if (usercheck.equals("No")) {
        String password = AdfmfJavaUtilities.getELValue("#{pageFlowScope.password}").toString();
        if (!password.equals(""))
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.loginMessage}", "Enter Username");
        else
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.loginMessage}", "Enter Username/Password");
    } else if (pwdcheck.equals("No")) {
        String userName = AdfmfJavaUtilities.getELValue("#{pageFlowScope.username}").toString();
        if (!userName.equals(""))
        {
            System.out.println("Inside username if condition");
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.loginMessage}", "Enter Password");
        }
        else
        {
            System.out.println("Inside username else condition");
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.loginMessage}", "Enter Username/Password");
        }
    }
    System.out.println("LoginIn_buttonClick end........."+AdfmfJavaUtilities.getELValue("#{pageFlowScope.loginMessage}"));
    // AdfmfJavaUtilities.setELValue("#{pageFlowScope.loginMessage}", "");
    }

    public String loginNav() {
        // Add event code here...
        System.out.println("login Page Navigation start");
        String pageNav;

        if (this.validated) {

            pageNav = "showHome";
            System.out.println("validated true");
        } else {
            pageNav = null;
        }
        System.out.println("landingNavigation end");
        return pageNav;
    }
}
