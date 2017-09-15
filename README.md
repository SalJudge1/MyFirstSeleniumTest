# MyFirstSeleniumTest

This project contains a sample Selenium test (written in Java).

Purpose:  verify that an invalid login produces "Permission Denied" message/dialog and does not log in the user.

The Test uses Chrome Driver.
It opens the 'USA Gymnastics' web page and clicks the Member Login.
When the login Modal opens, MyFirstTest enters a dummy login/password then clicks the login button.
The Permission denied modal should display - this is verified by checking the dialog's id.
The code prints the Text to systemOuts (I can verify that I got the correct modal).

Note:  FFor quick testing, I Hard coded the URL  and id/pwd  in MyFirstTest.java  vs. using a property file or another mechanism.

