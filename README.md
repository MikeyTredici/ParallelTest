fail log

org.openqa.selenium.NoSuchSessionException: invalid session id
Build info: version: '3.141.59', revision: 'e82be7d358', time: '2018-11-14T08:17:03'
System info: host: 'DESKTOP-UAF0L72', ip: '10.0.75.1', os.name: 'Windows 10', os.arch: 'amd64', os.version: '10.0', java.version: '12.0.1'
Driver info: org.openqa.selenium.chrome.ChromeDriver
Capabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 80.0.3987.87, chrome: {chromedriverVersion: 80.0.3987.16 (320f6526c1632..., userDataDir: C:\Users\Mike\AppData\Local...}, goog:chromeOptions: {debuggerAddress: localhost:57290}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify}
Session ID: ed1205c134e70a745b7dc96cd7053f4c

	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:500)
	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:481)
	at org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)
	at org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)
	at org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)
	at org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)
	at org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)
	at org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)
	at org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:285)
	at org.openqa.selenium.remote.RemoteWebElement.isEnabled(RemoteWebElement.java:156)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:567)
	at org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:51)
	at com.sun.proxy.$Proxy12.isEnabled(Unknown Source)
	at org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:672)
	at org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:666)
	at org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:249)
	at org.example.pages.NHLPage.clickTopNavPlayers(NHLPage.java:32)
	at org.example.NHLTest.nhlSearch(NHLTest.java:14)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:567)
	at org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:134)
	at org.testng.internal.TestInvoker.invokeMethod(TestInvoker.java:597)
	at org.testng.internal.TestInvoker.invokeTestMethod(TestInvoker.java:173)
	at org.testng.internal.MethodRunner.runInSequence(MethodRunner.java:46)
	at org.testng.internal.TestInvoker$MethodInvocationAgent.invoke(TestInvoker.java:816)
	at org.testng.internal.TestInvoker.invokeTestMethods(TestInvoker.java:146)
	at org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:146)
	at org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:128)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:835)
