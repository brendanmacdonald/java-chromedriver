```
mvn clean test -Dbrowser=<BROWSER> allure:serve
```

Valid values for <BROWSER>:
- CHROME_HEADLESS
- FIREFOX_MAX
- MOBILE360x640
  
E.g. 
```
mvn clean test -Dbrowser=CHROME_HEADLESS allure:serve
```

The ```allure:serve``` option will automatically open the results in a browser. Omit this option if not required.

By default the tests will run on Chrome / Maximised if no command line parameters are set.