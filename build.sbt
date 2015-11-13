organization := "org.webjars"

name := "swagger-ui-shai"

version := "2.1.1"

crossPaths := false

lazy val gulp = taskKey[Unit]("Run the gulp build")

gulp := { "gulp".! }

packageBin in Compile <<= (packageBin in Compile) dependsOn gulp

mappings in (Compile, packageBin) := {
  val distDir = baseDirectory.value / "dist"
  val files = distDir ** "*"
  val webjarContentsDir = s"META-INF/resources/webjars/${name.value}/${version.value}"
  files pair rebase(distDir, webjarContentsDir)
}
