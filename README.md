```
mvn clean test -Dbrowser=<BROWSER>
```

Valid values for <BROWSER>:
- CHROME_HEADLESS
- FIREFOX_MAX
- MOBILE360x640
  
E.g. 
```
mvn clean test -Dbrowser=CHROME_HEADLESS
```

By default the tests will run on Chrome / Maximised if no command line parameters are set.