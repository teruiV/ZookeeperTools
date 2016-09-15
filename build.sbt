name := "zk_monitor"

version := "1.0-SNAPSHOT"

resolvers ++= Seq(
  "Nexus osc" at "http://maven.oschina.net/content/groups/public/",
  "Nexus Repository" at "http://192.168.180.78:8082/nexus/content/groups/public/"
)

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "org.apache.curator" % "curator-framework" % "2.8.0",
  "log4j" % "log4j" % "1.2.17",
  "org.apache.commons" % "commons-lang3" % "3.3.2",
  "com.mob.hubble.service" % "zk_monitor_dao" % "1.0-SNAPSHOT",
  "com.mob.hubble.service" % "zk_monitor_service" % "1.0-SNAPSHOT"
)


play.Project.playJavaSettings
