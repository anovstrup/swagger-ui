import sbt._

object Build {
  lazy val gulpCommand = settingKey[String]("System command for running gulp")
  lazy val gulp = taskKey[Unit]("Run the gulp build")
  lazy val username = settingKey[String]("Username for publishing to the shai ivy repository")
  lazy val shaiIvyRepo = settingKey[Resolver]("SHAI ivy repository")

  lazy val baseShaiIvyRepo = Resolver.ssh("shai-ivy-repo", "thebeast.shai.com", "/usr/ivy/repo")(Resolver.ivyStylePatterns)
}
