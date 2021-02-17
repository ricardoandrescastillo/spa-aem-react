# Sample AEM project for SPA AEM REACT

# System Configuration Used
    It was tested on MacOS Catalina version 10.15.7
    AEM 6.5.7
    Apache Maven 3.6.3 
    Java version: 1.8.0_281
    OS name: "mac os x", version: "10.15.7", arch: "x86_64", family: "mac"
    npm 6.14.11
    node v14.15.5

# Structure of Archetype used 

mvn archetype:generate \
 -DarchetypeGroupId=com.adobe.aem \
 -DarchetypeArtifactId=aem-project-archetype \
 -DaemVersion=6.5.0 \
 -Dversion=1.0-SNAPSHOT \
 -DappId=spa-react-aem \
 -DappTitle="React Test Example" \
 -DoptionFrontendModule=react \
 -DfrontendModule=react \
 -DgroupId=com.aem.testreact \
 -DappsFolderName=spa-react-aem \
 -DartifactId=spa-react-aem \
 -DincludeExamples=y \
 -DarchetypeVersion=25

To Install
mvn clean install -PautoInstallPackage -Padobe-public

# Adding new Component using yo aem

Create a component to work with React it should have

    1)Aem Component
    2)Model
    3)Reac Component
    4)Add to import-components.js in react

yo aem-application:aem-component 
mavenAppsModuleName=ui.apps 
componentParentPath=spa-react-aem/components 
componentNodeName=react-component 
componentName="React Component" 
componentGroup="React Test Example - Content" 
mavenBundleModuleName=core 
javaRootPackageName=com.aem.testreact.core 
javaModelRelativePackageName=models 
javaModelClassName=ReactModel

Dont forget to add the new components in the template to see them in the components options.

# Adding Link Component using yo aem

yo aem-application:aem-component
mavenAppsModuleName=ui.apps
componentParentPath=spa-react-aem/components
componentNodeName=link-content
componentName="Link Content"
componentGroup="React Test Example - Content"
useSlingModelExporter=true
mavenBundleModuleName=core
javaRootPackageName=com.aem.reactsimpleexample.core
javaModelRelativePackageName=models
javaModelClassName=LinkContentModel

**_In the root there is a package homecontent.zip to see the components working_**
page for testing 
    http://localhost:4502/editor.html/content/spa-react-aem/us/en/home.html
    http://localhost:4502/content/spa-react-aem/us/en/home.html?wcmmode=disabled
    




