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


