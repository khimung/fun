fun
===


J2EE fun application

Environment:

java version "1.6.0_51"
Java(TM) SE Runtime Environment (build 1.6.0_51-b11-457-11M4509)

Apache Maven 3.0.3 (r1075438; 2011-02-28 09:31:09-0800)
Maven home: /usr/share/maven
Java version: 1.6.0_51, vendor: Apple Inc.

Database set up

1. install mysql 5
2. create root user with password root
3. cd ./fun/schema
4. apache-maven-2.2.1/bin/mvn db:drop db:create db:schema db:data


Execute Steps:

1.  Add to /etc/hosts localhost memcache
2.  Start memcache
3.  Install mysql with username/password root/root
4.  run mvn install
5.  cd to subdirectory "fun"
6.  run mvn jetty:run

Endpoints:

localhost:9090/fun/auth
localhost:9090/fun/resources?type=mysql
localhost:9090/fun/users/F?start=0
localhost:9090/fun/listDir?path=/var/log

I like maven because of its simple yet robust capbilities due to the community contributed plugins that creates ease for many operations.  Maven lets you create environment specific profiles so that you can build to any environment with a simple command line.  I can easily start up my app in jetty or deploy it to tomcat.  The format of the maven pom file are simple and easy to read.  The directory structures are standard which removes the unnecessary step of figuring out where files are located.  Maven also has db tools to help managed updating existing database schemas.

I like eclipse for the same reason I like maven.  It is a community contributed open source IDE.  I can easily set up debugging environments to debug deployed apps remotely or locally.

Mysql is a commonly used database server that I use in many projects.  With file descriptor configurations, it makes swapping databases easy.  I could have used postgres, MS SQL Server, etc.

I like Spring framework because of the suite of J2EE compliant API's that it offers and the dependency injection design.  I am acustom to defining fields in my controller, service, and dao classes by autowiring the required classes.   

