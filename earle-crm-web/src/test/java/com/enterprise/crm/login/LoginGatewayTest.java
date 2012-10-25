/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.login;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.Mock;
import com.enterprise.crm.navigation.Pages;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 *
 * @author jamescrabbe
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginGatewayTest {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    @Mock
    LoginAuthenticator authenitcator;
    LoginGateway loginGateway;

    @Before
    public void setUp() {
        loginGateway = new LoginGateway();
        loginGateway.authenitcator = authenitcator;
    }

    @Test
    public void testLoginValid() {
        //when(authenitcator.authenticate(USERNAME, PASSWORD)).thenReturn(true);

        loginGateway.setUsername(USERNAME);
        loginGateway.setPassword(PASSWORD);

        //assertThat(loginGateway.login(), is(Pages.HOME.getURLRedirect()));
    }

    @Test
    public void testLoginInvalid() {
        //when(authenitcator.authenticate(USERNAME, PASSWORD)).thenReturn(false);

        loginGateway.setUsername(USERNAME);
        loginGateway.setPassword(PASSWORD);

        //assertThat(loginGateway.login(), is(Pages.WELCOME.getURLRedirect()));
    }
}