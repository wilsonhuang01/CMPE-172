# CMPE 172 - Lab #4 Notes

## Spring Security
![](images/01_home.png)
Visiting "/home" does not require logging in first.

![](images/02_hello.png)
![](images/03_login.png)
However, visiting "/hello" requires us to log in, so the webpage
redirects to the "/login" page and prompts us to enter the
username and password.

![](images/04_hello.png)
After entering the username and password into the respective
fields and clicking on the "Sign in" button, it redirects us
back to the page we are requesting ("/hello").

## Spring Gumball v2

### Deployment
![](images/05_deployment.png)
Deployment of Spring Gumball to Docker, which contains 2
gumball containers and a load balancer.

![](images/06_docker_ps.png)
Typing "docker ps" into the terminal shows currently running
containers.

![](images/07_refresh_1.png)
![](images/08_refresh_2.png)
![](images/09_refresh_3.png)
Server Host/IP rotates between "87d6fb090374/172.19.0.2" and
"f70334b1c3bc/172.19.0.3", demonstrating that the load balancer
is working.

### Session
![](images/10_insert_quarter.png)

Clicking on the "Insert Quarter" button causes Whitelabel Error.

![](images/11_null.png)
Checking the logs of one of the spring-gumball reveals a
NullPointerException in GumballMachineController at line 70.

![](images/12_session.png)
`gm` is null, which means that there is an error with the
session table. Making it stateless would fix the error.

### Replay Attack (Before)
![](images/13_turn_crank.png)
![](images/14_message.png)
Clicking on the "Turn Crank" button without inserting a
quarter first prints "You turned, but there's no quarter. 
You need to pay first" in the terminal.

![](images/15_intercept.png)
To demonstrate a replay attack, we use the "Tamper Dev" Chrome
plugin to intercept and modify HTTP requests.

![](images/16_intercepted.png)

After toggling "Intercept requests" on and clicking on the
"Turn Crank" button, the request is intercepted.

![](images/17_edit_1.png)
![](images/18_edit_2.png)

We can modify the state of `Request body` from "NoQuarterState"
to "HasQuarterState" then send it.

![](images/19_message.png)

The terminal prints "You turned... A gumball comes rolling
out the slot..." but we have not inserted a quarter, this
demonstrates a successful replay attack.

### Replay Attack (After)
![](images/20_intercept.png)
Fixing the code and turning it stateless. Then open Tamper Dev
again to try intercepting requests.

![](images/21_edit.png)

Editing the `Request body` from "NoQuarterState" to
"HasQuarterState". Unlike the `Request body` from the previous
spring-gumball version, the new `Request body` now contains
additional parameters (timestamp, hash, and message).

![](images/22_exception.png)

Sending the modified request would cause a `GumballServerError`
because the change in timestamps is too large. This demonstrates
that a replay attack is thwarted.
